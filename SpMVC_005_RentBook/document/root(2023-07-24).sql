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

CREATE TABLE tbl_rent_book (
rent_seq	BIGINT		PRIMARY KEY,
rent_date	VARCHAR(10)	NOT NULL	,
rent_return_date	VARCHAR(10)	NOT NULL	,
rent_bcode	VARCHAR(13)	NOT NULL,	
rent_mcode	VARCHAR(6)	NOT NULL,	
rent_return_yn	VARCHAR(1)		,
rent_point	INT		,
rent_price	INT		
)