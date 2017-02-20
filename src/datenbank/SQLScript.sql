DROP DATABASE IF EXISTS databaseonlinebanking;

CREATE DATABASE databaseonlinebanking;

USE databaseonlinebanking;

drop table if exists adresse;
create table adresse (
	id int not null auto_increment primary key,
    strasse varchar(45) not null,
    hausnummer int not null,
    wohnort varchar(45),
    plz int not null
);

DROP TABLE IF EXISTS konto;
CREATE TABLE konto (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(45) NOT NULL,
  vorname varchar(45) not null,
  geburtsdatum varchar(10) not null,
  kartennummer long not null,
  passwort varchar(45) not null,
  kontostand decimal not null
);

drop table if exists rechnung;
create table rechnung(
	id int not null auto_increment primary key,
    versender varchar(45) not null,
    betrag double not null,
    konto_id int,
    foreign key (konto_id) references konto(id)
);
