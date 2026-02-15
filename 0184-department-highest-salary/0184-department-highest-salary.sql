SELECT
    t.name AS Department,
    e.name AS Employee,
    e.salary
FROM Employee e
JOIN (
    SELECT
        d.id,
        d.name,
        MAX(e.salary) AS max_salary
    FROM Department d
    JOIN Employee e ON d.id = e.departmentId
    GROUP BY d.id, d.name
) t
ON e.departmentId = t.id
WHERE e.salary = t.max_salary;