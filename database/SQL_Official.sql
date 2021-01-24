-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: thuongmaidientu
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commentcourse`
--

DROP TABLE IF EXISTS `commentcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commentcourse` (
  `idcomment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idcomment`),
  KEY `iduser` (`iduser`),
  KEY `idcourse` (`idcourse`),
  CONSTRAINT `commentcourse_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `commentcourse_ibfk_2` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentcourse`
--

LOCK TABLES `commentcourse` WRITE;
/*!40000 ALTER TABLE `commentcourse` DISABLE KEYS */;
INSERT INTO `commentcourse` VALUES ('CM001','Thầy dạy nhiệt tình, hài hước nên em học rất vui và nhanh hiểu bài','2020-01-01 08:00:00','U001','C01'),('CM002','Cảm ơn thầy đã nhiệt tình hỗ trợ và giúp đỡ em trong thời gian vừa qua','2020-01-01 08:02:00','U001','C01'),('CM003','Thank you so much. I love you 3000 <3 :)))))','2020-01-01 08:07:00','U003','C01'),('CM004','Thầy dạy nhiệt tình, hài hước nên em học rất vui và nhanh hiểu bài','2020-01-01 14:00:00','U003','C01'),('CM005','I really appriciate it! Thầy dạy không những rất hay mà còn đẹp trai nữa, kkk. ','2020-01-02 09:00:00','U001','C01'),('CM006','Cô rất vui tính ạ! Lần đầu tiên em học tiếng anh mà tiếp thu cả 100% luôn.','2020-01-05 18:00:00','U010','C01'),('CM007','Cảm ơn sự nhiệt tình của thầy trong thời gian vừa qua ạ','2020-01-07 09:00:00','U009','C01'),('CM008','Thanks a lot <3 <3 <3 <3 <3 <3 <3 <3 <3 <3! ','2020-01-07 15:00:00','U002','C01'),('CM009','Thanks for teaching me! Các bạn đăng ký học thử nhé, đăng kí 1 nhận được tận 10','2020-01-10 09:00:00','U007','C01'),('CM010','Xuất sắc quá thầy ơi. Mới có vài tuần học với thầy mà e đã cảm thấy tự tin hơn hẳn và e cảm thấy tiếng anh của mình có sự thay đổi hehe','2020-01-11 09:05:00','U008','C01'),('CM011','Thầy ơi cho e hỏi, khóa sau e có được học tiếp với thầy nữa k ạ! Em thích học với thầy lắm','2020-01-11 11:00:00','U006','C01'),('CMA849B4','hahahahahaha','2021-01-15 00:26:06','ST221DF7','C01'),('CME13473','Happy day!','2021-01-15 00:25:58','ST221DF7','C01');
/*!40000 ALTER TABLE `commentcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentvideo`
--

DROP TABLE IF EXISTS `commentvideo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commentvideo` (
  `idcomment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idvideo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idcomment`),
  KEY `iduser` (`iduser`),
  KEY `idvideo` (`idvideo`),
  CONSTRAINT `commentvideo_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `commentvideo_ibfk_2` FOREIGN KEY (`idvideo`) REFERENCES `video` (`idvideo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentvideo`
--

LOCK TABLES `commentvideo` WRITE;
/*!40000 ALTER TABLE `commentvideo` DISABLE KEYS */;
INSERT INTO `commentvideo` VALUES ('CM001','Thầy dạy nhiệt tình, hài hước nên em học rất vui và nhanh hiểu bài','2020-01-01 08:00:00','U001','V01'),('CM002','Cảm ơn thầy đã nhiệt tình hỗ trợ và giúp đỡ em trong thời gian vừa qua','2020-01-01 08:02:00','U001','V01'),('CM003','Thank you so much. I love you 3000 <3 :)))))','2020-01-01 08:07:00','U003','V01'),('CM004','Thầy dạy nhiệt tình, hài hước nên em học rất vui và nhanh hiểu bài','2020-01-01 14:00:00','U003','V01'),('CM005','I really appriciate it! Thầy dạy không những rất hay mà còn đẹp trai nữa, kkk. ','2020-01-02 09:00:00','U001','V01'),('CM006','Cô rất vui tính ạ! Lần đầu tiên em học tiếng anh mà tiếp thu cả 100% luôn.','2020-01-05 18:00:00','U010','V01'),('CM007','Cảm ơn sự nhiệt tình của thầy trong thời gian vừa qua ạ','2020-01-07 09:00:00','U009','V01'),('CM008','Thanks a lot <3 <3 <3 <3 <3 <3 <3 <3 <3 <3! ','2020-01-07 15:00:00','U002','V01'),('CM009','Thanks for teaching me! Các bạn đăng ký học thử nhé, đăng kí 1 nhận được tận 10','2020-01-10 09:00:00','U007','V01'),('CM010','Xuất sắc quá thầy ơi. Mới có vài tuần học với thầy mà e đã cảm thấy tự tin hơn hẳn và e cảm thấy tiếng anh của mình có sự thay đổi hehe','2020-01-11 09:05:00','U008','V01'),('CM011','Thầy ơi cho e hỏi, khóa sau e có được học tiếp với thầy nữa k ạ! Em thích học với thầy lắm','2020-01-11 11:00:00','U006','V01'),('CM6BAC28','Rất hay và bổ ích ạ','2021-01-15 01:18:02','ST221DF7','V01'),('CMCDDEA6','Rất hay và bổ ích ạ <3','2021-01-15 01:20:40','ST221DF7','V20'),('CMF36343','Rất hay và bổ ích ạ','2021-01-18 20:29:55','U001','V06B5E4');
/*!40000 ALTER TABLE `commentvideo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `idcourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `namecourse` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cost` int(11) NOT NULL,
  `startingday` date NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `summary` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idtype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idstatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idcourse`),
  KEY `idtype` (`idtype`),
  KEY `idstatus` (`idstatus`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`idtype`) REFERENCES `typecourse` (`idtype`),
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`idstatus`) REFERENCES `statuscourse` (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('C01','Online Video Course 1',490000,'2020-12-01','Khóa học tiếng Anh qua video, đập tan nỗi sợ, học mọi lúc mọi nơi','Chương 1: Tổng quan\r\nChương 2: Cơ bản','img/TCF09A29.jpg','TC2','SC1'),('C02','Online Tutor Course 2',1490000,'2020-12-01','Khóa học online 1-1 phát âm trong vòng 1 tháng. Giúp bạn nói tiếng Anh một cách chuẩn nhất','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/TCF09A29.jpg','TC2','SC1'),('C02E772','Giao Tiếp Anh Văn Cho Giới Trẻ Mới Lớn',200000,'2021-01-14','Học rộng, biết nhiều, nâng tầm cao mới, sánh vai với các nước trên thế giới','Chương 1: Giới thiệu\r\nChương 2: Tổng quan phát âm\r\nChương 3: Nguyên âm\r\nChương 4: Phụ âm\r\nChương 5: Các vấn đề cần lưu ý\r\nChương 6: Làm bài tập\r\nChương 7: Tổng kết','img/C02E772.jpg','TC2','SC1'),('C03','Online Tutor Course 3',2990000,'2020-12-01','Khóa học online 1-1 luyện tập theo chủ đề hằng ngày trong vòng 2 tháng, mọi chủ đề trong bàn tay của bạn','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/TCF09A29.jpg','TC2','SC1'),('C04','Online Tutor Course 4',3990000,'2020-12-01','Khóa học online 1-1 chuyên sâu trong vòng 3 tháng, tiếng Anh là chuyện nhỏ','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/TCF09A29.jpg','TC1','SC3'),('C423AAD','Giao Tiếp Anh Văn Không còn là nỗi sợ hãi',5000000,'2020-08-20','Khoá học giúp bạn thoát khỏi nỗi sợ hãi khi tiếp xúc và trò chuyện với người bản xứ','Chương 1: Nguyên âm\r\nChương 2: Nguyên âm đôi\r\nChương 3: Phụ âm\r\nChương 4: TobeVerbs & Adverbs\r\nChương 5: Tính từ sở hữu\r\nChương 6: Động từ thường\r\nChương 7: Động từ Modal\r\nChương 8: Object\r\nChương 9: Tổng kết & Làm bài tập','img/C423AAD.jpg','TC1','SC1'),('C732A31','Giao Tiếp Anh Văn Mỗi Ngày 2',3000000,'2021-10-14','Giúp bạn giao tiếp tốt hơn','Chương 1: Giới thiệu\r\nChương 2: Phát âm cơ bản','img/C732A31.jpg','TC2','SC1'),('C7AFEFC','Học Anh Văn Cơ Bản',500000,'2020-12-10','Học nhanh gọn, mà chắc chắn, đảm bảo giao tiếp tốt','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/C7AFEFC.jpg','TC1','SC1'),('C9BBB0C','Giao Tiếp Anh Văn Mỗi Ngày',1000000,'2020-12-11','Tạo cảm hứng mới mẻ','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/C9BBB0C.jpg','TC1','SC1'),('CA61AEE','Giao Tiếp Anh Văn Không còn là nỗi sợ hãi 3',2000000,'2021-01-11','Học nhanh gọn, mà chắc chắn, đảm bảo giao tiếp tốt','Chương 1: Giới thiệu\r\nChương 2: Tổng quan','img/CA61AEE.jpg','TC2','SC1'),('CB1A220','Học Anh Văn Online',500000,'2020-12-19','Học cơ bản - Chậm mà chắc','Chương 1: Tổng quan \\nChương 2: Cơ bản','img/CB1A220.jpg','TC2','SC1'),('CDCEC91','Giao Tiếp Anh Văn Không còn là nỗi sợ hãi',0,'2021-01-22','Học nhanh gọn, mà chắc chắn, đảm bảo giao tiếp tốt','fgejewfhwefewgdawtudgwwefalwefewhkfwejfewfe','img/CDCEC91.jpg','TC2','SC3'),('CE07535','Giao Tiếp Anh Văn Không còn là nỗi sợ hãi 2',5000000,'2021-01-10','sdhkGDJWHDdưq','Chương 1:cưewe\r\nChương 2:klwd\r\nChương 3:kjfwdewd','img/CE07535.jpg','TC2','SC1'),('CEF14ED','Giao Tiếp Anh Văn Không còn là nỗi sợ hãi 4',0,'2021-01-11','Nhanh gọn lẹ','Chương 1: Giới thiệu\r\nChương 2: Một số vấn đề cần biết','img/TCF09A29.jpg','TC2','SC3');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `income` (
  `idincome` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date NOT NULL,
  `totalcost` int(11) NOT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idincome`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES ('I001','2020-10-01',300000,'U001'),('I002','2020-10-01',12000000,'U002'),('I003','2020-10-01',6350000,'U003'),('I004','2020-10-01',5800000,'U004'),('I005','2020-10-01',8600000,'U005'),('I006','2020-10-01',4600000,'U006'),('I007','2020-10-01',3000000,'U007'),('I008','2020-10-01',12000000,'U008'),('I009','2020-10-01',5300000,'U009'),('I010','2020-10-01',4600000,'TCAA4F77');
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `level` (
  `idlevel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `namelevel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idlevel`),
  UNIQUE KEY `LEVEL_UK` (`namelevel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES ('1','ROLE_ADMIN'),('3','ROLE_STUDENT'),('2','ROLE_TEACHER');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `idpayment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datepayment` date NOT NULL,
  `cost` int(11) NOT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `payment` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpayment`),
  KEY `iduser` (`iduser`),
  KEY `idcourse` (`idcourse`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('P001','2020-10-02',2990000,'U011','C02','PAYPAL','PAID'),('P002','2020-10-04',1490000,'U012','C01','PAYPAL','PAID'),('P003','2020-10-08',1490000,'U013','C01','PAYPAL','PAID'),('P004','2020-10-10',490000,'U014','C01','PAYPAL','PAID'),('P005','2020-10-01',2990000,'U015','C02','PAYPAL','PAID'),('P006','2020-10-02',1490000,'U016','C01','PAYPAL','PAID'),('P007','2020-10-02',490000,'U017','C01','PAYPAL','PAID'),('P008','2020-10-12',2990000,'U018','C02','PAYPAL','PAID'),('P009','2020-10-12',1490000,'U019','C01','PAYPAL','PAID'),('P010','2020-10-22',1490000,'U020','C01','PAYPAL','PAID'),('P011','2020-10-24',2990000,'U021','C02','PAYPAL','PAID'),('P012','2020-10-30',2990000,'U022','C02','PAYPAL','PAID'),('P013','2020-10-30',1490000,'U023','C01','PAYPAL','PAID'),('P014','2020-10-30',2990000,'U024','C02','PAYPAL','PAID'),('P015','2020-10-30',2990000,'U025','C02','PAYPAL','PAID'),('P016','2020-10-30',1490000,'U026','C01','PAYPAL','PAID'),('P017','2020-10-02',2990000,'U027','C02','PAYPAL','PAID'),('P018','2020-10-06',2990000,'U028','C02','PAYPAL','PAID'),('P019','2020-10-06',1490000,'U029','C01','PAYPAL','PAID'),('P020','2020-10-06',490000,'U030','C01','PAYPAL','PAID'),('P021','2020-10-08',2990000,'U031','C02','PAYPAL','CANCELLED'),('P022','2020-10-08',2990000,'U032','C02','PAYPAL','CANCELLED'),('P023','2020-10-09',2990000,'U033','C02','PAYPAL','CANCELLED'),('P024','2020-10-09',2990000,'U034','C02','PAYPAL','CANCELLED'),('P025','2020-10-10',1490000,'U035','C01','PAYPAL','CANCELLED'),('P026','2020-10-15',1490000,'U036','C01','PAYPAL','CANCELLED'),('P027','2020-10-15',2990000,'U037','C02','PAYPAL','CANCELLED'),('P028','2020-10-19',2990000,'U038','C02','PAYPAL','CANCELLED'),('P029','2020-11-01',2990000,'U039','C02','PAYPAL','CANCELLED'),('P030','2020-11-01',490000,'U040','C01','PAYPAL','CANCELLED'),('P031','2020-11-03',2990000,'U041','C02','PAYPAL','CANCELLED'),('P032','2020-11-04',2990000,'U042','C02','PAYPAL','CANCELLED'),('P033','2020-11-04',2990000,'U043','C02','PAYPAL','CANCELLED'),('P034','2020-11-04',3990000,'U044','C03','PAYPAL','WAITING'),('P035','2020-11-04',3990000,'U045','C03','PAYPAL','WAITING'),('P036','2020-11-04',3990000,'U046','C03','PAYPAL','WAITING'),('P037','2020-11-06',2990000,'U047','C02','PAYPAL','WAITING'),('P038','2020-11-06',2990000,'U048','C02','PAYPAL','WAITING'),('P039','2020-11-07',490000,'U049','C01','PAYPAL','WAITING'),('P040','2020-11-08',3990000,'U050','C03','PAYPAL','WAITING'),('PAY41094B','2021-01-03',5000000,'ST221DF7','C03','PAYPAL','PAID'),('PAY7E7924','2021-01-14',2000000,'ST221DF7','CA61AEE','PAYPAL','PAID'),('PAY864148','2021-01-05',500000,'ST221DF7','C02','PAYPAL','PAID'),('PAYD3F5A1','2021-01-03',490000,'ST221DF7','C01','PAYPAL','PAID'),('PAYE0E347','2021-01-03',1000000,'ST221DF7','C9BBB0C','PAYPAL','PAID');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratecourse`
--

DROP TABLE IF EXISTS `ratecourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ratecourse` (
  `idrate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numstar` int(11) NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcourse` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idrate`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `ratecourse_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratecourse`
--

LOCK TABLES `ratecourse` WRITE;
/*!40000 ALTER TABLE `ratecourse` DISABLE KEYS */;
INSERT INTO `ratecourse` VALUES ('R001',4,'Very Good','U006','C01'),('R002',5,'Excellent','U005','C01'),('R003',3,'Good','U012','C01'),('R004',4,'Very Good','U019','C01'),('R005',4,'Very Good','U017','C01'),('R006',5,'Excellent','U004','C01'),('R007',5,'Excellent','U004','C02'),('R008',5,'Excellent','U006','C02'),('R009',3,'Good','U007','C02'),('R010',4,'Very Good','U007','C02'),('R011',5,'Excellent','U007','C02'),('R012',5,'Excellent','U008','C03'),('R013',4,'Very Good','U010','C03'),('R014',5,'Excellent','U009','C03'),('R015',5,'Excellent','U006','C03'),('R016',4,'Very Good','U005','C04'),('R017',4,'Very Good','U005','C04'),('R018',5,'Excellent','U002','C04'),('R019',3,'Good','U004','C04'),('R020',4,'Very Good','U008','C04'),('RC1179EB',2,'ffbbkravdedijlksnbcwchljsmsx','ST221DF7','C01');
/*!40000 ALTER TABLE `ratecourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rateteacher`
--

DROP TABLE IF EXISTS `rateteacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rateteacher` (
  `idrate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numstar` int(11) NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idteacher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idrate`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `rateteacher_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rateteacher`
--

LOCK TABLES `rateteacher` WRITE;
/*!40000 ALTER TABLE `rateteacher` DISABLE KEYS */;
INSERT INTO `rateteacher` VALUES ('R001',4,'Very Good','U012','U001'),('R002',5,'Excellent','U015','U001'),('R003',3,'Good','U018','U001'),('R004',4,'Very Good','U019','U001'),('R005',4,'Very Good','U012','U002'),('R006',5,'Excellent','U014','U002'),('R007',5,'Excellent','U018','U002'),('R008',5,'Excellent','U011','U002'),('R009',3,'Good','U015','U002'),('R010',4,'Very Good','U013','U002'),('R011',5,'Excellent','U017','U003'),('R012',5,'Excellent','U019','U003'),('R013',4,'Very Good','U012','U003'),('R014',5,'Excellent','U010','U003'),('R015',5,'Excellent','U012','U003'),('R016',4,'Very Good','U015','U003'),('R017',4,'Very Good','U019','U003'),('R018',5,'Excellent','U016','U003'),('R019',3,'Good','U011','U003'),('R020',4,'Very Good','U012','U003'),('RC1179EB',2,'ffbbkravdedijlksnbcwchljsmsx','ST221DF7','U003'),('RC4427F1',3,'kiufutyghkj','ST221DF7','U001'),('RCAF5902',5,'Execllent!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!','ST221DF7','U001');
/*!40000 ALTER TABLE `rateteacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `report` (
  `idreport` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datereport` date NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idincome` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idreport`),
  KEY `idteacher` (`iduser`),
  KEY `idincome` (`idincome`),
  CONSTRAINT `idteacher` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`idincome`) REFERENCES `income` (`idincome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES ('RP001','2020-11-01','Vui vẻ, tập trung, phát âm tốt','img/1.png',100000,'CONFIRMED','U002','I002'),('RP002','2020-11-01','Năng lượng, hay nhầm giữa 2 âm \"s\" và \"S\"','img/1.png',100000,'CONFIRMED','U001','I001'),('RP003','2020-11-01','Ngữ pháp vẫn còn yếu, nhớ được nhiều từ và ứng dụng được nhiều hơn','img/1.png',100000,'CONFIRMED','U004','I004'),('RP004','2020-11-01','Mạng hơi yếu do kết nối kém nên ảnh hưởng đến buổi học, nắm bài nhanh','img/1.png',100000,'CONFIRMED','U003','I003'),('RP005','2020-11-01','Phát âm còn sai một số lỗi, biết khá khá từ vựng nhưng dùng chưa được linh hoạt, sai một số lỗi np cơ bản','img/1.png',100000,'CONFIRMED','U005','I005'),('RP006','2020-11-02','Đã khắc phục được chỗ âm \"s\" và xì đúng chỗ hơn','img/1.png',100000,'CONFIRMED','U007','I007'),('RP007','2020-11-02','Chị nghe cả đoạn dài còn chưa quen, nghe đoán chữ khá tốt, phát âm khá tốt, ít quên âm đuôi, tự diễn đạt câu nói của mình còn yếu nhiều','img/1.png',100000,'CONFIRMED','U009','I009'),('RP008','2020-11-02','Vốn từ vựng khá, phát âm tốt và tiếp thu bài nhanh. Một số từ âm còn sai do ảnh hưởng tiếng Đức và khẩu hình miệng chưa đúng.','img/1.png',100000,'CONFIRMED','U008','I008'),('RP009','2020-11-02','Từ vựng khá nhưng chưa ứng dụng được nhiều, phát triển cấu trúc nhiều hơn','img/1.png',100000,'CONFIRMED','U010','I010'),('RP010','2020-11-02','Từ vựng nhớ được nhiều hơn. ngữ pháp tốt nhưng ứng dụng còn chậm','img/1.png',100000,'CONFIRMED','U006','I006'),('RP011','2020-11-03','Chị nắm được bài, áp dụng tốt, một số chỗ khó được GV giái đáp','img/1.png',100000,'CONFIRMED','U002','I002'),('RP012','2020-11-03','Có kiến thức khá tốt về modal verbs, tiếp thu nhanh và làm bài tập phần modal verbs rất tốt. Làm phần dịch khá tốt, học từ vựng ngay trên lớp và vận dụng tốt trong phần bài tập','img/1.png',100000,'CONFIRMED','U001','I001'),('RP013','2020-11-03','Speaking tốt, sử dụng vocab tốt nhưng hôm nay thỉnh thoảng ngập ngừng một tí. Em phản xạ nhanh, có thể nói 1 đoạn văn ngay lập tức mà không cần chuẩn bị nhiều.','img/1.png',100000,'CONFIRMED','U004','I004'),('RP014','2020-11-03','Tiếp thu bài về Adverbs nhanh chóng và làm bài tập khá tốt. Vẫn còn nhớ được các kiến thức đã học ở các bài trước nên làm phần ôn tập cuối khóa khá tốt, tuy nhiên vẫn có một số từ anh không nhớ, cần ôn lại','img/1.png',100000,'CONFIRMED','U003','I003'),('RP015','2020-11-03','Nhận diện tốt tính từ, nắm được nội dung bài mới nhưng ứng dụng chưa nhanh, có qun tâm đến sửa lỗi phát âm','img/1.png',100000,'CONFIRMED','U005','I005'),('RP016','2020-11-04','Bạn hiểu bài nhanh,đặt câu tốt , làm bài tập áp dụng đúng','img/1.png',100000,'CONFIRMED','U007','I007'),('RP017','2020-11-04','Chị phát âm khá tốt, có đa dạng các cấu trúc ngữ pháp để diễn đạt câu','img/1.png',100000,'CONFIRMED','U009','I009'),('RP018','2020-11-04','Ban nói được ý tưởng bằng tiếng Anh qua chủ đề cooking, đặt câu hỏi tốt, khả năng nghe tốt, chỉ một điểm yếu là thiếu tự tin','img/1.png',100000,'CONFIRMED','U008','I008'),('RP019','2020-11-04','Phát âm và từ vựng tốt. Cần luyện nghe nhiều hơn','img/1.png',100000,'CONFIRMED','U010','I010'),('RP020','2020-11-04','Có tiến bộ trong việc đặt câu, chịu khó học từ vựng ','img/1.png',100000,'CONFIRMED','U006','I006'),('RP021','2020-11-05','Biết nhiều từ vựng nhưng chưa vận dụng nhiều vào phần nói, tuy nhiên vẫn thiếu ý tưởng, cần nhiều sự trợ giúp từ giáo viên','img/1.png',100000,'CONFIRMED','U002','I002'),('RP022','2020-11-05','Tiếp thu từ vựng và chủ đề tốt. Đọc hiểu nhanh,giao tiếp tự tin','img/1.png',100000,'CONFIRMED','U001','I001'),('RP023','2020-11-05','Biết nhiều từ vựng nhưng chưa vận dụng nhiều vào phần nói, tuy nhiên vẫn thiếu ý tưởng, cần nhiều sự trợ giúp từ giáo viên','img/1.png',100000,'CONFIRMED','U004','I004'),('RP024','2020-11-05','Ngữ pháp vẫn còn chưa ổn lắm nhưng đã biết vận dụng nhiều từ vựng vào viết câu và nói','img/1.png',100000,'CONFIRMED','U003','I003'),('RP025','2020-11-05','Ngữ pháp vẫn còn bấp bênh, chịu khó học từ vựng','img/1.png',100000,'CONFIRMED','U005','I005'),('RP026','2020-11-06','Nghe hiểu tốt hơn đã đặt được nhiều câu hơn','img/1.png',100000,'CONFIRMED','U007','I007'),('RP027','2020-11-06','Tốt, cần luyện tập ngữ điệu để có thể nói lưu loát hơn,nhớ nhiều từ vựng hơn','img/1.png',100000,'CONFIRMED','U009','I009'),('RP028','2020-11-06','Tốt, cần luyện tập ngữ điệu để có thể nói lưu loát hơn','img/1.png',100000,'WAITING','U008','I008'),('RP029','2020-11-06','Thiếu tập trung, quên ngữ pháp hiện tại hoàn thành gần hết, cũng như lượng từ vựng về pp của động từ vẫn còn yếu. ','img/1.png',100000,'WAITING','U010','I010'),('RP030','2020-11-06','Vận dụng tốt các từ vựng trung cấp, phát triển ý tốt','img/1.png',100000,'WAITING','U006','I006'),('RP031','2020-11-08','Không tiếp thu được, phần lớn học trò ngáo ngơ','img/1.png',0,'CONFIRMED','U006','I004'),('RP26D573','2021-01-18','tdyq34fuioedefgdwvhsipwdewdtrqwy','img/1.png',0,'WAITING','U001','I001'),('RPE3A38E','2021-01-15','Tốt, chăm chỉ!','img/1.png',0,'WAITING','TCAA4F77','I010');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedule` (
  `idschedule` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `daysofweek` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idschedule`),
  KEY `iduser` (`iduser`),
  KEY `idcourse` (`idcourse`),
  CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES ('SC001','Teacher','Mon-Wed-Fri','U001','C01'),('SC002','Teacher','Tue-Thu-Sat','U001','C02'),('SC003','Teacher','Mon-Wed-Fri','U003','C03'),('SC004','Teacher','undentify','U002','C04'),('SC011','Teacher','undentify','U001','C7AFEFC'),('SC4BB673','Teacher','undentify','U001','C423AAD'),('SC5E0CD0','Teacher','undentify','U001','CE07535'),('SC636CCC','Teacher','Wed-Fri-Mon','TCAA4F77','CEF14ED'),('SC9299B4','Teacher','Thu-Fri-Sat','TCAA4F77','C02E772'),('SCA3299D','Teacher','undentify','U001','C9BBB0C'),('SCAFC529','Teacher','Thu-Sun-Mon','U001','CA61AEE'),('SCC0D974','Teacher','undentify','U001','CB1A220'),('SCF9275D','Teacher','undentify','U001','C732A31');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shift` (
  `idshift` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nameshift` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `starttime` time NOT NULL,
  `endtime` time NOT NULL,
  `idschedule` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idshift`),
  KEY `idschedule` (`idschedule`),
  CONSTRAINT `shift_ibfk_1` FOREIGN KEY (`idschedule`) REFERENCES `schedule` (`idschedule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift`
--

LOCK TABLES `shift` WRITE;
/*!40000 ALTER TABLE `shift` DISABLE KEYS */;
INSERT INTO `shift` VALUES ('S001','Mon','07:00:00','08:00:00','SC001'),('S002','Wed','07:00:00','08:00:00','SC001'),('S003','Fri','07:00:00','08:00:00','SC001'),('S004','none','00:00:00','00:00:00','SC004'),('S005','none','00:00:00','00:00:00','SC011'),('S006','Tue','07:00:00','09:00:00','SC002'),('S007','Thu','15:00:00','17:00:00','SC002'),('S008','Sat','17:00:00','19:00:00','SC002'),('S009','Mon','07:00:00','09:00:00','SC003'),('S010','Wed','07:00:00','09:00:00','SC003'),('S011','Fri','19:00:00','21:00:00','SC003'),('S0DA8EF','Sat','09:00:00','11:00:00','SC9299B4'),('S0F1279','none','23:00:00','23:00:00','SC5E0CD0'),('S55C415','Mon','13:00:00','15:00:00','SC636CCC'),('S60835C','Sun','07:00:00','09:00:00','SCAFC529'),('S6E5140','none','00:00:00','00:00:00','SCA3299D'),('S72AE33','Fri','17:00:00','19:00:00','SC636CCC'),('S83735F','none','00:00:00','00:00:00','SCC0D974'),('S8A231B','none','23:00:00','23:00:00','SCAFC529'),('S90CA17','Thu','07:00:00','09:00:00','SCAFC529'),('S9C3F84','Thu','07:00:00','09:00:00','SC9299B4'),('SA01C3E','none','23:00:00','23:00:00','SC9299B4'),('SA41B88','Wed','17:00:00','19:00:00','SC636CCC'),('SBE45FB','Mon','09:00:00','11:00:00','SCAFC529'),('SC21228','none','23:00:00','23:00:00','SC4BB673'),('SCDD6B3','Fri','09:00:00','11:00:00','SC9299B4'),('SD3AA3B','none','23:00:00','23:00:00','SC636CCC'),('SEDFA1E','Wed','07:00:00','09:00:00','SC9299B4'),('SEE3EBF','Tue','07:00:00','09:00:00','SC9299B4'),('SF881F1','none','23:00:00','23:00:00','SCF9275D');
/*!40000 ALTER TABLE `shift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuscourse`
--

DROP TABLE IF EXISTS `statuscourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `statuscourse` (
  `idstatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `namecourse` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuscourse`
--

LOCK TABLES `statuscourse` WRITE;
/*!40000 ALTER TABLE `statuscourse` DISABLE KEYS */;
INSERT INTO `statuscourse` VALUES ('SC1','Đang hoạt động'),('SC2','Đã kết thúc'),('SC3','Đang tạm dừng');
/*!40000 ALTER TABLE `statuscourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typecourse`
--

DROP TABLE IF EXISTS `typecourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `typecourse` (
  `idtype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nametype` varchar(100) NOT NULL,
  PRIMARY KEY (`idtype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typecourse`
--

LOCK TABLES `typecourse` WRITE;
/*!40000 ALTER TABLE `typecourse` DISABLE KEYS */;
INSERT INTO `typecourse` VALUES ('TC1','Khoá học Video'),('TC2','Khoá học online');
/*!40000 ALTER TABLE `typecourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iduserinfo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `USER_UK` (`username`),
  KEY `iduserinfo` (`iduserinfo`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`iduserinfo`) REFERENCES `userinfo` (`iduserinfo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ST221DF7','minhquangngo','$2a$10$4h1cts/p6/vuHmA5YfEIG.KvDg1nlhv6nlQv1BCb5JzCALlkYtl6a','ACTIVE','TCINFOC644B8'),('STDB9137','trucdao','$2a$10$2ZODYa2P.uROybq9/v14F.Q9KGLj/2PgrCLOCms7OyHa9ex.gZ5X.','ACTIVE','TCINFOEBC82D'),('TCAA4F77','nguyenhongson','$2a$10$tT/NRQ0cRUtv3x1Ulbmr1.lnVt6GcVcU/bmWCyJnxomWzgeEzs.8a','ACTIVE','TCINFO79DFB6'),('U000','Admin','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIA000'),('U001','Teacher001','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT001'),('U002','Teacher002','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT002'),('U003','Teacher003','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','Active','UIT003'),('U004','Teacher004','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT004'),('U005','Teacher005','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT005'),('U006','Teacher006','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT006'),('U007','Teacher007','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT007'),('U008','Teacher008','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT008'),('U009','Teacher009','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT009'),('U010','Teacher010','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIT010'),('U011','Student001','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS011'),('U012','Student002','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS012'),('U013','Student003','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS013'),('U014','Student004','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS014'),('U015','Student005','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS015'),('U016','Student006','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS016'),('U017','Student007','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS017'),('U018','Student008','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS018'),('U019','Student009','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS019'),('U020','Student010','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS020'),('U021','Student011','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS021'),('U022','Student012','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS022'),('U023','Student013','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS023'),('U024','Student014','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS024'),('U025','Student015','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS025'),('U026','Student016','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS026'),('U027','Student017','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS027'),('U028','Student018','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS028'),('U029','Student019','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS029'),('U030','Student020','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS030'),('U031','Student021','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS031'),('U032','Student022','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS032'),('U033','Student023','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS033'),('U034','Student024','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS034'),('U035','Student025','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS035'),('U036','Student026','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS036'),('U037','Student027','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS037'),('U038','Student028','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS038'),('U039','Student029','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS039'),('U040','Student030','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS040'),('U041','Student031','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS041'),('U042','Student032','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS042'),('U043','Student033','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS043'),('U044','Student034','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS044'),('U045','Student035','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS045'),('U046','Student036','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS046'),('U047','Student037','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS047'),('U048','Student038','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS048'),('U049','Student039','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS049'),('U050','Student040','$2a$10$ffeKZBemgEGvxAujcQBKW.3.20opQQLGHm7R9OsWFJB26yhzwCUbS','active','UIS050');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` varchar(50) NOT NULL,
  `iduser` varchar(20) NOT NULL,
  `idlevel` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_ROLE_UK` (`iduser`,`idlevel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('URF354BB','ST221DF7','3'),('UR2B5D70','STDB9137','3'),('URB6DA41','TCAA4F77','2'),('UR8908UT','U000','1'),('UR8908UF','U000','2'),('UR8908US','U000','3'),('UR8902UF','U001','2'),('UR8U08UF','U002','2'),('UR890457','U003','2'),('UR88MEWT','U004','2'),('UR8908WW','U005','2'),('UR8908RR','U006','2'),('UR8908UE','U007','2'),('UR8908CC','U008','2'),('UR890WQ2','U009','2'),('UR890PYF','U010','2'),('UR890M9E','U011','3'),('UR890P22','U012','3'),('UR8908A7','U013','3'),('UR8909A1','U014','3'),('UR8902C0','U015','3'),('UR8903C1','U016','3'),('UR8904C2','U017','3'),('UR8905C3','U018','3'),('UR8909C6','U019','3'),('UR890EG7','U020','3'),('UR890503','U021','3'),('UR890MMH','U022','3'),('UR890Q1F','U023','3'),('UR890LLL','U024','3'),('UR890T66','U025','3'),('UR890U09','U026','3'),('UR890U22','U027','3'),('UR890U23','U028','3'),('UR8901M8','U029','3'),('UR890ZZZ','U030','3'),('UR890M9Y','U031','3'),('UR89005V','U032','3'),('UR8901PW','U033','3'),('UR890N5Q','U034','3'),('UR890P0P','U035','3'),('UR890M12','U036','3'),('UR890Z10','U037','3'),('UR890009','U038','3'),('UR890RRE','U039','3'),('UR890NGH','U040','3'),('UR890323','U041','3'),('UR890890','U042','3'),('UR890OQS','U043','3'),('UR890512','U044','3'),('UR890QQS','U045','3'),('UR890PPO','U046','3'),('UR890778','U047','3'),('UR890BVB','U048','3'),('UR890RPT','U049','3'),('UR890UHG','U050','3');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userinfo` (
  `iduserinfo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fullname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phonenumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diploma` varchar(200) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `biography` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`iduserinfo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('TCINFO79DFB6','Nguyen Hong Son22','2021-01-06','Nam','img/avatardefault.png','TEACHER','nguyenhongson22@gmail.com','0982642951','img/diploma.jpg','121 Ap Tan Hoa - Xa Tan Hoa - Duc Lap Ha - Duc Hoa - Long An','ougedbwelkjqwdwqdwqdhljdhkdn qws'),('TCINFOC644B8','Ngô Minh Quang','2003-06-17','Nam','img/avatardefault.png','STUDENT','ngominhquang9999@gmail.com','0982642951',NULL,'121 Ap Tan Hoa - Xa Tan Hoa - Duc Lap Ha - Duc Hoa - Long An','Thích ca hát, nấu ăn, coding'),('TCINFOEBC82D','Ngo Thi Truc Dao','2021-01-21','Nam','img/avatardefault.png','STUDENT','trucdaongo@gmail.com','0982642951','img/diploma.jpg','121 Ap Tan Hoa - Xa Tan Hoa - Duc Lap Ha - Duc Hoa - Long An','ougedbwelkjqwdwqdwqdhljdhkdn qws'),('UIA000','Admin','1999-08-01','Nam','img/avatardefault.png','ADMIN','admin0108@gmail.com','0969177286',NULL,'TP.HCM','Năng động, nỗ lực'),('UIS011','Tran Trong Anh','1999-02-11','Nam','img/avatardefault.png','STUDENT','tronganh@gmail.com','0397263546',NULL,'Binh Phuoc','Năng động, nỗ lực'),('UIS012','Nguyen Hong Son','1999-08-01','Nam','img/avatardefault.png','STUDENT','hongson@gmail.com','0392837642',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS013','Nguyen Tan Tai','1995-12-08','Nam','img/avatardefault.png','STUDENT','tantai@gmail.com','0283754858',NULL,'Long An','Năng động, nỗ lực'),('UIS014','Vo Thanh Quy','1989-08-12','Nu','img/avatardefault.png','STUDENT','thanhquy@gmail.com','0937482732',NULL,'Binh Dinh','Năng động, nỗ lực'),('UIS015','Ngo Minh Quang','1992-04-13','Nam','img/avatardefault.png','STUDENT','minhquang@gmail.com','0273645261',NULL,'Long An','Năng động, nỗ lực'),('UIS016','Nguyen Tan Huy','2001-07-11','Nam','img/avatardefault.png','STUDENT','tanhuy@gmail.com','0827374732',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS017','Nguyen Thi Thuy Hang','1996-09-02','Nu','img/avatardefault.png','STUDENT','thuyhang@gmail.com','0182732635',NULL,'Long An','Năng động, nỗ lực'),('UIS018','Truong Thi My Hao','1999-12-30','Nu','img/avatardefault.png','STUDENT','myhao@gmail.com','0182937348',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS019','Phan Kim Anh','2004-05-28','Nu','img/avatardefault.png','STUDENT','kimanh@gmail.com','0182838475',NULL,'TP.HCM','Năng động, nỗ lực'),('UIS020','Nguyen Tan Hung','1989-02-12','Nam','img/avatardefault.png','STUDENT','tanhung@gamil.com','0987654321',NULL,'An Giang','Năng động, nỗ lực'),('UIS021','Quynh Anh Minh','2001-12-21','Nu','img/avatardefault.png','STUDENT','anhminh@gmail.com','0192837478',NULL,'Tra Vinh','Năng động, nỗ lực'),('UIS022','Nguyen Tan Ninh','2000-12-28','Nam','img/avatardefault.png','STUDENT','tanninh@gmail.com','0982736472',NULL,'Ha Noi','Năng động, nỗ lực'),('UIS023','Tran Trong Chinh','1987-02-15','Nam','img/avatardefault.png','STUDENT','trongchinh@gmail.com','0826374617',NULL,'Thua Thien Hue','Năng động, nỗ lực'),('UIS024','Phan Van Ba','2003-07-15','Nam','img/avatardefault.png','STUDENT','vanba@gmail.com','0827636126',NULL,'Thanh Hoa','Năng động, nỗ lực'),('UIS025','Ninh Huu Phuoc','1999-11-17','Nam','img/avatardefault.png','STUDENT','huuphuoc@gmail.com','0172673654',NULL,'Gia Lai','Năng động, nỗ lực'),('UIS026','Nguyen Ha My','1998-11-26','Nu','img/avatardefault.png','STUDENT','hamy@gmail.com','0367261726',NULL,'Dak Lak','Năng động, nỗ lực'),('UIS027','Vo Thi Thanh Thuy','2001-08-26','Nu','img/avatardefault.png','STUDENT','thanhthuy@gmail.com','0182374817',NULL,'Cao Bang','Năng động, nỗ lực'),('UIS028','Tran Nguyen Quang Minh','2000-05-14','Nam','img/avatardefault.png','STUDENT','quangminh@gmail.com','0183273647',NULL,'Bac Giang','Năng động, nỗ lực'),('UIS029','Tuy Van Hau','1997-05-25','Nam','img/avatardefault.png','STUDENT','vanhau@gmail.com','0182938741',NULL,'Nghe An','Năng động, nỗ lực'),('UIS030','Le Nhu Huynh','2000-11-11','Nu','img/avatardefault.png','STUDENT','nhuhuynh@gmail.com','0182938481',NULL,'An Giang','Năng động, nỗ lực'),('UIS031','Nguyen Le Ngoc Tuan','1998-08-30','Nam','img/avatardefault.png','STUDENT','ngoctuan@gmail.com','0736472812',NULL,'Lam Dong','Năng động, nỗ lực'),('UIS032','Le Hong Hanh','1996-07-26','Nu','img/avatardefault.png','STUDENT','honghanh@gmail.com','0928384756',NULL,'Da Lat','Năng động, nỗ lực'),('UIS033','Vo Kieu Loan','2003-02-22','Nu','img/avatardefault.png','STUDENT','kieuloan@gmail.com','0298371627',NULL,'TP.HCM','Năng động, nỗ lực'),('UIS034','Nguyen Truc Dao','1999-04-26','Nu','img/avatardefault.png','STUDENT','trucdao@gmail.com','0298172635',NULL,'Ha Nam','Năng động, nỗ lực'),('UIS035','Mai Trong Tan','1998-09-25','Nam','img/avatardefault.png','STUDENT','trongtan@gmail.com','0182738281',NULL,'Kien Giang','Năng động, nỗ lực'),('UIS036','Nguyen Ha Anh','1999-08-08','Nam','img/avatardefault.png','STUDENT','haanh@gmail.com','0182738731',NULL,'Tra Vinh','Năng động, nỗ lực'),('UIS037','Tran Ngoc Mai','2002-11-09','Nu','img/avatardefault.png','STUDENT','ngocmai@gmail.com','0938283912',NULL,'Cao Bang','Năng động, nỗ lực'),('UIS038','Nguyen Van Binh','2001-04-23','Nam','img/avatardefault.png','STUDENT','vanbinh@gmail.com','0832763712',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS039','Tran Ha Nam Uyen','1999-02-18','Nu','img/avatardefault.png','STUDENT','namuyen@gmail.com','0792837364',NULL,'Hau Giang','Năng động, nỗ lực'),('UIS040','Le Thuc Quan','1995-06-13','Nam','img/avatardefault.png','STUDENT','thuquan@gmail.com','0831728361',NULL,'TP.HCM','Năng động, nỗ lực'),('UIS041','Tran Thi Lan Anh','1994-07-24','Nu','img/avatardefault.png','STUDENT','lananh@gmail.com','0837261726',NULL,'Vung Tau','Năng động, nỗ lực'),('UIS042','Nguyen Hong Tuan','1988-12-11','Nam','img/avatardefault.png','STUDENT','hongtuan@gmail.com','0251625371',NULL,'Tra Vinh','Năng động, nỗ lực'),('UIS043','Huynh Tan Tai','1994-04-21','Nam','img/avatardefault.png','STUDENT','tantai@gmail.com','0253426172',NULL,'Ben Tre','Năng động, nỗ lực'),('UIS044','Van Sy Thanh','2000-03-16','Nu','img/avatardefault.png','STUDENT','sythanh@gmail.com','0563726351',NULL,'Vinh Long','Năng động, nỗ lực'),('UIS045','Van Sy Hung','1999-12-02','Nam','img/avatardefault.png','STUDENT','syhung@gmail.com','0127837374',NULL,'TP.HCM','Năng động, nỗ lực'),('UIS046','Tran Trong Tat','2004-04-22','Nam','img/avatardefault.png','STUDENT','trongtat@gmail.com','0983762512',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS047','Nguyen Van Thanh','1999-11-21','Nam','img/avatardefault.png','STUDENT','vanthanh@gmail.com','0382738461',NULL,'Quang Nam','Năng động, nỗ lực'),('UIS048','Mai Tran Van Tuan','1999-02-15','Nam','img/avatardefault.png','STUDENT','vantuan@gmail.com','0934783281',NULL,'Quang Ngai','Năng động, nỗ lực'),('UIS049','Nguyen Tien Quynh','1997-06-11','Nu','img/avatardefault.png','STUDENT','tienquynh@gmail.com','0362728371',NULL,'Tien Giang','Năng động, nỗ lực'),('UIS050','Tran Phuong Uyen','1999-05-23','Nu','img/avatardefault.png','STUDENT','phuongquyen@gmail.com','0372819283',NULL,'Bac Giang','Năng động, nỗ lực'),('UIT001','Nguyen Ngoc Anh','1980-02-01','Nam','img/AVATAR.jpg','TEACHER','ngocanh0102@gmail.com','0384756294','img/diploma.jpg','Da Nang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT002','Tran Thi Kim Anh','1990-12-05','Nu','img/AVATAR.jpg','TEACHER','kimanh0512@gmail.com','0384759695','img/diploma.jpg','Long An','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT003','Tran Kim Bao','1995-10-24','Nam','img/AVATAR.jpg','TEACHER','kimbao2410@gmail.com','0483928476','img/diploma.jpg','Long An','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT004','Nguyen Quoc Cuong','1988-02-02','Nam','img/AVATAR.jpg','TEACHER','quoccuong0202@gmail.com','0182736453','img/diploma.jpg','Tra Vinh','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT005','Vu Thi My Duyen','1991-06-03','Nu','img/AVATAR.jpg','TEACHER','myduyen0306@gmail.com','0182738475','img/diploma.jpg','Hau Giang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT006','Nguyen Cong Danh','1998-01-25','Nam','img/AVATAR.jpg','TEACHER','congdanh2501@gmail.com','0394857684','img/diploma.jpg','Tien Giang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT007','Ngo Kim Oanh','1997-07-10','Nu','img/AVATAR.jpg','TEACHER','kimoanh1007@gmail.com','0384756192','img/diploma.jpg','Kien Giang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT008','Phan Phuong Nam','1880-10-07','Nam','img/AVATAR.jpg','TEACHER','phuongnam0710@gmail.com','0392718273','img/diploma.jpg','Tien Giang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT009','Nguyen Duc Manh','1990-07-30','Nam','img/AVATAR.jpg','TEACHER','ducmanh3007@gmail.com','0372837182','img/diploma.jpg','An Giang','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.'),('UIT010','Le Thi Tuyet','1997-11-29','Nu','img/AVATAR.jpg','TEACHER','tuyet2911@gmail.com','0392836471','img/diploma.jpg','Thanh Hoa','Tôi đã học qua khá nhiều trường lớp, dày dăn kinh nghiệm trong nhiều năm qua.');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `idvideo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `namevideo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `link` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `idcourse` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `iduser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idvideo`),
  KEY `idcourse` (`idcourse`),
  KEY `iduser` (`iduser`),
  CONSTRAINT `video_ibfk_1` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`),
  CONSTRAINT `video_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES ('V01','Lesson1_Vowels1','img/communication.jpg','video/1.mp4','free',115,'C01','U001'),('V02','Lesson2_Vowels2','img/communication.jpg','video/2.mp4','free',124,'C01','U001'),('V03','Lesson3_Dipthongs','img/communication.jpg','video/1.mp4','free',80,'C01','U001'),('V04','Lesson4_Consonants2','img/communication.jpg','video/2.mp4','purchage',113,'C01','U001'),('V05','Lesson5_Consonants3','img/communication.jpg','video/1.mp4','purchage',117,'C01','U001'),('V06','Lesson6_Consonants4','img/communication.jpg','video/2.mp4','purchage',101,'C01','U001'),('V06B5E4','Lesson14_MacDuong','img/V06B5E4.jpg','video/V06B5E4.mp4','free',1,'C02','U001'),('V07','Lesson7_TobeVerbs&Adverbs','img/communication.jpg','video/1.mp4','purchage',132,'C01','U001'),('V08','Lesson8_Possessive_Adjective','img/communication.jpg','video/2.mp4','purchage',110,'C01','U001'),('V09','Lesson9_NormalVerbs','img/communication.jpg','video/1.mp4','purchage',124,'C01','U001'),('V10','Lesson10_ModalVerbs','img/communication.jpg','video/2.mp4','purchage',90,'C01','U001'),('V11','Lesson11_Objects','img/communication.jpg','video/1.mp4','purchage',118,'C01','U001'),('V12','Lesson12_Review&Practice','img/communication.jpg','video/2.mp4','purchage',182,'C01','U001'),('V13','Lesson1_Vowels1','img/communication.jpg','video/1.mp4','free',112,'C02','U002'),('V14','Lesson2_Vowels2','img/communication.jpg','video/2.mp4','free',112,'C02','U002'),('V15','Lesson3_Dipthongs','img/communication.jpg','video/1.mp4','purchage',112,'C02','U002'),('V16','Lesson4_Consonants2','img/communication.jpg','video/2.mp4','purchage',112,'C02','U002'),('V17','Lesson5_Consonants3','img/communication.jpg','video/1.mp4','purchage',112,'C02','U002'),('V18','Lesson6_Consonants4','img/communication.jpg','video/2.mp4','purchage',112,'C02','U002'),('V19','Lesson7_TobeVerbs&Adverbs','img/communication.jpg','video/1.mp4','purchage',116,'C02','U002'),('V20','Lesson8_Possessive_Adjective','img/communication.jpg','video/2.mp4','purchage',118,'C02','U002'),('V21','Lesson9_NormalVerbs','img/communication.jpg','video/1.mp4','purchage',116,'C02','U002'),('V22','Lesson10_ModalVerbs','img/communication.jpg','video/2.mp4','purchage',116,'C02','U002'),('V23','Lesson11_Objects','img/communication.jpg','video/1.mp4','purchage',116,'C02','U002'),('V24','Lesson12_Review&Practice','img/communication.jpg','video/2.mp4','purchage',116,'C02','U002'),('V25','Lesson1_Vowels1','img/communication.jpg','video/1.mp4','free',116,'C03','U003'),('V26','Lesson2_Vowels2','img/communication.jpg','video/2.mp4','free',116,'C03','U003'),('V27','Lesson3_Dipthongs','img/communication.jpg','video/1.mp4','free',116,'C03','U003'),('V28','Lesson4_Consonants2','img/communication.jpg','video/2.mp4','purchage',116,'C03','U003'),('V29','Lesson5_Consonants3','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V30','Lesson6_Consonants4','img/communication.jpg','video/2.mp4','purchage',116,'C03','U003'),('V31','Lesson7_TobeVerbs&Adverbs','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V32','Lesson8_Possessive_Adjective','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V33','Lesson9_NormalVerbs','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V34','Lesson10_ModalVerbs','img/communication.jpg','video/2.mp4','purchage',116,'C03','U003'),('V35','Lesson11_Objects','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V36','Lesson12_Review&Practice','img/communication.jpg','video/2.mp4','purchage',116,'C03','U003'),('V37','Lesson13_Review&Practice2','img/communication.jpg','video/1.mp4','purchage',116,'C03','U003'),('V4DE00A','Chương 1: Giới thiệu','img/V4DE00A.jpg','video/V4DE00A.mp4','free',126,'C02E772','TCAA4F77'),('V6E3251','Lesson15_TTTTTT','img/V6E3251.jpg','video/2.mp4','purchage',112,'C01','U001'),('V9E1386','Lesson01_Giới thiệu','img/V9E1386.jpg','video/2.mp4','free',112,'C7AFEFC','U001'),('VCB141F','Lesson13_ABCDE','img/VCB141F.jpg','video/2.mp4','free',112,'C01','U001'),('VD8EF13','Lesson14_XYZZZ','img/VD8EF13.jpg','video/2.mp4','purchage',112,'C01','U001'),('VEF01F1','Chương 2: Tổng quan','img/VEF01F1.jpg','video/VEF01F1.mp4','free',2,'C02E772','TCAA4F77');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'thuongmaidientu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 11:35:07
