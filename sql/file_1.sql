create database scocietymanagement;
use scocietymanagement;
create table login_table(username varchar(06) , password varchar(06));
select * from login_table;
insert into login_table values("user_1","user@1");
create table members_table(date varchar(50), name varchar(50), m_name varchar(50), l_name varchar(50), unit_no varchar(4), contact varchar(10), email varchar(50));
drop table members_table;
select * from members_table;
DELETE FROM members_table;
