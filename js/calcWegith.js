//실제 체중, 신장
let realWeight = 0; //실제 체중
let realHeight = 0; //실제 신장
let standardWeight = 0; //표준체중
let obesity = 0; //비만도
let bmi = "";
let str = "";

realWeight = Number(prompt("실제 체중을 입력하세요. (예, 50kg이라면 50)"));
//realWeight = !isNaN(Number(realWeight)) ? Number(realWeight) : alert("숫자만 입력하세요.");
realHeight = Number(prompt("실제 신장을 입력하세요. (예, 170cm이라면 170)"));

//조건1 ? 참 : 조건2 ? 참 : 거짓
standardWeight = realHeight >= 160 ? 
(realHeight - 100) * 0.9 : realHeight >=150 ? 
(realHeight - 150) * 0.5 + 50 : realHeight - 100;

obesity = (realWeight - standardWeight) / standardWeight * 100;

bmi = obesity < 18.5 ? "저체중" : obesity <= 24.9 ? "정상" : obesity <= 29.9 ? "과체중 비만 1단계" : "과체중 비만 2단계";

str = `
<p>당신의 체중은 ${realWeight}kg이고 신장은 ${realHeight}cm입니다.</p>
<p>당신의 키에 대한 표준 체중은 ${standardWeight}kg, 비만도는 ${obesity.toFixed(2)}이므로</p>
<p>당신은 <h1>${bmi}</h1>입니다.</p>
`;
display.innerHTML = str;

