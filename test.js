const http = require('http');
const dt = require(/node/myModule);
const url = require('url');
const fs = require('fs');
const events = require('events');

import http from 'http';
import url from 'url';
import fs from 'fs';
import events from 'events';
import { myDateTime } from '/node/myModule.js';
import * as formidable from 'formudable';

const eventEmitter = new events.EventEmitter();

eventEmitter.on('myEvent', function() {
    console.log('이벤트 발동!!!');
});

//upper-case 외부 모듈
// const uc = require('upper-case');
// console.dir(upperCase);
http.createServer(function(req, res) {
    //console.dir(req.url);
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
            eventEmitter.emit('myEvent');
            fs.readFile('filleupload.txt', function(err, data) {
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
            res.write('파일 업로드 가동중~~');
            res.end();
            break;
        default:
            res.end();
            break;
    }

}).listen(9999, function() {
    console.log('9999로 서버 호출 요망~~')
    setInterval(() => {
        console.log(dt.myDateTime());
    }, 5000);
});