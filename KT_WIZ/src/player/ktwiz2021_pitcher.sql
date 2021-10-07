-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ktwiz2021
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pitcher`
--

DROP TABLE IF EXISTS `pitcher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pitcher` (
  `name` varchar(45) NOT NULL,
  `salary` int NOT NULL,
  `deposit` int NOT NULL,
  `position` varchar(45) NOT NULL,
  `number` int NOT NULL,
  `era` double NOT NULL,
  `phr` int NOT NULL,
  `win` int NOT NULL,
  `lose` int NOT NULL,
  `sv` int NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitcher`
--

LOCK TABLES `pitcher` WRITE;
/*!40000 ALTER TABLE `pitcher` DISABLE KEYS */;
INSERT INTO `pitcher` VALUES ('고영표',12000,13000,'투수',1,2.81,6,11,4,0),('이대은',5000,0,'투수',11,2.73,2,3,1,1),('엄상백',5000,23000,'투수',18,3.89,6,3,1,0),('배제성',17000,3000,'투수',19,3.31,5,9,8,0),('이창재',4700,12000,'투수',21,2.52,0,2,0,0),('김민수',7000,11000,'투수',26,2.75,2,4,2,0),('소형준',14000,36000,'투수',30,4.46,6,5,6,0),('쿠에바스',59000,29000,'투수',32,4.54,9,4,0,0),('심재민',6300,25000,'투수',34,2.54,3,0,1,0),('주권',25000,30000,'투수',38,2.91,3,3,3,0),('데스파이네',59000,35000,'투수',40,3.42,10,10,9,0),('박시영',6800,0,'투수',46,2.61,4,3,2,0),('안영명',7000,18000,'투수',48,4.32,2,0,1,0),('조현우',7500,10000,'투수',59,3.47,0,0,0,0),('김재윤',17000,0,'투수',62,2.86,5,4,3,29);
/*!40000 ALTER TABLE `pitcher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-07 18:09:41
