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
-- Table structure for table `batter`
--

DROP TABLE IF EXISTS `batter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batter` (
  `name` varchar(45) NOT NULL,
  `salary(단위:만원)` int NOT NULL,
  `deposit(단위:만원)` int NOT NULL,
  `position` varchar(45) NOT NULL,
  `number` int NOT NULL,
  `avg` double NOT NULL,
  `hr` int NOT NULL,
  `sb` int NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batter`
--

LOCK TABLES `batter` WRITE;
/*!40000 ALTER TABLE `batter` DISABLE KEYS */;
INSERT INTO `batter` VALUES ('김건형',3000,4000,'타자',0,0.212,0,1),('심우준',15500,13000,'타자',2,0.261,6,15),('권동진',3000,15000,'타자',3,0.266,1,3),('오윤석',6000,0,'타자',4,0.248,4,4),('신본기',9200,12000,'타자',5,0.238,1,1),('박경수',40000,43000,'타자',6,0.206,8,0),('강민국',5500,20000,'타자',7,0.244,0,0),('홍현빈',3400,9000,'타자',8,0.2,0,0),('송민섭',5700,0,'타자',12,0.239,0,12),('김병희',3500,13000,'타자',14,0.288,5,3),('박승욱',8000,8000,'타자',16,0.333,0,1),('허도환',7500,0,'타자',17,0.272,2,0),('황재균',80000,6000,'타자',20,0.307,10,11),('장성우',21000,20000,'타자',22,0.235,14,0),('조용호',13000,0,'타자',23,0.24,0,11),('호잉',35000,11000,'타자',24,0.245,8,4),('문상철',6000,13000,'타자',25,0.221,2,2),('배정대',14000,15000,'타자',27,0.258,11,16),('이홍구',7000,11000,'타자',35,0.164,1,0),('김준태',6500,0,'타자',43,0.204,4,0),('김태훈',3700,6000,'타자',45,0.22,1,0),('강백호',31000,45000,'타자',50,0.357,16,9),('김민혁',6500,6000,'타자',53,0.315,0,4),('천성호',4000,10000,'타자',54,0.306,0,1),('유한준',50000,6000,'타자',61,0.285,2,1);
/*!40000 ALTER TABLE `batter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-06 10:46:22
