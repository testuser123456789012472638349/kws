import { useState, useRef, useEffect } from "react";

function InputSample() {

    const [inputs, setInputs] = useState({
        name: '',
        nickname: ''
    });

    const {name, nickname} = inputs;

    const nameInput = useRef();
    const nickinput = useRef();

    useEffect(() => {
        // nameInput.current.style = "background-color: red";
        nickinput.current.onclick = function() {
            //alert('test');
        };
    }, []);
    

    const onChange = (e) => {
        // console.log(e.target.name + " : " + e.target.value);
        const {name, value} = e.target;
        const newValue = {
            ...inputs,
            [name]: value
        };
        setInputs(newValue);
    }

    const onReset = () => {
        setInputs({
            name: '',
            nickname: ''
        });
        nameInput.current.focus();
        nameInput.current.style = "background-color: lightgreen";
    }

    //SPA - 단일 페이지 앱

    const checkSumbit = (e) => {
        //console.log(nameInput.current.value);
        //console.log(nickinput.current.value);
        //console.log(name);
        //console.log(nickname);
        if(name === '') {
            alert('이름을 입력해 주세요.');
            nameInput.current.focus();
            e.preventDefault(); //전송 취소
            return;
        }

        if(nickname === '') {
            alert('닉네임을 입력해 주세요.');
            nickinput.current.focus();
            e.preventDefault(); //전송 취소
        }
    }

    return (
        <div>
            <form action="http://www.naver.com" method="post" onSubmit={checkSumbit}>
                <input placeholder="이름" name='name' value={name} onChange={onChange} ref={nameInput} /> {/* 무한반복: 단순 setText를 이용하면 무한 반복 - 다른 함수로 감싸줘야함 */}
                <input placeholder="닉네임" name='nickname' value={nickname}  onChange={onChange} ref={nickinput} />
                <button onClick={onReset}>초기화</button>
                <div>
                    <b>값: </b> {name}({nickname})
                </div>
                <button>전송</button>
            </form>
        </div>
    );
}

export default InputSample;