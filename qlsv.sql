create database qlsv01
go

use qlsv01
go

drop table Student
create table Student
(
	id int not null identity(1,1),
	fullName nvarchar(50) not null,
	gender nvarchar(5) not null,
	age int not null,
	email nvarchar(30) not null unique,
	phone nvarchar(13) not null unique
)
go


select * from Student

insert into Student(fullName,gender,age,email,phone)
values(N'Vũ Văn Tuấn','Nam',100,'Tuanvv@gmail.com','0999999999')

delete from Student where age = 23
select * from Student where fullName like N'%Thư%'


