let fs = require("fs");
let ejs = require("ejs");
let express = require("express");
let bodyParser = require("body-parser");
let cookieParser = require("cookie-parser");

let app = express();

app.use(cookieParser());
app.use(bodyParser.urlencoded({extended: false}));

const users = [
    {
        uid: '고길동',
        uname: '고길동',
        upass: 28
    },
    {
        uid: '홍길동',
        uname: '홍길동',
        upass: 12
    },
    {
        uid: '마길동',
        uname: '마길동',
        upass: 28
    },
    {
        uid: '최길동',
        uname: '최길동',
        upass: 28
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

app.get("/", (req, res) => {
    if(req.cookies.auth) {
        res.send("환영합니다. " + req.cookies.uname + "님<br><a href='/logout'>로그아웃</a>");
    } else {
        res.send("<a href='/login'>login</a><a href='/join'>회원가입</a>");
    }
}); //메인 페이지

app.get('/join', (req, res) => {
    res.send(`
        <form method='post'>
            <input type='text' name='uid' placeholder='아이디'><br>
            <input type='password' name='upass' placeholder='비번'><br>
            <input type='text' name='uname' placeholder='이름'><br>
            <input type='submit' value='join'><br>
        </form>
    `);
});

app.post('/join', (req, res) => {
    const {uid, uname, upass} = req.body;

    let user = {
        uid: uid,
        uname: uname,
        upass: upass
    };

    users.push(user);
    res.send(`
        <script>
            alert('환영합니다. ${uname}님.\\n로그인 해주세요.');
            location.href = '/login';
        </script>
    `);
});

app.get("/login", (req, res) => {
    fs.readFile("login.html", (err, data) => {
        let log = false;
        if(req.query) {
            log = req.query.log;   
        }
        res.send(ejs.render(data.toString(), {log: log}));
    });
}); //로그인 페이지

// app.post("/login", (req, res) => {
//     const {uid, upass} = req.body;
//     if(uid === userId && upass === userPass) {
//         res.cookie("auth", true);
//         res.redirect("/");
//     } else {
//         res.redirect("/login?log=false");
//     }
// }); //로그인 처리 페이지

app.post("/login", (req, res) => {
    const {uid, upass} = req.body;
    if(uname = isUser(uid, upass)) {
        res.cookie("auth", true);
        res.cookie("uname", uname);
        res.redirect("/");
    } else {
        res.redirect("/login?log=true");
    }
}); //로그인 처리 페이지(아이디 및 비번 일치 유무 추가)

function isUser(uid, upass) {
    let user = users.find(user => user.uid === uid && user.upass);
    if(user) return user.uname;
    return false;
} //아이디 및 비번 일치 유무 함수

app.get("/logout", (req, res) => {
    res.clearCookie("auth");
    res.redirect("/");
}); //로그아웃

app.listen(8888, () => {
    console.log(8888);
});