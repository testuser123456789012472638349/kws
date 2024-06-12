const fs = require("fs");
const http = require("http");
const socket = require("socket.io");

const server = http.createServer(function(req, res) {
    fs.readFile("test.html", function(err, data) {
        res.writeHead(200, {"Content-Type" : "text/html"});
        res.end(data);
    });
}).listen(8888, function() {
    console.log(8888);
});

const io = socket.listen(server);
//connection이벤트 , disconnection 이벤트가 발생


io.sockets.on("connection", function(so) {
    //console.log(so.id);

    let players = [];

    so.on("userId", function(data) {
        players.push(data);
        console.log(players);
        io.sockets.emit("userUpdata", players);
    });

    so.on("msg", function(data) {
        //console.log(data);

        //public 모든 클라이언트들에게 전송
        io.sockets.emit("showMsg", data);

        //broadcast 자신을 제외한 클라이언트들에게 전송
        //so.broadcast.emit()

        //private 특정 클라이언트에게만 전송
        //io.sockets.to(id).emit()
    });

    so.on("primsg", function(data) {
        io.sockets.emit("showPrimsg", data);
    });

    so.on("disconnect", function(reason) {
        players = players.filter(player => {
            return player.id !== so.id;
        });
    });
});
