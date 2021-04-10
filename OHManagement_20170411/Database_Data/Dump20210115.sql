CREATE DATABASE  IF NOT EXISTS `oh_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `oh_management`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: oh_management
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,2,'Hi , I want to talk with you !!','2020-12-04'),(2,1,3,'Hi , what happen !!','2020-12-02'),(3,2,1,'Hi , call me !!','2021-12-01'),(4,2,3,'Hi , your grade in site !!','2021-12-22'),(5,1,4,'Hi I am Moaaz !!','2021-01-14'),(6,1,21,'Hi I am Moaaz !!','2021-01-14'),(7,1,2,'Hi Me too !!','2021-01-14'),(8,2,4,'Hii I am Hana !!','2021-01-14'),(9,2,21,'Hii I am Hana !!','2021-01-14'),(10,1,1,'Hi math!','2021-01-15'),(11,2,1,'Testing Messages !! ^_^','2021-01-15');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,1,2,'Moaaz cancel the meeting','2021-12-22'),(2,1,0,'Add reservition for the meeting in slot 12:00:00','2021-12-22'),(3,2,1,'Doaa send to you massage','2021-12-22'),(4,1,2,'Moaaz cancel the meeting','2021-12-22'),(5,1,0,'Add reservition for the meeting in slot 12:00:00','2021-12-22'),(6,2,1,'Today you have a meeting','2021-12-22'),(7,0,1,'Moaaz cancel the meeting','2021-12-22'),(8,3,1,'Add reservition for the meeting in slot 12:00:00','2021-12-22'),(9,2,1,'reservition with two meetings','2021-12-02'),(10,2,1,'The Reservation was Cancling from Hana to Moaaz','2021-01-15'),(11,1,1,'The message was sent from Moaaz to Moaaz','2021-01-15'),(12,0,4,'The Reservation was Cancling from null to Rufidah','2021-01-15'),(13,2,1,'The message was sent from Hana to Moaaz','2021-01-15');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `office_hours`
--

LOCK TABLES `office_hours` WRITE;
/*!40000 ALTER TABLE `office_hours` DISABLE KEYS */;
INSERT INTO `office_hours` VALUES (1,1,'01:30:00','03:00:00','2020-01-15',1),(3,1,'02:30:00','03:00:00','2020-01-12',0),(4,1,'01:30:00','02:00:00','2020-01-15',0),(5,1,'02:30:00','04:00:00','2020-01-05',0),(6,1,'02:45:00','04:50:00','2020-05-08',0),(8,4,'06:35:00','07:36:00','2021-01-12',1),(9,4,'06:03:00','03:06:00','2021-01-07',1),(12,4,'06:21:00','07:21:00','2021-01-12',1),(13,4,'04:22:00','05:22:00','2021-01-12',0),(14,1,'10:00:00','11:00:00','2021-01-04',0);
/*!40000 ALTER TABLE `office_hours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (2,1,2,1,'2020-12-20'),(6,8,0,4,'2021-01-06'),(7,9,0,4,'2021-01-06'),(14,12,2,4,'2021-01-14');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'math'),(2,'design'),(3,'programming'),(4,'logic'),(5,'concept'),(6,'IA');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Moaaz','mo2222ath@gmail.com','2112',1,'staff','Moaaz Hasan'),(2,'Hana','Hana@gmail.com','1212',-1,'student','Hana Abduallah'),(3,'Doaa','doaa@gmail.com','1414',-1,'student','Doaa Hasan'),(4,'Rufidah','R@gmail.com','1313',2,'staff','Rufaidah'),(21,'Sohaib','S@gmail.com','1515',2,'staff','Sohaib Ahmed'),(22,'mhr411','mhr411@stud.fci-cu.edu.eg','WKW7QQ',-1,'staff',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-15 23:47:57
