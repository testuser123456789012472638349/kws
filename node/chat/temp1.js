// const app = require('express')();
// const http = require('http').createServer(app);
// const fs = require("fs");

// const io = require('socket.io')(http);

// let rooms = [];

// app.get('/', (req, res) => {
//     fs.readFile("temp1.html", "utf-8", function(err,data) {
//         res.send(data);
//     });
// });

// io.on('connection', (socket)=>{
//     socket.on('request_message', (msg) => {
//         // response_message로 접속중인 모든 사용자에게 msg 를 담은 정보를 방출한다.
//         io.emit('response_message', msg);
//     });

//     // 방참여 요청
//     socket.on('req_join_room', async (msg) => {
//         let roomName = 'Room_' + msg;
//         if(!rooms.includes(roomName)) {
//             rooms.push(roomName);
//         }else{
            
//         }
//         socket.join(roomName);
//         io.to(roomName).emit('noti_join_room', "방에 입장하였습니다.");
//     });

//     // 채팅방에 채팅 요청
//     socket.on('req_room_message', async(msg) => {
//         let userCurrentRoom = getUserCurrentRoom(socket);
//         io.to(userCurrentRoom).emit('noti_room_message', msg);
//     });

//     socket.on('disconnect', async () => {
//         console.log('user disconnected');
//     });
// });
// // TEST CODE GOES HERE
// (async function(){
// })();

// function getUserCurrentRoom(socket){
//     let currentRoom = '';
//     let socketRooms = Object.keys(socket.rooms);

//     for( let i = 0 ; i < socketRooms.length; i ++ ){
//         if(socketRooms[i].indexOf('Room_') !== -1){
//             currentRoom = socketRooms[i];
//             break;
//         } 
//     }
//     return currentRoom;
// }


// http.listen(7777, () => {
//     console.log('Connected at 7777!!');
// });

var express = require("express");
var app = express();
var http = require("http").Server(app);
var io = require("socket.io")(http);
var fs = require("fs");

// Client가 서버에 접속하면(GET 방식) 다음 html 파일을 응답으로 보냅니다. - callback 함수
app.get('/', (req, res) => {
    fs.readFile("temp1.html", "utf-8", function(err,data) {
        res.send(data);
    });
});

// 서버를 실행
// Q. 왜 3000일까? 기본적으로 실행되는 포트번호는 3000 입니다.
//    해당 포트가 사용 중일 경우 다른 포트번호로 변경 가능합니다.
http.listen(7777, function () {
  console.log("Server가 실행 중 입니다. Server의 포트번호는 7777번 입니다. ");
});

// 서버는 한 개이나 여러 명의 클라이언트가 참가할 수 있습니다.
// 참가한 클라이언트들을 보관하는 배열입니다.
var clientList = [];

// socket 통신 - 클라이언트가 연결을 요청하였습니다.
//  서버와 클라이언트 간의 connection을 생성합니다.
io.on("connection", function (socket) {
  let joinedClient = false;
  let nickname; // 접속한 클라이언트의 nickname

  // 클라이언트가 채팅에 참여를 요청하였습니다.
  socket.on("join", function (data) {
    console.log(data);
    // 채팅 참여시 요청으로 들어온 data의 값은 nickname 입니다.
    // join한 클라이언트가 이미 입장하였다면 false return 합니다.
    if (joinedClient) {
      return false;
    }

    // join한 클라이언트가 아니라면, clientList에 추가합니다.
    // 해당 채팅방에 접속한 클라이언트들에게 새로운 참석자의 nickname과
    // 현재 채팅방에 접속 중인 클라이언트의 리스트를 응답으로 전송합니다.
    nickname = data;
    clientList.push(nickname);
    socket.broadcast.emit("join", {
      nickname: nickname,
      clientList: clientList,
    });

    joinedClient = true;
  });

  // client가 메시지를 전달하였습니다.
  socket.on("msg", function (data) {
    console.log(`msg: ${data}`);
    io.emit("msg", {
      nickname: nickname,
      msg: data,
    });
  });

  // client가 접속 종료를 요청하였습니다.
  socket.on("disconnect", function () {
    // 입장하지 않은 Client가 접속 종료를 요청하였다면 false를 return 합니다.
    if (!joinedClient) {
      console.log("This Client is not joined");
      return false;
    }

    // 입장한 Client가 접속 종료를 요청했다면, client를 clientList에서 지운 뒤,
    // 해당 채팅방에 접속한 모든 사용자에게 한 client가 접속을 종료하였다는 사실을 알립니다.
    // 채팅방에 남은 사용자 리스트를 떠난 client의 nickname과 함께 응답으로 전송합니다.
    var index = clientList.indexOf(nickname);
    clientList.splice(index, 1);
    socket.broadcast.emit("left", {
      nickname: nickname,
      clientList: clientList,
    });
  });
});