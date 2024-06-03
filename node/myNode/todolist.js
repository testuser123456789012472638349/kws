/**
 * 서버 메모리 to do list
 * 
 * Get /todo 리스트 표시
 * Post / todo 내용 추가
 * Get /todo/:id 특정 내용 표시
 * Put /todo/:id 특정 내용 수정
 * Delete /todo/:id 특정 내용 삭제
 */

const express = require("express");
const bodyParser = require("body-parser");

const MemoryDB = (function() { //값 추가 삭제 기능
    let myObject = {};
    let db = [];
    let id = 0;

    myObject.get = function(id) {
        if(id) {
            id = (typeof id === 'string') ? Number(id) : id; // id는 문자로 넘어오기 때문
            return db.filter(todo => todo.id === id); //filter() 반복하면서 값을 체크하는 메소드
        } else {
            return db;
        }
    } // 리스트 전부를 반환하는 메소드 : get()

    myObject.insert = function(todo) {
        todo.id = ++id; // 1부터~
        db = db.concat(todo); //conct() 배열 합침.
        return todo;
    }

    myObject.remove = function(id) { //삭제 메소드
        let result = false;

        if(id) {
            id = (typeof id === 'string') ? Number(id) : id; //id를 숫자화
            db = db.filter(todo => todo.id !== id);
            result = true;
        } else { // 전체 삭제(id값 없을시)
            db = []; 
            result = true;
        }

        return result;
    }

    return myObject;
})(); // 즉시 실행 함수 생성

const app = express();

app.use(bodyParser.urlencoded({extended: false}));
app.get("/todo", function(req, res) { // 리스트
    res.send(MemoryDB.get());
});
app.post("/todo", function(req, res) { //내용추가
    //todo
    //dateTodo(일자), doTodo(내용), isTodo(했는지 여부)
    let dateTodo = req.body.dateTodo;
    let doTodo = req.body.doTodo;
    let isTodo = req.body.isTodo;

    if(dateTodo && doTodo && isTodo) { //생성 여부 확인
        MemoryDB.insert({
            dateTodo: dateTodo,   // 새로운 객체 속성 이름 : 넘어온 값
            doTodo: doTodo,
            isTodo: isTodo        
        }); //새로운 객체 생성

        res.redirect('http://localhost:8888/todo');
    } else {
        throw new Error('Insert Error!');
    }
});
app.get("/todo/:id", function(req, res) { // 객체(주소에 id값) 불러오기
    res.send(MemoryDB.get(req.params.id));
});
app.put("/todo/:id", function(req, res) { //값 수정
    let id = req.params.id;
    let dateTodo = req.body.dateTodo;
    let doTodo = req.body.doTodo;
    let isTodo = req.body.isTodo;
    
    let todo = MemoryDB.get(id);
    console.log(todo[0].dateTodo);

    todo[0].dateTodo = dateTodo || todo[0].dateTodo; //넘어온 값 대체 || 기존값 대체
    todo[0].doTodo = doTodo || todo[0].doTodo; //넘어온 값 대체 || 기존값 대체
    todo[0].isTodo = isTodo || todo[0].isTodo; //넘어온 값 대체 || 기존값 대체

    // let todo = MemoryDB.get(id)[0]; 상단과 결과값 동일 (배열)

    // todo.dateTodo = dateTodo || todo.dateTodo;
    // todo.doTodo = doTodo || todo.doTodo;
    // todo.isTodo = isTodo || todo.isTodo;

    res.redirect('http://localhost:8888/todo' + id); // 해당페이지(id)으로 이동
});
app.delete("/todo/:id", function(req, res) { //값 삭제
    MemoryDB.remove(req.params.id); //상단 remove 메소드 확인
    res.redirect('http://localhost:8888/todo');
});
app.delete("/todo", function(req, res) { //값 전체 삭제 (동일 주소관련 추가)
    MemoryDB.remove();
    res.redirect('http://localhost:8888/todo');
});

app.listen(8888, () => {
    console.log("8888");
});