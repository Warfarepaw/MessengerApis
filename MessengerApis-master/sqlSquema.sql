create schema MessengerUsers;

use MessengerUsers;

drop table User;

create table User(
id integer primary key,
nombre varchar(50),
correo varchar(150),
password varchar(150);

insert into User values('Jesus Gallardo','jes.gallardo.d@hotmail.com','123@123');