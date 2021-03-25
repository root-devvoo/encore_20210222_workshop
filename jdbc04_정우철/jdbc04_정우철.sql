-- 1. 이름이 'adams'인 직원의 급여와 입사일을 조회하시오. 이때 이름을 소문자로 그대로 쿼리문에 사용할 수 있도록 문자함수 lower()를 이용하세요
select * from emp where ename = lower('adams');
-- 1. 7년 이상 장기 근속한 직원들의 이름, 입사일, 급여, 근무 년차를 조회하시오
SELECT ename, hiredate, sal, year(curdate()) - year(hiredate) '근무 년차'
from emp
where '근무 년차' >= '7';
-- 2. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력 되도록 하시오
Select deptno from emp 
group by deptno
having count(deptno) >= 5
order by deptno;
/* 3. 각 부서별 최대급여와 최소급여를 조회하시오
단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기 때문에
조회결과에서 제외시킨다.
*/
select deptno, min(sal) 최소급여, max(sal) 최대급여 from emp
group by deptno
order by deptno;
-- 5. 10, 20번 부서에 속해있으면서 급여가 2000 이상인 직원의 이름, 급여, 업무, 부서번호를 조회하시오
select ename, sal, job, deptno from emp
where deptno in(10, 20)
having sal >= 2000;

/* 6. 1981년대에 입사해서 10, 20, 30번 부서에 속해있으면서,
급여를 1500 이상 3000 이하를 받는 직원을 조회하시오.
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며,
먼저 입사한 직원이 먼저 출력되어야 하며 입사일이 같은 경우 급여가
많은 직원이 먼저 출력 되도록 하시오.
*/
select ename, hiredate, sal, deptno from emp
where hiredate like '__81%' and deptno in(10, 20, 30) and comm is not null
and sal between 1500 and 3000
order by hiredate, sal;

/* 7. 부서가 10, 20, 30번인 직원들 중에서 급여를 1500 이상 3000 이하를 받는
직원들을 대상으로 부서별 평균 급여를 조회하시오.
단, 평균급여가 2000이상인 부서만 출력되어야 하며,
출력결과를 평균급여가 높은 부서 먼저 출력되도록 해야 한다.
*/
select deptno, round(avg(sal)) '평균 급여'
from emp
where deptno in(10, 20, 30) and sal between 1500 and 3000
group by deptno
having round(avg(sal)) >= 2000
order by round(avg(sal)) desc;
