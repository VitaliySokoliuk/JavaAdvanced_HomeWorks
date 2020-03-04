drop database if exists garage;
create database garage char set utf8;
use garage;

create table cars(
	car_id int not null primary key auto_increment,
    model varchar(30) not null,
	max_speed int not null
);

insert into cars (model, max_speed) values
('model x', 250),
('model 3', 200);

select * from cars;