-- root 화면 
-- RentBook root 접속

CREATE DATABASE rentBookDB;

USE rentBookDB;

CREATE TABLE tbl_books (
b_code	VARCHAR(13)		PRIMARY KEY,
b_name	VARCHAR(125)	NOT NULL	,
b_auther	VARCHAR(125)	NOT NULL,	
b_comp	VARCHAR(125)		,
b_year	INT	NOT NULL	,
b_iprice	INT		,
b_rprice	INT	NOT NULL	
);
DESC tbl_books;
DROP TABLE tbl_books;
SHOW TABLES;

INSERT INTO tbl_books (
b_code, b_name, b_auther, b_comp,
b_year, b_iprice, b_rprice
) VALUES (
'001', '자바야 놀자' , '야놀자', '놀자출판',
2000, 20000, 200
);

SELECT * FROM tbl_books;


USE rentbookDB;
DROP TABLE tbl_members;
CREATE TABLE tbl_members (
	m_code	VARCHAR(6)		PRIMARY KEY,
	m_name	VARCHAR(125)	NOT NULL	,
	m_tel	VARCHAR(125)	NOT NULL	,
	m_addr	VARCHAR(125)		
);
DESC tbl_members;

INSERT INTO tbl_members (
	m_code, m_name, m_tel, m_addr)
    VALUES (
    '00001','홍길동', '010-1234-4321', '광주');

SELECT * FROM tbl_members;

DROP TABLE tbl_rent_book;
CREATE TABLE tbl_rent_book (
rent_seq	BIGINT		PRIMARY KEY AUTO_INCREMENT,
rent_date	VARCHAR(10)	NOT NULL	,
rent_return_date	VARCHAR(10)	NOT NULL	,
rent_bcode	VARCHAR(13)	NOT NULL,	
rent_mcode	VARCHAR(6)	NOT NULL,	
rent_return_yn	VARCHAR(1)		,
rent_point	INT		,
rent_price	INT		
);

SELECT * FROM tbl_rent_book;
INSERT INTO tbl_rent_book (rent_date, rent_return_date, rent_bcode, rent_mcode, rent_return_yn, rent_point, rent_price)
VALUES ("2023-07-25", "2023-07-28", "0000000000001", "000001","Y", 2000, 10000);


use rentbookdb;
SELECT COUNT(*) FROM tbl_books;
SELECT * FROM tbl_books LIMIT 10;
SELECT COUNT(*) FROM tbl_members;
SELECT * FROM tbl_members LIMIT 10;
SELECT * FROM tbl_rent_book;
TRUNCATE TABLE tbl_rent_book;


SELECT * FROM tbl_rent_book R
LEFT JOIN tbl_members M
	ON R.rent_mcode = M.m_code
LEFT JOIN tbl_books B
	ON R.rent_bcode = B.b_code









