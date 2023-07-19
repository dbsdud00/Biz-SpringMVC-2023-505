-- MyCar root 화면

CREATE DATABASE mycarDB;
USE mycarDB;

DROP TABLE tbl_carmanager;
CREATE TABLE tbl_carmanager (
c_seq	BIGINT		PRIMARY KEY	AUTO_INCREMENT,
c_carnum	VARCHAR(15)	NOT NULL		,
c_qty	VARCHAR(10)	NOT NULL		,
c_username	VARCHAR(20)	NOT NULL		,
c_sdate	VARCHAR(10)	NOT NULL		,
c_stime	VARCHAR(10)	NOT NULL		,
c_goal	VARCHAR(30)			,
c_edate	VARCHAR(10)			,
c_etime	VARCHAR(10)			,
c_skm	INT			,
c_ekm	INT			,
c_cost	INT			
);

DESC tbl_carmanager;

INSERT INTO tbl_carmanager (
	c_carnum, c_qty, c_username, c_sdate, c_stime,
	c_skm, c_ekm ) 
VALUES (
	'001', '출근','callor','2023-07-01','07:00:00',
    '3000', '3010');
    
INSERT INTO tbl_carmanager (
	c_carnum, c_qty, c_username, c_sdate, c_stime,
	c_skm, c_ekm ) 
VALUES (
	'001', '퇴근','callor','2023-07-01','18:00:00',
    '3010', '3020');


INSERT INTO tbl_carmanager (
	c_carnum, c_qty, c_username, c_sdate, c_stime,
	c_skm, c_ekm ) 
VALUES (
	'002', '서울출장','callor','2023-07-02','07:00:00',
    '3020', '3100');
    
INSERT INTO tbl_carmanager (
	c_carnum, c_qty, c_username, c_sdate, c_stime,
	c_skm, c_ekm ) 
VALUES (
	'002', '출장복귀','callor','2023-07-02','18:00:00',
    '3100', '3200');

-- 001 차량의 가장 마지막 운행 기록
SELECT * FROM tbl_carmanager
WHERE c_carnum = '001'
ORDER BY c_sdate DESC, c_stime DESC
LIMIT 1;

COMMIT;








