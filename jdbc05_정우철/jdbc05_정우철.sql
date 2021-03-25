-- 1. 'ACCOUNTING' 부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE DEPTNO = 10;
-- 2. 'TURNER'와 같은 부서에서 근무하는 직원의 이름과 부서번호를 조회하시오
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'TURNER');
-- 3. 10번 부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오
SELECT ENAME, DEPTNO, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10);
-- 4. KING에게 보고하는 모든 사원의 이름과 급여를 표시하시오. 사원의 이름은 직원으로 Alias를 부여하시오
select ename 직원, mgr
from emp
where mgr = (select empno from emp where ename = 'KING');
-- 5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원번호, 이름 및 급여를 표시하시오 -- 다시
select empno, ename, sal, deptno from emp 
WHERE sal > (select avg(sal) from emp) 
and deptno in (select deptno from emp where sal and ename like '%U%');

-- 6. 평균 급여보다 높고 최대 급여보다 낮은 월급을 받는 사원의 정보를 조회하시오.
select * from emp 
where sal > (select avg(sal) from emp) and sal < (select max(sal) from emp);

-- 7. 급여가 10번 부서에 속한 어떤 사원의 급여보다 많은 급여를 받는 사원 검색
-- 이때 10번 부서에 속한 사원은 제외
-- 사원번호순으로 정렬한다.
select * from emp
where sal > all (select sal from emp where deptno = 10)
and deptno != 10
order by empno;

-- 8. 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색
select ename, sal from emp
where sal > (select max(sal) from emp where deptno = 30);

-- 9. 부하직원을 거느린 사원을 검색 (부하직원이 있다. mgr에 내 empno가 있다)
select * from emp
where empno IN (select distinct mgr from emp where mgr);

-- 10. 부하직원을 거느리지 않은 사원을 검색 (부하직원이 없다. mgr에 내 empno가 없다)
select * from emp
where empno not in (select distinct mgr from emp where mgr);
