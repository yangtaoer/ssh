create database ssh;
use ssh;
create table t_user(
	t_id int,
	t_name varchar(50),
	t_age int,
	t_salary double,
	t_hiredate datetime,
	primary key(t_id)
)

create table t_product(
	t_id int auto_increment primary key,
	t_name varchar(30),
	t_price double
)