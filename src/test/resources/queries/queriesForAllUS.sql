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
where b.name = 'The House of Mirth';

select bc.name
from book_borrow bb
         join books b on bb.book_id = b.id
         join book_categories bc on b.book_category_id = bc.id
where is_returned = 0
group by bc.name
order by count(*) desc
limit 1;

select b.name, b.isbn, b.year, b.author, bc.name
from books b
         join book_categories bc
              on b.book_category_id = bc.id
where b.name = '99 Reason To Be Single'
limit 1;

select u.full_name,
       b.name
from books b
         join book_borrow bb
              on b.id = bb.book_id
         join users u on bb.user_id = u.id

where u.full_name = 'Ellan Robel MD'
  and b.name = 'Four Night In Honolulu'
  and bb.is_returned = 0
limit 1;


