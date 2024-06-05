const fs = require("fs");
const ejs = require("ejs");
const mysql = require("mysql");
const express = require("express");
const bodyParser = require("body-parser");

const client = mysql.createConnection({
    user: "root",
    password: "0000",
    database: "kws"
});

const app = express();
app.use(bodyParser.urlencoded({extended: false}));
app.listen(8888, function() {
    console.log("8888");
});
app.get("/", function(req, res) {
    fs.readFile("query.html", "utf-8", function(err, data) {
        res.send(ejs.render(data, {
            code: -1,
            query: '',
            error: null,
            result: null
        }));
    });
});
app.post("/", function(req, res) {
    const {query} = req.body;

    //수정
    // \n 개행문자(new line)
    // \r 개행문자(캐리지 리턴)
    const run = query.replace(/\n|\r/g, ' ');
    fs.readFile("query.html", "utf-8", function(err, data) {
        client.query(query, function(sqlError, result) {
            if(sqlError) {
                res.send(ejs.render(data, {
                    code: 0,
                    error: sqlError.sqlMessage,
                    result: null,
                    query: query
                }));
            } else {
                res.send(ejs.render(data, {
                    code: 1,
                    error: null,
                    result: result,
                    query: query
                }));
            }
        });
    });
});