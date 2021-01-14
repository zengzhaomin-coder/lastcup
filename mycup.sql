create database mycup;
go

use mycup;

create table cup
(
	id int identity primary key,
	name varchar(20) not null,
	price money check(price > 0),
	prodate datetime default getdate()
);

insert into cup values
('¸ß½Å±­', '10.5', '2020-10-25'),
('Æ¡¾Æ±­', '10.8', '2020-10-25'),
('²èË®±­', '13.5', '2020-10-25');

select * from cup;