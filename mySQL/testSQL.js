const mysql = require("mysql");

const client = mysql.createConnection({// mysql 연결 객체 생성
    //host: "주소", 로컬이라 생략가능 (현재 상태)
    user: "root",
    password: "0000",
    database: "kws", //USE kws 부분
});  //연결 구문(SQL)


// client.query('DROP TABLE member', (err, result) => { //TABLE명 member 삭제
//     console.log(result);
// });

// //IF NOT EXISTS 기존 존재하면 진행 O, 존재하지 않으면 진행 X

// const query = `CREATE TABLE IF NOT EXISTS member (  //TABLE명 member 생성
//                 uid int NOT NULL AUTO_INCREMENT,
//                 uname varchar(10) NOT NULL,
//                 uage int,
//                 PRIMARY KEY(uid)
//             );`;

// client.query(query, function(err, result) {
//     if(err) {
//         console.log(err.errno);
//         console.log(err.message);
//     } else {
//         console.log(result);
//     }
// });

// client.query('SHOW tables', (err, result) => {
//     console.log(result);
// });

client.query('SELECT * FROM users', (err, result) => {
    console.log(result);
});

const fs = require("fs");
const ejs = require("ejs");
const express = require("express");
const bodyParser = require("body-parser");

const app = express();

app.get("/", (req, res) => {

});
app.post("/", (req, res) => {
    const {uid, uname, uage} = result;
    
});