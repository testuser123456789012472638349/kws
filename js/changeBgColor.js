function ChangeBgColor() {
    //지역변수
    let arrColorList = ['red', 'green', 'blue'];

    //초기화
    this.init = function(target) {
        //요소를 만드는 방법
        //1. 문자로 생성
        //2. 객체로 생성
        if(!target) {
            document.body.insertAdjacentHTML('afterbegin', '<button>색상변경</button>');
        } else {
            let btnColor = document.createElement('button');
            btnColor.innerText = '색상변경';
            btnColor.onclick = changeBackground;
            document.getElementById(target).insertAdjacentElement('afterbegin', btnColor);
        }
    }

    function changeBackground() {
        document.body.style.backgroundColor = arrColorList[Math.floor((Math.random() * 3))];
    }

}