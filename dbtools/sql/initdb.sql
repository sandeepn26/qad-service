DROP USER 'qad'@'localhost';

DROP DATABASE IF EXISTS qad;

CREATE DATABASE qad;

CREATE USER 'qad'@'localhost' IDENTIFIED BY 'qad';

GRANT ALL PRIVILEGES ON *.* TO 'qad'@'localhost' IDENTIFIED BY 'qad';