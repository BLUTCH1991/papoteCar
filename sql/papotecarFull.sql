-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.20-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5278
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour papotecar
CREATE DATABASE IF NOT EXISTS `papotecar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `papotecar`;

-- Listage de la structure de la table papotecar. city
CREATE TABLE IF NOT EXISTS `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `zip_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.city : ~6 rows (environ)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
REPLACE INTO `city` (`city_id`, `name`, `zip_code`) VALUES
	(1, 'Nantes', '44000'),
	(2, 'Paris', '75000'),
	(3, 'Bordeaux', '33000'),
	(4, 'Toulouse', '31000'),
	(5, 'Rennes', '35000'),
	(6, 'Le Mans', '72000');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. message
CREATE TABLE IF NOT EXISTS `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_user_id` int(11) NOT NULL,
  `receiver_user_id` int(11) NOT NULL,
  `trip_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`),
  KEY `FK_message_user` (`sender_user_id`),
  KEY `FK_message_user_2` (`receiver_user_id`),
  KEY `FK_message_trip` (`trip_id`),
  CONSTRAINT `FK_message_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`),
  CONSTRAINT `FK_message_user` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_message_user_2` FOREIGN KEY (`receiver_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.message : ~10 rows (environ)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
REPLACE INTO `message` (`message_id`, `sender_user_id`, `receiver_user_id`, `trip_id`, `content`, `date`) VALUES
	(1, 2, 3, 1, 'Rendez vous Cardo les coco', '2018-06-01 11:44:01'),
	(2, 2, 1, 1, 'Rendez vous Cardo les coco', '2018-06-01 11:44:01'),
	(3, 3, 2, 1, 'Ok bonhomme', '2018-06-01 11:44:01'),
	(4, 1, 2, 1, 'Bien recu', '2018-06-01 11:44:01'),
	(5, 3, 1, 1, 'Gros boulet le Albert', '2018-06-01 11:44:01'),
	(6, 3, 1, 2, 'Hey c\'est ou le rendez vous?', '2018-06-01 11:44:01'),
	(7, 1, 3, 3, 'Tu viens quand?', '2018-06-01 11:44:01'),
	(8, 2, 3, 2, 'Des news du rendez vous?', '2018-06-01 11:44:01'),
	(9, 1, 2, 2, 'Rendez vous dans ton cul!', '2018-06-01 11:44:01'),
	(10, 2, 1, 3, 'Il vient quand l\'autre con?', '2018-06-01 11:44:01');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. step
CREATE TABLE IF NOT EXISTS `step` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `trip_id` int(11) NOT NULL,
  `cityStartId` int(11) NOT NULL,
  `cityEndId` int(11) NOT NULL,
  `adress_start` varchar(50) DEFAULT NULL,
  `adress_end` varchar(50) DEFAULT NULL,
  `meeting_hour` datetime NOT NULL,
  `rank` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`step_id`),
  KEY `FK_step_trip` (`trip_id`),
  KEY `FK_step_city` (`cityStartId`),
  KEY `FK_step_city_2` (`cityEndId`),
  CONSTRAINT `FK_step_city` FOREIGN KEY (`cityStartId`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_step_city_2` FOREIGN KEY (`cityEndId`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_step_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step : ~7 rows (environ)
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
REPLACE INTO `step` (`step_id`, `trip_id`, `cityStartId`, `cityEndId`, `adress_start`, `adress_end`, `meeting_hour`, `rank`) VALUES
	(1, 1, 1, 6, 'Rue albert Premier', '12 avenue marechal petain', '2018-06-01 13:09:05', 1),
	(2, 1, 6, 2, '12 avenue marechal petain', 'Tour Eiffel', '2018-06-01 15:09:05', 2),
	(3, 2, 5, 1, 'Place Jean Macé', 'Rue de Tabior', '2018-07-04 10:18:47', 1),
	(4, 2, 1, 3, 'Rue de Tabior', 'Place Jean joseh', '2018-07-04 14:18:47', 2),
	(5, 2, 3, 4, 'Place Jean joseh', 'Boulevard Ignace du sauterne', '2018-07-04 17:18:47', 3),
	(6, 3, 3, 1, '15 Avenue du baril de poudre', 'parking saint pierre', '2018-06-01 11:21:53', 1),
	(7, 3, 1, 2, 'parking saint pierre', 'Boulevard Titouan Lamasou', '2018-06-01 11:21:53', 2);
/*!40000 ALTER TABLE `step` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. step_user
CREATE TABLE IF NOT EXISTS `step_user` (
  `step_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `step_id` int(11) NOT NULL,
  `step_user_role_id` int(11) NOT NULL,
  PRIMARY KEY (`step_user_id`),
  KEY `FK_step_user_user` (`user_id`),
  KEY `FK_step_user_step` (`step_id`),
  KEY `FK_step_user_step_user_role` (`step_user_role_id`),
  CONSTRAINT `FK_step_user_step` FOREIGN KEY (`step_id`) REFERENCES `step` (`step_id`),
  CONSTRAINT `FK_step_user_step_user_role` FOREIGN KEY (`step_user_role_id`) REFERENCES `step_user_role` (`step_user_role_id`),
  CONSTRAINT `FK_step_user_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step_user : ~21 rows (environ)
/*!40000 ALTER TABLE `step_user` DISABLE KEYS */;
REPLACE INTO `step_user` (`step_user_id`, `user_id`, `step_id`, `step_user_role_id`) VALUES
	(1, 2, 1, 1),
	(2, 2, 2, 1),
	(3, 3, 1, 2),
	(4, 3, 2, 2),
	(5, 1, 1, 2),
	(6, 1, 2, 2),
	(7, 3, 3, 1),
	(8, 3, 4, 1),
	(9, 3, 5, 1),
	(10, 2, 3, 2),
	(13, 2, 4, 2),
	(14, 2, 5, 2),
	(15, 1, 3, 2),
	(16, 1, 4, 2),
	(17, 1, 5, 2),
	(18, 1, 6, 1),
	(19, 1, 7, 1),
	(20, 2, 6, 2),
	(21, 2, 7, 2),
	(22, 3, 6, 2),
	(23, 3, 7, 2);
/*!40000 ALTER TABLE `step_user` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. step_user_role
CREATE TABLE IF NOT EXISTS `step_user_role` (
  `step_user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`step_user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step_user_role : ~2 rows (environ)
/*!40000 ALTER TABLE `step_user_role` DISABLE KEYS */;
REPLACE INTO `step_user_role` (`step_user_role_id`, `role`) VALUES
	(1, 'Driver'),
	(2, 'Passenger');
/*!40000 ALTER TABLE `step_user_role` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. trip
CREATE TABLE IF NOT EXISTS `trip` (
  `trip_id` int(11) NOT NULL AUTO_INCREMENT,
  `cityStartId` int(11) NOT NULL,
  `cityEndId` int(11) NOT NULL,
  `date_start` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  `adress_end` varchar(50) DEFAULT NULL,
  `adress_start` varchar(50) DEFAULT NULL,
  `sits` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trip_id`),
  KEY `FK_trip_city` (`cityStartId`),
  KEY `FK_trip_city_2` (`cityEndId`),
  CONSTRAINT `FK_trip_city` FOREIGN KEY (`cityStartId`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_trip_city_2` FOREIGN KEY (`cityEndId`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.trip : ~3 rows (environ)
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
REPLACE INTO `trip` (`trip_id`, `cityStartId`, `cityEndId`, `date_start`, `date_end`, `adress_end`, `adress_start`, `sits`, `state`) VALUES
	(1, 1, 2, '2018-06-01 11:09:05', '2018-06-01 15:09:08', NULL, NULL, 4, 0),
	(2, 5, 4, '2018-07-04 09:18:47', '2018-07-04 17:18:47', NULL, NULL, 7, 0),
	(3, 3, 2, '2018-06-01 11:11:43', '2018-06-01 17:11:46', NULL, NULL, 2, 1);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_user_user_role` (`user_role_id`),
  CONSTRAINT `FK_user_user_role` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.user : ~3 rows (environ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `user_role_id`, `firstname`, `lastname`, `email`, `password`) VALUES
	(1, 1, 'Roger', 'Plantouille', 'roger.plantouille@dede.fr', '06e0c73df89561a5ee056d2eea9deabe'),
	(2, 2, 'Albert', 'Plantu', 'albert.plantu@dede.fr', 'a2726103f4c224208895054943bd0221'),
	(3, 3, 'Bobby', 'Lapointe', 'bobby.lapointe@dede.fr', '648f262a5f9641aba603cc06fd98b6fd');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.user_role : ~3 rows (environ)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
REPLACE INTO `user_role` (`user_role_id`, `role`) VALUES
	(1, 'Admin'),
	(2, 'Simple_User'),
	(3, 'Register_User');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
