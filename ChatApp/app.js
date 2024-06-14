const { Socket } = require("dgram");
const express = require("express");
const http = require("http");
const app = express();
const path = require("path");
const server = http.createServer(app);
const socketIO = require("socket.io");
const moment = require("moment");

const io = socketIO(server);

app.use(express.static(path.join(__dirname, "src")));

const PORT = process.env.PORT || 7777;

server.listen(PORT, () => {
    console.log(`running at ${PORT}`);
});

io.on("connection", (socket) => {
    socket.on("chatting", (data) => {
        const { name, msg, time } = data;
        io.emit("chatting", {
            name: name,
            msg: msg,
            time: moment(new Date()).format("h:ss A")
        });
    });
});