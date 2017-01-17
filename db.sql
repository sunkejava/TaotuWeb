/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.34 : Database - db_taotu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_taotu` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_taotu`;

/*Table structure for table `db_taotu` */

DROP TABLE IF EXISTS `db_taotu`;

CREATE TABLE `db_taotu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增列',
  `name` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '套图名称',
  `url` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '套图地址',
  `imgurl` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '封面图片地址',
  `tagName` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '标签',
  `typeName` varchar(200) CHARACTER SET utf8 NOT NULL COMMENT '图片来源',
  `addTime` varchar(100) DEFAULT 'CURRENT_TIMESTAMP' COMMENT '添加图片时间',
  `crawlTime` varchar(100) DEFAULT 'CURRENT_TIMESTAMP' COMMENT '本库添加时间',
  PRIMARY KEY (`id`),
  KEY `index_name` (`name`),
  KEY `index_url` (`url`),
  KEY `index_imgurl` (`imgurl`),
  KEY `index_tagName` (`tagName`),
  KEY `index_typeName` (`typeName`)
) ENGINE=InnoDB AUTO_INCREMENT=27465 DEFAULT CHARSET=latin1;

/*Table structure for table `db_taotudetail` */

DROP TABLE IF EXISTS `db_taotudetail`;

CREATE TABLE `db_taotudetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '套图明细ID',
  `url` varchar(300) NOT NULL COMMENT '图片地址',
  `purl` varchar(200) NOT NULL COMMENT '关联表头',
  `context` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '简介',
  `pid` int(11) NOT NULL COMMENT '关联表头',
  PRIMARY KEY (`id`),
  KEY `index_url` (`url`),
  KEY `index_purl` (`purl`),
  KEY `index_context` (`context`(255)),
  KEY `pid` (`pid`),
  CONSTRAINT `db_taotudetail_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `db_taotu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1527608 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
