// import logo from './logo.svg';
import './App.css';
import React from 'react';
import Hello from './component/Hello.js';
import Welcome from './component/Welcome.js';
import style from './App.module.css';
import TicTacToc from './Components/TicTacToc/TicTacToc.jsx';

function App() {
  return (
    <div className="App">
      <h3>props</h3>
      <Hello age={10} />
      <Hello age={20} />
      <Hello age={30} />
      {/* <div className={style.box} /> */}
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
            <div>
            </div>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      <TicTacToc />
    </div>
  );
}

export default App;
