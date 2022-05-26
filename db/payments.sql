-- sum all payments

select sum(amount::decimal)
from payments p
where p.status not in ('created');

select sum(amount::decimal)
from payments p
where p.status in ('accepted', 'rejected');
