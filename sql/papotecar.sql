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
  `zip_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.city : ~0 rows (environ)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.message : ~0 rows (environ)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. step
CREATE TABLE IF NOT EXISTS `step` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `trip_id` int(11) NOT NULL,
  `city_start_id` int(11) NOT NULL,
  `city_end_id` int(11) NOT NULL,
  `adress_start` varchar(50) DEFAULT NULL,
  `adress_end` varchar(50) DEFAULT NULL,
  `meeting_hour` datetime NOT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`step_id`),
  KEY `FK_step_trip` (`trip_id`),
  KEY `FK_step_city` (`city_start_id`),
  KEY `FK_step_city_2` (`city_end_id`),
  CONSTRAINT `FK_step_city` FOREIGN KEY (`city_start_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_step_city_2` FOREIGN KEY (`city_end_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_step_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step : ~0 rows (environ)
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step_user : ~0 rows (environ)
/*!40000 ALTER TABLE `step_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `step_user` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. step_user_role
CREATE TABLE IF NOT EXISTS `step_user_role` (
  `step_user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`step_user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.step_user_role : ~0 rows (environ)
/*!40000 ALTER TABLE `step_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `step_user_role` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. trip
CREATE TABLE IF NOT EXISTS `trip` (
  `trip_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_start_id` int(11) NOT NULL,
  `city_end_id` int(11) NOT NULL,
  `date_start` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  `adress_end` varchar(50) DEFAULT NULL,
  `adress_start` varchar(50) DEFAULT NULL,
  `sits` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trip_id`),
  KEY `FK_trip_city` (`city_start_id`),
  KEY `FK_trip_city_2` (`city_end_id`),
  CONSTRAINT `FK_trip_city` FOREIGN KEY (`city_start_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `FK_trip_city_2` FOREIGN KEY (`city_end_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.trip : ~0 rows (environ)
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.user : ~0 rows (environ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Listage de la structure de la table papotecar. user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table papotecar.user_role : ~0 rows (environ)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
