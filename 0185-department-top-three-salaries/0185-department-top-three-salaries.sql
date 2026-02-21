WITH salary_ranking AS (
    SELECT 
        department.name AS Department,
        employee.name AS Employee,
        employee.salary AS Salary,
        DENSE_RANK() OVER(PARTITION BY department.name ORDER BY employee.salary DESC) AS ranking
    FROM employee
    LEFT JOIN department ON employee.departmentId = department.id
)

SELECT 
    Department, Employee, Salary
FROM salary_ranking
WHERE
    ranking <= 3;