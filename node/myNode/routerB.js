const express = require("express");

const routerB = express.Router();

// locahost:8888/b/---
routerB.get("/", function(req, res) {
    res.send("routerB");
});
routerB.get("/show", function(req, res) {
    res.send("routerB show");
});

exports.routerB = routerB;