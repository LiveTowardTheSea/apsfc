/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : apsfc

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2018-09-03 13:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `authority` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'sa', '123', '0');
INSERT INTO `admin` VALUES ('2', 'admin', '123', '0');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `typeid` varchar(50) DEFAULT NULL,
  `burden` varchar(100) DEFAULT NULL,
  `brief` varchar(500) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `sums` varchar(50) DEFAULT '0',
  `price1` varchar(50) DEFAULT NULL,
  `sums1` varchar(50) DEFAULT '0',
  `imgpath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('12', '粉蒸肉', '10', '米粉、五花肉', '暂无11111', '26', '0', '23', '0', 'img/m_fenzhengrou.gif');
INSERT INTO `menus` VALUES ('14', '糖醋排骨', '2', '排骨、糖、醋', '暂无', '26', '0', '24', '4', 'img/m_tangcupaigu.gif');
INSERT INTO `menus` VALUES ('15', '咸肉菜饭', '6', '咸肉、米饭', '暂无', '15', '0', '12', '4', 'img/m_xianroucaifan.gif');
INSERT INTO `menus` VALUES ('17', '五香驴肉', '1', '驴肉', '暂无', '25', '0', '21', '1', 'img/m_wuxianglvrou.gif');
INSERT INTO `menus` VALUES ('18', '黄瓜拉皮', '1', '黄瓜、拉皮', '暂无', '8', '0', '6', '1', 'img/m_huanggualapi.gif');
INSERT INTO `menus` VALUES ('19', '水煮鱼', '11', '鱼，辣椒', '暂无', '38', '0', '32', '1', 'img/m_shuizhuyu.gif');
INSERT INTO `menus` VALUES ('20', '111111', '1', '111111', '111', '11', '0', '11', '1', 'img/001.jpg');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('6', '新增菜单《糖醋排骨》', '糖醋排骨超级好吃。再挑食的小朋友都无法拒绝酸甜的口味，吃光排骨，再用糖醋汁拌米饭，今天的饭量见长。', '2015-02-28 13:49:40');
INSERT INTO `notice` VALUES ('7', '本店特色《咸菜肉饭》', '记得小时候每每妈妈做咸肉菜饭，我都要吃上二大碗，那个香啊那个好吃啊，真的不知道怎样来形容。吃过的朋友，大家都懂的，呵呵！', '2015-02-28 13:53:39');
INSERT INTO `notice` VALUES ('10', '123', '123', '2017-09-12 11:02:20');
INSERT INTO `notice` VALUES ('11', '123', '123', '2017-09-12 11:02:36');
INSERT INTO `notice` VALUES ('12', 't\'t', 'tttt', '2017-09-12 23:03:24');
INSERT INTO `notice` VALUES ('14', 'yyyyyyyyyyyyyy', 'iii', '2017-09-12 23:09:07');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  `menusum` varchar(50) DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  `delivery` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('16', '2', '12', '2', '2015-02-15 13:16:28', '1');
INSERT INTO `orders` VALUES ('17', '1', '14', '1', '2015-02-15 13:23:30', '1');
INSERT INTO `orders` VALUES ('18', '1', '15', '1', '2015-02-15 13:26:09', '1');
INSERT INTO `orders` VALUES ('20', '2', '12', '1', '2015-02-16 00:38:49', '1');
INSERT INTO `orders` VALUES ('21', '2', '15', '1', '2015-02-16 00:38:49', '1');
INSERT INTO `orders` VALUES ('22', '2', '17', '1', '2015-02-16 00:38:49', '1');
INSERT INTO `orders` VALUES ('23', '1', '14', '1', '2015-04-30 17:22:27', '1');
INSERT INTO `orders` VALUES ('24', '1', '15', '1', '2015-04-30 17:22:27', '1');
INSERT INTO `orders` VALUES ('31', '1', '14', '1', '2017-09-12 23:09:56', '1');
INSERT INTO `orders` VALUES ('32', '1', '18', '1', '2017-09-12 23:09:56', '1');
INSERT INTO `orders` VALUES ('33', '1', '14', '3', '2017-09-12 23:30:04', '0');
INSERT INTO `orders` VALUES ('34', '5', '17', '3', '2017-09-14 00:11:46', '0');
INSERT INTO `orders` VALUES ('35', '5', '18', '2', '2017-09-14 00:11:46', '0');
INSERT INTO `orders` VALUES ('36', '5', '17', '7', '2017-09-14 00:18:32', '0');
INSERT INTO `orders` VALUES ('37', '5', '18', '6', '2017-09-14 00:18:32', '0');
INSERT INTO `orders` VALUES ('38', '5', '18', '1', '2017-09-14 00:18:49', '0');
INSERT INTO `orders` VALUES ('39', '5', '17', '4', '2017-09-14 11:26:11', '0');
INSERT INTO `orders` VALUES ('40', '5', '20', '4', '2017-09-14 11:26:18', '0');
INSERT INTO `orders` VALUES ('41', '5', '14', '7', '2017-09-14 11:26:30', '0');
INSERT INTO `orders` VALUES ('42', '5', '19', '2', '2017-09-14 11:26:49', '0');
INSERT INTO `orders` VALUES ('43', '5', '17', '5', '2017-09-15 14:19:52', '0');
INSERT INTO `orders` VALUES ('44', '5', '17', '3', '2017-09-15 14:22:09', '0');
INSERT INTO `orders` VALUES ('45', '5', '18', '1', '2017-09-15 14:22:09', '0');
INSERT INTO `orders` VALUES ('46', '5', '17', '3', '2017-09-15 14:24:22', '0');
INSERT INTO `orders` VALUES ('47', '5', '18', '1', '2017-09-15 14:24:22', '0');
INSERT INTO `orders` VALUES ('48', '5', '14', '1', '2017-09-15 14:24:22', '0');
INSERT INTO `orders` VALUES ('49', '5', '20', '1', '2017-09-15 14:24:22', '0');
INSERT INTO `orders` VALUES ('50', '1', '12', '3', '2018-03-23 11:15:15', '0');
INSERT INTO `orders` VALUES ('51', '1', '12', '3', '2018-03-23 11:16:42', '0');
INSERT INTO `orders` VALUES ('52', '1', '12', '2', '2018-03-23 11:17:02', '0');
INSERT INTO `orders` VALUES ('53', '1', '14', '1', '2018-03-23 11:17:02', '0');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '凉拌菜');
INSERT INTO `types` VALUES ('2', '炒菜');
INSERT INTO `types` VALUES ('6', '炒饭');
INSERT INTO `types` VALUES ('10', '蒸菜');
INSERT INTO `types` VALUES ('11', '111');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `card` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '111', '111', '111', '男', '22', '111111111111111111', '天津市', '13977777777', '1123@163.com', '110044', '1');
INSERT INTO `users` VALUES ('2', '222', '222', '张三', '男', '24', '111111111111111111', '天津市', '13988888888', '123@163.com', '110044', '1');
INSERT INTO `users` VALUES ('3', 'sunday', '123', '张三', '男', '26', '4222222222222222', '北京市海淀区', '13901001111', '13901001111@139.com', '101000', '1');
INSERT INTO `users` VALUES ('4', '1', '1', '1', '男', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `users` VALUES ('5', 'test', '123', 'test', '男', '12', '1111', 'dxy', '111', 'abc@126.com1111', '1234', '1');
INSERT INTO `users` VALUES ('6', '100', '100', '', '男', '', '', '', '', '', '', '1');
INSERT INTO `users` VALUES ('7', '20', '20', '20', '男', '20', '20', '20', '20', '20', '20', '1');
