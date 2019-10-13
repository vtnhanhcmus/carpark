DROP SCHEMA IF EXISTS `car_park`;

CREATE DATABASE `car_park` DEFAULT CHARSET=utf8mb4 /*!40100 DEFAULT CHARACTER SET latin1 */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_park`.`car_park` (
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
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`car_park_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `car_park`.`location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_park`.`location` (
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `car_park_no` varchar(10) NOT NULL,
  PRIMARY KEY (`car_park_no`),
  KEY `fk_location_carpark_idx` (`car_park_no`),
  CONSTRAINT `fk_location_carpark` FOREIGN KEY (`car_park_no`) REFERENCES `car_park` (`car_park_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `car_park`.`availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_park`.`availability` (
  `car_park_no` varchar(10) NOT NULL,
  `lot_type` varchar(1) NOT NULL,
  `total_lots` int(11) NOT NULL,
  `available_lots` int(11) NOT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`car_park_no`,`lot_type`),
  KEY `fk_ availability_carpark_idx` (`car_park_no`),
  CONSTRAINT `fk_availability_carpark` FOREIGN KEY (`car_park_no`) REFERENCES `car_park` (`car_park_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `car_park`.`carpark_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_park`.`carpark_data` (
  `car_park_no` varchar(10) NOT NULL,
  `lot_type` varchar(1) NOT NULL,
  `total_lots` int(11) NOT NULL,
  `available_lots` int(11) NOT NULL,
  `update_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`car_park_no`, `lot_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;