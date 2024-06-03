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
// let fs = require("fs");
// let express = require("express");
// let cookieParser = require("cookie-parser");
// let bodyParser = require("body-parser");

// let app = express();

// app.use(cookieParser());
// app.use(bodyParser.urlencoded({extended: false}));

// let userId = "aaa";
// let userPass = "bbb";
// let userN = "아무개";

// app.get("/", (req, res) => {
//     if(req.cookies.auth) {
//         res.send("로그인 완료 " + userN + "님<br><a href='/logout'>로그아웃</a>");
//     } else {
//         res.send("<a href='login'>로그인</a>")
//     }
//     res.send("<a href='/login'>로그인</a>")
// });

// app.get("/login", (req, res) => {
//     fs.readFile("test.html", (err, data) => {
//         console.log(req.query);
//         res.send(data.toString());
//     });
// });

// app.post("/login", (req, res) => {
//     const {uid, upass} = req.body;
//     if(uid == userId && upass === userPass) {
//         res.cookie("auth", true);
//         res.redirect("/");
//     } else {
//         res.redirect("/");
//     }
// });

// app.get("/logout", (req, res) => {
//     res.clearCookie("auth");
//     res.redirect("/");
// });

// app.listen(7777, () => {
//     console.log(7777);
// });

///////////////////////////////////////////////////////////////////////////////////////////
// let fs = require("fs");
// let ejs = require("ejs");
// let express = require("express");
// let bodyParser = require("body-parser");
// let cookieParser = require("cookie-parser");
// const path = require("path");
// const { routerA } = require("./routerA");

// let app = express();

// app.use(cookieParser());
// app.use(bodyParser.urlencoded({extended: false}));
// app.use(express.static(path.join(__dirname, 'public')));

// const myPageRouter = express.Router();
// app.use("/myPageRouter", myPageRouter)

// myPageRouter.get("/myPageRouter", (req, res) => {
//     res.send("ssndfsnflknskdlf");
// });

// const users = [
//     {
//         uid: '고길동',
//         uname: '고길동',
//         upass: 28
//     },
//     {
//         uid: '홍길동',
//         uname: '홍길동',
//         upass: 12
//     },
//     {
//         uid: '마길동',
//         uname: '마길동',
//         upass: 28
//     },
//     {
//         uid: '최길동',
//         uname: '최길동',
//         upass: 28
//     },
// ];

// function makeObject(str) {
//     let arrProps = str.split('&');
//     let obj = {};
//     arrProps.forEach(val => {
//         let arrProp = val.split("=");
//         obj[arrProp[0]] = decodeURI(arrProp[1]);
//     });
//     return obj;
// }

// app.get("/", (req, res) => {
//     if(req.cookies.auth) {
//         res.send("환영합니다. " + req.cookies.uname + "님<br><a href='/logout'>로그아웃</a><br><a href='/myPageRouter'>마이페이지1(Using static)</a><br><a href='/myPageRouter'>마이페이지2(Using Router)</a>");
//     } else {
//         res.send("<a href='/login'>로그인</a><a href='/join'>회원가입</a>")
//     }
// });
// app.get("/join", (req, res) => {
//     res.send(`
//         <form method='post'>
//             <input type='text' name='uid' placeholder='아이디'><br>
//             <input type='password' name='upass' placeholder='비밀번호'><br>
//             <input type='text' name='uname' placeholder='닉네임'><br>
//             <input type='submit' value='join'><br>
//         </form>
//     `);
// });
// app.post("/join", (req, res) => {
//     const {uid, uname, upass} = req.body;

//     let user = {
//         uid: uid,
//         uname: uname,
//         upass: upass
//     };

//     users.push(user);
//     res.send(`
//         <script>
//             alert('환영합니다. ${uname}님.\\n로그인 해주세요.');
//             location.href = '/login';
//         </script>
//     `);
// });
// app.get("/login", (req, res) => {
//     fs.readFile("test.html", (err, data) =>{
//         let log = false;
//         if(req.query) {
//             log = req.query.log;
//         }
//         res.send(ejs.render(data.toString(), {log: log}));
//     });
// });
// app.post("/login", (req, res) => {
//     const {uid, upass} = req.body;
//     if(uname = isUser(uid, upass)) {
//         res.cookie("auth", true);
//         res.cookie("uname", uname);
//         res.redirect("/");
//     } else {
//         res.redirect("login?log=true");
//     }
// });

// function isUser(uid, upass) {
//     let user = users.find(user => user.uid === uid && user.upass);
//     if(user) return user.uname;
//     return false;
// }
// app.get("/logout", (req, res) => {
//     res.clearCookie("auth");
//     res.redirect("/");
// });

// app.get("/mypage", async(req, res) => {
//     res.sendFile(path.join(__dirname, 'testlogin.html'));
// });

// myPageRouter.get("/", (req, res) => {
//     res.send("fkjnksdjfhjksf");
// });

// app.listen(8888, () => {
//     console.log(8888);
// });




// const express = require("express");
// const bodyParser = require("body-parser");

// const MemoryDB = (function() { //값 추가 삭제 기능
//     let myObject = {};
//     let db = [];
//     let id = 0;

//     myObject.get = function(id) {
//         if(id) {
//             id = (typeof id === 'string') ? Number(id) : id // id는 문자로 넘어오기 때문
//             return db.filter(todo => todo.id === id); //filter() 반복하면서 값을 체크하는 메소드
//         } else {
//             return db;
//         }
//     } // 리스트 전부를 반환하는 메소드 : get()

//     myObject.insert = function(todo) {
//         todo.id = ++id; // 1부터~
//         db = db.concat(todo); //conct() 배열 합침.
//         return todo;
//     }

//     return myObject;
// })(); // 즉시 실행 함수 생성

// const app = express();

// app.use(bodyParser.urlencoded({extended: false}));
// app.get("/todo", function(req, res) { // 리스트
//     res.send(MemoryDB.get());
// });
// app.post("/todo", function(req, res) { //내용추가
//     //todo
//     //dateTodo(일자), doTodo(내용), isTodo(했는지 여부)
//     let dateTodo = req.body.dateTodo;
//     let doTodo = req.body.doTodo;
//     let isTodo = req.body.isTodo;

//     if(dateTodo && doTodo && isTodo) { //생성 여부 확인
//         MemoryDB.insert({
//             dateTodo: dateTodo,   // 새로운 객체 속성 이름 : 넘어온 값
//             doToto: doTodo,
//             isTodo: isTodo        
//         }); //새로운 객체 생성

//         res.redirect('http://localhost:8888/todo');
//     } else {
//         throw new Error('Insert Error!');
//     }
// });
// app.get("/todo/:id", function(req, res) { // 객체(주소에 id값) 불러오기
//     res.send(MemoryDB.get(req.params.id));
// });
// app.put("/todo/:id", function(req, res) { //값 표시
    
// });
// app.delete("/todo/:id", function(req, res) { //값 삭제
    
// });

// app.listen(8888, () => {
//     console.log("8888");
// });

const express = require("express");
const bodyParser = require("body-parser");

const app = express();

const MemoryDB = (function() {
    let myObject = {};
    let db = [];
    let id = 0;

    myObject.get = function(id) {
        if(id) {
            id = (typeof id === 'string') ? Number(id) : id;
            return db.filter(todo => todo.id === id);
        } else {
            return db;
        }
    }

    myObject.insert = function(todo) {
        todo.id = ++id;
        db = db.concat(todo);
        return todo;
    }

    myObject.remove = function(id) {
        let result = false;

        if(id) {
            id = (typeof id === 'string') ? Number(id) : id;
            db = db.filter(todo => todo.id !== id);
            result = true;
        } else {
            db = [];
            result = true;
        }

        return result;
    }

    return myObject;
})();

app.use(bodyParser.urlencoded({extended: false}));
app.get("/todo", function(req, res) {
    res.send(MemoryDB.get());
});

app.post("/todo", function(req, res) {
    let dateTodo = req.body.dateTodo;
    let doTodo = req.body.doTodo;
    let isTodo = req.body.isTodo;

    if(dateTodo && doTodo && isTodo) {
        MemoryDB.insert({
            dateTodo: dateTodo,
            doTodo: doTodo,
            isTodo: isTodo
        });

        res.redirect('http://localhost:8888/todo');
    } else {
        throw new Error('Insert Error');
    }
});

app.get("/todo/:id", function(req, res) {
    res.send(MemoryDB.get(req.params.id));    
});

app.put("/todo/:id", function(req, res) {
    let id = req.params.id;
    let dateTodo = req.body.dateTodo;
    let doTodo = req.body.doTodo;
    let isTodo = req.body.isTodo;

    let todo = MemoryDB.get(id)[0];

    todo.dateTodo = dateTodo || todo.dateTodo;
    todo.doTodo = doTodo || todo.doTodo;
    todo.isTodo = isTodo || todo.isTodo;

    res.redirect('http://localhost:8888/todo');
});

app.delete("/todo/:id", function(req, res) {
    MemoryDB.remove(req.params.id);
    res.redirect('http://localhost:8888/todo');
});

app.delete("/todo", function(req, res) {
    MemoryDB.remove();
    res.redirect('http://localhost:8888/todo');
});

app.listen(8888, () => {
    console.log("8888");
});