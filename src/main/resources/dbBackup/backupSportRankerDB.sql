-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: sportRankerDB
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `CODICE` char(15) COLLATE utf8mb4_general_ci NOT NULL,
  `NOME` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `COGNOME` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `ANNO_NASCITA` year NOT NULL,
  `SPORT` enum('B','S') COLLATE utf8mb4_general_ci NOT NULL,
  `RUOLO` enum('C','AG','AP','G','PG','CE','DI','AT','PO') COLLATE utf8mb4_general_ci NOT NULL,
  `RATING` decimal(5,2) DEFAULT NULL,
  `NAZIONALITA` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`CODICE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES ('DML30101960160C','Diego Armando','Maradona',1960,'S','CE',193.92,'ARG'),('EPT23101940170A','Edson Arantes do Nascimento','Pele\'',1940,'S','AT',218.29,'BRA'),('FIP09081973180A','Filippo','Inzaghi',1973,'S','AT',108.10,'ITA'),('LBW07121956200A','Larry Joe','Bird',1956,'B','AG',82.70,'USA'),('MJN17021963190G','Michael Jeffrey','Jordan',1963,'B','G',88.40,'USA'),('PMM26061968180D','Paolo Cesare','Maldini',1968,'S','DI',107.97,'ITA');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-10 18:04:20
