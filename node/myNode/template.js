/**
 * Node 프로그램을 제공(배포)하려면 소스와 package.json파일만 제공(node_modules은 제외)
 * 
 * 템플릿(Template): 규격화된 내용에 변경된 부분을 삽입하는 페이지
 * Node를 지원하는 외부모듈을 사용
 * 
 * 전역모듈 - 설정없이 사용
 * 내부모듈 - 설정 require(import) 후 사용
 * 외부모듈 - 설치(install) 후 설정하여 사용
 * 
 * ejs, jade
 */

const http = require("http");
const fs = require("fs");
const ejs = require("ejs");

const val = {
    name: '고길동',
    age: 28
};

const users = [
    val,
    {
        name: '홍길동',
        age: 56
    },
    {
        name: '최길동',
        age: 16
    },
    {
        name: '조길동',
        age: 94
    },
    {
        name: '임길동',
        age: 91
    },
    {
        name: '주길동',
        age: 48
    },
];

http.createServer((req,res) => {
    fs.readFile("useEjs.html", "utf-8", function(err, data) {
        res.writeHead(200, {"Content-Type" : "text/html"});
        res.end(ejs.render(data, {name: val.name, age: val.age, users: users}));
    });
}).listen(7777, () => {
    console.log(7777);
});

// const server = http.createServer((req, res) => {
//     if(req.method === "GET") {
//         fs.readFile("useEjs.html", "utf-8", function(err, data) {
//             res.writeHead(200, {"Content-Type" : "text/html; charset=utf-8"});
//             res.end(ejs.render(data, {name: val.name, age: val.age, users: users}));
//         });
//     } else {
//         const aaa = additional(data.toString());
//         req.on('data', function(data) {
//             res.writeHead(200, {"Content-Type" : "text/html; charset=utf-8"});
//             res.end(`
//                     str += <tr>
//                     str += <td>${decodeURI(aaa.name)}</td><td>${decodeURI(aaa.age)}</td>;
//                     str += </tr>
//             `);
//         });
//     }
// });

// function additional(str) {
//     let arradi = str.split('&');
//     let addi = {};
//     arradi.forEach(value => {
//         let arradi = value.split("=");
//         addi[arradi[0]] = arradi[1];        
//     });
//     return addi;
// }