//http 내장 모듈
// const http = require('http');
// //사용자 모듈
// const dt = require('./myModule');
// // console.dir(dt);
// //url 내장 모듈
// const url = require('url');
// //fs 내장 모듈
// const fs = require('fs');

// const events = require('events');

import http from 'http';
import url from 'url';
import fs from 'fs';
import events from 'events';

import {myDateTime} from './myModule.js';

import * as formidable from 'formidable';

// import {upperCase} from 'upper-case';
// console.log(upperCase('test'));


const evetnEmitter = new events.EventEmitter();

//이벤트 등록
evetnEmitter.on('myEvent', function() {
    console.log('이벤트 발동');
});


//upper-case 외부 모듈
// const uc = require('upper-case');
// console.dir(upperCase);

http.createServer(function(req, res) {
    // console.dir(req.url);
    res.writeHead(200, {'Content-type': 'text/html; charset=utf-8', 'access-control-allow-origin': '*'});

    //url 분해
    // var q = url.parse(req.url, true).query;
    // console.log(q.name);
    // console.log(q.age);

    let pathname = url.parse(req.url).pathname;
    

    let menu = "<hr><a href='/'>HOME</a> | ";
    menu += "<a href='/about'>ABOUT</a> | ";
    menu += "<a href='/event?name=홍길동&age=28'>EVENT</a> | ";
    menu += "<a href='/up'>파일업로드</a> | "
    
    switch(pathname) {
        case "/":
        case "/home":
            res.end(`${menu}<h1 style="color:pink">HOME</h1> ${myDateTime()}`);
            break;
        case "/about":
            
            //이벤트 실행
            evetnEmitter.emit('myEvent');

            // res.end(`${menu}<h1 style="color:pink">ABOUT</h1> ${dt.myDateTime()}`);
            fs.readFile('demofile1.html', function(err, data) {
                if(err) console.log(err);
                res.end(data);
            });
            break;
        case "/event":
            let q = url.parse(req.url, true).query;
            const {name, age} = q;
            res.end(`${menu}<h1 style="color:pink">EVENT</h1><hr>이름: ${name}<br>나이: ${age}`);
            break;
        case "/up":
            res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
            res.write('<input type="file" name="filetoupload"><br>');
            res.write('<input type="submit">');
            res.write('</form>');
            return res.end();
        case "/fileupload":
            const form = new formidable.IncomingForm();
            form.parse(req, function(err, fields, files){
                console.log(files.filetoupload[0].filepath);
                let oldpath = files.filetoupload[0].filepath;
                let newpath = 'C:/User' + files.filetoupload[0].originalFilename;
                
                fs.rename(oldpath, newpath, function(err) {
                    if(err) res.end(err.message);
                    else res.end('File uploaded');
                }); 
            });
            break;
        default:
            res.end(`${menu}<h1 style="color:pink">404 NOT Found!!!</h1> ${myDateTime()}`);
            break;
    }
}).listen(7777, function() {
    console.log('open server at 7777');
    // setInterval(() => {
    //     console.log(dt.myDateTime());
    // }, 1000);
});



/* 
    node.js는 비동기 이벤트 기반 프로그래밍 언어, 

    node.js를 실행시키는 방법
    콘솔에 node 실행파일.js

    localhost:포트번호
    - localhost:8080
    - http://192.168.0.48:8080

    의존성 : 플러그인과 같음
    npm install 프로그램명
    npm i -g 프로그램명

    nodemod - 서버를 새로고침 함.
*/