// window.onload = function() { //이벤트 처리기
    
// };

window.addEventListener('load', function() { //이벤트 추가
    var heading = document.querySelector('#heading');
    heading.onclick = function() {
        heading.style.color = 'red';
    };
});

//이벤트 추가 방법
//1. on...  속성 이용 - 기존 내용 삭제
//2. addEventListener 메서드 이용 - 기존 내용 유지

/* 
    프로그래밍
    1. 변수 - 내용 저장 공간
    2. 함수 - 작업 저장 공간

    3. 객체 - 이벤트(함수), 속성(변수), 메서드(함수)
*/

console.dir(window);
// window.alert('안녕하세요?');
// let isOk = window.confirm('정말 배경 이미지를 바꾸겠습니까?');
// if(isOk) {
//     console.log('확인');
// } else {
//     console.log('취소');
// }
// let userAnswer = window.prompt("이름을 입력하세요", "홍길동");
// console.log(userAnswer);
console.dir(document);
document.write(new String("test"));
document.write("단순 문자열");
document.write(["문자열", "배열", "<hr>"]);


//에러 처리
try {
    //에러가 발생할만한 내용
    //document.writ('test');
} catch(err) {
    //에러 처리
    //에러가 발생하면 여기가 작동
    //alert(err);
} finally {
    //에러 처리 후 무조건 실행
    console.log('run');
}

// var now = new Date();
// console.dir(now); //날짜 객체
// var cur = now.getFullYear();
// console.log(cur); //숫자타입의 날짜
// var bir, age;

// bir = prompt("태어난 연도를 입력해주세요.(YYYY)", "");
// age = cur - bir;
// document.write(cur + "년 현재<br>");
// document.write(bir + "년에 태어난 사람의 나이는 " + age + "세 입니다.");

/*
    if(조건1) {
        조건1일 참일때 실행
    } else if(조건2) {
        조건2가 참일 때 실행
    } ... {

    } else {
        모든 조건이 거짓일 때 실행
    }
    */

    // var userNumber = prompt("숫자를 입력하세요.");

    // // if(userNumber !== null && userNumber !== "") {
    // //     if(userNumber % 3 === 0) {
    // //         alert("3의 배수입니다");
    // //     } else if(userNumber % 7 === 0) {
    // //         alert("7의 배수입니다.");
    // //     } else {
    // //         alert("3 또는 7의 배수가 아닙니다.");
    // //     }
    // // } else {
    // //     alert('입력값 취소');
    // // }
   
    // (userNumber !== null && userNumber !== "") ? 
    //     ((userNumber % 3 === 0) ? 
    //         alert("3의 배수") 
    //     : ((userNumber % 7 === 0) ? 
    //             alert("7의 배수") 
    //             : alert("3의 배수가 아닙니다."))) 
    // : alert("취소");

    // var numberOne = prompt("10 미만인 숫자를 입력하세요.");
    // var numberTwo = prompt("10 미만인 숫자를 입력하세요.");

    // if(numberOne < 10 && numberTwo < 10) {
    //     alert("모든 숫자가 10미만");
    // } else {
    //     alert("최소 하나의 숫자가 10이상");
    // }

    // console.log(!true);

    // var memNum = prompt("입장객은 몇 명인가요?");
    // var colNum = prompt("한 줄에 몇 명씩 앉습니까?");
    // var rowNum = 0;

    // // console.log(parseInt(memNum / colNum));
    // // console.log(memNum % colNum);
    // if(memNum % colNum === 0) {
    //    rowNum = parseInt(memNum / colNum);
    // } else {
    //    rowNum = parseInt(memNum / colNum) + 1;
    // }

    // document.write(rowNum + "개의 줄이 필요");

    // var sum = 0;

    // for(var i =1; i < 6; i++) {
    //     sum += i;
    // }
    // console.log(i);
    // console.log(sum);


    // document.write("1부터 5까지 합: " + sum);

    // var n = prompt("숫자를 입력하세요.");
    // var msg = "";

    // if(n !== null && n !== "") {
    //     var nFact = 1;
    //     var i = 1;

    //     while(i <= n) {
    //         nFact *= i; //nFact = nFact * i;
    //         i++;
    //     }

    //     msg = n + "! = " + nFact;
    // } else {
    //     msg = "취소";
    // }

    // if(n !== null && n !== "") {
    //     var nFact = 1;
    //     var i = 100;
    
    //     do {
    //         nFact *= i;
    //         i++;
    //     } while(i <= n);
    
    //     msg = n + "! = " + nFact;
    // } else {
    //     msg = "취소";
    // }

    // console.log(msg);

    // 거짓 : 0, null, undefined, "", false
    // 참: 위의 값을 제외한 모든 값

    for(let i = 0; i < 100; i++) {
        if(i === 50) break; //for, switch
        if(i % 2 === 0) continue;
        console.log(i);
    }
    