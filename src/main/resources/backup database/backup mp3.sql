-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: mp3
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.22-MariaDB

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
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `Id` int(6) NOT NULL AUTO_INCREMENT,
  `artistName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (2,'Rednex'),(3,'Snollebollekes'),(4,'Snollebollekes'),(5,'Omdat Het Kan Soundsystem'),(7,'Monty Python'),(8,'Vieze Asbak'),(9,'André van Duin'),(11,'Vengaboys'),(12,'Redbone'),(13,'Omdat Het Kan Soundsystem'),(14,'DJ ToXiq'),(15,'DJ ToXiq'),(16,'bobby mcferrin'),(18,'Survivor'),(19,'Ray Charles'),(20,'Lil Nas X'),(21,'Kabouter Plop'),(22,'3 Doors Down'),(23,'Michel Sardou'),(24,'Parla & Pardoux'),(25,'Rick Astley'),(26,'Metallica'),(27,'Ricardo Milos'),(28,'Omdat Het Kan Soundsystem'),(29,'Snollebollekes'),(30,'Snollebollekes'),(31,'The tokens'),(32,'The Cranberries'),(33,'David Guetta ft Sia'),(34,'The Spice girls'),(35,'The Village People'),(36,'Smash Mouth'),(37,'Coolio'),(38,'Elton John'),(39,'Eurythmics'),(40,'Don Omar ft. Lucenzo'),(41,'Black Eyed Peas'),(44,'Avicii'),(45,'Wiz Khalifa ft. Charlie Puth'),(46,'Snollebollekes'),(47,'Creedence Clearwater Revival'),(48,'Creedence Clearwater Revival'),(49,'Creedence Clearwater Revival'),(50,'Witch Doctor');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `trackId` int(6) NOT NULL AUTO_INCREMENT,
  `trackName` varchar(255) DEFAULT NULL,
  `trackURL` varchar(255) DEFAULT NULL,
  `imgURL` longtext DEFAULT NULL,
  `artistId` int(6) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  PRIMARY KEY (`trackId`),
  KEY `artistId` (`artistId`),
  CONSTRAINT `track_ibfk_1` FOREIGN KEY (`artistId`) REFERENCES `artist` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (2,'Cotton Eye Joe','src/main/resources/cotton Eye Joe.mp3','https://media.s-bol.com/3o0QMz14pY9/550x550.jpg',2,200.136),(3,'Snollebolleke','src/main/resources/Snollebollekes - Snollebolleke.mp3','https://www.berkmusic.nl/shop/image/cache/catalog/Covers/snollebollekes - snollebolleke-500x500.jpg',3,190.74),(4,'Links Rechts','src/main/resources/LinksRechts.mp3','https://i.scdn.co/image/ab67616d0000b273d2a7ecd9375ac2781a1168a9',4,159.47755102),(5,'Alles Is Shtamp','src/main/resources/Alles Is Shtamp.mp3','https://cdns-images.dzcdn.net/images/cover/324aa8db267a185e6ad5ca19a488f707/500x500.jpg',5,141.144),(7,'Always look on the bright side','src/main/resources/always-look-on-the-bright-side-of-life.mp3','https://c.saavncdn.com/880/Always-Look-on-the-Bright-Side-of-Life-English-2012-20171101091126-500x500.jpg',7,215.952),(8,'Ameno techno rave remix','src/main/resources/ameno Techno.mp3','https://is2-ssl.mzstatic.com/image/thumb/Music113/v4/99/19/55/9919557b-4581-7c94-7d0d-841a2a07b7c2/artwork.jpg/400x400cc.jpg',8,147.909),(9,'Waarom zijn de bananen krom?','src/main/resources/Andre Van Duin - Waarom Zijn De Bananen Krom.mp3','https://i.ytimg.com/vi/hbU0OEa_OlQ/hqdefault.jpg',9,159.048),(11,'Boom Boom Boom Boom!','src/main/resources/Boom Boom Boom.mp3','https://upload.wikimedia.org/wikipedia/en/f/f8/BoomBoomBoomBoom.jpg',11,203.448),(12,'Come and get your love','src/main/resources/come and get your love.mp3','https://images.hungama.com/c/1/1c7/f51/49204636/49204636_300x300.jpg',12,207.504),(13,'De Shtampioenen','src/main/resources/De Shtampioenen.mp3','https://i.ytimg.com/vi/JFQo2K2rq6U/maxresdefault.jpg',13,152.448),(14,'He\'s a Pirate (Hardstyle Remix)','src/main/resources/He\'s a Pirate (DJ ToXiq Hardstyle Remix).mp3','https://i.ytimg.com/vi/F0W53N4d6bg/maxresdefault.jpg',14,275.472),(15,'Pirate (Extended Edit)','src/main/resources/DJ ToXiq - Pirate (Extended Edit).mp3','https://i1.sndcdn.com/artworks-000579448394-dmfxe9-t500x500.jpg',14,301.176),(16,'Don\'t Worry Be Happy','src/main/resources/Don\'t Worry Be Happy.mp3','https://upload.wikimedia.org/wikipedia/en/9/98/DontWorryBe.jpg',16,231.696),(18,'Eye of the Tiger','src/main/resources/Eye of the Tiger.mp3','https://www.noviscore.com/sleeve255-eye-of-the-tiger-survivor.jpg',18,243.488),(19,'Hit the road Jack!','src/main/resources/Hit the road Jack!.mp3','https://media.hitparade.ch/cover/big/ray_charles-hit_the_road_jack_s.jpg',19,139.344),(20,'Industry baby','src/main/resources/industry baby.mp3','https://i2.wp.com/www.dansendeberen.be/wp-content/uploads/Lil-Nas-X-INDUSTRY-BABY.jpeg?fit=2048,2048',20,212.453877551),(21,'Kabouterdans','src/main/resources/Kabouterdans.mp3','https://lastfm.freetls.fastly.net/i/u/627bcc603e7eba0c6fa4f84b3cd671b4.png',21,234.772),(22,'Kryptonite','src/main/resources/Kryptonite.mp3','https://fringster.com/content/images/19668.jpg',22,233.874285714),(23,'Les lacs du Connemara','src/main/resources/Les lacs du Connemara.mp3','https://i.ytimg.com/vi/bpEmjxobvbY/maxresdefault.jpg',23,328.2),(24,'Liberté','src/main/resources/Liberté.mp3','https://fringster.com/content/images/49218.jpg',24,145.344),(25,'Never Gonna Give You Up','src/main/resources/Never Gonna Give You Up.mp3','https://upload.wikimedia.org/wikipedia/en/3/34/RickAstleyNeverGonnaGiveYouUp7InchSingleCover.jpg',25,212.088),(26,'Nothing Else Matters','src/main/resources/Nothing Else Matters.mp3','https://www.noviscore.com/sleeve255-nothing-else-matters-metallica.jpg',26,385.776),(27,'Classical','src/main/resources/Offenbach - Can Can Music.mp3','https://pbs.twimg.com/profile_images/1324357023602036736/UpKepdqi_400x400.jpg',27,131.904),(28,'Siren Shtamp','src/main/resources/Siren Shtamp.mp3','https://images-na.ssl-images-amazon.com/images/I/41sSdHPoYBL._SR600,315_PIWhiteStrip,BottomLeft,0,35_SCLZZZZZZZ_FMpng_BG255,255,255.jpg',28,246.312),(29,'Springen Nondeju (2nd Bass Remix)','src/main/resources/Snollebollekes - Springen Nondeju (2nd Bass Remix).mp3','https://media.hitparade.ch/cover/big/snollebollekes-springen_nondeju_s.jpg',29,153.408),(30,'Daar gaat ze!','src/main/resources/Snollebollekes - Daar gaat ze.mp3','https://media.hitparade.ch/cover/big/snollebollekes-daar_gaat_ze_s.jpg',30,172.224),(31,'The Lion Sleeps Tonight','src/main/resources/The Lion Sleeps Tonight.mp3','https://media.s-bol.com/ovmWy4BKXzQz/vgjWp1V/550x550.jpg',31,160.194),(32,'Zombie','src/main/resources/The-Cranberries-Zombie.mp3','https://upload.wikimedia.org/wikipedia/en/1/16/The_Cranberries_-_Zombie.jpg',32,306.573061224),(33,'Titanium (Future Rave Remix)','src/main/resources/Titanium (Future Rave Remix).mp3','https://i.scdn.co/image/ab67616d0000b2730158075a94563b7e08e42f11',33,216.552),(34,'Wannebe','src/main/resources/Spice Girls - Wannabe ( Lyrics ).mp3','https://i1.sndcdn.com/artworks-000219487416-9f748a-t500x500.jpg',34,180.072),(35,'YMCA','src/main/resources/ymca.mp3','https://i.ytimg.com/vi/CS9OO0S5w2k/hqdefault.jpg',35,241.176),(36,'All Star','src/main/resources/Smash Mouth - All Star with Lyrics.mp3','https://m.media-amazon.com/images/I/51LmALHpELL._SY355_.jpg',36,200.952),(37,'Gangsta\'s Paradise','src/main/resources/Coolio - Gangsters Paradise (Official Lyrics On Screen).mp3','https://upload.wikimedia.org/wikipedia/en/c/c6/Gangsta\'s_paradise.jpg',37,241.32),(38,'I\'m Still Standing','src/main/resources/Elton John - I\'m Still Standing.mp3','https://photos.bandsintown.com/large/9572199.jpeg',38,182.016),(39,'Sweet dreams','src/main/resources/Eurythmics - Sweet dreams ( Lyrics 2020).mp3','https://m.media-amazon.com/images/M/MV5BZDBlNGE1ZGEtOGY3OS00ZDBjLTkzYjQtYTg0MDQ4Nzc4ZDA3L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNDE4OTY5NzI@._V1_FMjpg_UX1000_.jpg',39,213.696),(40,'Danza Kuduro (Extended Remix)','src/main/resources/Danza Kuduro (Official Extended Remix).mp3','https://i.ytimg.com/vi/us3tczsrKQc/hqdefault.jpg',40,359.904),(41,'I Gotta Feeling','src/main/resources/Black Eyed Peas - I Gotta Feeling (Audio).mp3','https://i.ytimg.com/vi/CwdrtwZiQ9E/hqdefault.jpg',41,289.08),(44,'Wake Me Up','src/main/resources/Avicii - Wake Me Up (Lyric Video).mp3','https://i1.sndcdn.com/artworks-zmVOvMMUim2rylwS-WNzgPw-t500x500.jpg',44,251.424),(45,'See You Again','src/main/resources/Wiz Khalifa - See You Again.mp3','https://i1.sndcdn.com/artworks-qDyKHhFy16KAuFUf-AMyHaw-t500x500.jpg',45,237.408),(46,'Bam Bam (Bam)','src/main/resources/bam bam bam.mp3','https://media.s-bol.com/mLnGvo5ZBG3/550x550.jpg',46,173.04),(47,'Have You Ever Seen The Rain','src/main/resources/Creedence Clearwater Revival- Have You Ever Seen The Rain.mp3','https://media.hitparade.ch/cover/big/creedence_clearwater_revival-have_you_ever_seen_the_rain_s_6.jpg',47,161.232),(48,'Bad Moon Rising','src/main/resources/Creedence Clearwater Revival- Bad Moon Rising.mp3','https://media.s-bol.com/J6orwN7Kz71v/1rNA973/1200x1200.jpg',48,141.84),(49,'Fortunate Son','src/main/resources/Creedence Clearwater Revival- Fortunate Son.mp3','https://media.hitparade.ch/cover/big/creedence_clearwater_revival-fortunate_son_s.jpg',49,141.744),(50,'Cartoons','src/main/resources/Witch Doctor - Cartoons.mp3','https://media.s-bol.com/gvMmD0qk626/550x550.jpg',50,187.344);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mp3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-27 20:51:30
