//console.log('hello');

const container = document.querySelector(".image-container");
const startButton = document.querySelector(".start-button");
const gameText = document.querySelector(".game-text");
const playTime = document.querySelector(".play-time");

const tileCount = 16;

let tiles = [];
const dragged = {
    el: null,
    class: null,
    index: null
}

let isPlaying = false;
let timeInterval = null;
let time = 0;

// console.log(tiles);

// setGame();

// function

function setGame() {
    isPlaying = true;
    time = 0;
    container.innerHTML = "";
    gameText.computedStyleMap.display = 'none';
    clearInterval(timeInterval);
    tiles = createImageTiles();
    tiles.forEach(tile=> container.appendChild(tile));
    setTimeout(() => {
        container.innerHTML = "";
        shuffle(tiles).forEach(tile=> container.appendChild(tile));
        timeInterval = setInterval(() => {
            playTime.innerText = time;
            time++;
        }, 1000);
    }, 5000);
}

function createImageTiles() {
    const tempArray = [];
    Array(tileCount).fill().forEach((_, i) => {
        const li = document.createElement("li");
        li.setAttribute('data-index', i);
        li.setAttribute('draggable', 'true');
        li.classList.add(`list${i}`);
        // console.log(li);
        tempArray.push(li);
        // container.appendChild(li);
    });
    return tempArray;
}

function shuffle(array) {
    let index = array.length - 1;
    while(index > 0) {
        const randomIndex = Math.floor(Math.random() * (index + 1));
        [array[index], array[randomIndex]] = [array[randomIndex], array[index]];
        index --;
    }
    return array;
}

function checkStatus() {
    const currentList = [...container.children];
    const unMatchedList = currentList.filter((child, index) => Number(child.getAttribute("data-index")) !== index);
    if(unMatchedList.length === 0) {
        gameText.computedStyleMap.display = "block";
        isPlaying = false;
        clearInterval(timeInterval);
    }
}

//events
container.addEventListener('dragstart', e => {
    if(!isPlaying) return;
    const obj = e.target;
    dragged.el = obj;
    dragged.class = obj.className;
    // console.log(typeof e.target.parentNode.children);
    dragged.index = [ ...obj.parentNode.children].indexOf(obj);
    // console.log(e);
});
container.addEventListener('dragover', e => {
    e.preventDefault();
    // console.log('over');
});
container.addEventListener('drop', e => {
    if(!isPlaying) return;
    const obj = e.target;

    // console.log({ obj} );
    

    if(obj.className !== dragged.class) {
        let originPlace;
        let isLast = false;

        if(dragged.el.nextSibling) {
            originPlace = dragged.el.nextSibling;
        } else {
            originPlace = dragged.el.previousSibling;
            isLast = true;
        }
        const droppedIndex = [...obj.parentNode.children].indexOf(obj);
        dragged.index > droppedIndex ? obj.before(dragged.el) : obj.after(dragged.el);
        isLast ? originPlace.after(obj) : originPlace.before(obj);
    };
    checkStatus();
    // console.log('dropped');
    // console.log({ obj });
});

startButton.addEventListener('click', () => {
    setGame();
});