SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE
  FROM MEMBER;

INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) 
VALUES ('박규영', 'parkgy', '1234', 'pgy@gmail.com', '010-1111-2222', 0);

SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE
  FROM MEMBER
 WHERE USERID = 'parkgy';

UPDATE MEMBER
   SET NAME='문채원', PWD='5678', EMAIL='mcw@gmail.com', 
       PHONE='010-3333-5555', ADMIN=1, JOINDATE='2020-08-20'
 WHERE USERID = 'parkgy';

DELETE FROM MEMBER WHERE USERID = 'test';

-- usercheck
SELECT PWD FROM MEMBER WHERE USERID = 'somi';





----------------------------------
SELECT USER FROM DUAL;

SELECT *
	FROM USER_TABLES ;
	
SELECT MAX(TITLE_NO)+1 FROM TITLE;

SELECT  * FROM title;

SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT ;





SELECT EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, REGDATE, 
       EMAIL, TEL, PIC_URL, TITLE_NAME, DEPT_NAME, MANAGER_NAME 
  FROM VW_EMPLOYEE_JOIN;

INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, PASSWD) VALUES(?, ?, ?, ?, ?, ?, ?, ?);

DELETE FROM EMPLOYEE WHERE EMP_NO = 4378;


