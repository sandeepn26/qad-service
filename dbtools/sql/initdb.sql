DROP USER 'leaguepanda'@'localhost';

DROP DATABASE IF EXISTS proman;

CREATE DATABASE proman;

CREATE USER 'leaguepanda'@'localhost' IDENTIFIED BY 'leaguepanda';

GRANT ALL PRIVILEGES ON *.* TO 'leaguepanda'@'localhost' IDENTIFIED BY 'leaguepanda';
