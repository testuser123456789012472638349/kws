//실제 체중, 신장
let realWeight = 0; //실제 체중
let realHeight = 0; //실제 신장
let standardWeight = 0; //표준체중
let obesity = 0; //비만도
let bmi = "";
let str = "";

let bgStyle = "";
const bgColors = ["low", "nomal", "big1", "big2"];
const bmiWords = ["저체중", "정상", "비만1단계", "비만2단계"];


realWeight = Number(prompt("실제 체중을 입력하세요. (예, 50kg이라면 50)"));
//realWeight = !isNaN(Number(realWeight)) ? Number(realWeight) : alert("숫자만 입력하세요.");
if(isNaN(realWeight)) { //사용자가 문자를 넣음.
    alert("실제 체중은 숫자만 입력해주세요.");   
    location.reload(); //새로고침   
} else { //사용자가 숫자 사용
    realHeight = Number(prompt("실제 신장을 입력하세요. (예, 170cm이라면 170)"));

    if(isNaN(realHeight)) {
        alert("실제 신장은 숫자만 입력해주세요.");
        location.reload(); //새로고침
    } else { //사용자가 숫자 사용
        if(realHeight >= 160) {
            standardWeight = (realHeight - 100) * 0.9;
        } else if(realHeight >= 150) {
            standardWeight = (realHeight - 150) * 0.5 + 50;
        } else {
            standardWeight = realHeight - 100;
        }

        obesity = (realWeight - standardWeight) / standardWeight * 100;

        if(obesity < 18.5) {
            bmi = bmiWords[0];
            bgStyle = bgColors[0];
        } else if(obesity <= 24.9) {
            bmi = bmiWords[1];
            bgStyle = bgColors[1];
        } else if(obesity <= 29.9) {
            bmi = bmiWords[2];
            bgStyle = bgColors[2];
        } else {
            bmi = bmiWords[3];
            bgStyle = bgColors[3];
        }

        document.body.classList.remove(...bgColors);
        document.body.classList.add(bgStyle);

        str = `
            <p>당신의 체중은 ${realWeight}이고 신장은 ${realHeight}입니다.</p>
            <p>당신의 키에 대한 표준 체중은 ${standardWeight}이고 비만도는 ${obesity.toFixed(2)}이므고</p>
            <p>당신은 <b>${bmi}</b>입니다.</p>
        `;
        display.innerHTML = str;
    }
}




// 조건1 ? 참 : 조건2 ? 참 : 거짓
// standardWeight = realHeight >= 160 ? 
//     (realHeight - 100) * 0.9 : realHeight >= 150 ? 
//     (realHeight - 150) * 0.5 + 50 : realHeight - 100;

// obesity = (realWeight - standardWeight) / standardWeight * 100;

// bmi = obesity < 18.5 ? "저체중" : obesity <= 24.9 ? "정상" : obesity <= 29.9 ? "비만 1단계" : "비만 2단계";

// str = `
//     <p>당신의 체중은 ${realWeight}이고 신장은 ${realHeight}입니다.</p>
//     <p>당신의 키에 대한 표준 체중은 ${standardWeight}이고 비만도는 ${obesity.toFixed(2)}이므고</p>
//     <p>당신은 <b>${bmi}</b>입니다.</p>
// `;
// display.innerHTML = str;
