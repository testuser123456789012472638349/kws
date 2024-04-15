let now = new Date();
let year = now.getFullYear();
let birthYear = prompt("생년을 입력하세요.(예, 1999)", "1999");
let age = year - birthYear + 1;

let display = document.getElementById("display");
display.innerHTML = "<h1>당신의 나이는 " + age + "살이군요.</h1>";


var heading = document.querySelector('#display');
heading.onclick = function() {
    heading.style.color = "red";
}
