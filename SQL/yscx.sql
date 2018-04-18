/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.17-log : Database - yscx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yscx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yscx`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `parentId` int(10) NOT NULL COMMENT '父级分类的id',
  `level` int(10) DEFAULT NULL COMMENT '1一级分类，2二级分类，3三级分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自动编号',
  `userId` int(10) NOT NULL,
  `loginName` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cost` float(10,2) NOT NULL,
  `status` int(1) NOT NULL COMMENT '1待审核，2审核通过，3配货中，4卖家已发货，5已收货',
  `payType` int(1) NOT NULL DEFAULT '1' COMMENT '支付方式，1支付宝，2微信，3银联，默认支付宝',
  `serialNumber` varchar(64) NOT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自动编号',
  `orderId` int(10) NOT NULL,
  `productId` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `cost` float(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_detail` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自动编号',
  `name` varchar(20) NOT NULL,
  `describe` varchar(100) DEFAULT NULL,
  `price` float(10,2) NOT NULL,
  `parentId` int(10) DEFAULT NULL,
  `fileName` varchar(100) NOT NULL COMMENT '上传的文件名',
  `isDelete` int(10) DEFAULT NULL COMMENT '1为删除，0为未删除',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自动编号',
  `loginName` varchar(20) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `sex` int(1) DEFAULT '1' COMMENT '1为男，0为女，默认男',
  `phone` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `identityCode` varchar(18) DEFAULT NULL,
  `type` int(1) DEFAULT '0' COMMENT '1为商家，0为用户',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，自动编号',
  `userId` int(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `isDefault` int(1) NOT NULL COMMENT '1是，0不是',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_address` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
