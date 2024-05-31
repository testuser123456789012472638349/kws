const express = require("express");

const routerA = express.Router();

// locahost:8888/a/---
routerA.get("/", function(req, res) {
    res.send("routerA");
});
routerA.get("/about", function(req, res) {
    res.send("routerA about");
});

exports.routerA = routerA;