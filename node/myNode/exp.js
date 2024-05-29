/*
    express는 http모듈 기반으로 작성

    외부모듈 설치
    npm i express@4
*/
const http = require("http");
const express = require("express");
const fs = require("fs");

const app = express(); //server

//리소스(이미지, 미디어) 추가(인터넷에 등록)
app.use(express.static(__dirname));
//use 미들웨어

app.use((req, res, next) => {
    req.myValue = 15;
    res.myResult = 100;
    console.log("미들웨어 설정1");
    next();
});

app.use((req, res, next) => {
    console.log(req.myValue);
    console.log(res.myResult);
    console.log("미들웨어 설정2");
    next();
});

app.use((req, res, next) => {
    console.log("미들웨어 설정3");
    next();
});

app.use((req, res, next) => {
    console.log("미들웨어 설정4");
    next();
});

app.use((req, res, next) => {
    console.log("미들웨어 설정5");
    next();
});


app.use((req, res, next) => {

    //response
    // res.writeHead(200, {"Content-Type":"text/html"});
    // res.end("<h1>Hello!</h1>");

    //이미지
    //res.send("<h1>Hello!</h1><img src='a.png' alt='a'>");

    //JSON - react나 client js에서 데이터를 ajax로 전송
    // let out = [];
    // for(let i = 0; i < 3; i++) {
    //     out.push({
    //         c: i,
    //         n: 'name - ' + i
    //     });
    // }

    // res.send(out);

    //404
    //res.status(404).send("<h1>404 Not Found</h1>");
    //res.status(302).redirect("https://www.naver.com");
    //res.sendStatus(404);

    // fs.readFile("index.txt", (err, data) => {
    //     res.send(data.toString());
    // });

///////////////////////////////////////////////////////
    //request
    //User-Agent
    // let agent = req.header("User-Agent");
    // if(agent.toLocaleLowerCase().match(/edg/)) {
    //     res.send('<h1>Edge</h1>');
    // } else {
    //     res.send('<h1>Chrome</h1>');
    // }

    //query[string](GET)
    console.log(req.query);
    const {name, age} = req.query;
    let str = `이름: ${name}, 나이: ${age}`;
    if(Number(age) >= 18) {
        str += "<br>성인";
    } else {
        str += "<br>미성년";
    }

    res.str = str;
    next();

    // res.send(str + "<br>myValue: " + req.myValue + "<br>myResult: " + res.myResult);
});

app.get("/", function(req, res) {
    fs.readFile("index.html", (err, data) => {
        res.send(data.toString());
    });
});

app.get("/about", function(req, res) {
    res.send(res.str + "<br><a href='/'>myValue: " + req.myValue + "<br>myResult: " + res.myResult);
});

//request의 params
app.get("/page/:val/:key", function(req, res) {
    console.log('req.params.val: ' + req.params.val);
    console.log('req.params.key: ' + req.params.key);
    res.send('test');
});

//POST 
//body-parser 미들웨어 사용하여 POST데이터를 사용
//설치 npm i body-parser

app.all("*", function(req, res) {
    res.status(404).send("<h1>없는 페이지</h1>");
});

app.listen(8888, () => {
    console.log(8888);
});

//다른 모듈과 같이 사용
// http.createServer(app).listen(8888, function() {console.log(8888);});