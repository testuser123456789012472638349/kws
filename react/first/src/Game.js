import React from "react";
import './Game.css';

class Square extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        
        return <button 
                    className="square" 
                    onClick={this.props.onClick} 
                >{this.props.value}</button>;
    }
}

function calculateWinner(squares) {
    const lines = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
      ];

    for(let i = 0; i < lines.length; i++) {
        const [a, b, c] = lines[i];
        // console.log(squares[a], squares[b], squares[c]);
        if(squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
            return squares[a];
        }
    }

    return null;
}


class Board extends React.Component {
     
    renderSquare(i) {
        return <Square 
                value={this.props.squares[i]} 
                onClick={() => this.props.onClick(i)} 
            />;
    }

    render() {
        return (
            <div>
                <div className="board-row">
                    {this.renderSquare(0)}
                    {this.renderSquare(1)}
                    {this.renderSquare(2)}
                </div>
                <div className="board-row">
                    {this.renderSquare(3)}
                    {this.renderSquare(4)}
                    {this.renderSquare(5)}
                </div>
                <div className="board-row">
                    {this.renderSquare(6)}
                    {this.renderSquare(7)}
                    {this.renderSquare(8)}
                </div>
            </div>
        );
    }
}

class Game extends React.Component { //Object
    constructor(props) {
        super(props);

        this.state = {
            history: [
                {
                    squares: Array(9).fill(null)
                }
            ],
            xIsNext: true,
            stepNumber: 0
        };
    }

    handleClick(i) {

        let history = this.state.history.slice(0, this.state.stepNumber + 1);
        const squares = history[history.length - 1].squares.slice();
        // console.log(squares);

        if(squares[i]) return;
        if(calculateWinner(squares)) return;

        const xIsNext = this.state.xIsNext;

        squares[i] = xIsNext ? 'X' : 'O';
        history = history.concat({squares: squares});
        this.setState({history: history, xIsNext: !xIsNext, stepNumber: this.state.stepNumber + 1});

    }

    jumpTo(move) {
        console.log(move);  
        this.setState({
            stepNumber: move,
            xIsNext: move % 2 === 0
        });
    }

    render() {
        // console.clear();
        // console.dir(this); //this 객체의 자신
        // slice(start[, end]) 
        // start: 시작하는 인덱스 값
        // end: 종료 인덱스(자신은 미포함)
        const history = this.state.history.slice();
        // console.log(history);
        const current = history[this.state.stepNumber].squares;
        let status;
        let winner = calculateWinner(current);
        if(winner) {
            status = 'Winner player : ' + winner;
        } else {
            status = 'Next player : ' + (this.state.xIsNext ? 'X' : 'O');
        }

        const moves = history.map((step, move) => {
            const desc = move ? 'Go to move #' + move : 'Go to start';
            return (
                <li key={move}>
                    <button onClick={() => this.jumpTo(move)}>{desc}</button>
                </li>
            );
        });

        return (
            <div className="game">
                <div className="game-board">
                    <Board squares={current} onClick={(i) => this.handleClick(i)} />
                </div>
                <div className="game-info">
                    <div>{status}</div>
                    <ol>{moves}</ol>
                </div>
            </div>
        );
    }
}
    

export default Game;