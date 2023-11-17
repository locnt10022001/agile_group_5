
create database qlsv02
go 
use qlsv02
go


drop table student
create table Student
(
	id int not null identity(1,1),
	MaSV nvarchar(10) not null unique,
	HoTen nvarchar(50) not null,
	NgaySinh datetime not null,
	lop nvarchar(15) not null,
	Gender nvarchar(5) not null,
	phone nvarchar(13) not null,
	Gmail nvarchar(30) not null unique
	
)

drop table TaiKhoan
create table TaiKhoan
(	
	id int not null identity(1,1),
	Username nvarchar(25) not null unique,
	Password nvarchar(25) not null ,
	Gmail nvarchar(30) not null unique,
)

select Username,Password,Gmail from TaiKhoan


select * from TaiKhoan
insert into TaiKhoan(Username,Password,Gmail)
values('abc','123','abc123@gmail.com')


insert into Student(MaSV,HoTen,lop,NgaySinh,Gender,phone,Gmail)
values('1010',N'Vũ Văn Tuấn','PK001','5-4-2050','Nam','0999999999','tuan123@gmail.com')
select * from Student


delete from Student where MaSV like '1022'

update Student set MaSV = ?,HoTen = ?,NgaySinh = ?,lop = ?,Gender = ?,phone = ? ,Gmail =? where id=?

Delete from Student where id=?
