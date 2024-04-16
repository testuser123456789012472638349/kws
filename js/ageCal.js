let now = new Date();
let year = now.getFullYear();
let birthYear = prompt("생년을 입력하세요.(예, 1999)", "1999");

// Number.isInteger(birthYear) ? null : alert('숫자만 입력해주세요.'); 
birthYear = Number(birthYear); //형변환 - 문자를 숫자로 변경해주는 Number생성자 함수
console.log(birthYear);

let age = year - birthYear + 1;
const ADULTAGE = 18;

let grownup = age > ADULTAGE ? "성인" : "미성년"; //삼항 연산자

let display = document.getElementById("display");

display.innerHTML = !Number.isInteger(birthYear) ? "<p style='color: red'>숫자만 입력해주세요.</p>" : "<h1>당신의 나이는 " + age + "이며, " + grownup + "이군요.</h1>";


var heading = document.querySelector('#display');
heading.onclick = function() {
    heading.style.color = "red";
}

let hyosung = {
    d3: 4,
    aws: 5,
    web: 7
};
console.dir(window);
console.log(typeof hyosung);
console.dir(hyosung.d3);
let man = {
    name: '홍길동',
    age: 28,
    weight: 78,
    height: 199
};
console.dir(man);
console.log(man.name);

let str;
console.log(str);
string = "";
console.log(typeof str);
console.log("test \" \" test");
console.log("나\b는 " + man.name + "\n입 \t니다.");
console.log(`나는 ${man.name}입니다.`);
console.log(typeof `나는 ${man.name}입니다.`);
console.dir(string);
console.log(man.name.length);
alert("We are the so-called \"Vikings\" from the north.<br>");
let backticks = `
&nbsp; &nbsp; 우리나라<br>
    좋은나라
`;
alert(backticks);
display.innerHTML += backticks;
let x = "John";
let y = "John";
console.log(`x == y : ${x == y}`);
console.log(`x === y : ${x === y}`);
y = new String("John"); //사용 안함.
console.log(`x == new y : ${x == y}`);
console.log(`x === new y : ${x === y}`);
x = new String("John");
console.log(`new x == new y : ${x == y}`);
console.log(`new x === new y : ${x === y}`);
console.log(999999999999999);
console.log(9999999999999999);

display.innerHTML += "<br><hr>";

let myNumber = 2;
let txt = "";
while(myNumber != Infinity) {
    myNumber *= myNumber;
    txt += myNumber + "<br>";
}
display.innerHTML += txt;

console.log(2/0);
console.log(-2/0);

myNumber = 25654;
console.log(myNumber.toString(32));
console.log(myNumber.toString(16));
console.log(myNumber.toString(12));
console.log(myNumber.toString(10));
console.log(myNumber.toString(8));
console.log(myNumber.toString(2));