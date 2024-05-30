const express = require("express");
const cookie = require("cookie-parser");

const app = express();
app.use(cookie());

app.get("/setCookie", function(req, res) {
    res.cookie("string", "cookie", {
        secure: true,
        maxAge: 6000
    });
    //maxAge: 만료 시간 설정
    //path : cookie 경로 설정 기본값: "/"
    //secure: https에서만 적용
    //httpOnly: 웹서버에서만 적용

    res.cookie("json", {
        name: "홍길동",
        age: "28"
    });

    res.redirect("/getCookie");
});

app.get("/getCookie", function(req, res) {
    let uname = "삭제";
    if(req.cookies.json) {
        uname = req.cookies.json.name;
    }
    res.send(uname + "<br> <a href='/setCookie'>쿠키설정</a><a href='/clearCookie'>쿠키 삭제</a>");
});

app.get("/somePage", function(req, res) {
    let isCookie = "";
    if(req.cookies.json) {
        isCookie = "환영!!  " + req.cookies.json.name + "<a href='/getCookie'>메인</a>";
        // console.log(isCookie);
    } else {
        isCookie = "<a href='/setCookie'>로그인</a>";
    }
    res.send(isCookie);
});

app.get("/clearCookie", function(req, res) {
    res.clearCookie("json");
    res.redirect("/getCookie");
});

app.listen(8888, () => {
    console.log(8888);
});