USE mycardb;

SELECT * FROM tbl_carmanager;


CREATE TABLE tbl_users (
username	VARCHAR(15)		PRIMARY KEY,
password	VARCHAR(255)	NOT NULL	,
u_name	VARCHAR(20)	NOT NULL	,
u_nickname	VARCHAR(20)		,
u_tel	VARCHAR(15)		,
u_role	VARCHAR(15)	NOT NULL	
);
DESC tbl_users;

DROP TABLE tbl_carmanager;
DROP TABLE tbl_users;
SHOW TABLES;


INSERT INTO tbl_users (
username, password, u_name, u_nickname, u_tel, u_role)
VALUES(
'callor','12341234','홍길동','길동아','','ADMIN');
SELECT * FROM tbl_users;


