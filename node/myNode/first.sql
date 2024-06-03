-- SqL - 데이터베이스 질의어(DDL, DCL, DML(주로 사용))
-- 관계형 데이터 베이스
-- DBMS - 데이터베이스 관리 프로그램
-- DB: 테이블들을 저장하는 공간
-- table: 자료를 저장하는 공간
-- 행: 레코드, 튜플, 객체, 로우
-- 열: 속성, 어트리뷰트(Attribute) 릴레이션의 열을 '속성' 또는 어트리뷰트, 필드, 컬럼
-- 스키마(Schema) 데이터베이스에 저장되는 데이터 구조와 제약조건을 정의한 것이다. 데이터베이스 스키마는 모든 테이블, 열 이름 및 유형, 인덱스 등을 설명한다.
-- 인스턴스(Instance) 정의된 스키마에 따라 데이터베이스에 실제로 저장된 값을 인스턴스라고 한다.
-- 테이블(Table) 테이블은 행과 열로 구성된 데이터 집합입니다. 흔히 볼 수 있는 하나의 표라고 생각하면 된다.
-- 릴레이션(Relation) 보통 관계 데이터 모델(관계형 데이터베이스)의 테이블을 릴레이션(Relation)이라고 부른다. 튜플(Tuple)과 어트리뷰트(Attribute)로 구성되어있다. 쉽게 말해, 엑셀이나 스프레드 시트와 같은 것이라고 보면 된다.
-- 뷰(View) 다른 테이블을 기반으로 만들어진 가상 테이블을 뷰라고 한다. 뷰는 일반 테이블과 달리 데이터를 실제로 저장하고 있지는 않다. 논리적으로만 존재하면서 일반 물리적으로 존재하는 테이블과 동일한 방법으로 사용할 수 있다.
-- 투플(Tuple) 릴레이션의 행을 튜플이라고 부른다.
-- 키(Key) 키는 데이터베이스에서 조건에 만족하는 튜플을 찾거나 순서대로 정렬할 때 다른 튜플들과 구별할 수 있는 유일한 기준이 되는 속성이다.
-- 필드(Field) 파일 구조에서 열을 필드라고 한다. 따라서 필드, 열, 속성은 유사한 의미를 가진다.
-- 레코드(Record) 파일 구조에서 행 또는 튜플을 레코드라고 한다. 따라서 레코드, 행, 튜플은 유사한 의미를 가진다.
-- 차수(Degree) 하나의 릴레이션에서 속성의 전체 개수를 릴레이션의 차수라고 한다. 릴레이션의 차수는 일반적으로 자주 변하지 않는다는 정적인 특징이 있다.
-- 카디널리트(Cardinality) 하나의 릴레이션에서 투플(행)의 전체 개수를 릴레이션의 카디널리티라고 한다. 투플이 존재하지 않는 릴레이션이 있을 수 있으며, 삽입과 삭제가 반복적으로 일어날 수 있어 일반적으로 자주 변한다는 동적인 특징이 있다.

-- USE 데이터베이스이름 - 데이터베이스 선택
-- DESC 테이블이름 - 테이블 디자인 확인



--MySQL Workbench 프로그램(프로그램 비밀번호: 0000)
-- show databases;
-- use world;
-- show tables;
-- #SELECT  DISTINCT Name, ID
-- #FROM city;
-- SELECT *
-- FROM country
-- WHERE (Region LIKE '%a%'
-- 	AND Code IN ('ATA', 'COD', 'SLV'))
-- 	OR Capital BETWEEN 50 AND 100
-- ORDER BY Region ASC;

-- #SELECT now()
-----------------------------------------
--show databases;
--use sakila; #데이터 베이스 선택
--show tables;
----------------------------------------
--show databases;
--#CREATE DATABASE kws; 데이터베이스 생성
--#DROP DATABASE kws; 데이터베이스 삭제

-- CREATE TABLE users ( -- 테이블 생성 방법1
-- 	uid int,
-- 	uname varchar(10),
--     uage int
-- );

-- USE kws;
-- SHOW TABLES; 
-- CREATE TABLE users (
-- 	uid int,
-- 	uname varchar(10),
--     uage int
-- );
-- DESC users;   테이블 디자인 확인

-- CREATE TABLE copy_users SELECT uid FROM users; 기존 테이블의 부분 복사(테이블 생성 방법2)
-- DESC copy_users; 테이블 디자인 확인

-- 컬럼 추가
-- ALTER TABLE users ADD address varchar(255);
-- 컬럼 삭제
-- ALTER TABLE users DROP COLUMN address;
-- DESC copy_users; 테이블 디자인 확인
-- 컬럼 타입 수정
--ALTER TABLE users MODIFY COLUMN uage date;
--DESC users; 테이블 디자인 확인
-- 컬럼 이름 수정
-- ALTER TABLE users CHANGE COLUMN uage ubrith date;
-- DESC users;

-- INSERT INTO users(uid, uname, uage)
-- VALUES (1, '홍길동', 25);

-- INSERT INTO users()
-- VALUES ();

-- SELECT * FROM users;
-- SELECT count(*) FROM users;

-- ALTER TABLE users MODIFY COLUMN uage int NOT NULL;
-- ALTER TABLE users MODIFY COLUMN uname varchar(255) NOT NULL;

-- -- 테이블 삭제
-- DROP TABLE users;

-- 내용 삭제
-- DELETE FROM users WHERE uname = 1;
-- DELETE FROM users;(전체 내용 삭제)

-- ALTER TABLE users ADD PRIMARY KEY(uid);
-- DESC users;

-- AUTO_INCREMENT 추가(자동 증가)
-- ALTER TABLE users
-- MODIFY uid int AUTO_INCREMENT; 

-- INSERT INTO users(uname, uage)
-- VALUES ('고길동', 5);
-- INSERT INTO users(uname, uage)
-- VALUES ('마길동', 65);
-- INSERT INTO users(uname, uage)
-- VALUES ('최길동', 15);

-- uid 값 자동 증가 확인(SELECT * FROM users;)