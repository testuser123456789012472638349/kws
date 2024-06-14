// import path from 'path';
// import { fileURLToPath } from 'url';
// import { dirname } from 'path';

// const _filename = fileURLToPath(import.meta.url);
// const __dirname = dirname(_filename);

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

server.listen(PORT, () => console.log(`server is running ${PORT}`));

io.on("connection", (socket) => {
    // console.log('Now connecting!!!');
    socket.on("chatting", (data) => { //get 1 chat.js 넘겨받은 데이터
        // console.log(data);
        const { name, msg } = data;
        // io.emit("chatting", data);
        io.emit("chatting", {
            name: name,   // 넘겨줄 : 넘겨받은 변수(생략가능)
            msg: msg,
            time: moment(new Date()).format("h:ss A") //"YYYY-MM-DD HH:mm:ss"
        });
    });
});