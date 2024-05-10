import logo from './logo.svg';
import './App.css';
import { Fragment } from 'react';

function App() {

  let bgcolor = 'red';
  return (
    /* 
      JSX
      1. 꼭 닫혀야 하는 태그
      2. 꼭 감싸져야하는 태그(부모) - 부모로 대신 사용(Fragment) <></>, <Fragment></Fragment>
      3. JSX안에서 JS의 내용은 {}로 감쌈.
      4. class 속성은 className을 사용, style은 객체로 값을 지정
      5. JSX의 주석 {\/* JSX의 주석 *\/}
    
    react는 값을 유지함(리로드 하지 않음).

    props : 부모 컴포넌트가 자식 컴포넌트에게 데이터를 전송하는 방식
    */

    <Fragment>
      <hr />
      {bgcolor}
      <div className="App" style={{backgroundColor: bgcolor, borderRadius: '100px'}} data-value={bgcolor}>
        <hr></hr>
        <br></br>
        {/* JSX의 주석 */}
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            {/* Edit <code>src/App.js</code> and save to reload. */}
            Hello world!
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    </Fragment>  
  );
}

export default App;
