const express = require("express");
const http = require("http");
const socket = require("socket.io");
const fs = require("fs");


const server = http.createServer(function(req, res) {
    fs.readFile("test.html", function(err, data) {
        res.writeHead(200, {"Content-Type" : "text/html"});
        res.end(data);
    });
}).listen(9999, function() {
    console.log(9999);
});

const io = socket.listen(server);

io.sockets.on('connection', function(socket) {
    console.log(socket.id, 'connected!!!!!!!!!!!');

    io.sockets.emit('msg', `${socket.id}`);

    socket.on('msg', function (data) {
        socket.broadcast.emit('msg', `${socket.id}: ${data}`);
    });

    socket.on('disconnect', function(data) {
        io.sockets.emit('msg', `${socket.id}`);
    });
});