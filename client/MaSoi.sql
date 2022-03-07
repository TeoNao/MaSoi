create database MaSoi;
go
use MaSoi;
go
create table information (
	userName nvarchar(50) primary key,
	pass nvarchar(50),
	email nvarchar(50)
);