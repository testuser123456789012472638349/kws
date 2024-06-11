/**
 * express, socket.io
 */

// make server and socket
// connecting socket and disconnecting socket
// enroll and delete players id(socket.id)
// load game(temp).html(chcking inside game Area(clear(), show(), etc....))
//(js file) after connecting sercer(io(server name).sockets.on("connecting", function(socket){socket.on("wanting connecting something", function(data){...data})}))
//(including html file) socket.on("connection", function(data) {socket.emit("wanting connecting something", wanting data){....data}})
const fs = require("fs");
const http = require("http");
const express = require("express");
const socket = require("socket.io");

const app = express();
const server = http.createServer(app);

app.get("/", function(req, res) {
    fs.readFile("game(temp).html", "utf-8", function(err, data) {
        res.send(data);
    });
});

server.listen(7777, function() {
    console.log(7777);
});

const io = socket.listen(server);

let players = [];

io.sockets.on("connection", function(socket) {
    console.log(socket.id);
    socket.on("new_join", function(data) {
        // console.clear();
        players.push(data);
        // console.log(players);
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