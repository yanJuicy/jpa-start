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
    id       VARCHAR(100) NOT NULL PRIMARY KEY,
    name     VARCHAR(50),
    grade    VARCHAR(255),
    zipcode  varchar(5),
    address1 varchar(255),
    address2 varchar(255)
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
    id       INT NOT NULL PRIMARY KEY,
    name     VARCHAR(200),
    ct_phone VARCHAR(255),
    ct_email VARCHAR(255),
    ct_zip   VARCHAR(255),
    ct_addr1 VARCHAR(255),
    ct_addr2 VARCHAR(255)
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.sight
(
    id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    zipcode     VARCHAR(5),
    address1    VARCHAR(100),
    address2    VARCHAR(100),
    eng_zipcode VARCHAR(5),
    eng_addr1   VARCHAR(100),
    eng_addr2   VARCHAR(100)
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.sight_detail
(
    sight_id   INT NOT NULL PRIMARY KEY,
    hours_op   VARCHAR(255),
    holidays   VARCHAR(255),
    facilities VARCHAR(255)
) ENGINE innodb CHARACTER SET utf8;

CREATE TABLE jpastart.month_charge
(
    hotel_id   VARCHAR(255) NOT NULL,
    year_mon   VARCHAR(255) NOT NULL,
    charge_amt INT,
    unpay_amt  INT,
    PRIMARY KEY (hotel_id, year_mon)
) ENGINE innodb CHARACTER SET utf8;
