const http = require('http');
const url = require('url');

const server = http.createServer((req, res) => {
    if(req.method === "GET") {
        let query = url.parse(req.url, true).query;
        console.log(query);
        res.writeHead(200, {"Content-Type": "text/html; charset=utf-8" });
        res.end(`
        <a href = '/?name=고길동&age=15'>link</a>
        <a href = '/?name=마길동&age=35'>link</a>
        <h1>${JSON.stringify(query)}</h1>
        <form method='POST'>
            <input type='text' name='uname'><br>
            <input type='number' name='uage'><br>
            <input type='submit' value='전송'>
        </form>
        `);
    } else {
        console.log("POST");
        req.on('data', function(data) {
            res.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
            // console.log(data.toString());
            const objUser = makeObject(data.toString());
            //encodeURI(문자열) => url로 변경 (암호화)
            //decodeURI(문자열) => 일반문자로 변경 (복고화)
            res.end(`
                <a href='/?name=고길동&age=15'>link</a>
                <a href='/?name=마길동&age=35'>link</a>
                <h1>${"이름: " + decodeURI(objUser.uname) + " 나이: " + objUser.uage}</h1>
                <form method='POST'>
                    <input type='text' name='uname'><br>
                    <input type='number' name='uage'><br>
                    <input type='submit' value='전송'>
                </form>
            `);
        });
    }
});

function makeObject(str) {
    let arrProps = str.split('&');
    let obj = {};
    arrProps.forEach(val => {
        let arrProp = val.split("=");
        obj[arrProp[0]] = arrProp[1];
    });
    console.log(obj);
    return obj;
}

server.listen(8888, function() {
    console.log("8888");
});