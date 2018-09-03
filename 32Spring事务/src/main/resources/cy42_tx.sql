/*
Navicat MySQL Data Transfer

Source Server         : 问问
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : cy42_tx

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-03 17:03:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tx_book
-- ----------------------------
DROP TABLE IF EXISTS `tx_book`;
CREATE TABLE `tx_book` (
  `isbn` varchar(255) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tx_book
-- ----------------------------
INSERT INTO `tx_book` VALUES ('1001', '西游记', '50');
INSERT INTO `tx_book` VALUES ('1002', '水浒', '60');
INSERT INTO `tx_book` VALUES ('1003', '三国', '70');

-- ----------------------------
-- Table structure for tx_book_stock
-- ----------------------------
DROP TABLE IF EXISTS `tx_book_stock`;
CREATE TABLE `tx_book_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tx_book_stock
-- ----------------------------
INSERT INTO `tx_book_stock` VALUES ('1', '1001', '10');
INSERT INTO `tx_book_stock` VALUES ('2', '1002', '10');
INSERT INTO `tx_book_stock` VALUES ('3', '1003', '10');

-- ----------------------------
-- Table structure for tx_user
-- ----------------------------
DROP TABLE IF EXISTS `tx_user`;
CREATE TABLE `tx_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `balance` int(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tx_user
-- ----------------------------
INSERT INTO `tx_user` VALUES ('1', 'wukong', '100');
INSERT INTO `tx_user` VALUES ('2', 'bajie', '200');
INSERT INTO `tx_user` VALUES ('3', 'tangseng', '100');
