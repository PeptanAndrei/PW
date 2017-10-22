-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: movie_store
-- ------------------------------------------------------
-- Server version	5.7.16

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
  `name` varchar(45) NOT NULL,
  `year` int(11) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `actors` varchar(200) DEFAULT NULL,
  `age_restriction` int(11) DEFAULT NULL,
  `review` longtext,
  `category` varchar(45) DEFAULT NULL,
  `image` varchar(800) DEFAULT NULL,
  `video` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Guardian of Galaxy',2015,'James Hake','rita ore, duane jonson',15,'After stealing a mysterious orb in the far reaches of outer space, Peter Quill from Earth, is now the main target of a manhunt led by the villain known as Ronan the Accuser. To help fight Ronan and his team and save the galaxy from his power, Quill creates a team of space heroes known as the \"Guardians of the Galaxy\" to save the world. Written by James Hake','Action','https://pbs.twimg.com/media/BtfyWiXCAAA7vNi.jpg','hH9TRy8gGyE'),(2,'HULK',12,'','1',1,'1','1','http://cdn.wallpapersafari.com/33/87/hFaPlW.jpg','1'),(3,'iron man',1,'','1',1,'1','1','http://cdn.playbuzz.com/cdn/869ac0ff-e203-4e23-9351-4d8c833db083/cc005806-39c2-44ce-b36d-dc04d5042150.jpg','1'),(4,'x men',1,'','1',1,'1','1','http://images.techtimes.com/data/images/full/236034/x-men.jpeg','1'),(5,'Spiderman',2160,'James Jonson','Peter Parker, Brok, jon',12,'A young Peter Parker/Spider-Man, who made his sensational debut in Captain America: Civil War, begins to navigate his newfound identity as the web-slinging superhero in Spider-Man: Homecoming. Thrilled by his experience with the Avengers, Peter returns home, where he lives with his Aunt May, under the watchful eye of his new mentor Tony Stark, Peter tries to fall back into his normal daily routine - distracted by thoughts of proving himself to be more than just your freindly neighborhood Spider-Man - but when the Vulture emerges as a new villain, everything that Peter holds most important will be threatened. Written by Benett Sullivan','Action','http://wallpapercave.com/wp/BF1PfVs.jpg','zDunO0wESoI'),(6,'Capitan America',2017,'Roger Phelps','Bradly cooper, indiana jones, cameron diaz',16,'M Marvel\'s \"Captain America: Civil War\" finds Steve Rogers leading the newly formed team of Avengers in their continued efforts to safeguard humanity. But after another incident involving the Avengers results in collateral damage, political pressure mounts to install a system of accountability, headed by a governing body to oversee and direct the team. The new status quo fractures the Avengers, resulting in two camps-one led by Steve Rogers ','Drama-Action','http://images.fashionnstyle.com/data/images/full/153239/captain-america.jpg?w=600','dKrVegVI0Us'),(7,'game of thrones',30,'dasdasd','dasd,das dasd',21,'dasdasdafasd','dasdasfasffasd','https://upload.wikimedia.org/wikipedia/en/7/78/Game_of_Thrones_(season_6_soundtrack)_cover.jpg','https://youtu.be/hQMtZL7y18U'),(8,'transformers 4',121,'dads','dasdasdas',212,'dasdasd','asdasdas','http://nsm08.casimages.com/img/2014/07/18/14071812362217742612394456.jpg','dsds'),(9,'taest',2121,'ddsss','csvsdscsd',12,'cvxvxvdxv','csdcsdcs','https://s-media-cache-ak0.pinimg.com/originals/53/3f/9f/533f9fc2f24fee526188e72822814121.jpg','csdcsdcs');
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

-- Dump completed on 2016-12-21 23:24:29
