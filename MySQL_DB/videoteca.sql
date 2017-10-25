-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: localhost    Database: videoteca
-- ------------------------------------------------------
-- Server version	5.7.19

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idmovie_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Wonder Woman',2017,'Patty Jenkins','Action','https://multimedia.bbycastatic.ca/multimedia/products/1500x1500/m22/m2224/m2224814_2.jpg','VSB4wGIdDwo',150),(2,'Guardians of the Galaxy: Vol. 2',2017,'James Gunn','Adventure,Action','https://www.zoom.co.uk/assets/images/site/product/buy0274801_2.jpg?width=1200','2cv2ueYnKjg',120),(3,'Doctor Strange',2017,'Scott Derrickson','Action,Sci-Fi','http://images.static-bluray.com/news/upload/7838_tn.jpg','HSzx-zryEgM',160),(4,'Ant-Man',2015,'Peyton Reed','Action','https://static.fnac-static.com/multimedia/Images/FR/NR/87/fd/6f/7339399/1507-1/tsp20151216161314/Ant-Man-Blu-ray.jpg','pWdKf3MneyI',99),(5,'The Dark Knight',2008,'Christopher Nolan','Action, Crime, Drama ','https://images-na.ssl-images-amazon.com/images/I/71YmAkoEUhL._SL1367_.jpg','EXeTwQWrcwY',99),(6,'Inception',2010,'Christopher Nolan','Action, Adventure, Sci-Fi ','https://s2.thcdn.com/productimg/0/600/600/73/10629573-1352466109-845730.jpg','YoHD9XEInc0',90),(7,'Fight Club',1999,'David Fincher','Drama','https://images-na.ssl-images-amazon.com/images/I/91sOMQmAGzL._SY445_.jpg','SUXWAEX2jlg',100),(8,'Sherlock Holmes',2009,'Guy Ritchie','Action, Adventure, Crime ','http://www.mubis.es/media/releases/1453/95982/sherlock-holmes-blu-ray-l_cover.jpg','Egcx63-FfTE',110),(9,'300 Spartans',2006,'Zack Snyder','Action, Fantasy ','https://multimedia.bbycastatic.ca/multimedia/products/500x500/m22/m2211/m2211971.jpg','4Prc1UfuokY',80),(10,'Avatar',2009,'James Cameron','Action, Adventure, Fantasy','http://www.gadgethelpline.com/wp-content/uploads/2013/01/Avatar-Blu-ray-disc-thumb-320x447.jpg','aVdO-cx-McA',99);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-24 19:26:34
