-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: BikeTrip
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.15.10.1

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
-- Table structure for table `BIKE`
--

DROP TABLE IF EXISTS `BIKE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BIKE` (
  `id_BIKE` int(11) NOT NULL AUTO_INCREMENT,
  `BIKE_User` int(11) DEFAULT NULL,
  `BIKE_name` varchar(45) DEFAULT NULL,
  `BIKE_groupe` varchar(45) DEFAULT NULL,
  `BIKE_km` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_BIKE`),
  UNIQUE KEY `BIKE_name_UNIQUE` (`BIKE_name`),
  KEY `fk_USER_idx` (`BIKE_User`),
  CONSTRAINT `fk_USER` FOREIGN KEY (`BIKE_User`) REFERENCES `USER` (`id_USER`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BIKE`
--

LOCK TABLES `BIKE` WRITE;
/*!40000 ALTER TABLE `BIKE` DISABLE KEYS */;
/*!40000 ALTER TABLE `BIKE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRIP`
--

DROP TABLE IF EXISTS `TRIP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRIP` (
  `id_TRIP` int(11) NOT NULL,
  `TRIP_Date` datetime NOT NULL,
  `TRIP_Bike` int(11) DEFAULT NULL,
  `TRIP_KM` varchar(45) DEFAULT NULL,
  `TRIP_Time` varchar(45) DEFAULT NULL,
  `TRIP_Speed` varchar(45) DEFAULT NULL,
  `TRIP_Denivele` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_TRIP`),
  KEY `fk_TRIP_BIKE_idx` (`TRIP_Bike`),
  CONSTRAINT `fk_TRIP_1` FOREIGN KEY (`TRIP_Bike`) REFERENCES `BIKE` (`id_BIKE`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRIP`
--

LOCK TABLES `TRIP` WRITE;
/*!40000 ALTER TABLE `TRIP` DISABLE KEYS */;
/*!40000 ALTER TABLE `TRIP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `id_USER` int(11) NOT NULL AUTO_INCREMENT,
  `USER_Name` varchar(45) NOT NULL,
  `USER_KM` int(11) DEFAULT NULL,
  `USER_Temps` datetime DEFAULT NULL,
  PRIMARY KEY (`id_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-30 10:53:36