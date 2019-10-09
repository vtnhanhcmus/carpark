-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: car_park
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car_park`
--

DROP TABLE IF EXISTS `car_park`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_park` (
  `car_park_no` varchar(10) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `x_coord` double DEFAULT NULL,
  `y_coord` double DEFAULT NULL,
  `car_park_type` varchar(100) DEFAULT NULL,
  `type_of_parking_system` varchar(50) DEFAULT NULL,
  `short_term_parking` varchar(50) DEFAULT NULL,
  `free_parking` varchar(45) DEFAULT NULL,
  `night_parking` varchar(45) DEFAULT NULL,
  `car_park_decks` int(11) DEFAULT NULL,
  `gantry_height` double DEFAULT NULL,
  `car_park_basement` varchar(1) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3047 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_park_id` int(11) NOT NULL,
  `total_lots` int(11) NOT NULL,
  `available_lots` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_park_no_UNIQUE` (`car_park_id`),
  KEY `fk_ availability_carpark_idx` (`car_park_id`),
  CONSTRAINT `fk_availability_carpark` FOREIGN KEY (`car_park_id`) REFERENCES `car_park` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2048 DEFAULT CHARSET=latin1;


/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_park`
--

LOCK TABLES `car_park` WRITE;
/*!40000 ALTER TABLE `car_park` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_park` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-08 23:56:23

