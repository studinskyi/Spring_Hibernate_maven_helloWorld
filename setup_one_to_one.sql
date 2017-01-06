create database db1;
use db1;
CREATE TABLE Person (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL DEFAULT '',
  country varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
-- Create Employee table with one to one communication to Person
create table Employee(
  ID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20),
  ROLE VARCHAR(50),
  insert_time DATE,
  PRIMARY KEY (ID),
  CONSTRAINT FK_Employees_PersonID FOREIGN KEY (id) REFERENCES Person (id)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8; 
commit;

-- Create Department table with one to one communication to Employee
-- create table Department(
--   id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
--   name VARCHAR(50) NOT NULL,
--   PRIMARY KEY (id),
--   CONSTRAINT FK_Department_EmployeesID FOREIGN KEY (id) REFERENCES Employee (id)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8;