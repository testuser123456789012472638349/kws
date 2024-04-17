let fahrenheit = 0;
let Celsius = 0;

Celsius = Number(prompt("온도를 입력하세요. (예, 16도라면 16)"));
if(isNaN(Celsius)) {
    alert("실제 온도를 입력하세요");
    location.reload();
} else {
    fahrenheit = Celsius * 9 / 5 + 32;

str = `
            <p>입력하신 온도는 ${Celsius}도(섭씨)이고, 입력하신 온도의 화씨는 ${fahrenheit}도입니다.</p>
        `;

        display.innerHTML = str;
}