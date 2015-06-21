-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema yimixican
--

CREATE DATABASE IF NOT EXISTS yimixican;
USE yimixican;

--
-- Definition of table `daily_card`
--

DROP TABLE IF EXISTS `daily_card`;
CREATE TABLE `daily_card` (
  `dailyid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `habitid` int(10) unsigned NOT NULL,
  `finishtime` datetime NOT NULL,
  PRIMARY KEY (`dailyid`),
  KEY `FK_daily_card_1` (`uid`),
  KEY `FK_daily_card_2` (`habitid`),
  CONSTRAINT `FK_daily_card_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  CONSTRAINT `FK_daily_card_2` FOREIGN KEY (`habitid`) REFERENCES `habits` (`habitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `daily_card`
--

/*!40000 ALTER TABLE `daily_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_card` ENABLE KEYS */;


--
-- Definition of table `habits`
--

DROP TABLE IF EXISTS `habits`;
CREATE TABLE `habits` (
  `habitid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `class` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `fromuser` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`habitid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `habits`
--

/*!40000 ALTER TABLE `habits` DISABLE KEYS */;
INSERT INTO `habits` (`habitid`,`class`,`name`,`fromuser`) VALUES 
 (1,1,'按时吃饭',0),
 (2,1,'多喝水',0),
 (3,1,'不吃零食',0),
 (4,1,'拒绝宵夜',0),
 (5,1,'不喝碳酸饮料',0),
 (6,1,'每天吃水果',0),
 (7,1,'早晨空腹喝一杯蜂蜜水',0),
 (8,1,'不吃油炸食物',0),
 (9,2,'早睡',0),
 (10,2,'早起',0),
 (11,2,'睡午觉',0),
 (12,2,'睡前泡脚',0),
 (13,2,'记日记',0),
 (14,2,'每天玩手机不超过一小时',0),
 (16,3,'仰卧起坐',0),
 (17,3,'平板支撑',0),
 (18,3,'球类运动',0),
 (19,3,'每天运动一小时',0),
 (20,3,'跑步',0),
 (21,3,'爬十层楼梯',0),
 (22,3,'饭后散步半小时',0),
 (23,3,'瘦身运动',0),
 (24,3,'练腹肌',0),
 (25,3,'游泳',0),
 (26,1,'多吃蔬菜少吃肉',0);
/*!40000 ALTER TABLE `habits` ENABLE KEYS */;


--
-- Definition of table `tips`
--

DROP TABLE IF EXISTS `tips`;
CREATE TABLE `tips` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(10) unsigned NOT NULL,
  `txt` text NOT NULL,
  `titile` varchar(45) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tips`
--

/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;


--
-- Definition of table `user_card`
--

DROP TABLE IF EXISTS `user_card`;
CREATE TABLE `user_card` (
  `habitid` int(10) unsigned NOT NULL DEFAULT '0',
  `uid` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`habitid`,`uid`),
  KEY `FK_user_card_1` (`uid`),
  CONSTRAINT `FK_user_card_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  CONSTRAINT `FK_user_card_2` FOREIGN KEY (`habitid`) REFERENCES `habits` (`habitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_card`
--

/*!40000 ALTER TABLE `user_card` DISABLE KEYS */;
INSERT INTO `user_card` (`habitid`,`uid`) VALUES 
 (6,1),
 (8,1),
 (13,1),
 (26,1);
/*!40000 ALTER TABLE `user_card` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `regtime` datetime DEFAULT NULL,
  `gender` int(10) unsigned DEFAULT NULL,
  `age` int(10) unsigned DEFAULT NULL,
  `remind` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `declaration` varchar(100) DEFAULT NULL,
  `remindtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `repassword` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`uid`,`username`,`regtime`,`gender`,`age`,`remind`,`password`,`height`,`weight`,`declaration`,`remindtime`,`repassword`) VALUES 
 (1,'aa','2015-09-01 01:00:00',NULL,NULL,NULL,'1',NULL,NULL,NULL,'2015-06-09 16:17:00','1'),
 (2,'s',NULL,0,0,NULL,'1',0,0,NULL,'2015-06-21 07:30:08','1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
