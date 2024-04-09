select *
from users;

select id
from users;
select distinct id
from users;

select *
from users;

select count(*)
from book_borrow
where is_returned = 0;

select name
from book_categories;

select b.name, b.isbn, b.year, b.author, b.description, bc.name
from books b
         join book_categories bc on b.book_category_id = bc.id
where b.name = 'asdasdadsa';