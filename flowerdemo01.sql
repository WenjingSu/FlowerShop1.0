/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : flowerdemo01

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-03-29 22:17:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `postcode` varchar(6) NOT NULL,
  `consignee_name` varchar(30) NOT NULL,
  `consignee_tel` varchar(11) NOT NULL,
  `add_del` int(1) NOT NULL DEFAULT '1',
  `add_memo` varchar(10) NOT NULL DEFAULT '家',
  PRIMARY KEY (`add_id`),
  KEY `address_fk_u_id` (`u_id`) USING BTREE,
  CONSTRAINT `address_fk_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '10', '山西省太原市杏花岭区山西大学', '030013', '章鱼', '15735104154', '0', '学校');
INSERT INTO `address` VALUES ('2', '10', '山西省太原市杏花岭区山西大学', '030013', '章鱼', '15735104157', '0', '学校');
INSERT INTO `address` VALUES ('3', '10', '山西省朔州市朔城区朔州市一中', '036000', '章鱼', '15735104157', '1', '学校');
INSERT INTO `address` VALUES ('4', '10', '北京市北京市海淀区北京大学', '100000', '小溪', '15735104157', '1', '家');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `g_id` int(11) NOT NULL,
  `goods_amount` int(3) NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `u_id` (`u_id`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `cart_fk_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `cart_fk_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('60', '10', '95', '1');

-- ----------------------------
-- Table structure for `flowernum`
-- ----------------------------
DROP TABLE IF EXISTS `flowernum`;
CREATE TABLE `flowernum` (
  `floNum_id` int(2) NOT NULL AUTO_INCREMENT,
  `floNum_name` varchar(20) DEFAULT NULL,
  `floNum_mean` varchar(100) DEFAULT NULL,
  `floNum_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`floNum_id`),
  UNIQUE KEY `floNum_name` (`floNum_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowernum
-- ----------------------------
INSERT INTO `flowernum` VALUES ('4', '1朵', '情有独钟，你是我的唯一', '1');
INSERT INTO `flowernum` VALUES ('5', '2朵', '二人世界，心心相印', '1');
INSERT INTO `flowernum` VALUES ('6', '3朵', '我爱你', '1');
INSERT INTO `flowernum` VALUES ('7', '4朵', '誓言、承诺、海誓山盟', '0');
INSERT INTO `flowernum` VALUES ('8', '5朵', '无怨无悔', '1');
INSERT INTO `flowernum` VALUES ('9', '6朵', '顺利、一帆风顺', '1');
INSERT INTO `flowernum` VALUES ('10', '7朵', '喜相逢', '1');
INSERT INTO `flowernum` VALUES ('11', '8朵', '弥补、兴旺发达、吉祥如意', '1');
INSERT INTO `flowernum` VALUES ('12', '9朵', '坚定的爱', '1');
INSERT INTO `flowernum` VALUES ('13', '10朵', '十全十美、美满幸福', '1');
INSERT INTO `flowernum` VALUES ('14', '11朵', '一心一意、心中最爱', '1');
INSERT INTO `flowernum` VALUES ('15', '12朵', '全部的爱、一年好运', '1');
INSERT INTO `flowernum` VALUES ('16', '13朵', '暗恋', '1');
INSERT INTO `flowernum` VALUES ('17', '14朵', '好聚好散', '1');
INSERT INTO `flowernum` VALUES ('18', '15朵', '青春美丽', '1');
INSERT INTO `flowernum` VALUES ('19', '16朵', '爱的最高点', '1');
INSERT INTO `flowernum` VALUES ('20', '17朵', '此情不渝', '1');
INSERT INTO `flowernum` VALUES ('21', '18朵', '最爱、青春美丽、财源广进', '1');
INSERT INTO `flowernum` VALUES ('22', '19朵', '爱到永远', '1');
INSERT INTO `flowernum` VALUES ('23', '20朵', '生生世世的爱', '1');
INSERT INTO `flowernum` VALUES ('24', '22朵', '双双对对、爱相随', '1');
INSERT INTO `flowernum` VALUES ('25', '24朵', '时时刻刻的思念', '1');
INSERT INTO `flowernum` VALUES ('26', '27朵', '爱妻', '1');
INSERT INTO `flowernum` VALUES ('27', '29朵', '爱到永久', '1');
INSERT INTO `flowernum` VALUES ('28', '30朵', '请接受我的爱', '1');
INSERT INTO `flowernum` VALUES ('29', '33朵', '我爱你三生三世', '1');
INSERT INTO `flowernum` VALUES ('30', '36朵', '我的爱只留给你', '1');
INSERT INTO `flowernum` VALUES ('31', '44朵', '至死不渝', '1');
INSERT INTO `flowernum` VALUES ('32', '48朵', '挚爱', '1');
INSERT INTO `flowernum` VALUES ('33', '50朵', '无怨无悔', '1');
INSERT INTO `flowernum` VALUES ('34', '51朵', '我的心中只有你', '1');
INSERT INTO `flowernum` VALUES ('35', '66朵', '真爱永不变、爱无止境', '1');
INSERT INTO `flowernum` VALUES ('36', '99朵', '长相厮守、天长地久', '1');
INSERT INTO `flowernum` VALUES ('37', '100朵', '百年好合、白头偕老', '1');
INSERT INTO `flowernum` VALUES ('38', '101朵', '直到永远、执着的爱', '1');
INSERT INTO `flowernum` VALUES ('39', '108朵', '求婚', '1');
INSERT INTO `flowernum` VALUES ('40', '110朵', '无尽的爱', '1');
INSERT INTO `flowernum` VALUES ('41', '111朵', '爱你一生一世', '1');
INSERT INTO `flowernum` VALUES ('42', '144朵', '爱你生生世世', '1');
INSERT INTO `flowernum` VALUES ('43', '365朵', '天天想你', '1');
INSERT INTO `flowernum` VALUES ('44', '999朵', '天长地久、无尽的爱', '1');
INSERT INTO `flowernum` VALUES ('45', '1000朵', '爱你一万年', '1');
INSERT INTO `flowernum` VALUES ('46', null, null, '0');
INSERT INTO `flowernum` VALUES ('47', '1000000朵', '无穷大的爱', '1');
INSERT INTO `flowernum` VALUES ('48', '81朵', '', '1');
INSERT INTO `flowernum` VALUES ('49', '38朵', '', '1');

-- ----------------------------
-- Table structure for `flowertype`
-- ----------------------------
DROP TABLE IF EXISTS `flowertype`;
CREATE TABLE `flowertype` (
  `floType_id` int(11) NOT NULL AUTO_INCREMENT,
  `floType_name` varchar(20) NOT NULL,
  `floType_mean` varchar(30) DEFAULT NULL,
  `floType_del` int(1) DEFAULT '1',
  `floType_img` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`floType_id`),
  UNIQUE KEY `floType_name` (`floType_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowertype
-- ----------------------------
INSERT INTO `flowertype` VALUES ('1', '香槟玫瑰', '', '1', 'floType002.png');
INSERT INTO `flowertype` VALUES ('2', '粉色康乃馨', '', '1', 'floType003.png');
INSERT INTO `flowertype` VALUES ('3', '郁金香', null, '1', 'floType004.png');
INSERT INTO `flowertype` VALUES ('4', '白百合', '', '1', 'floType005.png');
INSERT INTO `flowertype` VALUES ('5', '满天星', '', '1', '');
INSERT INTO `flowertype` VALUES ('6', '扶郎', null, '1', 'floType006.png');
INSERT INTO `flowertype` VALUES ('7', '马蹄莲', null, '1', 'floType007.png');
INSERT INTO `flowertype` VALUES ('8', '向日葵', null, '1', 'floType008.png');
INSERT INTO `flowertype` VALUES ('9', '大和锦', '', '0', null);
INSERT INTO `flowertype` VALUES ('10', '蓝石莲', '', '0', null);
INSERT INTO `flowertype` VALUES ('11', '碧斯诺', '', '0', null);
INSERT INTO `flowertype` VALUES ('12', '红玫瑰', '', '1', 'floType001.png');
INSERT INTO `flowertype` VALUES ('13', '紫色勿忘我', '', '1', null);
INSERT INTO `flowertype` VALUES ('14', '栀子叶', '', '1', null);
INSERT INTO `flowertype` VALUES ('15', '苏醒玫瑰', '', '1', null);
INSERT INTO `flowertype` VALUES ('16', '紫罗兰', '', '1', null);
INSERT INTO `flowertype` VALUES ('17', '银叶菊', '', '1', null);
INSERT INTO `flowertype` VALUES ('18', '雪山白玫瑰', '', '1', 'floType009.png');
INSERT INTO `flowertype` VALUES ('19', '白边紫色多头康乃馨', '', '1', null);
INSERT INTO `flowertype` VALUES ('20', '戴安娜粉玫瑰', '', '1', 'floType010.png');
INSERT INTO `flowertype` VALUES ('21', '白色相思梅', '', '1', null);
INSERT INTO `flowertype` VALUES ('22', '蓝色绣球', '', '1', null);
INSERT INTO `flowertype` VALUES ('23', '紫色小雏菊', '', '1', null);
INSERT INTO `flowertype` VALUES ('24', '紫红色康乃馨', '', '1', null);
INSERT INTO `flowertype` VALUES ('25', '粉百合', '', '1', null);
INSERT INTO `flowertype` VALUES ('26', '紫玫瑰', '', '1', 'floType011.png');
INSERT INTO `flowertype` VALUES ('27', '紫色桔梗', '', '1', null);
INSERT INTO `flowertype` VALUES ('28', '香槟桔梗', '', '1', null);
INSERT INTO `flowertype` VALUES ('29', '粉色洋桔梗', '', '1', null);
INSERT INTO `flowertype` VALUES ('30', '红色康乃馨', '', '1', null);
INSERT INTO `flowertype` VALUES ('31', '白色小雏菊', '', '1', null);
INSERT INTO `flowertype` VALUES ('32', '绿萝', '', '1', null);
INSERT INTO `flowertype` VALUES ('33', '金钱树', '', '1', null);
INSERT INTO `flowertype` VALUES ('34', '绿色康乃馨', '', '1', null);
INSERT INTO `flowertype` VALUES ('35', '水果', '', '1', null);
INSERT INTO `flowertype` VALUES ('36', '绿色桔梗', '', '1', null);

-- ----------------------------
-- Table structure for `floweruse`
-- ----------------------------
DROP TABLE IF EXISTS `floweruse`;
CREATE TABLE `floweruse` (
  `floUse_id` int(11) NOT NULL AUTO_INCREMENT,
  `floUse_name` varchar(20) NOT NULL,
  `floUse_del` int(1) DEFAULT '1',
  `floUse_img` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`floUse_id`),
  UNIQUE KEY `floUse_name` (`floUse_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of floweruse
-- ----------------------------
INSERT INTO `floweruse` VALUES ('1', '爱情鲜花', '1', '009.png');
INSERT INTO `floweruse` VALUES ('2', '友情鲜花', '1', 'f01.png');
INSERT INTO `floweruse` VALUES ('3', '生日鲜花', '1', 'b01.png');
INSERT INTO `floweruse` VALUES ('4', '问候长辈', '1', 't01.png');
INSERT INTO `floweruse` VALUES ('5', '探病慰问', '1', 'p01.png');
INSERT INTO `floweruse` VALUES ('6', '道歉鲜花', '1', 'a001.png');
INSERT INTO `floweruse` VALUES ('7', '祝贺鲜花', '1', 'c001.png');
INSERT INTO `floweruse` VALUES ('8', '婚庆鲜花', '1', 'm001.png');
INSERT INTO `floweruse` VALUES ('9', '商务鲜花', '1', 'business01.png');
INSERT INTO `floweruse` VALUES ('10', 'great', '0', null);
INSERT INTO `floweruse` VALUES ('11', '馈赠长辈', '1', 't01.png');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(30) NOT NULL,
  `gt_id` int(11) NOT NULL,
  `floNum_id` int(2) NOT NULL,
  `purchasing_price` double(10,2) DEFAULT NULL,
  `original_price` double(10,2) DEFAULT NULL,
  `goods_price` double(10,2) DEFAULT NULL,
  `g_imgurl` varchar(100) DEFAULT NULL,
  `putaway_time` date DEFAULT NULL,
  `g_state` int(1) NOT NULL DEFAULT '2',
  `g_info` varchar(200) DEFAULT NULL,
  `amount` int(4) NOT NULL DEFAULT '0',
  `g_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`g_id`),
  UNIQUE KEY `g_name` (`g_name`) USING BTREE,
  KEY `fk_floNum_id` (`floNum_id`),
  KEY `gt_id` (`gt_id`) USING BTREE,
  CONSTRAINT `fk_floNum_id` FOREIGN KEY (`floNum_id`) REFERENCES `flowernum` (`floNum_id`),
  CONSTRAINT `fk_gt_id` FOREIGN KEY (`gt_id`) REFERENCES `goodstype` (`gt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '天天天晴', '4', '35', '386.00', '636.00', '496.00', '001.png', null, '1', '你有没有发现，只要我们在一起，就是好天气', '10', '1');
INSERT INTO `goods` VALUES ('2', '爱的纪念日', '4', '14', '152.00', '199.00', '168.00', '005.png', null, '1', '一次偶然的凝眸，就注定了一生的痴情', '10', '1');
INSERT INTO `goods` VALUES ('3', '幸福的约定', '4', '29', '320.00', '448.00', '349.00', '009.png', null, '1', '幸福是一种温暖的陪伴，即使没有说出口，也会蔓延永远', '10', '1');
INSERT INTO `goods` VALUES ('4', '缘分天空', '4', '4', '218.00', '279.00', '279.00', '013.png', null, '1', '也许是缘分的安排，知心的你，让我从此不再孤单', '10', '1');
INSERT INTO `goods` VALUES ('5', 'd', '4', '6', '0.00', '0.00', '0.00', null, null, '1', null, '100', '1');
INSERT INTO `goods` VALUES ('6', '深情眷恋', '4', '35', '476.00', '670.00', '660.00', '017.png', null, '1', '眷恋你深情的相拥，愿我们相爱到永久', '10', '1');
INSERT INTO `goods` VALUES ('8', 'g', '4', '6', '0.00', '0.00', '0.00', null, null, '1', null, '100', '1');
INSERT INTO `goods` VALUES ('9', '恋恋不忘', '4', '36', '829.00', '958.00', '958.00', '021.png', null, '1', '有一种幸福，叫恋恋不忘......', '10', '1');
INSERT INTO `goods` VALUES ('11', '三生三世', '4', '29', '269.00', '399.00', '289.00', '025.png', null, '1', '三千繁花只为你留恋', '10', '1');
INSERT INTO `goods` VALUES ('12', '如初', '4', '22', '208.00', '268.00', '268.00', '029.png', null, '1', '还记得我们第一次的约会吗？那天的星空是那样美', '10', '1');
INSERT INTO `goods` VALUES ('13', '幸福绽放', '4', '22', '160.00', '215.00', '215.00', '033.png', null, '1', '您在我的心里永远美丽，漂亮！', '10', '1');
INSERT INTO `goods` VALUES ('14', '幸福万年长', '4', '48', '379.00', '400.00', '389.00', '037.png', null, '1', '家是什么?有人说家是倦鸟归来的巢，家是小船避风的港......有爱有家，幸福万年长。', '10', '1');
INSERT INTO `goods` VALUES ('15', '纯爱之美', '4', '49', '306.00', '392.00', '388.00', '041.png', null, '1', '似乎又回到曾经的纯真岁月，那时的我们自然、淳朴。我对你的爱也一直如此，深沉不虚浮......', '10', '1');
INSERT INTO `goods` VALUES ('16', '双鱼座守护之花', '4', '8', '232.00', '350.00', '292.00', '045.png', null, '1', '属于双鱼座的星座花，献给温柔多情的她。', '10', '1');
INSERT INTO `goods` VALUES ('17', '不变的心', '4', '35', '429.00', '660.00', '429.00', '050.png', null, '1', '爱上你是我今生最大的幸福，想你是我最甜蜜的痛苦，和你在一起是我的骄傲。', '10', '1');
INSERT INTO `goods` VALUES ('18', '母爱', '4', '22', '168.00', '258.00', '178.00', '054.png', null, '1', '你给了我青春的年华，自己却满头白发，不负青春年华，是对你最好的报答！', '10', '1');
INSERT INTO `goods` VALUES ('19', '青青子衿', '4', '9', '230.00', '358.00', '280.00', '057.png', null, '1', '“青青子衿，悠悠我心。”', '20', '1');
INSERT INTO `goods` VALUES ('20', '嫁给我吧', '4', '39', '688.00', '928.00', '738.00', '061.png', null, '1', '108朵玫瑰，每一朵都在细诉无尽的爱，每一朵都是我在对你说：“嫁给我吧！”', '15', '1');
INSERT INTO `goods` VALUES ('21', '用心爱你', '4', '36', '600.00', '899.00', '699.00', '065.png', null, '1', '99朵玫瑰，寓意想和你相守，直到天荒地老......', '10', '1');
INSERT INTO `goods` VALUES ('22', '一心一意', '4', '14', '109.00', '159.00', '139.00', '068.png', null, '2', '11枝玫瑰，寓意一心一意！', '10', '1');
INSERT INTO `goods` VALUES ('23', '致美丽的你', '4', '4', '109.00', '149.00', '139.00', '072.png', null, '1', '纵然途中万般风景，我的眼里只有你！', '10', '1');
INSERT INTO `goods` VALUES ('24', '海洋之心', '4', '27', '236.00', '296.00', '296.00', '076.png', null, '2', '无际的蓝色大海，轻轻地泛起白色的浪花，就像是亲密恋人之间的耳语。', '10', '1');
INSERT INTO `goods` VALUES ('25', '感激', '4', '28', '198.00', '228.00', '108.00', '081.png', null, '2', '常怀感激之情的生活是最甜美的！', '50', '1');
INSERT INTO `goods` VALUES ('26', '窈窕淑女', '5', '14', '196.00', '268.00', '208.00', '085.png', null, '2', '“关关雎鸠，在河之洲，窈窕淑女，君子好逑。”爱上你是我今生最大的幸福，我只钟情你一个。', '9', '1');
INSERT INTO `goods` VALUES ('27', '嫣然一笑', '5', '22', '208.00', '278.00', '238.00', '090.png', null, '2', '回眸一笑百媚生，万千粉黛无颜色，最爱那刹那的娇羞，浑然不知今夕何夕。', '10', '1');
INSERT INTO `goods` VALUES ('28', '向阳的温暖', '5', '14', '200.00', '268.00', '268.00', '093.png', null, '2', '心若向阳，必生温暖。', '10', '1');
INSERT INTO `goods` VALUES ('29', '爱在春天', '5', '27', '300.00', '400.00', '328.00', '097.png', null, '2', '沐浴爱的春风，你我情深如酒浓，化作一片相思雪，融化我心中！', '10', '1');
INSERT INTO `goods` VALUES ('30', '伊人如梦', '5', '27', '328.00', '388.00', '378.00', '101.png', null, '1', '繁星如许，明月如初，愿为你拼尽柔情傲骨，永生永世为你守护！', '10', '1');
INSERT INTO `goods` VALUES ('31', '特价：爱在巴黎', '5', '30', '308.00', '388.00', '328.00', '105.png', null, '2', '海岸线蔓延的巴黎，和遇见你那个雨季，你的笑容，像阳光开满温暖心底。', '10', '1');
INSERT INTO `goods` VALUES ('32', '你的微笑', '5', '30', '298.00', '348.00', '338.00', '109.png', null, '2', '如果金色的阳光，停止了它耀眼的光芒。那么你的一个微笑，将照亮我的整个世界。', '10', '1');
INSERT INTO `goods` VALUES ('33', '纯纯的爱恋', '5', '30', '308.00', '388.00', '338.00', '113.png', null, '2', '白玫瑰，它是那么的娇艳和可爱，如你。', '10', '1');
INSERT INTO `goods` VALUES ('34', '拥抱的幸福', '5', '30', '288.00', '328.00', '308.00', '117.png', null, '2', '你的拥抱融化了我的心，你就像阳光一样暖暖的。自从你入驻了我的左心房，我的整个世界都是幸福的。', '10', '1');
INSERT INTO `goods` VALUES ('35', '痴恋', '5', '30', '268.00', '318.00', '318.00', '121.png', null, '2', '有一种执着的信念，是天涯海角的追随；有一种心的期待，是不见不散的痴恋！', '20', '1');
INSERT INTO `goods` VALUES ('36', '芬芳', '4', '26', '208.00', '278.00', '278.00', '125.png', null, '2', '钟声敲醒萌芽的爱情，微风透露甜蜜的气息。', '10', '1');
INSERT INTO `goods` VALUES ('37', '夏日倾情', '5', '22', '199.00', '256.00', '256.00', '129.png', null, '2', '是你吗？手执鲜花的那一个，你我曾在梦里暗中相约在这夏，让这么一刻，燃亮爱吧~', '10', '1');
INSERT INTO `goods` VALUES ('38', '轻语', '5', '29', '308.00', '378.00', '368.00', '133.png', null, '1', '微风伴着花香，吹来爱的气息。用一颗真心轻轻爱你，温柔的话只说给你听。', '10', '1');
INSERT INTO `goods` VALUES ('39', '恋香', '5', '27', '308.00', '378.00', '378.00', '137.png', null, '2', '微风伴着花香，吹来爱的气息。用一颗真心轻轻爱你，温柔的话只说给你听。', '10', '1');
INSERT INTO `goods` VALUES ('40', '天使之祈', '5', '22', '155.00', '205.00', '195.00', '141.png', null, '1', '健康、平安、幸福，一切尽在不言中，让花儿的香味弥漫四周，带来对于生活最美好的祝福。', '10', '1');
INSERT INTO `goods` VALUES ('41', '醉思念', '5', '22', '139.00', '199.00', '199.00', '145.png', null, '1', '从何时起，爱上红酒，深夜沉静如水，音乐浅吟低唱，持酒不邀月，垂首独一人，心已醉。', '12', '1');
INSERT INTO `goods` VALUES ('42', '馨情无限', '5', '24', '206.00', '246.00', '246.00', '149.png', null, '1', '曾经有人说“回家叫一声妈妈，是一件很幸福的事”。直到现在，才体会到这种甜蜜，原来我一直都过得如此美满...因为有妳，我的妈妈！', '20', '1');
INSERT INTO `goods` VALUES ('43', '爱是唯一', '5', '16', '236.00', '296.00', '286.00', '153.png', null, '1', '我把你当作我的空气，捧你在我手心，在爱的纯净世界，你就是我唯一，我唯一爱的就是你！', '10', '1');
INSERT INTO `goods` VALUES ('44', '我只钟情你', '4', '17', '199.00', '239.00', '239.00', '157.png', null, '1', '香槟玫瑰清新、脱俗，品位独特！让我们乘着芬芳的清风，手牵着手走过四季春秋。', '10', '1');
INSERT INTO `goods` VALUES ('45', '大绿萝', '61', '4', '198.00', '258.00', '258.00', '161.png', null, '1', '大绿萝：性耐旱、耐阴，也耐强光，为驰名之室内盆栽植物', '20', '1');
INSERT INTO `goods` VALUES ('46', '金钱树', '61', '4', '500.00', '618.00', '618.00', '162.png', null, '1', '金钱树原产于非洲东部雨量偏少的热带', '10', '1');
INSERT INTO `goods` VALUES ('47', '发财树', '61', '4', '288.00', '328.00', '328.00', '163.png', null, '1', '性耐旱、耐阴，也耐强光，为驰名之室内盆栽植物', '5', '1');
INSERT INTO `goods` VALUES ('48', '巴西木', '61', '4', '198.00', '298.00', '298.00', '163.png', null, '1', '巴西木:性耐旱、耐阴，也耐强光，为驰名之室内盆栽植', '10', '1');
INSERT INTO `goods` VALUES ('49', '绿帝王', '61', '4', '88.00', '108.00', '106.00', '164.png', null, '1', '办公室的好伙伴', '10', '1');
INSERT INTO `goods` VALUES ('50', '多头斑马万年青', '61', '4', '105.00', '135.00', '135.00', '165.png', null, '1', '办公室的好助手', '10', '1');
INSERT INTO `goods` VALUES ('51', '火鹤', '62', '4', '138.00', '168.00', '168.00', '166.png', null, '1', '祝福鸿运当头，财源滚滚来！', '10', '1');
INSERT INTO `goods` VALUES ('52', '花开富贵', '62', '4', '308.00', '358.00', '358.00', '167.png', null, '1', '适用于家庭，办公环境的装饰，用来美化环境，净化空气', '10', '1');
INSERT INTO `goods` VALUES ('53', '万事顺意', '62', '8', '508.00', '568.00', '568.00', '168.png', null, '1', '大花蕙兰，欧美称之“新美娘兰”，其花大，花形规整丰满，色泽鲜艳，花茎直立，花朵多，花色品种丰富，花期长（三个月以上），不怕寒冷，栽培容易，生长健壮。', '6', '1');
INSERT INTO `goods` VALUES ('54', '黄金岁月', '62', '8', '508.00', '568.00', '568.00', '169.png', null, '1', '大花蕙兰，欧美称之“新美娘兰”，其花大，花形规整丰满，色泽鲜艳，花茎直立，花朵多，花色品种丰富，花期长（三个月以上），不怕寒冷，栽培容易，生长健壮。', '6', '1');
INSERT INTO `goods` VALUES ('55', '吉星高照', '62', '4', '268.00', '298.00', '298.00', '170.png', null, '1', '适宜生长在潮湿的环境之中', '10', '1');
INSERT INTO `goods` VALUES ('56', '蝴蝶兰', '62', '9', '508.00', '558.00', '558.00', '171.png', null, '1', '公司开业.喜庆.乔迁. 会场布置.居家摆饰. 送礼自用两', '12', '1');
INSERT INTO `goods` VALUES ('57', '纯洁天使', '62', '8', '498.00', '568.00', '568.00', '172.png', null, '1', '被誉为“洋兰王后”的蝴蝶兰，越来越受到花迷们的青', '12', '1');
INSERT INTO `goods` VALUES ('58', '十全十美', '62', '13', '800.00', '899.00', '899.00', '173.png', null, '1', '被誉为“洋兰王后”的蝴蝶兰，越来越受到花迷们的青', '12', '1');
INSERT INTO `goods` VALUES ('59', '吉祥如意', '62', '5', '218.00', '238.00', '258.00', '174.png', null, '1', '被誉为“洋兰王后”的蝴蝶兰，越来越受到花迷们的青', '6', '1');
INSERT INTO `goods` VALUES ('60', '常相伴', '6', '27', '318.00', '328.00', '358.00', '175.png', null, '1', '仿佛阳光扑入怀抱，拥抱一个全新世界。那里有温暖的阳光，醉人的花香...', '12', '1');
INSERT INTO `goods` VALUES ('61', '永不褪色的爱', '6', '27', '329.00', '379.00', '379.00', '178.png', null, '1', '时光易逝，容颜易改，而我对你的爱一如初见，历久弥新，永不褪色！挚爱一生，唇齿相依。 ', '6', '1');
INSERT INTO `goods` VALUES ('62', '清新的爱', '6', '20', '209.00', '299.00', '299.00', '182.png', null, '1', '享受生活带来的温暖与诗意，享受每一个充满爱的时刻', '6', '1');
INSERT INTO `goods` VALUES ('63', '苏醒的温柔', '6', '23', '299.00', '339.00', '339.00', '186.png', null, '1', '阳光下的晴朗世界，那温柔的春风已苏醒！', '6', '1');
INSERT INTO `goods` VALUES ('64', '圆满', '6', '23', '190.00', '206.00', '206.00', '190.png', null, '1', '载着寓意希望的鲜花驶向快乐幸福的彼岸…… ', '5', '1');
INSERT INTO `goods` VALUES ('65', '爱的思念', '6', '16', '186.00', '196.00', '196.00', '192.png', null, '1', '的思念绵延不绝，终于和天在地平线上交汇......有一种很玄的东西叫思念，思念是是甜蜜，夹杂着淡淡苦涩，被人思念，也是一种被爱的幸福。', '12', '1');
INSERT INTO `goods` VALUES ('66', '生如夏花', '7', '15', '208.00', '258.00', '258.00', '197.png', null, '1', '我相信自己生来如同璀璨的夏日之花，不凋不败，妖冶如火，承受心跳的负荷和呼吸的累赘，乐此不疲。', '12', '1');
INSERT INTO `goods` VALUES ('67', '紫情密语', '7', '15', '268.00', '268.00', '288.00', '201.png', null, '1', '偷偷将空白抹去，汇成七彩的梦境，甜蜜的话语只说与你听。', '12', '1');
INSERT INTO `goods` VALUES ('68', '简爱', '7', '25', '255.00', '298.00', '288.00', '204.png', null, '1', '简单，my love，是最真实的爱。', '6', '1');
INSERT INTO `goods` VALUES ('69', '晨曦（特价）', '7', '19', '218.00', '388.00', '298.00', '208.png', null, '1', '晨曦洒落大地，扑鼻而来阵阵的芳香。', '100', '1');
INSERT INTO `goods` VALUES ('70', '想念的季节（特价）', '59', '4', '188.00', '288.00', '198.00', '211.png', null, '1', '我总是会想起你的笑，像个傻瓜不自觉的笑，空荡荡的心里，满满的全是你。', '100', '1');
INSERT INTO `goods` VALUES ('71', '一生一世', '59', '4', '100.00', '198.00', '128.00', '215.png', null, '1', '弱水三千只取一瓢饮，一生一世只爱你一人。', '100', '1');
INSERT INTO `goods` VALUES ('72', 'To温暖', '59', '4', '268.00', '488.00', '288.00', '219.png', null, '1', '我看到在你眼中，天真的纯洁与晴朗，告诉我关于这世界的故事，自由和欢乐的梦想！', '10', '1');
INSERT INTO `goods` VALUES ('73', '幸福港湾', '59', '6', '268.00', '288.00', '288.00', '223.png', null, '1', '我张开那轻盈的翅膀，停靠在你美丽的港湾，海风唱着夜曲和我相伴，那是天地之间温馨的浪漫。', '100', '1');
INSERT INTO `goods` VALUES ('74', '烈焰魅惑', '59', '4', '390.00', '520.00', '520.00', '227.png', null, '1', 'Dior迪奥999口红1支、进口紫色永生玫瑰1朵、樱花粉永生小玫瑰4枝、搭配粉色、紫色绣球、紫色满天星适量、粉色仿真珍珠2颗', '56', '1');
INSERT INTO `goods` VALUES ('75', '幸福时光', '58', '10', '458.00', '558.00', '558.00', '231png.png', null, '1', '不凋谢的鲜花，寓意：情感美丽永恒。', '8', '1');
INSERT INTO `goods` VALUES ('76', '一路上有你', '58', '8', '208.00', '568.00', '338.00', '233.png', null, '1', '不凋谢的鲜花，寓意：情感美丽永恒。', '12', '1');
INSERT INTO `goods` VALUES ('77', '美丽无限', '58', '6', '258.00', '288.00', '288.00', '234.png', null, '1', '不凋谢的鲜花，寓意：情感美丽永恒。', '12', '1');
INSERT INTO `goods` VALUES ('78', '触摸', '56', '4', '169.00', '288.00', '188.00', '236.png', null, '1', '“那一月，我转过所有经轮，不为超度，只为触摸你的指尖。”守住内心的信念，终会触摸到美好的爱情。', '8', '1');
INSERT INTO `goods` VALUES ('79', '彩虹下的约定', '55', '4', '299.00', '427.00', '357.00', '239.png', null, '1', '生活像彩虹充满无限希望与美好，心中的那个你在我心中永远多姿多彩般的美丽，寓意着我们的爱永恒不变！', '10', '1');
INSERT INTO `goods` VALUES ('80', '十二星座经典蓝·双鱼座', '55', '4', '268.00', '328.00', '328.00', '243.png', null, '1', '厄瓜多尔进口巨型玫瑰（直径9-10CM），玫瑰之中的极品！值得珍藏！双鱼座（Pisces）专属定制礼盒（2月19日－3月20日），双鱼座象征：冬天即将离去，铸造独特缄默方式。', '12', '1');
INSERT INTO `goods` VALUES ('81', '十二星座经典七彩·双鱼座', '55', '4', '200.00', '398.00', '298.00', '247.png', null, '1', '瓜多尔进口巨型彩色玫瑰（直径9-10CM），玫瑰之中的极品，值得珍藏！双鱼座（Pisces）专属定制礼盒（2月19日－3月20日），双鱼座象征：冬天即将离去，铸造独特缄默方式。', '10', '1');
INSERT INTO `goods` VALUES ('82', '十二星座经典红·双鱼座', '55', '4', '258.00', '308.00', '298.00', '251.png', null, '1', '厄瓜多尔进口巨型玫瑰（直径9-10CM），玫瑰之中的极品！值得珍藏！双鱼座（Pisces）专属定制礼盒（2月19日－3月20日），双鱼座象征：冬天即将离去，铸造独特缄默方式。', '12', '1');
INSERT INTO `goods` VALUES ('83', '紫魅----紫色永生玫瑰', '55', '4', '208.00', '268.00', '268.00', '255.png', null, '1', '厄瓜多尔进口巨型玫瑰（直径9-10CM），玫瑰之中的极品！值得珍藏！', '18', '1');
INSERT INTO `goods` VALUES ('84', '柔粉----粉色永生玫瑰', '55', '4', '268.00', '328.00', '328.00', '259.png', null, '1', '厄瓜多尔进口巨型玫瑰（直径9-10CM），玫瑰之中的极品！值得珍藏！', '18', '1');
INSERT INTO `goods` VALUES ('85', '小公主', '4', '4', '400.00', '598.00', '498.00', '263.png', null, '1', '进口永生玫瑰＋唯爱S925银锁骨项链 (初次见你，人群中独自美丽，你仿佛有一种魔力，那一刻我怦然心动。)', '6', '1');
INSERT INTO `goods` VALUES ('86', '迷你兔·红', '54', '5', '189.00', '198.00', '198.00', '269.png', null, '1', '苔藓小兔1只、进口红色永生玫瑰1朵（直径6-7cm）、樱花粉小玫瑰1朵、搭配粉色绣球、银叶菊、满天星', '18', '1');
INSERT INTO `goods` VALUES ('87', '永恒的约定', '54', '12', '368.00', '466.00', '466.00', '271.png', null, '1', '红色进口永生玫瑰（花头直径6-7cm）6枝，红色小玫瑰3枝，搭配灰黑色绣球，小米花配饰', '18', '1');
INSERT INTO `goods` VALUES ('88', '星辰', '54', '12', '569.00', '689.00', '689.00', '275.png', null, '1', '进口永生蓝玫瑰（直径6-7cm）9枝，搭配香芋紫绣球', '6', '1');
INSERT INTO `goods` VALUES ('89', '维也纳深林', '54', '9', '288.00', '428.00', '328.00', '279.png', null, '1', '苔藓小熊1个，厄瓜多尔进口永生白色玫瑰（直径7-8cm）2枝，绿色奥斯丁玫瑰1枝，浅粉桃小玫瑰3枝，搭配秋色绣球、粉色绣球', '2', '1');
INSERT INTO `goods` VALUES ('90', '最相思----永生花盒', '54', '8', '218.00', '289.00', '298.00', '283.png', null, '1', '厄瓜多尔进口白玫瑰1朵（直径7.5-9cm），进口紫玫瑰1朵(直径4-5cm)，黄边紫心奥斯丁3朵，搭配适量香芋紫绣球、白粉双色绣球、米花、龙须草', '100', '1');
INSERT INTO `goods` VALUES ('91', '深海秘境', '54', '12', '368.00', '468.00', '468.00', '287.png', null, '1', '进口永生蓝玫瑰（直径6-7cm）6枝，浅粉桃色玫瑰3枝，搭配白色、蓝色绣球，人造珍珠饰品3个，海星1个', '9986', '1');
INSERT INTO `goods` VALUES ('92', '爱在心头', '4', '33', '289.00', '298.00', '398.00', '291.png', null, '1', '“此情无计可消除，才下眉头，却上心头。”李清照《一剪梅》', '10000', '1');
INSERT INTO `goods` VALUES ('93', '甜美公主', '4', '30', '268.00', '328.00', '328.00', '299.png', null, '1', '再多一点点距离，我就能靠近你。清晰甜美的空气里，爱你到不能呼吸。', '9999', '1');
INSERT INTO `goods` VALUES ('94', '燃梦', '5', '14', '196.00', '226.00', '206.00', '304.png', null, '1', '你把我的世界点亮，所有烦恼烟消云散，你把我的心已偷走，爱情的烟火，每夜在我梦里点燃，每分每秒，思念蔓延。', '9985', '1');
INSERT INTO `goods` VALUES ('95', '和青春跳舞', '5', '29', '308.00', '368.00', '368.00', '309.png', null, '1', '躁动着，呐喊着，青春的旋律永不停息。拥抱爱人，和我们的青春跳一支舞吧。', '3', '1');
INSERT INTO `goods` VALUES ('96', '浪漫满屋', '4', '14', '200.00', '268.00', '209.00', '312.png', null, '1', '“以后别提冰激凌，再也不吃。以后给我买玫瑰吧，就要玫瑰。”“玫瑰很贵的。”如果可以，让心一起住在《浪漫满屋》（韩剧）里，去开开心心、活蹦乱跳的谈情说爱。', '6', '1');

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `gt_id` int(11) NOT NULL AUTO_INCREMENT,
  `gt_typename` varchar(20) NOT NULL,
  `ft_id` int(11) DEFAULT NULL,
  `gt_mark` varchar(1000) DEFAULT NULL,
  `gt_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`gt_id`),
  UNIQUE KEY `gt_typename` (`gt_typename`) USING BTREE,
  KEY `ft_id` (`ft_id`) USING BTREE,
  CONSTRAINT `goodtype_ft_id` FOREIGN KEY (`ft_id`) REFERENCES `goodstype` (`gt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '鲜花', null, '', '1');
INSERT INTO `goodstype` VALUES ('2', '永生花', null, null, '1');
INSERT INTO `goodstype` VALUES ('3', '盆栽', null, null, '1');
INSERT INTO `goodstype` VALUES ('4', '花束', '1', '', '1');
INSERT INTO `goodstype` VALUES ('5', '花盒', '1', 'beautiful', '1');
INSERT INTO `goodstype` VALUES ('6', '花篮', '1', 'flowers', '1');
INSERT INTO `goodstype` VALUES ('7', '瓶花', '1', null, '1');
INSERT INTO `goodstype` VALUES ('8', '鲜花配件', null, '土陶花盆、种植工具等', '0');
INSERT INTO `goodstype` VALUES ('54', '经典花盒', '2', null, '1');
INSERT INTO `goodstype` VALUES ('55', '巨型玫瑰', '2', null, '1');
INSERT INTO `goodstype` VALUES ('56', '薰衣草', '2', null, '1');
INSERT INTO `goodstype` VALUES ('58', '永生瓶花', '2', null, '1');
INSERT INTO `goodstype` VALUES ('59', '特色永生花', '2', null, '1');
INSERT INTO `goodstype` VALUES ('60', '呆萌多肉植物', '3', null, '1');
INSERT INTO `goodstype` VALUES ('61', '环保卫士绿植', '3', null, '1');
INSERT INTO `goodstype` VALUES ('62', '盆景花卉', '3', null, '1');

-- ----------------------------
-- Table structure for `goods_ft`
-- ----------------------------
DROP TABLE IF EXISTS `goods_ft`;
CREATE TABLE `goods_ft` (
  `gft_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL,
  `floType_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`gft_id`),
  UNIQUE KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `fk_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_ft
-- ----------------------------
INSERT INTO `goods_ft` VALUES ('1', '14', '2,14,19');
INSERT INTO `goods_ft` VALUES ('3', '13', '2,13,14');
INSERT INTO `goods_ft` VALUES ('4', '9', '1');
INSERT INTO `goods_ft` VALUES ('5', '1', '1');
INSERT INTO `goods_ft` VALUES ('6', '11', '12');
INSERT INTO `goods_ft` VALUES ('7', '2', '12,13,14');
INSERT INTO `goods_ft` VALUES ('8', '3', '15,16,17');
INSERT INTO `goods_ft` VALUES ('9', '4', '12');
INSERT INTO `goods_ft` VALUES ('10', '6', '12');
INSERT INTO `goods_ft` VALUES ('11', '12', '13,18');
INSERT INTO `goods_ft` VALUES ('12', '15', '20,21');
INSERT INTO `goods_ft` VALUES ('13', '16', '22,23');
INSERT INTO `goods_ft` VALUES ('14', '17', '13,20');
INSERT INTO `goods_ft` VALUES ('15', '18', '2,24');
INSERT INTO `goods_ft` VALUES ('16', '19', '4');
INSERT INTO `goods_ft` VALUES ('17', '20', '20');
INSERT INTO `goods_ft` VALUES ('18', '21', '12,20');
INSERT INTO `goods_ft` VALUES ('19', '22', '12,13,14');
INSERT INTO `goods_ft` VALUES ('20', '23', '5,12');
INSERT INTO `goods_ft` VALUES ('21', '24', '18');
INSERT INTO `goods_ft` VALUES ('22', '25', '24,25');
INSERT INTO `goods_ft` VALUES ('23', '26', '13,20');
INSERT INTO `goods_ft` VALUES ('24', '27', '13,26');
INSERT INTO `goods_ft` VALUES ('25', '28', '4,8,14,18,21');
INSERT INTO `goods_ft` VALUES ('26', '29', '1,27,28');
INSERT INTO `goods_ft` VALUES ('27', '30', '15,18,20');
INSERT INTO `goods_ft` VALUES ('28', '31', '12');
INSERT INTO `goods_ft` VALUES ('29', '32', '1');
INSERT INTO `goods_ft` VALUES ('30', '33', '18');
INSERT INTO `goods_ft` VALUES ('31', '34', '20');
INSERT INTO `goods_ft` VALUES ('32', '35', '12');
INSERT INTO `goods_ft` VALUES ('33', '36', '6,15,21,29');
INSERT INTO `goods_ft` VALUES ('34', '37', '1,17,21');
INSERT INTO `goods_ft` VALUES ('35', '38', '18');
INSERT INTO `goods_ft` VALUES ('36', '39', '1');
INSERT INTO `goods_ft` VALUES ('37', '40', '2,13');
INSERT INTO `goods_ft` VALUES ('38', '41', '13,30');
INSERT INTO `goods_ft` VALUES ('39', '42', '14,20,30');
INSERT INTO `goods_ft` VALUES ('40', '43', '4,17,18');
INSERT INTO `goods_ft` VALUES ('41', '44', '1,31');
INSERT INTO `goods_ft` VALUES ('42', '45', '32');
INSERT INTO `goods_ft` VALUES ('43', '46', '33');
INSERT INTO `goods_ft` VALUES ('44', '60', '1,34');
INSERT INTO `goods_ft` VALUES ('45', '61', '12,14');
INSERT INTO `goods_ft` VALUES ('46', '62', '1,8,35,36');
INSERT INTO `goods_ft` VALUES ('47', '63', '4,15,17,30,35');
INSERT INTO `goods_ft` VALUES ('48', '64', '12,24,25');
INSERT INTO `goods_ft` VALUES ('49', '65', '12,14,30');
INSERT INTO `goods_ft` VALUES ('50', '66', '1,8,31');
INSERT INTO `goods_ft` VALUES ('51', '67', '17,26');
INSERT INTO `goods_ft` VALUES ('52', '68', '2,14,15,27');
INSERT INTO `goods_ft` VALUES ('53', '69', '14,18,36');
INSERT INTO `goods_ft` VALUES ('54', '70', '20');
INSERT INTO `goods_ft` VALUES ('55', '71', '12');
INSERT INTO `goods_ft` VALUES ('56', '72', '20');
INSERT INTO `goods_ft` VALUES ('57', '73', '20,24');
INSERT INTO `goods_ft` VALUES ('58', '75', '12');
INSERT INTO `goods_ft` VALUES ('59', '76', '12');
INSERT INTO `goods_ft` VALUES ('60', '77', '12');
INSERT INTO `goods_ft` VALUES ('61', '92', '12,20');
INSERT INTO `goods_ft` VALUES ('62', '93', '14,18,20');
INSERT INTO `goods_ft` VALUES ('63', '94', '12,13');
INSERT INTO `goods_ft` VALUES ('64', '95', '14,20');
INSERT INTO `goods_ft` VALUES ('65', '96', '1');

-- ----------------------------
-- Table structure for `goods_fu`
-- ----------------------------
DROP TABLE IF EXISTS `goods_fu`;
CREATE TABLE `goods_fu` (
  `gfu_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL,
  `floUse_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`gfu_id`),
  UNIQUE KEY `fu_g_id` (`g_id`) USING BTREE,
  CONSTRAINT `fk_fu_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_fu
-- ----------------------------
INSERT INTO `goods_fu` VALUES ('1', '14', '1,2,3');
INSERT INTO `goods_fu` VALUES ('2', '12', '2,3,5,6,7,8');
INSERT INTO `goods_fu` VALUES ('3', '11', '1,3,6');
INSERT INTO `goods_fu` VALUES ('4', '1', '1');
INSERT INTO `goods_fu` VALUES ('5', '2', '1,3,8');
INSERT INTO `goods_fu` VALUES ('6', '3', '1,2,3,6,8');
INSERT INTO `goods_fu` VALUES ('7', '4', '1,3,8');
INSERT INTO `goods_fu` VALUES ('8', '6', '1,8');
INSERT INTO `goods_fu` VALUES ('9', '9', '1,3,6,8');
INSERT INTO `goods_fu` VALUES ('10', '13', '3,5,6,7,9,11');
INSERT INTO `goods_fu` VALUES ('11', '15', '1,3,6,8');
INSERT INTO `goods_fu` VALUES ('12', '16', '1,2,3,5,6,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('13', '17', '1,3,8');
INSERT INTO `goods_fu` VALUES ('14', '18', '3,5,7,11');
INSERT INTO `goods_fu` VALUES ('15', '19', '1,2,3,5,6,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('16', '20', '1,3');
INSERT INTO `goods_fu` VALUES ('17', '21', '1,8');
INSERT INTO `goods_fu` VALUES ('18', '22', '1,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('19', '23', '1,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('20', '24', '1,2,3,5,6,8');
INSERT INTO `goods_fu` VALUES ('21', '25', '3,11');
INSERT INTO `goods_fu` VALUES ('22', '26', '1,3,8');
INSERT INTO `goods_fu` VALUES ('23', '27', '1,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('24', '28', '2,3,5,7,9,11');
INSERT INTO `goods_fu` VALUES ('25', '29', '1,2,3,5,6,7,8');
INSERT INTO `goods_fu` VALUES ('26', '31', '1,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('27', '32', '1,2,3,5,6,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('28', '33', '1,3,6,8');
INSERT INTO `goods_fu` VALUES ('29', '34', '1,3,8');
INSERT INTO `goods_fu` VALUES ('30', '35', '1,3,7,8');
INSERT INTO `goods_fu` VALUES ('31', '36', '1,2,3,5,6,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('32', '37', '1,2,3,5,6,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('33', '38', '1,2,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('34', '40', '1,2,3,5,6,11');
INSERT INTO `goods_fu` VALUES ('35', '41', '1,3,11');
INSERT INTO `goods_fu` VALUES ('36', '42', '3,11');
INSERT INTO `goods_fu` VALUES ('37', '43', '1,2,3,8');
INSERT INTO `goods_fu` VALUES ('38', '45', '5,7,9,11');
INSERT INTO `goods_fu` VALUES ('39', '46', '7,8,9,11');
INSERT INTO `goods_fu` VALUES ('40', '47', '7,9,11');
INSERT INTO `goods_fu` VALUES ('41', '48', '7,9,11');
INSERT INTO `goods_fu` VALUES ('42', '49', '9,11');
INSERT INTO `goods_fu` VALUES ('43', '50', '9,11');
INSERT INTO `goods_fu` VALUES ('44', '51', '9,11');
INSERT INTO `goods_fu` VALUES ('45', '52', '7,11');
INSERT INTO `goods_fu` VALUES ('46', '53', '7,11');
INSERT INTO `goods_fu` VALUES ('47', '56', '3,7,8,9,11');
INSERT INTO `goods_fu` VALUES ('48', '57', '3,7,11');
INSERT INTO `goods_fu` VALUES ('49', '58', '3,7,11');
INSERT INTO `goods_fu` VALUES ('50', '59', '3,7,11');
INSERT INTO `goods_fu` VALUES ('51', '60', '1,2,3,5,6,7,8,11');
INSERT INTO `goods_fu` VALUES ('52', '61', '1,3,8');
INSERT INTO `goods_fu` VALUES ('53', '62', '1,2,3,5,6,7,8,11');
INSERT INTO `goods_fu` VALUES ('54', '64', '1,2,3,5,6,7,8,11');
INSERT INTO `goods_fu` VALUES ('55', '65', '1,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('56', '66', '1,2,3,5,6,7,8');
INSERT INTO `goods_fu` VALUES ('57', '67', '1,2,3,5,6,7');
INSERT INTO `goods_fu` VALUES ('58', '68', '1,2,3,5,6,7,11');
INSERT INTO `goods_fu` VALUES ('59', '70', '1,2,3,6');
INSERT INTO `goods_fu` VALUES ('60', '71', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('61', '72', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('62', '73', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('63', '74', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('64', '75', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('65', '76', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('66', '77', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('67', '78', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('68', '79', '1,2,6,7');
INSERT INTO `goods_fu` VALUES ('69', '80', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('70', '81', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('71', '82', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('72', '83', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('73', '84', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('74', '85', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('75', '86', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('76', '88', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('77', '89', '1,2,3,6,7');
INSERT INTO `goods_fu` VALUES ('78', '90', '1,2,3,7');
INSERT INTO `goods_fu` VALUES ('79', '91', '1,2,3,7,8');
INSERT INTO `goods_fu` VALUES ('80', '92', '1,3,6,7,8,11');
INSERT INTO `goods_fu` VALUES ('81', '93', '1,2,3,8');
INSERT INTO `goods_fu` VALUES ('82', '94', '1,2,3,6,7,8');
INSERT INTO `goods_fu` VALUES ('83', '95', '2,3,7');
INSERT INTO `goods_fu` VALUES ('84', '96', '1,3,7,8');

-- ----------------------------
-- Table structure for `goods_images`
-- ----------------------------
DROP TABLE IF EXISTS `goods_images`;
CREATE TABLE `goods_images` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `gimg_fk__g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_images
-- ----------------------------
INSERT INTO `goods_images` VALUES ('1', '12', null);
INSERT INTO `goods_images` VALUES ('2', '13', null);
INSERT INTO `goods_images` VALUES ('3', '14', null);
INSERT INTO `goods_images` VALUES ('4', '14', null);
INSERT INTO `goods_images` VALUES ('5', '14', null);
INSERT INTO `goods_images` VALUES ('6', '14', 'null,006.jpg,007.jpg,008.jpg');
INSERT INTO `goods_images` VALUES ('9', '13', null);
INSERT INTO `goods_images` VALUES ('10', '12', null);
INSERT INTO `goods_images` VALUES ('11', '11', null);
INSERT INTO `goods_images` VALUES ('12', '12', null);
INSERT INTO `goods_images` VALUES ('13', '14', null);
INSERT INTO `goods_images` VALUES ('14', '9', null);
INSERT INTO `goods_images` VALUES ('15', '1', null);
INSERT INTO `goods_images` VALUES ('16', '9', null);
INSERT INTO `goods_images` VALUES ('17', '11', null);
INSERT INTO `goods_images` VALUES ('18', '1', null);
INSERT INTO `goods_images` VALUES ('19', '1', null);
INSERT INTO `goods_images` VALUES ('20', '9', null);
INSERT INTO `goods_images` VALUES ('21', '2', null);
INSERT INTO `goods_images` VALUES ('22', '3', null);
INSERT INTO `goods_images` VALUES ('23', '4', 'null,014.png,015.png,020.png');
INSERT INTO `goods_images` VALUES ('24', '1', 'null,002.png,003.png,004.png');
INSERT INTO `goods_images` VALUES ('25', '2', 'null,006.png,007.png,008.png');
INSERT INTO `goods_images` VALUES ('26', '3', 'null,010.png,011.png,012.png');
INSERT INTO `goods_images` VALUES ('27', '4', 'null,014.png,015.png,020.png');
INSERT INTO `goods_images` VALUES ('28', '6', 'null,018.png,019.png,020.png');
INSERT INTO `goods_images` VALUES ('29', '9', 'null,022.png,023.png,024.png');
INSERT INTO `goods_images` VALUES ('30', '11', 'null,026.png,027.png,028.png');
INSERT INTO `goods_images` VALUES ('31', '12', 'null,030.png,031.png,032.png');
INSERT INTO `goods_images` VALUES ('32', '13', 'null,034.png,035.png,036.png');
INSERT INTO `goods_images` VALUES ('33', '14', 'null,038.png,039.png,040.png');
INSERT INTO `goods_images` VALUES ('34', '15', 'null,042.png,043.png,044.png');
INSERT INTO `goods_images` VALUES ('35', '16', 'null,046.png,047.png,048.png');
INSERT INTO `goods_images` VALUES ('36', '17', 'null,049.png,051.png,052.png');
INSERT INTO `goods_images` VALUES ('37', '18', 'null,055.png,056.png,053.png');
INSERT INTO `goods_images` VALUES ('38', '19', 'null,058.png,059.png,060.png');
INSERT INTO `goods_images` VALUES ('39', '20', 'null,062.png,063.png,064.png');
INSERT INTO `goods_images` VALUES ('40', '21', 'null,066.png,067.png');
INSERT INTO `goods_images` VALUES ('41', '22', 'null,069.png,071.png,070.png');
INSERT INTO `goods_images` VALUES ('42', '23', 'null,073.png,074.png,075.png');
INSERT INTO `goods_images` VALUES ('43', '24', 'null,077.png,078.png,079.png');
INSERT INTO `goods_images` VALUES ('44', '25', 'null,082.png,083.png,084.png');
INSERT INTO `goods_images` VALUES ('45', '26', 'null,086.png,087.png,088.png');
INSERT INTO `goods_images` VALUES ('46', '27', 'null,089.png,091.png,092.png');
INSERT INTO `goods_images` VALUES ('47', '28', 'null,094.png,095.png,096.png');
INSERT INTO `goods_images` VALUES ('48', '29', 'null,098.png,099.png,100.png');
INSERT INTO `goods_images` VALUES ('49', '30', 'null,102.png,103.png,104.png');
INSERT INTO `goods_images` VALUES ('50', '31', 'null,106.png,107.png,108.png');
INSERT INTO `goods_images` VALUES ('51', '32', 'null,110.png,111.png,112.png');
INSERT INTO `goods_images` VALUES ('52', '33', 'null,114.png,115.png,116.png');
INSERT INTO `goods_images` VALUES ('53', '34', 'null,118.png,119.png,120.png');
INSERT INTO `goods_images` VALUES ('54', '35', 'null,122.png,123.png,124.png');
INSERT INTO `goods_images` VALUES ('55', '36', 'null,126.png,127.png,128.png');
INSERT INTO `goods_images` VALUES ('56', '37', 'null,130.png,131.png,132.png');
INSERT INTO `goods_images` VALUES ('57', '38', 'null,134.png,135.png,136.png');
INSERT INTO `goods_images` VALUES ('58', '39', 'null,138.png,139.png,140.png');
INSERT INTO `goods_images` VALUES ('59', '40', 'null,142.png,143.png,144.png');
INSERT INTO `goods_images` VALUES ('60', '41', 'null,146.png,147.png,148.png');
INSERT INTO `goods_images` VALUES ('61', '42', 'null,150.png,151.png,152.png');
INSERT INTO `goods_images` VALUES ('62', '43', 'null,154.png,155.png,156.png');
INSERT INTO `goods_images` VALUES ('63', '44', 'null,158.png,159.png,160.png');
INSERT INTO `goods_images` VALUES ('64', '45', 'null,161.png,161.png,161.png');
INSERT INTO `goods_images` VALUES ('65', '46', 'null,162.png,162.png,162.png');
INSERT INTO `goods_images` VALUES ('66', '47', 'null,163.png,163.png,163.png');
INSERT INTO `goods_images` VALUES ('67', '48', 'null,163.png,163.png,163.png');
INSERT INTO `goods_images` VALUES ('68', '49', 'null,164.png,164.png,164.png');
INSERT INTO `goods_images` VALUES ('69', '50', 'null,165.png,165.png,165.png');
INSERT INTO `goods_images` VALUES ('70', '51', 'null,166.png,166.png,166.png');
INSERT INTO `goods_images` VALUES ('71', '52', 'null,167.png,167.png,167.png');
INSERT INTO `goods_images` VALUES ('72', '53', 'null,168.png,168.png,168.png');
INSERT INTO `goods_images` VALUES ('73', '54', 'null,169.png,169.png,169.png');
INSERT INTO `goods_images` VALUES ('74', '55', 'null,170.png,170.png,170.png');
INSERT INTO `goods_images` VALUES ('75', '56', 'null,171.png,171.png,171.png');
INSERT INTO `goods_images` VALUES ('76', '57', 'null,172.png,172.png,172.png');
INSERT INTO `goods_images` VALUES ('77', '58', 'null,173.png,173.png,173.png');
INSERT INTO `goods_images` VALUES ('78', '59', 'null,174.png,174.png,174.png');
INSERT INTO `goods_images` VALUES ('79', '60', 'null,175.png,176.png,177.png');
INSERT INTO `goods_images` VALUES ('80', '61', 'null,179.png,180.png,181.png');
INSERT INTO `goods_images` VALUES ('81', '62', 'null,183.png,184.png,185.png');
INSERT INTO `goods_images` VALUES ('82', '63', 'null,187.png,188.png,189.png');
INSERT INTO `goods_images` VALUES ('83', '64', 'null,190.png,191.png,191.png');
INSERT INTO `goods_images` VALUES ('84', '65', 'null,194.png,195.png,196.png');
INSERT INTO `goods_images` VALUES ('85', '66', 'null,199.png,198.png,200.png');
INSERT INTO `goods_images` VALUES ('86', '67', 'null,201.png,202.png,203.png');
INSERT INTO `goods_images` VALUES ('87', '68', 'null,205.png,206.png,207.png');
INSERT INTO `goods_images` VALUES ('88', '69', 'null,209.png,210.png,207.png');
INSERT INTO `goods_images` VALUES ('89', '70', 'null,212.png,213.png,214.png');
INSERT INTO `goods_images` VALUES ('90', '71', 'null,216.png,217.png,218.png');
INSERT INTO `goods_images` VALUES ('91', '72', 'null,220.png,221.png,222.png');
INSERT INTO `goods_images` VALUES ('92', '73', 'null,224.png,225.png,226.png');
INSERT INTO `goods_images` VALUES ('93', '74', 'null,228.png,229.png,230.png');
INSERT INTO `goods_images` VALUES ('94', '75', 'null,008.png,231png.png,232.png');
INSERT INTO `goods_images` VALUES ('95', '76', 'null,232.png,233.png,008.png');
INSERT INTO `goods_images` VALUES ('96', '77', 'null,235.png,234.png,235.png');
INSERT INTO `goods_images` VALUES ('97', '78', 'null,236.png,237.png,238.png');
INSERT INTO `goods_images` VALUES ('98', '79', 'null,242.png,240.png,241.png');
INSERT INTO `goods_images` VALUES ('99', '80', 'null,244.png,245.png,246.png');
INSERT INTO `goods_images` VALUES ('100', '81', 'null,248.png,249.png,250.png');
INSERT INTO `goods_images` VALUES ('101', '82', 'null,252.png,253.png,254.png');
INSERT INTO `goods_images` VALUES ('102', '83', 'null,256.png,257.png,258.png');
INSERT INTO `goods_images` VALUES ('103', '84', 'null,260.png,261.png,262.png');
INSERT INTO `goods_images` VALUES ('104', '85', 'null,264.png,265.png,266.png');
INSERT INTO `goods_images` VALUES ('105', '86', 'null,267.png,268.png,270.png');
INSERT INTO `goods_images` VALUES ('106', '87', 'null,272.png,273.png,274.png');
INSERT INTO `goods_images` VALUES ('107', '88', 'null,276.png,277.png,278.png');
INSERT INTO `goods_images` VALUES ('108', '89', 'null,280.png,281.png,282.png');
INSERT INTO `goods_images` VALUES ('109', '90', 'null,284.png,285.png,286.png');
INSERT INTO `goods_images` VALUES ('110', '91', 'null,288.png,289.png,290.png');
INSERT INTO `goods_images` VALUES ('111', '92', 'null,292.png,293.png,294.png');
INSERT INTO `goods_images` VALUES ('112', '93', 'null,300.png,301.png,302.png');
INSERT INTO `goods_images` VALUES ('113', '94', 'null,305.png,306.png,307.png');
INSERT INTO `goods_images` VALUES ('114', '95', 'null,308.png,310.png,311.png');
INSERT INTO `goods_images` VALUES ('115', '96', 'null,313.png,314.png,315.png');

-- ----------------------------
-- Table structure for `g_order`
-- ----------------------------
DROP TABLE IF EXISTS `g_order`;
CREATE TABLE `g_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `orderserial` varchar(50) NOT NULL,
  `order_goods_num` int(5) NOT NULL,
  `order_total_price` float(10,2) NOT NULL,
  `ordertime` datetime NOT NULL,
  `u_id` int(11) NOT NULL,
  `add_id` int(11) NOT NULL,
  `orderstate` int(1) NOT NULL DEFAULT '1',
  `order_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `orderserial` (`orderserial`) USING BTREE,
  KEY `u_id` (`u_id`) USING BTREE,
  KEY `add_id` (`add_id`) USING BTREE,
  CONSTRAINT `order_fk_add_id` FOREIGN KEY (`add_id`) REFERENCES `address` (`add_id`),
  CONSTRAINT `order_fk_u_id` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_order
-- ----------------------------
INSERT INTO `g_order` VALUES ('1', ' 2018-03-23 15:59:4910', '2', '2248.00', '2018-03-23 15:59:49', '10', '1', '1', '1');
INSERT INTO `g_order` VALUES ('2', ' 2018-03-23 16:00:5210', '1', '596.00', '2018-03-23 16:00:52', '10', '1', '1', '1');
INSERT INTO `g_order` VALUES ('3', ' 2018-03-23 16:10:0910', '1', '1404.00', '2018-03-23 16:10:09', '10', '1', '1', '1');
INSERT INTO `g_order` VALUES ('4', ' 2018-03-24 11:12:5710', '1', '468.00', '2018-03-24 11:12:57', '10', '3', '1', '1');
INSERT INTO `g_order` VALUES ('5', ' 2018-03-24 11:15:5710', '1', '206.00', '2018-03-24 11:15:57', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('6', ' 2018-03-24 11:37:1910', '2', '880.00', '2018-03-24 11:37:19', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('7', ' 2018-03-24 11:48:4910', '2', '880.00', '2018-03-24 11:48:49', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('8', ' 2018-03-24 11:49:4310', '2', '866.00', '2018-03-24 11:49:43', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('9', ' 2018-03-24 11:50:5510', '2', '674.00', '2018-03-24 11:50:55', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('10', ' 2018-03-24 11:52:0310', '2', '674.00', '2018-03-24 11:52:03', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('11', ' 2018-03-24 11:58:0310', '2', '674.00', '2018-03-24 11:58:03', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('12', ' 2018-03-24 12:08:4610', '2', '674.00', '2018-03-24 12:08:46', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('13', ' 2018-03-24 12:09:0810', '1', '468.00', '2018-03-24 12:09:08', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('14', ' 2018-03-24 12:12:2810', '1', '468.00', '2018-03-24 12:12:28', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('15', ' 2018-03-24 12:17:2010', '1', '468.00', '2018-03-24 12:17:20', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('16', ' 2018-03-24 12:17:4310', '1', '468.00', '2018-03-24 12:17:43', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('17', ' 2018-03-24 12:55:5210', '1', '936.00', '2018-03-24 12:55:52', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('18', ' 2018-03-24 13:00:1510', '2', '1142.00', '2018-03-24 13:00:15', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('19', ' 2018-03-25 15:54:1410', '2', '674.00', '2018-03-25 15:54:14', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('20', ' 2018-03-25 16:05:3310', '1', '328.00', '2018-03-25 16:05:33', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('21', ' 2018-03-25 16:21:2010', '1', '328.00', '2018-03-25 16:21:20', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('22', ' 2018-03-25 17:34:5010', '1', '468.00', '2018-03-25 17:34:50', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('23', ' 2018-03-25 17:37:1110', '1', '206.00', '2018-03-25 17:37:11', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('24', ' 2018-03-25 17:39:2710', '1', '468.00', '2018-03-25 17:39:27', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('25', ' 2018-03-25 17:40:3110', '1', '468.00', '2018-03-25 17:40:31', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('26', ' 2018-03-25 17:40:4510', '1', '206.00', '2018-03-25 17:40:45', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('27', ' 2018-03-25 17:41:2410', '1', '206.00', '2018-03-25 17:41:24', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('28', ' 2018-03-25 17:47:0910', '1', '206.00', '2018-03-25 17:47:09', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('29', ' 2018-03-25 17:49:0110', '1', '206.00', '2018-03-25 17:49:01', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('30', ' 2018-03-25 17:51:1610', '1', '468.00', '2018-03-25 17:51:16', '10', '4', '3', '1');
INSERT INTO `g_order` VALUES ('31', ' 2018-03-25 17:52:4510', '1', '206.00', '2018-03-25 17:52:45', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('32', ' 2018-03-25 17:55:4710', '1', '206.00', '2018-03-25 17:55:47', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('33', ' 2018-03-25 18:30:5110', '1', '468.00', '2018-03-25 18:30:51', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('34', ' 2018-03-25 18:50:2010', '1', '936.00', '2018-03-25 18:50:20', '10', '4', '4', '1');
INSERT INTO `g_order` VALUES ('35', ' 2018-03-25 18:53:3610', '1', '206.00', '2018-03-25 18:53:36', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('36', ' 2018-03-25 18:54:1310', '1', '206.00', '2018-03-25 18:54:13', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('37', ' 2018-03-25 18:54:2110', '1', '206.00', '2018-03-25 18:54:21', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('38', ' 2018-03-25 18:54:4310', '1', '206.00', '2018-03-25 18:54:43', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('39', ' 2018-03-25 18:55:3010', '1', '206.00', '2018-03-25 18:55:30', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('40', ' 2018-03-25 21:23:1910', '2', '574.00', '2018-03-25 21:23:19', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('41', ' 2018-03-25 21:24:2010', '2', '574.00', '2018-03-25 21:24:20', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('42', ' 2018-03-25 21:25:3910', '2', '677.00', '2018-03-25 21:25:39', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('43', ' 2018-03-25 21:25:5510', '2', '677.00', '2018-03-25 21:25:55', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('44', ' 2018-03-25 21:26:2210', '1', '368.00', '2018-03-25 21:26:22', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('45', ' 2018-03-25 21:31:4010', '1', '206.00', '2018-03-25 21:31:40', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('46', ' 2018-03-25 21:32:2910', '1', '468.00', '2018-03-25 21:32:29', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('47', ' 2018-03-25 21:39:3510', '1', '209.00', '2018-03-25 21:39:35', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('48', ' 2018-03-25 21:43:4610', '1', '468.00', '2018-03-25 21:43:46', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('49', ' 2018-03-25 21:46:1510', '1', '468.00', '2018-03-25 21:46:15', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('50', ' 2018-03-25 21:46:4210', '1', '468.00', '2018-03-25 21:46:42', '10', '4', '4', '1');
INSERT INTO `g_order` VALUES ('51', ' 2018-03-27 16:57:0610', '1', '736.00', '2018-03-27 16:57:06', '10', '4', '1', '1');
INSERT INTO `g_order` VALUES ('52', ' 2018-03-27 16:57:2910', '1', '736.00', '2018-03-27 16:57:29', '10', '4', '2', '1');
INSERT INTO `g_order` VALUES ('53', ' 2018-04-01 13:00:0010', '10', '736.00', '2018-04-01 13:00:00', '10', '4', '1', '1');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(20) NOT NULL,
  `m_password` varchar(20) NOT NULL,
  `role` int(1) DEFAULT NULL,
  `m_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`m_id`),
  UNIQUE KEY `m_name` (`m_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1001', 'admin', 'admin123', '1', '1');
INSERT INTO `manager` VALUES ('2001', 'Scott', 'Nitali100', '2', '1');
INSERT INTO `manager` VALUES ('2002', 'Taylor', 'TaylorSwift123', '1', '1');
INSERT INTO `manager` VALUES ('2003', 'Adele', 'Adelenumber1', '2', '0');
INSERT INTO `manager` VALUES ('2004', 'Molly', 'Molly123456', '1', '1');
INSERT INTO `manager` VALUES ('2005', 'Angela', 'Angela123456', '1', '1');
INSERT INTO `manager` VALUES ('2006', 'Kitty', 'Kitty520', '2', '0');
INSERT INTO `manager` VALUES ('2007', 'Micheal', 'Micheal123', '2', '1');

-- ----------------------------
-- Table structure for `order_goods_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_info`;
CREATE TABLE `order_goods_info` (
  `ord_g_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `goods_num` int(5) NOT NULL,
  `g_id` int(11) NOT NULL,
  `g_name` varchar(30) DEFAULT NULL,
  `g_price` double(10,2) NOT NULL,
  `ord_g_info_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ord_g_info_id`),
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `g_id` (`g_id`) USING BTREE,
  CONSTRAINT `o_g_fk_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `o_g_fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `g_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods_info
-- ----------------------------
INSERT INTO `order_goods_info` VALUES ('1', '1', '6', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('2', '1', '15', '93', '甜美公主', '328.00', '1');
INSERT INTO `order_goods_info` VALUES ('3', '2', '9', '90', '最相思----永生花盒', '298.00', '1');
INSERT INTO `order_goods_info` VALUES ('4', '3', '100', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('5', '4', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('6', '5', '10', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('7', '6', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('8', '6', '0', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('9', '8', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('10', '8', '19', '92', '爱在心头', '398.00', '1');
INSERT INTO `order_goods_info` VALUES ('11', '9', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('12', '9', '0', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('13', '10', '0', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('14', '10', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('15', '11', '0', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('16', '11', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('17', '13', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('18', '14', '0', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('19', '15', '10', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('20', '17', '2', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('21', '18', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('22', '18', '2', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('23', '19', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('24', '19', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('25', '20', '1', '93', '甜美公主', '328.00', '1');
INSERT INTO `order_goods_info` VALUES ('26', '21', '1', '89', '维也纳深林', '328.00', '1');
INSERT INTO `order_goods_info` VALUES ('27', '22', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('28', '23', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('29', '24', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('30', '26', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('31', '27', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('32', '28', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('33', '29', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('34', '30', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('35', '31', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('36', '32', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('37', '33', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('38', '34', '2', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('39', '35', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('40', '38', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('41', '39', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('42', '40', '1', '95', '和青春跳舞', '368.00', '1');
INSERT INTO `order_goods_info` VALUES ('43', '40', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('44', '41', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('45', '41', '1', '95', '和青春跳舞', '368.00', '1');
INSERT INTO `order_goods_info` VALUES ('46', '42', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('47', '42', '1', '96', '浪漫满屋', '209.00', '1');
INSERT INTO `order_goods_info` VALUES ('48', '44', '1', '95', '和青春跳舞', '368.00', '1');
INSERT INTO `order_goods_info` VALUES ('49', '45', '1', '94', '燃梦', '206.00', '1');
INSERT INTO `order_goods_info` VALUES ('50', '46', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('51', '47', '1', '96', '浪漫满屋', '209.00', '1');
INSERT INTO `order_goods_info` VALUES ('52', '48', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('53', '49', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('54', '50', '1', '91', '深海秘境', '468.00', '1');
INSERT INTO `order_goods_info` VALUES ('55', '51', '2', '95', '和青春跳舞', '368.00', '1');

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `review_time` datetime NOT NULL,
  `content` varchar(300) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  `r_del` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`r_id`),
  KEY `g_id` (`g_id`) USING BTREE,
  KEY `u_id` (`u_id`) USING BTREE,
  CONSTRAINT `review_fk_g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `review_fk_u_id` FOREIGN KEY (`u_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) NOT NULL,
  `u_password` varchar(100) NOT NULL,
  `u_img` varchar(100) DEFAULT NULL,
  `u_realname` varchar(32) DEFAULT NULL,
  `u_idcard` varchar(18) DEFAULT NULL,
  `u_sex` int(1) DEFAULT '1',
  `u_residence` varchar(100) DEFAULT NULL,
  `u_birthday` date DEFAULT NULL,
  `u_phone` varchar(11) NOT NULL,
  `u_info` varchar(140) DEFAULT NULL,
  `u_state` int(2) DEFAULT '1' COMMENT '1：正常   2：异常   3：停用',
  `regist_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `regist_IP` varchar(15) DEFAULT NULL,
  `login_IP` varchar(15) DEFAULT NULL,
  `u_del` int(1) DEFAULT '1',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_name` (`u_name`) USING BTREE,
  UNIQUE KEY `u_phone` (`u_phone`) USING BTREE,
  UNIQUE KEY `u_idcard` (`u_idcard`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'susu', '123456', 'user001.jpg', 'Jessie', '140622199701010056', '0', null, '1997-12-12', '15735104190', 'pink', '1', '2018-01-25 11:50:30', '2018-02-28 11:50:34', '127.0.0.1', '127.0.0.1', '1');
INSERT INTO `user` VALUES ('2', 'Bella', '123456', 'user001.jpg', 'Bella', '140602200018790102', '0', null, null, '15735104158', 'blue', '1', '2018-02-06 11:52:20', '2018-02-22 11:52:25', '127.0.0.1', '127.0.0.1', '1');
INSERT INTO `user` VALUES ('4', 'Brian Ardley', '123456', null, null, null, '1', null, null, '15735104156', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('5', 'Peppa', '123456', null, null, null, '1', null, null, '15735104155', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('10', 'Jasper', '4a9838394451cd8f8c7d2d125c419795', 'user001.jpg', '苏苏', '14622199801010123', '0', null, '2011-01-07', '15735104157', '', '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('11', 'Daniel', 'e1aadc3949ba59abbe56e057f2ff883e', null, null, null, '1', null, null, '15735104153', null, '1', null, null, null, null, '0');
INSERT INTO `user` VALUES ('12', 'Alex', '123456', null, null, null, '1', null, null, '15735104152', null, '1', null, null, null, null, '0');
INSERT INTO `user` VALUES ('13', 'Alexa', '123456', null, null, null, '1', null, null, '15735104151', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('14', 'Aaron', '123456', null, null, null, '1', null, null, '15735194150', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('15', 'Adam', '123456', null, null, null, '1', null, null, '15735104149', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('16', 'Albert', '123456', null, null, null, '1', null, null, '15735104148', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('17', 'Andy', '123456', null, null, null, '1', null, null, '15735104147', null, '1', null, null, null, null, '1');
INSERT INTO `user` VALUES ('22', 'nitali', 'bca94c36a9284aafea4d8f21ebe95ef2', null, null, null, '1', null, null, '15234024635', null, '1', null, null, null, null, '1');

-- ----------------------------
-- View structure for `v_cart`
-- ----------------------------
DROP VIEW IF EXISTS `v_cart`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_cart` AS select `user`.`u_id` AS `u_id`,`user`.`u_name` AS `u_name`,`cart`.`c_id` AS `c_id`,`cart`.`g_id` AS `g_id`,`goods`.`g_name` AS `g_name`,`goods`.`g_info` AS `g_info`,`goods`.`goods_price` AS `goods_price`,`cart`.`goods_amount` AS `goods_amount`,`goods`.`g_imgurl` AS `g_imgurl`,`goods`.`amount` AS `amount` from ((`cart` left join `user` on((`user`.`u_id` = `cart`.`u_id`))) left join `goods` on((`cart`.`g_id` = `goods`.`g_id`))) ;

-- ----------------------------
-- View structure for `v_order_goods`
-- ----------------------------
DROP VIEW IF EXISTS `v_order_goods`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_order_goods` AS select `order_goods_info`.`ord_g_info_id` AS `ord_g_info_id`,`order_goods_info`.`order_id` AS `order_id`,`order_goods_info`.`goods_num` AS `goods_num`,`order_goods_info`.`g_id` AS `g_id`,`order_goods_info`.`g_name` AS `g_name`,`order_goods_info`.`g_price` AS `g_price`,`order_goods_info`.`ord_g_info_del` AS `ord_g_info_del`,`goods`.`g_imgurl` AS `g_imgurl` from (`order_goods_info` left join `goods` on((`order_goods_info`.`g_id` = `goods`.`g_id`))) ;

-- ----------------------------
-- View structure for `v_order_user_address`
-- ----------------------------
DROP VIEW IF EXISTS `v_order_user_address`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_order_user_address` AS select `g_order`.`order_id` AS `order_id`,`g_order`.`orderserial` AS `orderserial`,`g_order`.`u_id` AS `u_id`,`user`.`u_name` AS `u_name`,`g_order`.`order_goods_num` AS `order_goods_num`,`g_order`.`order_total_price` AS `order_total_price`,`g_order`.`ordertime` AS `ordertime`,`address`.`consignee_name` AS `consignee_name`,`address`.`consignee_tel` AS `consignee_tel`,`address`.`address` AS `address`,`g_order`.`orderstate` AS `orderstate`,`g_order`.`order_del` AS `order_del` from ((`g_order` left join `user` on((`user`.`u_id` = `g_order`.`u_id`))) left join `address` on((`g_order`.`add_id` = `address`.`add_id`))) ;

-- ----------------------------
-- View structure for `v_salesrank`
-- ----------------------------
DROP VIEW IF EXISTS `v_salesrank`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_salesrank` AS (select `order_goods_info`.`g_id` AS `g_id`,`order_goods_info`.`g_name` AS `g_name`,sum(`order_goods_info`.`goods_num`) AS `total_num` from `order_goods_info` group by `order_goods_info`.`g_name` order by sum(`order_goods_info`.`goods_num`) desc limit 5) ;

-- ----------------------------
-- View structure for `v_total_price`
-- ----------------------------
DROP VIEW IF EXISTS `v_total_price`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_total_price` AS (select `order_goods_info`.`g_id` AS `g_id`,`order_goods_info`.`g_name` AS `g_name`,sum((`order_goods_info`.`goods_num` * `order_goods_info`.`g_price`)) AS `total_price` from `order_goods_info` group by `order_goods_info`.`g_name` order by sum((`order_goods_info`.`goods_num` * `order_goods_info`.`g_price`)) desc limit 8) ;
