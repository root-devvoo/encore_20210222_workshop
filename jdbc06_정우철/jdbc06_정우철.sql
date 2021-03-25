-- 1. 'ACCOUNTING' 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오. (조건 → JOIN 사용)
SELECT e.ENAME, e.SAL, E.HIREDATE FROM EMP e, dept d
where e.deptno = d.deptno
and 
d.dname = 'ACCOUNTING';

-- 2. 직원의 이름과 관리자 이름을 조회하시오
select * from  
(select ename, mgr from emp) e,
(select empno, ename from emp) m
where e.mgr = m.empno;

-- 3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오
-- 단, 관리직원 수가 3명 이상인 관리자만 출력되도록 하시오.


-- 4. emp, dept 테이블을 JOIN하여 사원이름, 급여, 부서명을 검색하시오
select e.ename, e.sal, d.dname from emp e, dept d
where e.deptno = d.deptno;

-- 5. 이름이 KING사원의 부서명을 검색하시오
select e.ename 사원이름, d.dname 부서명 from emp e, dept d
where e.deptno = d.deptno
and 
e.ename = 'KING';

-- 6. Emp 테이블에 있는 empno와 mgr을 이용해서 서로의 관계를 다음과 같이 출력되도록 쿼리문을 작성하시오
-- --> ex. 'SCOTT의 매니저는 JONES이다'
select concat(a.ename, '의 매니저는 ', b.ename, '이다')
from emp a, emp b
where a.mgr = b.empno;
