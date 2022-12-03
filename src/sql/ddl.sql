CREATE database jpastart CHARACTER SET utf8;

CREATE USER 'jpauser'@'localhost' IDENTIFIED BY 'jpapass';
CREATE USER 'jpauser'@'%' IDENTIFIED BY 'jpapass';

GRANT ALL PRIVILEGES ON jpastart.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpastart.* TO 'jpauser'@'%';

CREATE TABLE jpastart.user
(
    email       VARCHAR(50) NOT NULL PRIMARY KEY,
    name        VARCHAR(50),
    create_date DATETIME
) ENGINE innodb CHARACTER SET utf8;