-- MySQL dump 10.17  Distrib 10.3.18-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: easy-apply
-- ------------------------------------------------------
-- Server version	10.3.18-MariaDB-1

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `application_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `vacancy_id` int(11) NOT NULL,
  `application_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,1,4,'2019-11-19 17:58:13'),(2,1,4,'2019-11-19 18:17:49'),(3,1,4,'2019-11-19 18:20:58'),(4,1,4,'2019-11-19 18:21:22'),(5,1,4,'2019-11-19 18:22:20'),(6,1,4,'2019-11-19 18:26:51'),(7,1,4,'2019-11-19 18:30:37'),(8,1,4,'2019-11-19 18:32:21'),(9,1,4,'2019-11-19 18:32:32'),(10,1,4,'2019-11-19 18:32:43'),(11,1,4,'2019-11-19 18:33:28'),(12,1,4,'2019-11-19 18:37:12'),(13,1,4,'2019-11-19 18:39:42'),(14,1,4,'2019-11-19 18:40:08'),(15,1,4,'2019-11-19 18:40:11'),(16,1,4,'2019-11-19 18:40:12'),(17,1,4,'2019-11-19 18:40:21'),(18,1,4,'2019-11-19 18:41:59'),(19,1,4,'2019-11-19 18:42:09'),(20,1,4,'2019-11-19 18:44:07'),(21,1,4,'2019-11-19 18:44:12'),(22,1,4,'2019-11-19 18:44:27'),(23,1,4,'2019-11-19 18:44:28'),(24,1,4,'2019-11-19 18:52:14'),(25,1,4,'2019-11-19 18:53:00'),(26,1,4,'2019-11-19 18:53:05'),(27,1,4,'2019-11-19 18:53:09'),(28,1,4,'2019-11-19 18:55:56'),(29,1,4,'2019-11-19 18:56:25'),(30,1,4,'2019-11-19 18:58:58'),(31,1,4,'2019-11-19 18:58:59'),(32,1,4,'2019-11-19 18:59:01'),(33,1,4,'2019-11-19 18:59:06'),(34,1,4,'2019-11-19 18:59:11'),(35,1,4,'2019-11-19 19:02:06'),(36,1,4,'2019-11-19 19:02:12'),(37,1,9,'2019-11-19 23:17:45'),(38,1,9,'2019-11-19 23:21:46'),(39,1,9,'2019-11-19 23:49:51');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `industry` varchar(45) NOT NULL,
  `website` varchar(45) NOT NULL,
  `joined_date` datetime NOT NULL DEFAULT current_timestamp(),
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'FinTech First LLC','Baltimore, MD','Technology','www.fintfirst.com','2019-11-19 12:41:51','',''),(2,'Gamers Paradise Inc.','Seattle, WA','IT','www.gparadiso.wa','2019-11-19 12:42:35','',''),(3,'Micro Systems LLC','Sunny Vale, CA','Software','www.microsystems.com','2019-11-20 00:00:00','support@microsystems.com','');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `joined_date` datetime NOT NULL DEFAULT current_timestamp(),
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Anna','Short','10 Richmond Avenue, FT, TX','718 912 1120','ashort87@gmail.com','2019-11-19 11:37:14',''),(2,'James','Buchanan','Elainworth St, Richmond, VA','612 912 9120','buchanan.james@hotmail.com','2019-11-19 12:10:01',''),(3,'Moore','Smith','Jacksonville Rd, Redwood, MA','312 651 9912','smithtmoore@hotmail.com','2019-11-19 12:18:10',''),(4,'Julian','Ottoman','213 Herring St, Palm Beach, CA','321 891 1231','jul.ottoman@outlook.com','2019-11-19 12:37:34','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacancy`
--

DROP TABLE IF EXISTS `vacancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacancy` (
  `vacancy_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` longtext NOT NULL,
  `company_id` int(11) NOT NULL,
  `date_posted` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`vacancy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacancy`
--

LOCK TABLES `vacancy` WRITE;
/*!40000 ALTER TABLE `vacancy` DISABLE KEYS */;
INSERT INTO `vacancy` VALUES (1,'Greetings','asda',1,'2019-11-19 14:13:52'),(2,'Greetings','asda',1,'2019-11-19 14:32:48'),(3,'Greetings','Best job ever!!!',1,'2019-11-19 14:33:01'),(4,'Greetings','asda',1,'2019-11-19 15:46:12'),(5,'Retail Coverage Merchandiser','At Acosta, we work with major consumer brands (CPG). Our Retail Coverage Merchandisers represent our customer and clients in retail locations where you shop. We execute product placement through modular integrity, stocking, building displays, selling and completing surveys and audits. We are a company of exceptional people who take pride in the clients and customers we represent, and no day is ever the same!\r\n\r\nAre you a self-starter with strong attention to detail? Do you work well in independent situations? Candidates with previous retail or sales experience, outgoing personality and the ability to build relationships have success with Acosta!\r\n\r\nAlong with competitive pay, Acosta offers a comprehensive benefits program, paid time off, and 401(k) match for both full and part-time employees!\r\n\r\nResponsibilities\r\n\r\nWe are seeking self-motivated individuals who can create solutions and can:\r\n\r\nâ¢ Work with technology collecting and reporting data from store visits with a company furnished tablet.\r\n\r\nâ¢ Maintain full distribution and display of products in assigned accounts.\r\n\r\nâ¢ Clean, stock, rotate and price merchandise, as appropriate.\r\n\r\nâ¢ Perform audits such as checking date codes and ensuring adherence to approved modular integrity.\r\n\r\nâ¢ Ability to follow store policies and procedures while being an expert for the clients you represent.\r\n\r\nâ¢ Consult with management in a timely manner, meet objectives and goals as assigned, and report store level observations related to client product and Customer needs.\r\n\r\nâ¢ Be the advocate for the client through sales opportunities and shelf work through building relationships through stores.\r\n\r\nâ¢ Receive mailings including Client signage, coupons, etc. to be transported and distributed in your territory.\r\n\r\nâ¢ Assess and prioritize work-loads based on store assignment and client needs.\r\n\r\nâ¢ Represent Acosta in a professional manner and follow company dress code policy.\r\n\r\nâ¢ Assist supervisors on retail initiatives as assigned.\r\n\r\nâ¢ Other duties as assigned by your manager.\r\n\r\nQualifications\r\n\r\nQualifications:\r\n\r\nâ¢ Retail or Sales Experience preferred\r\n\r\nâ¢ High School Diploma/GED\r\n\r\nâ¢ Experience utilizing technology (i.e. Smart Phones and handheld devices)\r\n\r\nâ¢ Comfortable with technology, ability to interpret instructions to build displays\r\n\r\nâ¢ Ability to access the internet, operate a computer, and be familiar with Microsoft Office â Outlook, Word and Excel\r\n\r\nâ¢ Must be able to lift up to 60 pounds, stand and walk for long periods of time, and lift and bend to low/high levels in order to reach product.\r\n\r\nâ¢ Must have a valid driverâs license; and have reliable transportation with the ability to drive a car for an extended period of time.\r\n\r\nâ¢ Strong interpersonal skills with the ability to clearly communicate verbally and written with others, read, comprehend, and execute documented instructions.\r\n\r\nâ¢ Must be willing and able to work in extremely cold conditions (i.e. refrigerated and freezer sections of retail stores).\r\n\r\nâ¢ Must be flexible and willing to participate in ongoing trainings to accommodate the changing needs of the business to ensure your success.\r\n\r\nâ¢ Must work independently within a team environment, use time efficiently, and demonstrate initiative to accomplish assigned tasks.\r\n\r\nâ¢ Ability to travel overnight occasionally.\r\n\r\nâ¢ Must follow Company policies.\r\n\r\nâ¢ Maintain confidentiality of client and Company information.\r\n\r\nAcosta Sales & Marketing is an Equal Opportunity Employer\r\n\r\nBy submitting your application you agree with and accept the Acosta Privacy Statement and Terms of Conditions.\r\n\r\nUS:\r\n\r\nCanada:\r\n\r\nJob ID 2019-166371\r\n\r\nWork City Fairfield\r\n\r\nPCN 221223\r\n\r\nPosition Type Regular Part-Time\r\n\r\nWork Zip 52556\r\n\r\nStarting average hours per week 25-30\r\n\r\nCategory Field Jobs',1,'2019-11-19 22:47:00'),(6,'Retail Coverage Supervisor','At Acosta, we work with major consumer brands (CPG). Our Retail Coverage Merchandisers represent our customer and clients in retail locations where you shop. We execute product placement through modular integrity, stocking, building displays, selling and completing surveys and audits. We are a company of exceptional people who take pride in the clients and customers we represent, and no day is ever the same!\r\n\r\nAre you a self-starter with strong attention to detail? Do you work well in independent situations? Candidates with previous retail or sales experience, outgoing personality and the ability to build relationships have success with Acosta!\r\n\r\nAlong with competitive pay, Acosta offers a comprehensive benefits program, paid time off, and 401(k) match for both full and part-time employees!',1,'2019-11-19 22:53:54'),(7,'Modulo Oblongata Medicare Specialist','At Acosta, we work with major consumer brands (CPG). Our Retail Coverage Merchandisers represent our customer and clients in retail locations where you shop. We execute product placement through modular integrity, stocking, building displays, selling and completing surveys and audits. We are a company of exceptional people who take pride in the clients and customers we represent, and no day is ever the same!\r\n\r\nAre you a self-starter with strong attention to detail? Do you work well in independent situations? Candidates with previous retail or sales experience, outgoing personality and the ability to build relationships have success with Acosta!\r\n\r\nAlong with competitive pay, Acosta offers a comprehensive benefits program, paid time off, and 401(k) match for both full and part-time employees!',1,'2019-11-19 23:10:43'),(8,'Speech-Language Pathologist','Our therapists believe in bringing quality rehab services to communities of all sizes through innovative care delivered with compassion and empathy. We are dedicated to improving the lives of our patients and making an impact in the small communities we serve.\r<br/>\r<br/>As a therapist-owned and managed company, we understand the day-to-day business of patient care and the importance of mentorship, interdisciplinary teamwork and support. We encourage our therapists to grow as individuals and as teams, and we help them to fulfill rewarding educational and professional goals. As a company, we believe in reasonable productivity standards. These values have been fundamental to our success since 1983.\r<br/>\r<br/>If we sound like a company youâd be proud to work for, consider joining us as a part-time or full-time speech-language pathologist providing speech therapy services in Fairfield, Iowa.\r<br/>\r<br/>Our Speech-Language Pathologists:\r<br/>â¢ Assess and treat patients\r<br/>â¢ Complete documentation\r<br/>â¢ Plan, market and develop new programs\r<br/>â¢ Communicate with patients, patientsâ families and physicians and staff\r<br/>â¢ Present in-services to fellow staff therapists\r<br/>â¢ Assist in the general operation of the department\r<br/>\r<br/>Speech-Language Pathologist Requirements:\r<br/>â¢ Must be a graduate of a certified therapy program\r<br/>â¢ Must possess or be eligible for state licensure\r<br/>â¢ Pediatric experience is preferred\r<br/>\r<br/>RehabVisions is an EEO and FMLA compliant employer. We have a competitive benefits offering for employees working at least 30 hours per week',1,'2019-11-19 23:15:53'),(9,'Speech-Language Pathologist','Our therapists believe in bringing quality rehab services to communities of all sizes through innovative care delivered with compassion and empathy. We are dedicated to improving the lives of our patients and making an impact in the small communities we serve.\r<br/>\r<br/>As a therapist-owned and managed company, we understand the day-to-day business of patient care and the importance of mentorship, interdisciplinary teamwork and support. We encourage our therapists to grow as individuals and as teams, and we help them to fulfill rewarding educational and professional goals. As a company, we believe in reasonable productivity standards. These values have been fundamental to our success since 1983.\r<br/>\r<br/>If we sound like a company youâd be proud to work for, consider joining us as a part-time or full-time speech-language pathologist providing speech therapy services in Fairfield, Iowa.\r<br/>\r<br/>Our Speech-Language Pathologists:\r<br/>â¢ Assess and treat patients\r<br/>â¢ Complete documentation\r<br/>â¢ Plan, market and develop new programs\r<br/>â¢ Communicate with patients, patientsâ families and physicians and staff\r<br/>â¢ Present in-services to fellow staff therapists\r<br/>â¢ Assist in the general operation of the department\r<br/>\r<br/>Speech-Language Pathologist Requirements:\r<br/>â¢ Must be a graduate of a certified therapy program\r<br/>â¢ Must possess or be eligible for state licensure\r<br/>â¢ Pediatric experience is preferred\r<br/>\r<br/>RehabVisions is an EEO and FMLA compliant employer. We have a competitive benefits offering for employees working at least 30 hours per week',1,'2019-11-19 23:17:23');
/*!40000 ALTER TABLE `vacancy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-20 11:28:48
