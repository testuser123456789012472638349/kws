//사용 변수
const GAME_TIME = 10;
let score = 0;
let time = GAME_TIME;
let isPlaying = false;
let timeInterval;
let words = [];
let checkInterval;

const wordinput = document.querySelector(".word-input");
const wordDisplay = document.querySelector(".word-display");
const scoreDisplay = document.querySelector(".score");
const timeDisplay = document.querySelector(".time");
const button = document.querySelector(".button")

// console.log(wordinput);

init();

function init() {
    buttonChange("게임 로딩 중");
    getWords();
    wordinput.addEventListener("input", checkMatch);
}

function checkStatus() {
    if(!isPlaying && time === 0) {
        // buttonChange("게임 종료");
        buttonChange("게임 시작");
        clearInterval(checkInterval);
    }
}

//call words
function getWords() {
    axios.get('https://random-word-api.herokuapp.com/word?number=100')
    .then(function (response) {
        // handle success
        response.data.forEach((word) => {
            if(word.length < 10) {
                words.push(word);
            }
        });
        buttonChange("게임시작");
        // console.log(words);
        // words = response.data;
        // console.log(response.data);
    })
    .catch(function (error) {
        // handle error
        console.log(error);
    })
    // words = ['Hello', 'Banana', 'Apple', 'Cherry'];
    // buttonChange("게임 시작");
}

// wordinput.addEventListener("input", () => {
//     //console.log(wordinput.value.toLowerCase() === wordDisplay.innerText.toLowerCase());
//     if(wordinput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()) {
//         score++;
//         scoreDisplay.innerText = score;
//         wordinput.value = "";
//     }
// });

//matching check some words
function checkMatch() {
    if(wordinput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()) {
        wordinput.value = "";
        if(!isPlaying) {
            return;
        }
        score++;
        scoreDisplay.innerText = score;
        time = GAME_TIME;
        const randomIndex = Math.floor(Math.random() * words.length);
        wordDisplay.innerText = words[randomIndex];
    }
}

// setInterval(countDown, 1000);
// buttonChange("게임 시작");
// game start
function run() {
    if(isPlaying) {
        return;
    }
    isPlaying = true;
    time = GAME_TIME;
    timeInterval = setInterval(countDown, 1000);
    checkInterval = setInterval(checkStatus, 50);
    wordinput.focus();
    scoreDisplay.innerText = 0;
    buttonChange("게임 중");
}

function countDown() {
    time > 0 ? time-- : isPlaying = false;
    if(!isPlaying) {
        clearInterval(timeInterval);
    }
    timeDisplay.innerText = time;

}

function buttonChange(text) {
    button.innerText = text;
    text === "게임 시작" ? button.classList.remove('loading') :  button.classList.add('loading')
}