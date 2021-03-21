-- 1. 급여가 1500 이상인 직원들의 이름, 급여, 부서번호를 조회하시오
select ename, sal, deptno from emp where sal >= 1500.0; 
-- 2. 직원 중에서 연봉이 2000 이상인 직원들의 이름, 연봉을 조회하시오.
select ename, sal, comm, sal*12 + ifnull(comm, 0) AnnualSalary from emp; 
select ename, sal*12 + ifnull(comm, 0) 'Annual Salary' 
from emp 
where 'Annual Salary' >= '2000';
-- 3. 직원 중에서 comm이 없는 직원의 이름과 급여, 업무, comm를 조회하시오
select ename, sal, job, comm from emp where comm is null;
-- 4. 입사한지 가장 오래된 직원 순으로 5명을 조회하시오
select * from emp order by hiredate limit 5;
-- 5. 1981년에 입사한 직원들 중에서 급여가 1500 이상 2500 이하인 직원들의 이름, 급여, 부서번호, 입사일을 조회하시오.
select ename, sal, deptno, hiredate from emp 
where hiredate like '__81%' and sal between 1500 and 2500;
-- 6. 이름이 A로 시작하는 직원의 이름, 급여, 입사일을 조회하시오
select ename, sal, hiredate from emp where ename like 'A%';
-- 7. 05월에 입사한 직원의 이름, 급여, 입사일을 조회하시오
select ename, sal, hiredate from emp where hiredate like '%05%';
-- 8. 세 번째 이름에 A 가 들어간 직원의 이름, 급여, 입사일을 조회하시오
select ename, sal, hiredate from emp where ename like '__a%';
-- 9. 이름이 K로 끝나는 직원의 이름, 급여, 입사일을 조회하시오
SELECT ename, sal, hiredate from emp where ename like '%k';
-- 10. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오
select ename, comm, sal from emp
where comm is not null;
-- or --
select ename, ifnull(comm, 0) comm, sal from emp
where comm not in (0);
 
/* --------------------------------------------------------------------------------------------- */
DESC DEPT;

-- 1번에서 테이블 작성시 추가하지 못한 primary key 제약조건을 DEPT_NO 컬럼에 적용해보자
ALTER TABLE DEPT ADD PRIMARY KEY(DEPT_NO);
-- 데이터 추가
INSERT INTO DEPT
(DEPT_NO, DEPT_NAME, DEPT_LOC, DEPT_TEL_NO) 
VALUES (10, 'SALES', 'SEOUL', '02-671-1111'),
(20, 'FINANCE', 'SEOUL', '02-862-2222'),
(30, 'HR', 'BUSAN', '051-111-1111'),
(40, 'PURCHASE', 'BUSAN', '051-222-2222'),
(50, 'MANAGEMENT', 'SEOUL', '02-383-3333');

SELECT * FROM DEPT;

/* --------------------------------------------------------------------------------------------- */
SELECT * FROM EMP;
SELECT * FROM DEPT;
desc emp;

/* EMP 테이블의 Constraint PK, FK를 추가해보자
	(단, PK는 EMP_NO, FK는 DEPT_NO로 한다.)
*/   
ALTER TABLE EMP 
ADD CONSTRAINT EMP_NO 
PRIMARY KEY(EMP_NO);
--
ALTER TABLE EMP
ADD CONSTRAINT DEPT_NO
FOREIGN KEY(DEPT_NO)
REFERENCES DEPT(DEPT_NO);
--
-- 4번 테이블과 같이 데이터를 추가해보자.
INSERT INTO emp
(EMP_NO, EMP_NAME, EMP_MGE, HIREDATE, SAL, DEPT_NO) 
VALUES (1001, 'KIM', 1003, '2005-01-15', 4750, '20'),
(1002, 'LEE', 1003, '2008-06-05', 3000, '30'),
(1003, 'PARK', 1001, '2007-11-28', 3500, '10');

-- HR 부서가 MANAGEMENT부서로 통합되었다. HR 부서 직원에 대한 소속 부서를 MANAGEMENT 부서로 변경해보자
UPDATE EMP SET DEPT_NO = '50'
WHERE DEPT_NO = '30';

-- HR 부서를 DEPT 테이블에서 삭제해보자.
DELETE FROM DEPT WHERE DEPT_NAME = 'HR';

/* 아래의 데이터를 EMP테이블에 추가해보자
추가시 입사일은 시스템의 현재일자를 자동으로 가져와서 부여하도록 하며, 
'년-월'일'의 형태로 작성해보자
*/
INSERT INTO emp (EMP_NO, EMP_NAME, EMP_MGE, HIREDATE, SAL, DEPT_NO)
values (2001, 'chung', 1001, now(), 3000, '50');		