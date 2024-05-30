// const fs= require("fs");
// let bp = require("body-parser");
// const express = require("express");
// const cookie = require("cookie-parser");
// const bodyParser = require("body-parser");
// const { constants } = require("buffer");

// const app = express();

// app.use(bodyParser.urlencoded({extended: false}));
// app.use(cookie());

// app.get("/", (req, res) => {
//     fs.readFile("test.html", "utf8", (err, data) => {
//         if(err) {
//             console.error(err);
//             return;
//         }
//         res.send(data);
//     });
// });


// app.post("/", (req, res) => {
//     const {Id, Pass} = req.body;
//     res.send(`Id: ${Id}, Pass: ${Pass}`);
// });

// const users = [];
// const {Id, Pass} = req.body;
// const user = users.find((user) => user.id === id);

// app.get("/enroll", (req, res) => {
//     if(!Id || !Pass) {
//         res.status(400).send({message: 'Id, password를 입력해주세요.'});
//     }
   
//     if(user) {
//         res.status(400).send({message: '이미 존재하는 아이디입니다.'});
//         return;
//     }

//     users.push(req.body);
//     res.send({message: '입력하신 Id를 등록했습니다.'})
// });

// app.post('/login', (req, res) => {
//     if(!Id || !Pass) {
//         res.status(400).send({message: 'Id, password를 입력해주세요.'});
//         return;
//     }
//     if(!user) {
//         res.status(400).send({message: '존재하지 않은 아이디입니다.'});
//         redirect("/enroll");
//     }
//     if(!user.Pass !== Pass) {
//         res.status(400).send({message: '비밀번호가 일치하지 않습니다.'});
//         redirect("/enroll");
//     }
// });

// app.get("/setCookie", function(req, res) {
    
//     res.cookie("string", "cookie", {
//         secure: true,
//         maxAge: 6000
//     });
//     maxAge: 만료 시간 설정
//     path : cookie 경로 설정, 기본값: "/"
//     secure: https에서만 적용
//     httpOnly: 웹서버에서만 적용

//     res.cookie("json", {
//         name: "홍길동",
//         age: "28"
//     });

//     res.redirect("/getCookie");
// });

// app.get("/getCookie", function(req, res) {
//     let uname = "";
//     if(req.cookies.json) {
//         uname = req.cookies.json.name;
//     }
//     res.send(uname + "<br> <a href='/setCookie'>쿠키 설정</a><br><a href='/clearCookie'>쿠키 삭제</a><br><a href='somePage'>다른 페이지</a>");
// });

// app.get("/somePage", function(req, res) {
//     let isCookie = "";
//     if(req.cookies.json) {
//         isCookie = "환영 " + req.cookies.json.name + "<a href='/getCookie'>메인</a>";
//     } else {
//         isCookie = "<a href='/setCookie'>로그인</a>";
//     }
//     res.send(isCookie);
// }); 

// app.get("/clearCookie", function(req, res) {
//     res.clearCookie("json");
//     res.redirect("/getCookie");
// });

// app.listen(7777, () => {
//     console.log(7777);
// });

/////////////////////////////////////////////////////////////////////////////////
let fs = require("fs");
let express = require("express");
let cookieParser = require("cookie-parser");
let bodyParser = require("body-parser");

let app = express();

app.use(cookieParser());
app.use(bodyParser.urlencoded({extended: false}));

let userId = "aaa";
let userPass = "bbb";
let userN = "아무개";

app.get("/", (req, res) => {
    if(req.cookies.auth) {
        res.send("로그인 완료 " + userN + "님<br><a href='/logout'>로그아웃</a>");
    } else {
        res.send("<a href='login'>로그인</a>")
    }
    res.send("<a href='/login'>로그인</a>")
});

app.get("/login", (req, res) => {
    fs.readFile("test.html", (err, data) => {
        console.log(req.query);
        res.send(data.toString());
    });
});

app.post("/login", (req, res) => {
    const {uid, upass} = req.body;
    if(uid == userId && upass === userPass) {
        res.cookie("auth", true);
        res.redirect("/");
    } else {
        res.redirect("/");
    }
});

app.get("/logout", (req, res) => {
    res.clearCookie("auth");
    res.redirect("/");
});

app.listen(7777, () => {
    console.log(7777);
});
