# Write your MySQL query statement below
with cte as(
    select orders.sales_id
    from orders 
    join company
    on orders.com_id = company.com_id
    where company.name = 'red'
)

select SalesPerson.name 
from SalesPerson
where sales_id not in (select sales_id from cte)