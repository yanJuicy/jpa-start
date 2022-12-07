CREATE
database jpastart CHARACTER SET utf8;

CREATE
USER 'jpauser'@'localhost' IDENTIFIED BY 'jpapass';
CREATE
USER 'jpauser'@'%' IDENTIFIED BY 'jpapass';

GRANT ALL PRIVILEGES ON jpastart.* TO
'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpastart.* TO
'jpauser'@'%';

CREATE TABLE jpastart.user
(
    email       VARCHAR(50) NOT NULL PRIMARY KEY,
    name        VARCHAR(50),
    create_date DATETIME
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.room_info
(
    id          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    number      VARCHAR(50) NOT NULL,
    name        VARCHAR(50),
    description VARCHAR(255),
    createtime  DATETIME,
    UNIQUE KEY (number)
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.hotel
(
    id    VARCHAR(100) NOT NULL PRIMARY KEY,
    name  VARCHAR(50),
    grade VARCHAR(255)
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.hotel_review
(
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hotel_id    VARCHAR(100) NOT NULL,
    rate        INT          NOT NULL,
    comment     VARCHAR(255) NOT NULL,
    rating_date DATETIME
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.id_gen
(
    entity VARCHAR(100) NOT NULL PRIMARY KEY,
    nextid INT
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.city
(
    id   INT NOT NULL PRIMARY KEY,
    name VARCHAR(200)
) ENGINE innodb CHARACTER SET utf8;