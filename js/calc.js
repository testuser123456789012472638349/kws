let buttons = document.getElementsByTagName("button");
let str = "", op = "", equal = "";
let num = 0, num1 = 0, num2 = 0;

for(let i = 0; i < buttons.length; i++) {
    buttons[i].onclick = function() {
        clickButton(buttons[i].innerText);
    };
}

function clickButton(val) {
    if(isNaN(val)) { //true이면 기호(연산자)
        equal = val; // 연산자 '='
        if(equal === "=") {
            num2 = num;
            display.value = calc(op, num1, num2).toLocaleString("ko-KR");
            initCalc();
        } else { // 연산자 '+, -, *, /'
            str = "";
            op = equal;
            num1 = num;
            display.value = "";
        }
    } else { // 숫자
        str += val;
        num = Number(str);
        display.value = num.toLocaleString("ko-KR"); //쉼표 입력 가능하기 위해 입력
    }
}

function calc(op, num1, num2) {
    switch(op) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "x":
            return num1 * num2;
        case "/":
            return num1 / num2;
        case "C":
            initCalc();
            break;
    }
}

function initCalc() {
    str = "", op = "", equal = "";
    num = 0, num1 = 0, num2 = 0;
}