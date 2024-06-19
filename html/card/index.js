const cardArray = [
    {
        name: "one",
        img: "./public/one.png",
        id: null,
        done: false,
    },
    {
        name: "one",
        img: "./public/one.png",
        id: null,
        done: false,
    },
    {
        name: "two",
        img: "./public/two.png",
        id: null,
        done: false,
    },
    {
        name: "two",
        img: "./public/two.png",
        id: null,
        done: false,
    },
    {
        name: "three",
        img: "./public/three.png",
        id: null,
        done: false,
    },
    {
        name: "three",
        img: "./public/three.png",
        id: null,
        done: false,
    },
    {
        name: "four",
        img: "./public/four.png",
        id: null,
        done: false,
    },
    {
        name: "four",
        img: "./public/four.png",
        id: null,
        done: false,
    },
    {
        name: "five",
        img: "./public/five.png",
        id: null,
        done: false,
    },
    {
        name: "five",
        img: "./public/five.png",
        id: null,
        done: false,
    },
    {
        name: "six",
        img: "./public/six.png",
        id: null,
        done: false,
    },
    {
        name: "six",
        img: "./public/six.png",
        id: null,
        done: false,
    },
];

const gameDOM = [];
let clickFirst = -1;
let clickSecond = -1;
let clickCount = 0;
const getGameDOM = () => {
    // console.log("getGameDOM 실행");
    const rows = document.querySelectorAll(".container .row");
    for(let i = 0; i < rows.length; i++) {
        gameDOM[i] = rows[i].querySelectorAll(".column");   
    };
    // console.log(gameDOM);
    //gameDOM[1][2];
};

const setIDtoCardArray = () => {
    cardArray[0].id = "0-0";
    cardArray[1].id = "0-1";
    cardArray[2].id = "0-2";
    cardArray[3].id = "0-3";
    cardArray[4].id = "1-0";
    cardArray[5].id = "1-1";
    cardArray[6].id = "1-2";
    cardArray[7].id = "1-3";
    cardArray[8].id = "2-0";
    cardArray[9].id = "2-1";
    cardArray[10].id = "2-2";
    cardArray[11].id = "2-3";
};

const createBoard = () => {
    //console.log("물음표 가득");
    for(let i = 0; i < gameDOM.length; i++) {
        for(let j = 0; j < gameDOM[i].length; j++) {
            const card = document.createElement("img");
            card.setAttribute("src", "./public/Question-Mark.png");
            card.classList.add("eachImage");
            gameDOM[i][j].appendChild(card);
        }
    }
    //console.log(gameDOM);
}

const setClickHistory = (location) => {
    if(clickFirst === -1) {
        clickFirst = location;
    } else {
        clickSecond = location;
    }
};

const backFlip = () => {
    const parseIdFirst = cardArray[clickFirst].id.split("-");
    const parseIdSecond = cardArray[clickSecond].id.split("-");
    setTimeout(() => {
        gameDOM[parseIdFirst[0]][parseIdFirst[1]].querySelector("img").src = "./public/Question-Mark.png";
        gameDOM[parseIdSecond[0]][parseIdSecond[1]].querySelector("img").src = "./public/Question-Mark.png";
    }, 500);
};

const isCorrect = () => {
    //console.log("isCorrect 함수 실행");
    if(cardArray[clickFirst].name === cardArray[clickSecond].name) {
        cardArray[clickFirst].done = true;
        cardArray[clickSecond].done = true;
    } else {
        //console.log("일치 안함");
        backFlip();
    }
};

const flip = (location) => {
    //console.log(location);
    if(!cardArray[location].done) {
        //console.log(location);
        //console.log(cardArray[location].id.split("-"));
        setClickHistory(location);
        const parseId = cardArray[location].id.split("-");
        gameDOM[parseId[0]][parseId[1]].querySelector("img").src = cardArray[location].img;
        //console.log(clickFirst, clickSecond);
        clickCount++;
        if(clickCount === 2) {
            clickCount = 0;
            isCorrect();
        }
    if(clickFirst !== -1 && clickSecond !== -1) {
        clickFirst = -1;
        clickSecond = -1;
        }
    }
    
};

onload = () => {
    //console.log("DOM is ready");
    getGameDOM();
    cardArray.sort(() => 0.5 - Math.random());
    // console.log(cardArray);
    setIDtoCardArray();
    //console.log(cardArray);
    createBoard();
}