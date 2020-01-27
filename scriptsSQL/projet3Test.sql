-- Adminer 4.7.2 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `dateAvalaible` date DEFAULT NULL,
  `description` text,
  `dispo` bit(1) NOT NULL,
  `nbrBooking` int(11) DEFAULT NULL,
  `nbrDispo` int(11) NOT NULL,
  `nbrOfBook` int(11) NOT NULL,
  `reserve` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `book` (`book_id`, `author`, `category`, `dateAvalaible`, `description`, `dispo`, `nbrBooking`, `nbrDispo`, `nbrOfBook`, `reserve`, `title`) VALUES
(10,	'author',	'enfant',	'2019-01-01',	'blabla',	CONV('0', 2, 10) + 0,	4,	0,	2,	CONV('1', 2, 10) + 0,	'kirikou'),
(11,	'author',	'enfant',	'2019-01-01',	'blabla',	CONV('0', 2, 10) + 0,	1,	0,	1,	CONV('1', 2, 10) + 0,	'kirikou2'),
(12,	'author',	'enfant',	'2020-02-02',	'blabla',	CONV('0', 2, 10) + 0,	0,	0,	1,	CONV('0', 2, 10) + 0,	'kirikou3'),
(13,	'author',	'enfant',	'2019-01-01',	'blabla',	CONV('0', 2, 10) + 0,	0,	0,	1,	CONV('0', 2, 10) + 0,	'kirikou4');

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `maxDateBooking` date DEFAULT NULL,
  `priorityOrder` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKqqjo18dh1xhpm0e59elw0tcxi` (`book_id`),
  KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`),
  CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKqqjo18dh1xhpm0e59elw0tcxi` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `booking` (`booking_id`, `maxDateBooking`, `priorityOrder`, `book_id`, `user_id`) VALUES
(19,	NULL,	1,	10,	1),
(20,	NULL,	2,	10,	2),
(27,	NULL,	3,	10,	3),
(28,	NULL,	4,	10,	4),
(29,	NULL,	1,	11,	5);

DROP TABLE IF EXISTS `borrowed_book`;
CREATE TABLE `borrowed_book` (
  `borrowedBook_id` int(11) NOT NULL AUTO_INCREMENT,
  `availableExtension` bit(1) DEFAULT NULL,
  `dateBorrowing` date DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`borrowedBook_id`),
  KEY `FKo463ngdwoi1gt9mx0ni006os8` (`book_id`),
  KEY `FK4ihg26h2ffgtnohk5qn3phlgs` (`user_id`),
  CONSTRAINT `FK4ihg26h2ffgtnohk5qn3phlgs` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKo463ngdwoi1gt9mx0ni006os8` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `borrowed_book` (`borrowedBook_id`, `availableExtension`, `dateBorrowing`, `book_id`, `user_id`) VALUES
(1,	CONV('1', 2, 10) + 0,	'2020-01-01',	13,	5);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`user_id`, `active`, `email`, `lastName`, `name`, `password`, `role`, `username`) VALUES
(1,	CONV('1', 2, 10) + 0,	'brice.oc.formation@gmail.com 	',	'user1',	'test',	'$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu',	'user',	'user1test'),
(2,	CONV('1', 2, 10) + 0,	'brice.oc.formation@gmail.com ',	'user2',	'test',	'$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu',	'user',	'user2test'),
(3,	CONV('1', 2, 10) + 0,	'test@gmail.com',	'user3',	'test',	'$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu',	'user',	'user3test'),
(4,	CONV('1', 2, 10) + 0,	'test@gmail.com',	'user4',	'test',	'$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu',	'user',	'user4test'),
(5,	CONV('1', 2, 10) + 0,	'test@gmail.com',	'user5',	'test',	'$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu',	'user',	'user5test');

-- 2019-12-12 08:53:45
