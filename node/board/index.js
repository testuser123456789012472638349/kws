/**
 * REST - REST(RESTful, Representational State Transfer, RESTful, 레스트풀) - HTTP와 URI 기반으로 자원에 접근할 수 있도록 제공하는 애플리케이션 개발 인터페이스이다. 
 * 
 * CRUD - 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능인 Create(생성), Read(읽기), Update(갱신), Delete(삭제)를 묶어서 일컫는 말이다.
 */

/**
 * app.get("/")             : 리스트 표시           - list.html
 * app.get("/insert")       : 사용자 입력           - insert.html
 * app.post("/insert")      : 데이터 저장
 * app.get("/view/:id")     : 데이터 표시           - view.html
 * app.get("/edit/:id")     : 수정할 데이터 표시    - edit.html
 * app.post("/edit/:id")    : 수정할 데이터 저장
 * app.get("/delete/:id")   : 데이터 삭제
 * 
 * 외부 모듈(의존성 모듈)
 * fs, ejs, mysql, express, body-parser
 * 
 * 데이터베이스 디자인
 * board_id:(int) PK AUTO_INCREMENT 아이디
 * board_date: 날짜(data)
 * board_content: 내용(text)
 * 
 * CREATE TABLE board (
 *  board_id int NOT NULL AUTO_INCREMENT,
 *  board_date date,
 *  board_content text,
 *  PRIMARY KEY(board_id)
 * );
 */

const fs = require("fs");
const ejs = require("ejs");
const mysql = require("mysql");
const express = require("express");
const bodyParser = require("body-parser");

const client = mysql.createConnection({
    user: "root",
    password: "0000",
    database: "kws",
    multipleStatements: true
});

client.query("SELECT count(*) as recodeCount FROM board", function(err, result) {
    const today = new Date();
    const strDate = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();

    if(result[0].recodeCount < 100) {
        for(let i = 0; i < 1000; i++) {
            client.query(`INSERT INTO board(board_content, board_date) VALUES ('${i}', '${strDate}')`, function(err) {
                if(err) {
                    console.log(err.sqlMessage)
                    return;
                }
            });
        }
    }
});

const app = express();
app.use(bodyParser.urlencoded({extended: false})); //POST 데이터 받기위해.

app.listen(9999, function() {console.log(9999)});
// app.get(["/", "/:page"], function(req, res) {
//     const per = 11;
//     const block = 7;
//     let {page} = req.params;
//     if(!page) page = 0;

//     fs.readFile("list.html", "utf-8", function(err, data) {
//         const sql1 = `SELECT * FROM board ORDER BY board_id DESC LIMIT ${page}, ${per};`;
//         const sql2 = "SELECT count(*) as recodeCount FROM board;";
//         client.query(
//             sql1 + sql2, function(err, results) {
//                 console.log(results[1][0].recodeCount);
//                 res.send(ejs.render(data, {
//                     results: results,
//                     per: per,
//                     page: page,
//                     block: block //PAGE 나눌때
//                 }));
//             }
//         );
//     });
// });
const per = 13;
const block = 5;
app.get("/board/", function(req, res) {   
    let page = 0;
    getList(page, res);
});
app.get("/board/list/:page", function(req, res) {   
    let {page} = req.params;
    if(!page) {
        page = 0;
        getList(page, res);
    } else {
        getList(page, res);
    }
});
function getList(page, res) {
    fs.readFile("list.html", "utf-8", function(err, data) {
        const sql1 = `SELECT * FROM board ORDER BY board_id DESC LIMIT ${page}, ${per};`;
        const sql2 = "SELECT count(*) as recodeCount FROM board;";
        client.query(
            sql1 + sql2, function(err, results) {
                // console.log(results[1][0].recodeCount);
                console.log(results);
                res.send(ejs.render(data, {
                    results: results,
                    per: per,
                    page: page,
                    block: block
                }));
            }
        );
    });
}
app.get("/board/insert", function(req, res) {
    fs.readFile("insert.html", "utf-8", function(err, data) {
        res.send(ejs.render(data));
    });
});
app.post("/board/insert", function(req, res) {
    const {content} = req.body;
    const today = new Date();
    const strDate = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
    client.query(
        `INSERT INTO board (board_content, board_date) values ('${content}', '${strDate}')`, function(err) {
            if(err) {
                console.log(err.sqlMessage);
                return;
            } else {
                res.redirect("/board/");
            }
        }
    )
});
app.get("/board/view/:id", function(req, res) {
    const {id} = req.params;
    
    if(!id) {res.redirect("/board/");}

    fs.readFile("view.html", function(err, data) {
        client.query(
            `SELECT * FROM board WHERE board_id = ${id}`,
            function(err, result) {
                res.send(ejs.render(data.toString(), {result: result}));
            }
        );
    });
});
app.get("/board/edit/:id", function(req, res) {
    fs.readFile("edit.html", "utf-8", function(err, data) {
        client.query(
            `SELECT * FROM board WHERE board_id = ${req.params.id}`, function(err, result) {
                res.send(ejs.render(data, {result: result}));
            }
        );
    });
});
app.post("/board/edit/:id", function(req, res) {
    const {content} = req.body;
    const {id} = req.params;
    console.log(id, content);
    client.query(
        `UPDATE board SET board_content = '${content}' WHERE board_id = ${id}`,
        function(err) {
            if(err) {
                console.log(err.sqlMessage);
                return;
            } else {
                res.redirect(`/board/view/${id}`);
            }
        }
    );
});
app.get("/board/delete/:id", function(req, res) {
    client.query(
        `DELETE FROM board WHERE board_id = ${req.params.id}`,
        function(err) {
            if(err) {
                console.log(err);
                return;
            }
            res.redirect("/board/");
        }
    )
});

app.all("*", function(req, res) {
    res.send("<b>404!</b><hr><a href='/board/'>메인으로</a>");
});