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
        age: 30
    },
    {
        name: '최길동',
        age: 18
    },
    {
        name: '조길동',
        age: 63
    },
    {
        name: '임길동',
        age: 7
    },

];

function makeObject(str) {
    let arrProps = str.split('&');
    let obj = {};
    arrProps.forEach(val => {
        let arrProp = val.split("=");
        obj[arrProp[0]] = decodeURI(arrProp[1]);
    });
    return obj;
}

http.createServer((req, res) => {
    if(req.method === "GET") {
        fs.readFile("useEjs.html", "utf-8", function(err, data) {
            res.writeHead(200, {"Content-Type" : "text/html"});
            res.end(ejs.render(data, {name: val.name, 
                                        age: val.age, 
                                        users: users, 
                                        show: false}));
        });
    } else {
        req.on("data", function(user) {
            fs.readFile("useEjs.html", "utf-8", function(err, data) {
                let objUser = makeObject(user.toString());
                let valUser = {
                    name: objUser.name,
                    age: objUser.age
                };
                users.push(valUser);
                if(objUser.sortOn) {
                    let flag = objUser.sortOn === "name" 
                        ? objUser.flagName 
                        : objUser.flagAge;
                    sort(objUser.sortOn, flag);
                }

                res.writeHead(200, {"Content-Type" : "text/html"});
                res.end(ejs.render(data, {name: val.name, 
                                            age: val.age, 
                                            users: users, 
                                            show: true}));
            });

        });
    }

    function sort(type, flag) {
        users.sort(function(a, b) {
            if(flag) {
                if(type === "name")
                    return a[type] == b[type] ? 0 : a[type] > b[type] ? 1 : -1;
                else return a[type] - b[type]
            } else {
                if(type === "name")
                    return a[type] == b[type] ? 0 : a[type] > b[type] ? -1 : 1;
                else return b[type] - a[type]
            }
        });
    }
}).listen(7777, () => {
    console.log(7777);
});
