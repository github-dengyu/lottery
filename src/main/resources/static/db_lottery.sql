/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : db_lottery

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-12 10:02:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` int(11) NOT NULL COMMENT '奖品编号',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '奖品名称',
  `account` int(12) DEFAULT NULL COMMENT '奖品数量',
  `level` int(12) DEFAULT NULL COMMENT '奖品等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------


-- ----------------------------
-- Table structure for lottery
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `id` int(11) NOT NULL COMMENT '抽奖人编号',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '人员姓名',
  `times` int(11) DEFAULT NULL COMMENT '抽奖次数',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(255) DEFAULT '0' COMMENT '默认状态0，0为未抽奖，1为已抽奖',
  `aid` int(11) DEFAULT NULL COMMENT '外键 award表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------

-- ----------------------------
-- Table structure for winners
-- ----------------------------
DROP TABLE IF EXISTS `winners`;
CREATE TABLE `winners` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '名单编号',
  `lid` int(11) DEFAULT NULL COMMENT '抽奖人编号',
  `aid` int(11) DEFAULT NULL COMMENT '奖品编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

