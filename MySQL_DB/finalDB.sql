-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: videoteca
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `idmovie` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  PRIMARY KEY (`idmovie`),
  UNIQUE KEY `idMovie_UNIQUE` (`idmovie`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Wonder Woman',2017,'Federick Jon','Action','http://cineblog01hd.tv/3d/BD/wonder_woman_4k.png','VSB4wGIdDwo',110),(2,'Doctor Strange',2016,'Scott Derrickson','Action, Adventure, Fantasy','http://cineblog01hd.tv/3d/BD/doctor_strange_3d.png','HSzx-zryEgM',130),(6,'Deadpool',2016,'Tim Miller','Action, Adventure, Comedy ','http://cineblog01hd.tv/3d/BD/deadpool.png','gtTfd6tISfw',150),(7,'Logan',2017,'James Mangold','Action, Drama, Sci-Fi ','http://cineblog01hd.tv/3d/BD/logan__the_wolverine_4k-2.png','RH3OxVFvTeg',120),(8,'Geostorm',2017,'Dean Devlin','Action, Sci-Fi, Thriller ','http://cineblog01hd.tv/3d/BD/geostorm.png','EuOlYPSEzSc',160),(9,'Civi War',2016,'Anthony Russo, Joe Russo','Action, Adventure, Sci-Fi ','http://cineblog01hd.tv/3d/BD/captain_america_civil_war.png','dKrVegVI0Us',110),(10,'Warcraft',2016,'Duncan Jones','Action, Adventure, Fantasy ','http://cineblog01hd.tv/3d/BD/warcraft__linizio_3d.png','RhFMIRuHAL4',100),(11,'IT',2017,'Andy Muschietti','Drama, Horror, Thriller ','http://cineblog01hd.tv/3d/BD/it.png','hAUTdjf9rko',160),(12,'Valerian',2017,'Luc Besson','Action, Adventure, Fantasy ','http://cineblog01hd.tv/3d/BD/valerian_e_la_citt_dei_mille_pianeti.png','cPeqNTqZNN0',90),(13,'Thor: Ragnarok',2017,'Taika Waititi','Action, Adventure, Comedy ','http://cineblog01hd.tv/3d/BD/thor_ragnarok.png','ue80QwXMRHg',160),(14,'Sherlock Holmes',2011,'Guy Ritchie','Action, Adventure, Crime ','http://cineblog01hd.tv/3d/BD/sherlock_holmes_gioco_di_ombre.png','DpxtbtnC1u8',125);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordermovie`
--

DROP TABLE IF EXISTS `ordermovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordermovie` (
  `idorder` int(11) DEFAULT NULL,
  `idmovie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordermovie`
--

LOCK TABLES `ordermovie` WRITE;
/*!40000 ALTER TABLE `ordermovie` DISABLE KEYS */;
INSERT INTO `ordermovie` VALUES (4,11),(4,2),(5,2),(5,7),(5,12),(5,13),(6,1);
/*!40000 ALTER TABLE `ordermovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingorder`
--

DROP TABLE IF EXISTS `shoppingorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingorder` (
  `idorder` int(11) NOT NULL AUTO_INCREMENT,
  `totalprice` int(11) DEFAULT '0',
  `iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idorder`),
  UNIQUE KEY `id_UNIQUE` (`idorder`),
  KEY `iduser_idx` (`iduser`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingorder`
--

LOCK TABLES `shoppingorder` WRITE;
/*!40000 ALTER TABLE `shoppingorder` DISABLE KEYS */;
INSERT INTO `shoppingorder` VALUES (4,290,7),(5,500,6),(6,110,6);
/*!40000 ALTER TABLE `shoppingorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `id_UNIQUE` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'peledani','peledani'),(7,'peptanandrei','pep'),(8,'pelecristi','cristi'),(9,'admin','admin');
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

-- Dump completed on 2017-11-15 15:41:50
