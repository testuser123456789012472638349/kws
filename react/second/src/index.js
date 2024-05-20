import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Hello from './Hello.js';
import Counter from './Counter.js';
import Game from './Game.js';
import InputSample from './js/InputSample.js';
import UserList from './UserList.js';
import StockManager from './Stock/StockManger.js'

//react 단일페이지애프리케이션 - SPA

const root = ReactDOM.createRoot(document.getElementById('root'));

//props
// let userName = "홍길동";
let fontSize = 20;
let userObject = {
  userImg: 'https://i.etsystatic.com/21654192/r/il/2e5170/4547408392/il_570xN.4547408392_4911.jpg',
  userAge: 30
};

//사용자 컴포넌트는 이벤트가 작동하지 않음

//부모 컴포넌트의 자료는 props로 자식 컴포넌트에게 전송
//자식 컴포넌트이 자료는 부모에게 받은 함수를 사용

//컴포넌트 자신의 자료는 state로 관리

//회원관리

root.render(
  <>
    <StockManager />
    <UserList />
    <InputSample />
    <Game />
    <button onClick={() => {
      alert('test');
    }}>click</button>
    {true ? <Hello fsize={fontSize} userObject={userObject} onClick={() => {
      alert('test');
    }} isSpecial={'test'}>
      <h1>Hello World</h1>
      <input type="text" />
    </Hello> : <App />}
    <Counter />
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
