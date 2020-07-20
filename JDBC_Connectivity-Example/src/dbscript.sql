# List all databases 
show databases;

# Create the database
create database simplilearn;

# Use databse
use simplilearn;

# Which db i am in ?
select database();

# List all tables 
show tables;

# To create a new table 'Employee'
CREATE table EMPLOYEE(
EmpId int primary key,
EmpName varchar(50)
)

# Drop the table from database 
drop table Employee;

# Insert new record into database table
INSERT INTO Employee values(101,"King Kocher");
INSERT INTO Employee values(102,"Sara Bowling");
INSERT INTO Employee values(103,"Gautam Sidh");
INSERT INTO Employee values(103,"Sherya Sharma");
INSERT INTO Employee values(104,"Anant Sitaram");

# To See data in employee table as whole
select * from employee;

# Delete a record from table 
delete from employee where EmpId=104;

# Update the record
update employee set EmpName="John Travolta" where EmpName ="Anant Sitaram";

# To check mysql version 
select version();

# To check which port mysql services running 
show variables like 'PORT';

#To see list of users in mysql 
select host,user from mysql.user;



