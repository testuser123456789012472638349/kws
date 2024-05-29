let fs = require("fs");
let bp = require("body-parser");
let express = require("express");
const bodyParser = require("body-parser");

let app = express();

app.use(bodyParser.urlencoded({extended: false}));

app.get("/", (req, res) => {
    fs.readFile("sendPost.html", (err, content) => {
        res.send(content.toString());
    });
});

app.post("/", (req, res) => {
    // console.log(req.body);
    // console.log(req.body.uname);
    // console.log(req.body.uage);

    const {uname, uage} = req.body;
    res.send(`이름: ${uname}, 나이: ${uage}`);
});

app.all("*", (req, res) => {
    res.status(404).send("not");
});

app.listen(8888, () => {
    console.log(8888);
});