/*
    내장 모듈
    os 모듈: 실행되는 서버의 운영체제 정보
    url 모듈: 웹 주소에 관한 정보
    crypto 모듈: 암호화 모듈
*/

let os = require("os");
let url = require("url");
let crypto = require("crypto");

// console.dir(os);
console.log(os.hostname());
console.log(os.uptime());

console.dir(url);
let address = "https://user:pass@sub.example.com:8080/p/a/t/h?query=string#hash";
let urlObject = url.parse(address);
console.log(urlObject.port);
console.log(urlObject.hostname);

//복구 불가능
let sha = crypto.createHash("sha256");
sha.update("test1234") //key - 텍스트
console.log(sha.digest("base64"));
console.log("\n");
let sha2 = crypto.createHash("sha256");
sha2.update("test1234") //key - 텍스트
console.log(sha2.digest("hex"));

//복구 가능
//암호화
let key = "효성";
let pass = "홍길동";
let chipher = crypto.createCipher("aes192", key);
chipher.update(pass, "utf8", "hex");
let coutput = chipher.final("hex");

//복고화(decoding)
let dChipher = crypto.createDecipher("aes192", key);
dChipher.update(coutput, "hex", "utf8");
let doutput = dChipher.final("utf8");

console.log("원본: " + pass);
console.log("암호화: " + coutput);
console.log("복고화: " + doutput);