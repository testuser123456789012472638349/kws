var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

canvas.width = window.innerWidth - 100;
canvas.height = window.innerHeight - 100;

// ctx.fillStyle = 'green';
// ctx.fillRect(10,10, 100,100);

var dino = {
    x : 10,
    y : 200,
    width : 50,
    height : 50,
    draw() {
        ctx.fillStyle = 'green';
        ctx.fillRect(this.x, this.y, this.width, this.height);
        ctx.drawImage(img2, this.x, this.y);
    }
}
// dino.x += 1;
// dino.draw();

var img1 = new Image();
img1.src = 'cactus.png';

var img2 = new Image(); 
img2.src = 'dinosaur.png';

class Cactus {
    constructor() {
        this.x = 500;
        this.y = 200;
        this.width = 50;
        this.height = 50;
    }
    draw() {
        ctx.fillStyle = 'red';
        // ctx.fillRect(this.x, this.y, this.width, this.height);
        ctx.drawImage(img1, this.x, this.y);
    }
}
var cactus = new Cactus();
// cactus.draw();

var timer = 0;
var cactuss = [];
var Jumptimer = 0;
var animation;

function doEachFrame() {
    animation = requestAnimationFrame(doEachFrame); //60times for 1sec(move cha)
    timer++;

    ctx.clearRect(0,0, canvas.width, canvas.height);

    if(timer % 250 === 0) {
        var cactus = new Cactus();
        cactuss.push(cactus);
    }
    cactuss.forEach((a, i , o) => {
        if(a.x < 0) {//remove drawing cactus at 0(x display)
            o.splice(i, 1); //remove
        }
        a.x--;
    
        meet(dino, a);
        
        a.draw();
        
    });
    if(Isjumping == true) {
        dino.y -= 2; //jump dino
        Jumptimer++;
    }
    if(Isjumping == false) {
        if(dino.y < 200) {
            dino.y++;
        }
    }
    if(Jumptimer > 60) {
        Isjumping = false;
        Jumptimer = 0;
    }
    // cactus.draw();
    dino.draw();
}
doEachFrame();

// check
function meet(dino, cactus) {
    var disX = cactus.x - (dino.x + dino.width); //x-distance
    var disY = cactus.y - (dino.y + dino.height); //y-distance
    if(disX < 0 && disY < 0) { //meet
        ctx.clearRect(0,0, canvas.width, canvas.height); // cavas intion
        cancelAnimationFrame(animation);
    }
}

var Isjumping = false;

document.addEventListener('keydown', function(e) {
    if(e.code === 'Space') {
        Isjumping = true;
    }
});

