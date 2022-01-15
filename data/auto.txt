create table auto (
    id serial primary key, 
    name varchar(255),
	power int,
	type text
);
insert into auto(name, power, type) values('Ferarri', '400', 'X')
select * from auto
update auto set name ='BMW'
delete from auto