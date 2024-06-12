const fs = require("fs");
const http = require("http");
const express = require("express");
const socket = require("socket.io");

const app = express();
const server = http.createServer(app);

app.get("/", function(req, res) {
    fs.readFile("temp2.html", "utf-8", function(err, data) {
        res.send(data);
    });
});

const io = socket.listen(server);

io.sockets.on("connection", function(socket) {

    

    const req = io.eio;
    console.log(req);
    // const ip = req.headers['x-forwarded-for'] || req.connection.remoteAddress;

    // console.log('새로운 클라이언트 접속!', ip, socket.id, req.ip);

    // const req = socket.request;
    // const ip = req.headers['x-forwarded-for'] || req.connection.remoteAddress;

    // console.log('새로운 클라이언트 접속!', ip, socket.id, req.ip);
});

server.listen(7777, function() {
    console.log(7777);
});