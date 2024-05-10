import World from "./World";
import style from "./Hello.module.css";
import { useState } from "react";


export default function Hello({age}) {
    // console.log(props);
    
    // let name = "Mike"
    const [name, setName] = useState('Mike');
    const msg = age > 19 ? "성인 입니다." : "미성년자 입니다.";
    // const [age, setAge] = useState(props.age);

    // function changeName() {
    //     // const newName = name === "Mike" ? "Jane" : "Mike";
    //     // document.getElementById("name").innerText = name;
    //     setName(name === "Mike" ? "Jane" : "Mike");
    // }

    function showAge(age) {
        console.log(age);
    }

    function showName() {
        console.log('asdasd');
    }

    function showText(txt) {
        console.log(txt);
    }
    return(
        <div>
            <h2>{name}({age}) : {msg} </h2>
            <button onClick={() => {
                setName(name === "Mike" ? "Jane" : "Mike");
                // setAge(age + 1);
            }}>Change</button>

            {/* <h1>Hello</h1>
            <button onClick={showName}>Show name</button>
            <button onClick={
                ()=> {
                    showAge(23123);
                }
            }>Show age</button>
            <input type="text" onChange={e => {
                const txt = e.target.value;
                showText(txt);
            }} /> */}
        </div>
    );
}


// const Hello = () => {
//         return <p>Hello</p>;
        
//     };
    
        
//     export default Hello;