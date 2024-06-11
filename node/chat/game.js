/**
 * express, socket.io
 */
const fs = require("fs");
const http = require("http");
const express = require("express");
const socket = require("socket.io");

const app = express();
const server = http.createServer(app);

app.get("/", function(req, res) {
    fs.readFile("game.html", "utf-8", function(err, data) {
        res.send(data);
    });
});

server.listen(8888, function() {
    console.log(8888);
});

const io = socket.listen(server);

let players = [];

io.sockets.on("connection", function(socket) {
    socket.on("new_join", function(data) {
        // console.clear();
        players.push(data);
        // console.log(players);
        io.sockets.emit("gameUpdate", players);
    });
    socket.on("move", function(data) {
        players = players.map(player => {
            if(player.id === data.id) {
                return data;
            } else {
                return player;
            }
        });
        isCollision(players);
        io.sockets.emit("gameUpdate", players);
    });
    socket.on("disconnect", function(reson) {
        // console.clear();
        players = players.filter(player => {
            return player.id !== socket.id;
        });
        // console.log(players);
        io.sockets.emit("gameUpdate", players);
    });
});

function isCollision(players) {
    let len = players.length;
    for(let i = len - 1; i > 0; i--) {
        for(let j = 0; j < i; j++) {
            if(players[i].y < players[j].y + players[j].height 
            && players[i].y + players[i].height > players[j].y 
            && players[i].x < players[j].x + players[j].width 
            && players[i].x + players[i].width > players[j].x) {
                io.sockets.emit("collision", {aname: players[i].name, bname: players[j].name});
            }
        }
    }
}