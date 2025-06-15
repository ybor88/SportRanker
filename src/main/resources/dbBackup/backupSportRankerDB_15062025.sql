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
INSERT INTO `players` VALUES ('ADB04071926170A','Alfredo','Di Stéfano Laulhé',1926,'S','AT',168.81,'ARG'),('ADC09111974170A','Alessandro','Del Piero',1974,'S','AT',105.53,'ITA'),('AIH07061975180G','Allen Ezail','Iverson',1975,'B','G',87.80,'USA'),('ANR19031976180D','Alessandro','Nesta',1976,'S','DI',107.03,'ITA'),('DBZ02031973200A','Dejan','Bodiroga',1973,'B','AP',57.18,'SRB'),('DML30101960160C','Diego Armando','Maradona',1960,'S','CE',193.92,'ARG'),('DPC25051953177D','Daniel Alberto','Passarella',1953,'S','DI',170.83,'ARG'),('DRK06081965210C','David Maurice','Robinson',1965,'B','C',75.80,'USA'),('EPT23101940170A','Edson Arantes do Nascimento','Pele\'',1940,'S','AT',218.29,'BRA'),('FBM11091945180D','Franz Anton','Beckenbauer',1945,'S','DI',125.75,'GER'),('FCN13091973170D','Fabio','Cannavaro',1973,'S','DI',110.01,'ITA'),('FIP09081973180A','Filippo','Inzaghi',1973,'S','AT',108.10,'ITA'),('FTR27091976180A','Francesco','Totti',1976,'S','AT',105.53,'ITA'),('GB28011978190P','Gianluigi','Buffon',1978,'S','PO',148.41,'ITA'),('GBA01021969180A','Gabriel Omar','Batistuta',1969,'S','AT',139.89,'ARG'),('GBM22121963180D','Giuseppe Raffaele','Bergomi',1963,'S','DI',116.81,'ITA'),('HCF05071975180A','Hernán Jorge','Crespo',1975,'S','AT',111.10,'ARG'),('HOL21011963210C','Hakeem Abdul','Olajuwon',1963,'B','C',77.50,'NIG'),('JCL28021957190C','Jan','Ceulemans',1957,'S','CE',183.72,'BEL'),('JEE22021950200A','Julius Winfield','Erving II',1950,'B','AP',80.60,'USA'),('JPL04121953180P','Jean-Marie','Pfaff',1953,'S','PO',132.00,'BEL'),('JSB11121981160A','Javier Pedro','Saviola Fernández',1981,'S','AT',97.11,'ARG'),('JVL09031975180C','Juan Sebastián','Verón',1975,'S','CE',109.06,'ARG'),('JWC28051938190P','Jerome Alan','West',1938,'B','PG',86.20,'USA'),('JZB10081973170D','Javier Adelmar','Zanetti',1973,'S','DI',119.45,'ARG'),('KBP23081978190G','Kobe Bean','Bryant',1978,'B','G',81.10,'USA'),('KPN23111980190G','Kirk Samuel','Penney',1980,'B','G',31.30,'NZE'),('LBW07121956200A','Larry Joe','Bird',1956,'B','AG',82.70,'USA'),('LRI18091976180A','Luís Nazário de Lima','Ronaldo',1976,'S','AT',163.60,'BRA'),('MJN17021963190G','Michael Jeffrey','Jordan',1963,'B','G',88.40,'USA'),('MKB15071954180A','Mario Alberto','Kempes Chiodi',1954,'S','AT',139.05,'ARG'),('MPJ21061955170C','Michel François','Platini',1955,'S','CE',198.16,'FRA'),('OSN16021958200A','Oscar Daniel Bezerra','Schmidt',1958,'B','AG',65.12,'BRA'),('OSS02101935160A','Enrique Omar','Sívori',1935,'S','AT',127.36,'ARG'),('PMM26061968180D','Paolo Cesare','Maldini',1968,'S','DI',107.97,'ITA'),('PSG18111963190P','Peter Bolesław','Schmeichel',1963,'S','PO',146.90,'DAN'),('PSP09061977200A','Predrag','Stojaković',1977,'B','AP',70.50,'SRB'),('RBC18021967170A','Roberto','Baggio',1967,'S','AT',111.18,'ITA'),('RCN09081928180P','Robert Joseph','Cousy',1928,'B','PG',73.70,'USA'),('RDP21031980180C','Ronaldo de Assis Moreira','Ronaldinho',1980,'S','CE',166.88,'BRA'),('RMR24081965200G','Reginald Wayne','Miller',1965,'B','G',72.50,'USA'),('RSB02031981190G','Romain Guessagba','Sato Lebel',1981,'B','G',44.61,'RCA'),('SNJ07021974190P','Stephen John','Nash',1974,'B','PG',65.60,'RSA'),('SON06031972210C','Shaquille Rashaun','O\'Neal',1972,'B','C',78.40,'USA'),('VRP19041972180C','Vítor Borba Ferreira','Rivaldo',1972,'S','CE',178.59,'BRA'),('WCP21081936210C','Wilton Norman','Chamberlain',1936,'B','C',95.90,'USA'),('WRM12021934200C','William Felton','Russell',1934,'B','C',77.40,'USA'),('ZIM03101981190A','Zlatan','Ibrahimović',1981,'S','AT',153.68,'SVE');
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

-- Dump completed on 2025-06-15 16:09:57
