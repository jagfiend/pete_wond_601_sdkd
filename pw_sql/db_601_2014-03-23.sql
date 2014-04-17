# ************************************************************
# Sequel Pro SQL dump
# Version 4004
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.5.25)
# Database: db_601
# Generation Time: 2014-03-23 10:17:59 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table high_scores
# ------------------------------------------------------------

DROP TABLE IF EXISTS `high_scores`;

CREATE TABLE `high_scores` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `player_name` varchar(25) NOT NULL DEFAULT 'player_name',
  `player_score` int(5) NOT NULL DEFAULT '100',
  `player_locale` varchar(3) NOT NULL DEFAULT 'UNK',
  `player_photo` varchar(50) NOT NULL DEFAULT 'default_avatar.jpg',
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `high_scores` WRITE;
/*!40000 ALTER TABLE `high_scores` DISABLE KEYS */;

INSERT INTO `high_scores` (`id`, `player_name`, `player_score`, `player_locale`, `player_photo`, `created_at`)
VALUES
	(1,'player_name',1,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(2,'player_name',2,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(3,'player_name',3,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(4,'player_name',4,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(5,'player_name',5,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(6,'player_name',6,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(7,'player_name',7,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(8,'player_name',8,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(9,'player_name',9,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(10,'player_name',10,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(11,'player_name',11,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(12,'player_name',12,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(13,'player_name',13,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(14,'player_name',14,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(15,'player_name',15,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(16,'player_name',16,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(17,'player_name',17,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(18,'player_name',18,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(19,'player_name',19,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(20,'player_name',20,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(21,'player_name',21,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(22,'player_name',22,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(23,'player_name',23,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(24,'player_name',24,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(25,'player_name',25,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(26,'player_name',26,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(27,'player_name',27,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(28,'player_name',28,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(29,'player_name',29,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(30,'player_name',30,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(31,'player_name',31,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(32,'player_name',32,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(33,'player_name',33,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(34,'player_name',34,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(35,'player_name',35,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(36,'player_name',36,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(37,'player_name',37,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(38,'player_name',38,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(39,'player_name',39,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(40,'player_name',40,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(41,'player_name',40,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(42,'player_name',45,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(43,'player_name',45,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(44,'player_name',45,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(45,'player_name',50,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(46,'player_name',50,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(47,'player_name',55,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(48,'player_name',60,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(49,'player_name',61,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(50,'player_name',63,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(51,'player_name',63,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(52,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(53,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(54,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(55,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(56,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(57,'player_name',65,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(58,'player_name',66,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(59,'player_name',66,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(60,'player_name',66,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(61,'player_name',68,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(62,'player_name',68,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(63,'player_name',68,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(64,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(65,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(66,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(67,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(68,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(69,'player_name',69,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(70,'player_name',70,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(71,'player_name',70,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(72,'player_name',70,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(73,'player_name',70,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(74,'player_name',70,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(75,'player_name',77,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(76,'player_name',77,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(77,'player_name',77,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(78,'player_name',77,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(79,'player_name',79,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(80,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(81,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(82,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(83,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(84,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(85,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(86,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(87,'player_name',80,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(88,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(89,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(90,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(91,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(92,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(93,'player_name',90,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(94,'player_name',95,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(95,'player_name',96,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(96,'player_name',97,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(97,'player_name',98,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(98,'player_name',99,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(99,'player_name',100,'UNK','default_avatar.jpg','0000-00-00 00:00:00'),
	(100,'player_name',1000,'UNK','default_avatar.jpg','0000-00-00 00:00:00');

/*!40000 ALTER TABLE `high_scores` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
