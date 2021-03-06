-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema system
--

CREATE DATABASE IF NOT EXISTS system;
USE system;

--
-- Definition of table `b`
--

DROP TABLE IF EXISTS `b`;
CREATE TABLE `b` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `b`
--

/*!40000 ALTER TABLE `b` DISABLE KEYS */;
/*!40000 ALTER TABLE `b` ENABLE KEYS */;


--
-- Definition of table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `client_name` varchar(50) NOT NULL,
  `cardboard_sort` varchar(50) NOT NULL,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `cardboard_price` float NOT NULL,
  `net_price` double NOT NULL,
  `payed` double NOT NULL,
  `remainning` double NOT NULL,
  PRIMARY KEY  (`client_name`,`cardboard_sort`,`day`,`month`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tel` varchar(45) default NULL,
  PRIMARY KEY  (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`username`,`password`,`tel`) VALUES 
 ('احمد','11112222','01223363401'),
 ('شريف على','999999777777','01226840517'),
 ('محمد على','999999777777','01288432315'),
 ('محمود يحيي','999999777777','01283058082');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `print`
--

DROP TABLE IF EXISTS `print`;
CREATE TABLE `print` (
  `number` double NOT NULL,
  `day` int(20) NOT NULL,
  `month` int(20) NOT NULL,
  `year` int(20) NOT NULL,
  `color_number` int(50) default NULL,
  `total_price` double default '0',
  `payed` double default '0',
  `charge` double default '0',
  PRIMARY KEY  (`number`,`day`,`month`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `print`
--

/*!40000 ALTER TABLE `print` DISABLE KEYS */;
INSERT INTO `print` (`number`,`day`,`month`,`year`,`color_number`,`total_price`,`payed`,`charge`) VALUES 
 (20,3,2,2015,5,17.5,10,7.5),
 (5000,3,2,2015,5,17.5,10,7.5),
 (10000,3,2,2015,100,350,50,300);
/*!40000 ALTER TABLE `print` ENABLE KEYS */;


--
-- Definition of table `supplies`
--

DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies` (
  `kind` varchar(50) NOT NULL,
  `day` int(20) NOT NULL,
  `month` int(20) NOT NULL,
  `year` int(20) NOT NULL,
  `weight` double NOT NULL,
  `total_price` double default '0',
  `payed` double default '0',
  `charge` double default '0',
  PRIMARY KEY  USING BTREE (`kind`,`day`,`month`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplies`
--

/*!40000 ALTER TABLE `supplies` DISABLE KEYS */;
INSERT INTO `supplies` (`kind`,`day`,`month`,`year`,`weight`,`total_price`,`payed`,`charge`) VALUES 
 ('براكس',2,1,2015,10,5000,2000,3000),
 ('سليكات',1,2,2015,10,1111,20,1091),
 ('نشا',1,2,2015,10,1111,20,1091);
/*!40000 ALTER TABLE `supplies` ENABLE KEYS */;


--
-- Definition of table `workers`
--

DROP TABLE IF EXISTS `workers`;
CREATE TABLE `workers` (
  `name` varchar(50) NOT NULL,
  `month` int(11) NOT NULL,
  `week` int(11) NOT NULL,
  `day_salary` double NOT NULL,
  `day_work` double NOT NULL,
  `week_salary` double NOT NULL,
  `payed` double default NULL,
  `charge` double default NULL,
  PRIMARY KEY  USING BTREE (`month`,`week`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `workers`
--

/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` (`name`,`month`,`week`,`day_salary`,`day_work`,`week_salary`,`payed`,`charge`) VALUES 
 ('estrdyug',1,2,254,3,1778,1,761),
 ('محمد',1,2,100,5,700,400,100),
 ('awszedrxgfcthgyv',4,2,300,3,2100,200,700);
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
