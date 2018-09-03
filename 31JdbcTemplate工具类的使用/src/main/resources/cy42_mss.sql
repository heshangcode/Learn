/*
Navicat MySQL Data Transfer

Source Server         : 问问
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : cy42_mss

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-03 15:54:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oa_user
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `money` decimal(7,2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oa_user
-- ----------------------------
INSERT INTO `oa_user` VALUES ('1', '悟空', '男', '888.00', null);
INSERT INTO `oa_user` VALUES ('2', '八戒', '男', '999.00', null);
INSERT INTO `oa_user` VALUES ('3', '天蓬元帅', '女', '1000.00', null);
INSERT INTO `oa_user` VALUES ('4', '悟能', '男', '666.00', null);
INSERT INTO `oa_user` VALUES ('5', '法悟法', '女', '544.00', null);
INSERT INTO `oa_user` VALUES ('6', '悟', '女', '562.00', null);
INSERT INTO `oa_user` VALUES ('7', '悟', '女', '562.00', null);
INSERT INTO `oa_user` VALUES ('14', '嫦娥', '女', '1213.00', null);
INSERT INTO `oa_user` VALUES ('15', '月兔', '女', '2113.00', null);
INSERT INTO `oa_user` VALUES ('16', '和尚', '男', '455.00', '2018-08-05');
INSERT INTO `oa_user` VALUES ('18', '沙僧', '男', '455.00', '2018-08-05');
INSERT INTO `oa_user` VALUES ('19', '唐僧', '男', '220.00', '2018-08-09');
INSERT INTO `oa_user` VALUES ('20', '唐僧', '男', '220.00', '2018-08-09');

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `fk_teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES ('2', 'JS', '75', null);
INSERT INTO `skill` VALUES ('7', 'CSS', '66', null);
INSERT INTO `skill` VALUES ('8', 'java', '66', null);
INSERT INTO `skill` VALUES ('9', 'vue', '56', '9999');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `role_key` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '1可用 -1禁用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('-100', '超级管理员', 'ADMIN', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `user_name` varchar(32) DEFAULT '',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '1可用 -1删除  2禁用',
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(128) DEFAULT NULL,
  `fk_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_role_id` (`fk_role_id`),
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`fk_role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-999', 'super', 'super', '唐僧', '1', '2018-07-28 18:47:39', null, '-100');
INSERT INTO `sys_user` VALUES ('-888', 'admin', 'admin', '悟空', '1', '2018-07-03 18:48:21', null, '-100');
