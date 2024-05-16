import { useState, useRef, useEffect } from "react";

function InputSample() {
    const [inputs, setInputs] = useState({
        name: '',
        nickname: '',
        phoneNumber: ''
    });

    const nameInput = useRef();
    const nickinput = useRef();
    const phoneNumberInput = useRef();

    useEffect(() => {
        nameInput.current.style = "background-color: red";
        phoneNumberInput.current.style = "color: red";
        nickinput.current.onclick = function() {
            alert('닉네임을 입력해주세요~');
        };
        phoneNumberInput.current.onclick = function() {
            alert('휴대전화번호를 입력해주세요~');
        };
    }, []);


    const {name, nickname, phoneNumber} = inputs;

    const onChange = (e) => {
        // setText(e.target.value);
        // console.log(e.target.name + " : " + e.target.value);
        const {name, value, phoneNumber} = e.target;
        const newValue = {
            ...inputs,
            [name]: value 
        };
        setInputs(newValue);

        // setInputs({
        //     ...inputs,
        //     // [e.target.name] : e.target.value
        //     [name]: value
        // });
    };

    const onReset = () => {
        // setText('');
        setInputs({
            name: '',
            nickname: '',
            phoneNumber: ''
        });
        nameInput.current.focus();
        nameInput.current.style = "background-color: lightgreen";
    };

    //SPA - 단일 페이지 앱

    const checkSubmit = (e) => {
        //console.log(nameInput.current.value);
        //console.log(nickinput.current.value);
        //console.log(name);
        //console.log(nickname)
        if(name === '' || name === null) {
            alert('이름을 입력해 주세요.');
            nameInput.current.focus();
            e.preventDefault(); //전송 취소
            return;
        }

        if(nickname === '' || nickname === null) {
            alert('닉네임을 입력해 주세요.');
            nickinput.current.focus();
            e.preventDefault(); //전송 취소
            return;
        }

        if(phoneNumber === '' || phoneNumber === null) {
            alert('닉네임을 입력해 주세요.');
            phoneNumber.current.focus();
            e.preventDefault(); //전송 취소
            return false;
        }
    }

    return (
        <div>
            <form action="http://www.naver.com" method="post" onSubmit={checkSubmit}>
                <input name="name" placeholder="이름" value={name} onChange={onChange} ref={nameInput} /> {/* 무한반복: 단순 setText를 이용하면 무한 반복 - 다른 함수로 감싸줘야함 */}
                <input name="nickname" placeholder="닉네임" value={nickname} onChange={onChange} ref={nickinput} />
                <input name="phoneNumber" placeholder="휴대전화번호" value={phoneNumber} onChange={onChange} ref={phoneNumberInput} />
                <button onClick={onReset}>초기화</button>
                <div>
                    <b>이름: </b> 
                    {name}
                    ('별명: ' + {nickname})
                    ('휴대전화번호: ' + {phoneNumber})
                </div>
                <button>전송</button>
        </form>
        </div>
    );
}

export default InputSample;