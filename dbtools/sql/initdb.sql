DROP USER 'leaguepanda'@'localhost';

DROP DATABASE IF EXISTS leaguepanda;

CREATE DATABASE leaguepanda;

CREATE USER 'leaguepanda'@'localhost' IDENTIFIED BY 'leaguepanda';

GRANT ALL PRIVILEGES ON *.* TO 'leaguepanda'@'localhost' IDENTIFIED BY 'leaguepanda';

