/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springboot-demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-09-17 15:54:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grave_sale
-- ----------------------------
DROP TABLE IF EXISTS `grave_sale`;
CREATE TABLE `grave_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operation_no` varchar(255) DEFAULT NULL COMMENT '业务编号',
  `grave_full_path` varchar(255) DEFAULT NULL COMMENT '墓穴位置',
  `contact_name` varchar(255) DEFAULT NULL COMMENT '认购人姓名',
  `grave_user` varchar(255) DEFAULT NULL COMMENT '墓穴使用人',
  `end_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '维护管理费用到期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grave_sale
-- ----------------------------
INSERT INTO `grave_sale` VALUES ('1', 'GM2018', 'D1区1排3号', '齐世全', '齐润志', '2020-09-16 13:56:12');
INSERT INTO `grave_sale` VALUES ('2', 'GM2018', 'D1区1排3号', '齐世全', '南玉贞', '2020-09-17 13:56:57');
INSERT INTO `grave_sale` VALUES ('3', 'GX001', 'F1区3排1号', '路人甲', '路人乙', '2020-09-11 15:37:02');

-- ----------------------------
-- Table structure for payment_records
-- ----------------------------
DROP TABLE IF EXISTS `payment_records`;
CREATE TABLE `payment_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '缴费时间',
  `price` double(10,2) DEFAULT NULL COMMENT '缴费金额',
  `tarm` varchar(255) DEFAULT NULL COMMENT '缴费期限',
  `end_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '到期时间',
  PRIMARY KEY (`id`),
  KEY `FKfdo88jq4egrnixhun5osi0k1p` (`parent_id`),
  CONSTRAINT `FKfdo88jq4egrnixhun5osi0k1p` FOREIGN KEY (`parent_id`) REFERENCES `grave_sale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_records
-- ----------------------------
INSERT INTO `payment_records` VALUES ('1', '1', '2020-09-10 14:21:54', '111.00', '一年', '2020-09-25 14:22:04');
INSERT INTO `payment_records` VALUES ('2', '1', '2020-09-16 14:22:32', '222.00', '一年', '2020-09-16 14:22:43');
INSERT INTO `payment_records` VALUES ('3', '2', '2020-09-09 14:22:49', '333.00', '一年', '2020-09-23 14:22:59');
