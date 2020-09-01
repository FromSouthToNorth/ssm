/*
 Navicat Premium Data Transfer

 Source Server         : alyun
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 47.102.212.117:3306
 Source Schema         : staffing_system

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 01/09/2020 12:45:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES (1, '成都', 1);
INSERT INTO `t_city` VALUES (2, '广安', 1);
INSERT INTO `t_city` VALUES (3, '北京市', 3);
INSERT INTO `t_city` VALUES (4, '武汉', 2);
INSERT INTO `t_city` VALUES (5, '十堰', 2);
INSERT INTO `t_city` VALUES (6, '温州', 4);
INSERT INTO `t_city` VALUES (7, '黄冈', 2);

-- ----------------------------
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES (1, '四川');
INSERT INTO `t_province` VALUES (2, '湖北');
INSERT INTO `t_province` VALUES (3, '北京');
INSERT INTO `t_province` VALUES (4, '浙江');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_id` bigint(20) NULL DEFAULT NULL,
  `city_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES (27, 'demo', 11, '男', NULL, 2, 4);
INSERT INTO `t_staff` VALUES (28, '小明', 23, '女', NULL, 2, 5);
INSERT INTO `t_staff` VALUES (29, '李四', 15, '男', NULL, 2, 4);
INSERT INTO `t_staff` VALUES (34, '张三', 11, '男', NULL, 2, 5);

SET FOREIGN_KEY_CHECKS = 1;
