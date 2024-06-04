-- show databases;
#CREATE DATABASE kws;
#DROP DATABASE kws;

CREATE TABLE users (
	uid int NOT NULL AUTO_INCREMENT,
	uname varchar(10) NOT NULL,
    uage int,
    PRIMARY KEY(uid)
);

-- USE kws;
-- SHOW TABLES; 
-- USE sakila;
-- SHOW TABLES;
-- DROP TABLE users;
-- DESC users;

-- CREATE TABLE copy_users SELECT uid FROM users;
-- DESC copy_users;
-- DROP TABLES copy_users;
-- 컬럼 추가
-- ALTER TABLE users ADD address varchar(255);
-- 컬럼 삭제
-- ALTER TABLE users DROP COLUMN address;
-- DESC users;
-- 컬럼 타입 수정
-- ALTER TABLE users MODIFY COLUMN uage date;
-- DESC users;
-- 컬럼 이름 수정
ALTER TABLE users CHANGE COLUMN uage ubrith date;
DESC users;

INSERT INTO users(uname, uage)
VALUES ('홍길동', 25);
INSERT INTO users(uname, uage)
VALUES ('고길동', 5);
INSERT INTO users(uname, uage)
VALUES ('마길동', 65);
INSERT INTO users(uname, uage)
VALUES ('최길동', 15);

INSERT INTO users()
VALUES ();

SELECT * FROM users;
SELECT count(*) FROM users;

ALTER TABLE users MODIFY COLUMN uage int NOT NULL;
ALTER TABLE users MODIFY COLUMN uname varchar(255) NOT NULL;

-- 테이블 삭제
DROP TABLE users;

-- 내용 삭제
DELETE FROM users;

ALTER TABLE users ADD PRIMARY KEY(uid);
DESC users;

-- AUTO_INCREMENT 추가(자동 증가)
ALTER TABLE users
MODIFY uid int AUTO_INCREMENT; 