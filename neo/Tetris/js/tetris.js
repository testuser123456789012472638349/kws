import BLOCKS from "./blocks.js";

// DOM
const playground = document.querySelector(".playground > ul");
const gameText = document.querySelector(".game-text");
const scoreDisplay = document.querySelector(".score");
const restartButton = document.querySelector(".game-text > button");

// Setting
const Game_ROWS = 20;
const GAME_COLS = 10;


//variables
let score = 0;
let duration = 500;
let downInterval; 
let tempMovingItem; // temp store

// const BLOCKS = {
//     tree: [ // "ㅗ" shap type transition
//         [[2,1], [0,1], [1,0], [1,1]],
//         [[1,2], [0,1], [1,0], [1,1]],
//         [[1,2], [0,1], [2,1], [1,1]],
//         [[2,1], [1,2], [1,0], [1,1]], 
//     ]
// }

const movingItem = {
    type: "", //tree inside const BLCKS 
    direction: 3, //left, right moving
    top: 0, // top, bottom moving
    left: 0, // left, right value
};

init();

//functions
function init() {
    // const blockarray = Object.entries(BLOCKS); //updating method of Object in anoter js file
    // const randomIndex = Math.floor(Math.random() * blockarray.length);
    // console.log( blockarray[randomIndex][0]); --> move into generateNewBlock function
    //console.log(blockarray);
    // blockarray.forEach(block => {
    //     console.log(block[0]); // call BLOCKS name
    // })
    // console.log( blockarray[randomIndex][0]);
    // blockarray[randomIndex][0];
    // console.log(BLOCKS);
    tempMovingItem = { ...movingItem }; // only value
    // movingItem.left = 3;
    // console.log(tempMovingItem);

    for(let i = 0; i < 20; i++) {
        // console.log(i);
        // const li = document.createElement("li");
        // const ul = document.createElement("ul");
        // for(let j = 0; j < GAME_COLS; j++) {
        //     const matrix = document.createElement("li");
        //     ul.prepend(matrix);
        // }
        // li.prepend(ul);
        // playground.prepend(li);
    
        prependNewLine();
    }
    // renderBlocks();
    generateNewBlock()
}

// console.log(playground);


function prependNewLine() {
    const li = document.createElement("li");
    const ul = document.createElement("ul");
    for(let j = 0; j < GAME_COLS; j++) {
        const matrix = document.createElement("li");
        ul.prepend(matrix);
    }
    li.prepend(ul);
    playground.prepend(li);
}

function renderBlocks(moveType="") {
    const { type, direction, top, left } = tempMovingItem;
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        //console.log(moving); after delete li class="tree moving"
        moving.classList.remove(type, "moving");
    });
    // tempMovingItem.type;
    // tempMovingItem.direction;
    // tempMovingItem.top;
    // tempMovingItem.left;

    // console.log(type, direction, top, left);

    // console.log(BLOCKS[type][direction]);
    BLOCKS[type][direction].some(block => { // forEach -> some : when wanting discontiue, posible using  
        const x = block[0] + left;
        const y = block[1] + top;
        // const xxx = 조건 ? 참일경우 : 거짓일 경우(target ul 밖으로 나가지 않게 하기 위해 사용)
        const target = playground.childNodes[y] ? playground.childNodes[y].childNodes[0].childNodes[x] : null;
        const isAvailable =  checkEmpty(target);//밖으로 벗어나지 않는 역할 or 전에 쌓였던 블럭과 닿을 때 있는지 없는지 판단
        // const target = playground.childNodes[y].childNodes[0].childNodes[x];
        // console.log({ playground });
        // console.log(target);
        // target.classList.add(type, "moving"); //"moving" meaning : original class delete, after delete li class="tree moving"
        if(isAvailable) {
            target.classList.add(type, "moving"); 
        } else {
            tempMovingItem = { ...movingItem } // recovery
            if(moveType === 'retry') {
                clearInterval(downInterval);
                showGameoverText(); //game over function
            }
            // renderBlocks(); //recall function(posible : error name ? call stack maximum) // Do not enter inside event -> make setTimeout()
            setTimeout(() => {
                renderBlocks('retry'); //add : 'retry'(game over)
                if(moveType === "top") {
                    seizeBlock();  //when meeting floor or another block, make stopping block(function)
                }                      // add : add another  new block and check seizeblock
            }, 0); // 0 is no meaning
            return true; // forEach -> some : when wanting discontiue, posible using  
        }
    });
    movingItem.left = left;
    movingItem.top = top;
    movingItem.direction = direction;
}

function showGameoverText() {
    gameText.style.display = "flex";
}

function moveBlock(moveType, amount) {
    tempMovingItem[moveType] += amount; // add: target.classList.add("moving") 
    renderBlocks(moveType);
}

function checkEmpty(target) {
    if(!target || target.classList.contains("seized")) { // check empty || check including classList
        return false;
    }
    return true;
}

function seizeBlock() {
    // console.log('seize block');
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        moving.classList.remove("moving");
        moving.classList.add("seized");
    });
    chechMatch();
   // generateNewBlock(); //add new block
}
function chechMatch() {
    const childNodes = playground.childNodes;
    childNodes.forEach(child => {
        let matched = true;
        child.children[0].childNodes.forEach(li => { // one row
            if(!li.classList.contains("seized")) { //if Any row is seized, metched-> false
                matched = false;
            }
        });
        if(matched) {
            child.remove(); // if metched is false, child remove
            prependNewLine(); // add one row(top)
            score++;
            scoreDisplay.innerText = score + "점";
        }
    });
    generateNewBlock();
}
function generateNewBlock() { 
    clearInterval(downInterval);
    downInterval = setInterval(()=> {
        moveBlock('top', 1);
    },duration);


    const blockarray = Object.entries(BLOCKS); //updating method of Object in anoter js file
    const randomIndex = Math.floor(Math.random() * blockarray.length);
    movingItem.type = blockarray[randomIndex][0]; // after randomming block  -> change
    movingItem.top = 0;
    movingItem.left = 3;
    movingItem.direction = 0;
    tempMovingItem = { ...movingItem };
    renderBlocks();
}

function changeDirection() { // change direction(block shape)
    // tempMovingItem.direction += 1;
    // if(tempMovingItem.direction === 4) {
    //     tempMovingItem.direction = 0;
    // }  -> same content
    const  direction = tempMovingItem.direction;
    direction === 3 ? tempMovingItem.direction = 0 : tempMovingItem.direction += 1;
    renderBlocks();
}

function dropBlock() {
    clearInterval(downInterval);
    downInterval = setInterval(() => {
        moveBlock("top", 1);
    }, 10); // up speed
}

//event handling
document.addEventListener("keydown", e => {
    //console.log(e);
    switch(e.keyCode) {
        case 39: //moving right
            moveBlock("left", 1);
            break;
        case 37: //moving left
            moveBlock("left", -1);
            break;
        case 40: //moving down  // Do not need Top
            moveBlock("top", 1);
            break;
        case 38: //change direction key top
            changeDirection();
            break;
        case 32: //drop block(speedUp) key space bar
            dropBlock();
            break;
        default:
            break;
    }
});

restartButton.addEventListener("click", () => {
    playground.innerHTML = "";
    gameText.style.display = "none";
    init();
});