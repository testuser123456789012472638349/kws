const fs = require("fs");
const http = require("http");

const port = 7777;

function getExtension(url) {
    let fileName = url.substring(1);
    let arrFileName = fileName.split(".");
    console.log(arrFileName);
    return {
        name: arrFileName[0],
        ext: arrFileName[1]
    };
}

function getFile(res, path) {
    const extentions = ["/", "html", "png", "css", "mp3", "js"];
    const contentTypes = ["text/html","text/html","image/png","text/css","audio/mp3","text/script"];

    if(path === extentions[0]) {
        readFile(res, 'index', 'html', contentTypes[0]);
    } else {
        const {name, ext} = getExtension(path);

        for(let i = 1; i < extentions.length; i++) {
            if(extentions[i] === ext) {
                readFile(res, name, ext, contentTypes[i]);
                break;
            }
        }
        return;
    }
}

// function readFile(res, name, ext, type) {
//     fs.readFile(`${name}.${ext}`, function(err, data) {
//         res.writeHead(200, {"Content-type": type});
//         res.end(data);
//     });
// }

//쿠키: 서버에서 클라이언트에게 심어놓은 정보 파일
function readFile(res, name, ext, type) {
    fs.readFile(`${name}.${ext}`, function(err, data) {
        if(name === "index")
            res.writeHead(200, {"Content-type": type, "Set-Cookie": [`path=${name}`, `accDate=${new Date().toUTCString()}`]});
        else 
            res.writeHead(200, {"Content-type": type});
        
        res.end(data);
    });
}

http.createServer(function(req, res) {
    getFile(res, req.url);
    // console.log(req.url);
    // getExtension(req.url);
    // console.log("----------------------------------");

    // const {name, ext} = getExtension(req.url);

    // if(req.url === "/")
    //     fs.readFile("index.html", function(err, data) {
    //         res.writeHead(200, {"Content-type": "text/html"});
    //         res.end(data);
    //     });

    // if(ext === 'png')
    //     fs.readFile(name + "." + ext, function(err, data) {
    //         res.writeHead(200, {"Content-type": "image/png"});
    //         res.end(data);
    //     });
    
    // if(ext === 'mp3')
    //     fs.readFile(name + "." + ext, function(err, data) {
    //         res.writeHead(200, {"Content-type": "audio/mp3"});
    //         res.end(data);
    //     });

}).listen(port, function() {
    console.log("run at " + port);
});