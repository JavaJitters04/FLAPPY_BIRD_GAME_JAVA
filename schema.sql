create database userappdb;

use userappdb;

create table users
(
  ID integer auto_increment primary key,
  username varchar(50) not null unique,
  password varchar(100) not null ,
  email varchar(100) not null unique, 
  country varchar(50) not null ,
  high_score integer default 0
);