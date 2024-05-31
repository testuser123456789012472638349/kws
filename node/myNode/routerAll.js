const express = require("express");
const routerA = require("./routerA").routerA;
const routerB = require("./routerB").routerB;

const app = express();

app.use("/a", routerA);
app.use("/b", routerB);
app.get("/", function(req, res) {
    res.send("main");
});
app.all("*", function(req, res) {
    res.status(404).send("not found!");
});

app.listen(8888, function() {
    console.log(8888);
});