// 서버 - (서비스를 제공하는 프로그램이 설치된 컴퓨터) 서비스를 제공하는 행위
// 서버 프로그램 - 서비스 하는 프로그램(IIS, 아파치, node.js)
// 클라이언트 - 서비스를 받는 프로그램이 설치된 컴퓨터 (브라우저)

//node.js : 비동기 이벤트 기반 프로그래밍

//내장 모듈 - 설치(npm install) 없이 사용하는 모듈
// var http = require('http');
import http from 'http';
import fs from 'fs';
import url from 'url';
//console.log(http.STATUS_CODES['404']);

// import { myDateTime, sayHello } from './myModule.js'; //확장자
import * as dt from './myModule.js';
import MyModule from './myModule.js';
// var dt = require('./myModule');

console.dir(dt);
console.dir(MyModule);
dt.default.totalFunc("조길동");

MyModule.totalFunc("박길동");
console.log(MyModule.someValue);

dt.sayHello("홍길동");
// console.log(myDateTime());
// sayHello("홍길동");

http.createServer(function (request, response) {
//   response.writeHead(200, {'Content-Type': 'image/png'});
//   response.end('./a.png');
    
    console.log(url.parse(request.url, true).query);
    console.log(url.parse(request.url, true));

    fs.readFile('./audio.html', function(err, data) {
        if(!err) {
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.end(data);
        }
    });
}).listen(8080, function() {
    console.log('8080');
});


console.log('This example is different!');
console.log('The result is displayed in the Command Line Interface');


var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'your@gmail.com'
        pass: 'yourpass'
    }
});
/**
 * 모듈: 각각의 내용을 파일로 분리 시킨 것(라이브러리)
 * Node.js의 기본 모듈은 CommonJs를 사용(require)
 * import : UMD - https://beomy.github.io/tech/javascript/cjs-amd-umd-esm/ - package.json 설정 필요
 */

// fs.unlink('t.txt', function (err) {
//     if (err) throw err;
//     console.log('delete');
//     // fs.readFile('t.txt', function(err, data) {
//     //     console.log(data.toString());
//     // });
// });