const fs = require("fs");
const http = require("http");
const socket = require("socket.io");

const server = http.createServer(function(req, res) {
    fs.readFile("chat.html", function(err, data) {
        res.writeHead(200, {"Content-Type" : "text/html"});
        res.end(data);
    });
}).listen(9999, function() {
    console.log(9999);
});

const io = socket.listen(server);
//connection이벤트 , disconnection 이벤트가 발생
io.sockets.on("connection", function(so) {
    // console.log(so);
    so.on("msg", function(data) {
        console.log(data);

        //public 모든 클라이언트들에게 전송
        io.sockets.emit("showMsg", data);

        //broadcast 자신을 제외한 클라이언트들에게 전송
        //so.broadcast.emit();

        //private 특정 클라이언트에게만 전송
        //io.sockets.to(id).emit();
    });

    so.on("redUp", function(data) {
        console.log(data);
        // io.sockets.emit("redUP");
        io.sockets.emit("redUp", data);
    });

    // so.on("Down", function(data) {
    //     io.sockets.emit("Down", data);
    // });
    so.on("redDown", function(data) {
        io.sockets.emit("redDown", data);
    });
    so.on("redLeft", function(data) {
        io.sockets.emit("redLeft", data);
    });
    so.on("redRight", function(data) {
        io.sockets.emit("redRight", data);
    });

    so.on("blueUp", function(data) {
        io.sockets.emit("blueUp", data);
    });
    so.on("blueDown", function(data) {
        io.sockets.emit("blueDown", data);
    });
    so.on("blueLeft", function(data) {
        io.sockets.emit("blueLeft", data);
    });
    so.on("blueRight", function(data) {
        io.sockets.emit("blueRight", data);
    });
});