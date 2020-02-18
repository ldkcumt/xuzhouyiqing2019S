/*
Navicat MySQL Data Transfer

Source Server         : 疫情数据库
Source Server Version : 50724
Source Host           : 139.129.23.185:3306
Source Database       : XZYQ

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-02-17 11:20:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for epidemic_situation
-- ----------------------------
DROP TABLE IF EXISTS `epidemic_situation`;
CREATE TABLE `epidemic_situation` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `details` varchar(500) DEFAULT NULL,
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend4` varchar(255) DEFAULT NULL,
  `extend5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epidemic_situation
-- ----------------------------
INSERT INTO `epidemic_situation` VALUES ('1', '病毒', 'SARS-CoV-2，其导致疾病命名 COVID-19', null, null, null, null);
INSERT INTO `epidemic_situation` VALUES ('2', '传染源', '新冠肺炎的患者。无症状感染者也可能成为传染源。', null, null, null, null);
INSERT INTO `epidemic_situation` VALUES ('3', '传播途径', '经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。', null, null, null, null);
INSERT INTO `epidemic_situation` VALUES ('4', '易感人群', '人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病。', null, null, null, null);
INSERT INTO `epidemic_situation` VALUES ('5', '潜伏期', '一般为 3～7 天，绝大多数不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见。', null, null, null, null);
INSERT INTO `epidemic_situation` VALUES ('6', '宿主', '野生动物，可能为中华菊头蝠。', null, null, null, null);

-- ----------------------------
-- Table structure for xz_epidemic_situation
-- ----------------------------
DROP TABLE IF EXISTS `xz_epidemic_situation`;
CREATE TABLE `xz_epidemic_situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(20) DEFAULT NULL COMMENT '区域',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `confirm` int(10) DEFAULT NULL COMMENT '确诊',
  `dead` int(10) DEFAULT NULL COMMENT '死亡',
  `heal` int(10) DEFAULT NULL COMMENT '治愈',
  `suspect` int(10) DEFAULT NULL COMMENT '疑似',
  `confirm_add` int(10) DEFAULT '0',
  `dead_add` int(10) DEFAULT '0',
  `heal_add` int(10) DEFAULT '0',
  `suspect_add` int(10) DEFAULT '0',
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  `extend4` varchar(255) DEFAULT NULL,
  `extend5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='徐州疫情';

-- ----------------------------
-- Records of xz_epidemic_situation
-- ----------------------------
INSERT INTO `xz_epidemic_situation` VALUES ('1', '徐州', '2020-01-28', '8', '0', '0', '0', '0', '0', '0', '0', '2020-01-28 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('2', '徐州', '2020-01-29', '8', '0', '0', '0', '0', '0', '0', '0', '2020-01-29 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('3', '徐州', '2020-01-30', '15', '0', '0', '0', '7', '0', '0', '0', '2020-01-30 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('4', '徐州', '2020-01-31', '20', '0', '0', '0', '5', '0', '0', '0', '2020-01-30 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('5', '徐州', '2020-02-01', '23', '0', '0', '0', '3', '0', '0', '0', '2020-02-01 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('6', '徐州', '2020-02-02', '30', '0', '0', '0', '7', '0', '0', '0', '2020-02-02 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('7', '徐州', '2020-02-03', '36', '0', '0', '0', '6', '0', '0', '0', '2020-02-03 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('8', '徐州', '2020-02-04', '39', '0', '0', '0', '3', '0', '0', '0', '2020-02-04 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('9', '徐州', '2020-02-05', '45', '0', '1', '0', '6', '0', '1', '0', '2020-02-05 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('10', '徐州', '2020-02-06', '45', '0', '3', '0', '0', '0', '2', '0', '2020-02-06 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('11', '徐州', '2020-02-07', '49', '0', '3', '0', '4', '0', '0', '0', '2020-02-07 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('12', '徐州', '2020-02-08', '52', '0', '3', '0', '3', '0', '0', '0', '2020-02-08 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('13', '徐州', '2020-02-09', '56', '0', '8', '0', '4', '0', '5', '0', '2020-02-09 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('14', '徐州', '2020-02-10', '60', '0', '8', '0', '4', '0', '0', '0', '2020-02-10 23:59:59', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('17', '徐州', '2020-02-11', '63', '0', '10', '0', '3', '0', '2', '0', '2020-02-11 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('18', '徐州', '2020-02-12', '66', '0', '10', '0', '3', '0', '0', '0', '2020-02-12 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('19', '徐州', '2020-02-13', '71', '0', '16', '0', '5', '0', '6', '0', '2020-02-13 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('20', '徐州', '2020-02-14', '76', '0', '17', '0', '5', '0', '1', '0', '2020-02-14 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('21', '徐州', '2020-02-15', '77', '0', '20', '0', '1', '0', '3', '0', '2020-02-15 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('22', '徐州', '2020-02-16', '78', '0', '23', '0', '1', '0', '3', '0', '2020-02-16 23:50:00', null, null, null, null, null);
INSERT INTO `xz_epidemic_situation` VALUES ('23', '徐州', '2020-02-17', '79', '0', '28', '0', '1', '0', '5', '0', '2020-02-17 11:20:00', null, null, null, null, null);

-- ----------------------------
-- Table structure for xz_patient
-- ----------------------------
DROP TABLE IF EXISTS `xz_patient`;
CREATE TABLE `xz_patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `addr` varchar(500) DEFAULT NULL,
  `details` varchar(500) DEFAULT NULL,
  `longitude` decimal(12,9) DEFAULT NULL,
  `latitude` decimal(12,9) DEFAULT NULL,
  `height` decimal(12,9) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  `extend4` varchar(255) DEFAULT NULL,
  `extend5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xz_patient
-- ----------------------------
INSERT INTO `xz_patient` VALUES ('1', '邓某某', '男', '39', '睢宁县睢城镇星河湾', '', '117.965132000', '33.888897000', null, '2020-02-12 16:09:08', '2020-02-12 16:26:02', null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('2', '王某某', '男', '50', '睢宁县邱集镇大主村', '确诊病例的密切接触者。1月22日18时许在兴美广场4楼就餐，1月23日—29日期间正常上下班。1月30日被隔离治疗。2月10日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '118.041366000', '33.819656000', null, '2020-02-11 10:40:04', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('3', '李某某', '男', '43', '邳州市建设南路蔬菜公司宿舍北楼', '确诊病例的密切接触者。1月22日中午曾在邳州市锦华大酒店就餐。1月23日上午10时许在乐辉超市购物，1月24日—25日居家未外出。1月26日被隔离治疗。2月10日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.959590000', '34.314664000', null, '2020-02-11 10:42:13', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('4', '张某某', '女', '46', '云龙区骆驼山街道世贸天观', '确诊病例密切接触者。1月20日-21日9时许乘坐608路公交车到东店子，转25路到徐矿一院呼吸科探望住院家人，停留1小时后，坐25路转608公交车回家。1月25日出现发热症状，1月26日-28日每天8时至11时左右在东苑社区卫生服务中心输液，1月28日15时-16时去七十一集团军医院（原九七医院）发热门诊就诊。1月29日14时—16许和1月30日10时至13时许曾在东苑社区卫生服务中心输液。1月30日15:30左右到大黄山矿务局第一医院就诊后被收治入院。2月9日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.214399000', '34.241631000', null, '2020-02-10 10:43:23', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('5', '谢某某', '男', '51', '泉山区山语世家商住楼', '浙江省绍兴人，1月23日乘坐K1624（5车22号中铺）从武汉于凌晨2：40到达徐州火车站，2：50乘坐出租车（苏CE0333）回家；1月24日—29日居家未外出；1月30日乘私家车前往市中心医院，8时许在该院急诊科量体温后回家；1月31日-2月5日居家未外出；2月6日10时-11时许在徐医附院东院发热门诊就诊，16时再次到徐医附院就诊被隔离收治。2月9日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.172408000', '34.214812000', null, '2020-02-10 10:44:11', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('6', '贾某某', '男', '80', '睢宁县锦绣华庭', '确诊病例的密切接触者。1月21日-2月1日曾在睢宁县中医院呼吸科住院治疗，2月2日—6日均居家未外出。2月7日21时被隔离治疗。2月9日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.946639000', '33.896962000', null, '2020-02-10 10:45:06', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('7', '赵某某', '男', '50', '睢宁县睢城镇东方花园', '确诊病例的密切接触者。1月23日—27日，曾至睢宁县中医院探视病人，1月31日被隔离治疗。2月9日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.963367000', '33.903254000', null, '2020-02-10 10:45:46', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('8', '张某', '女', '46', '睢宁县睢城镇东方花园', '确诊病例的密切接触者。1月23日—27日上午，曾到睢宁县中医院看望家人，25日到睢宁东方花园附近农贸市场购物，27日15时许在睢宁农村商业银行天虹支行办理业务，31日该患者被隔离治疗。2月8日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.963367000', '33.903255000', null, '2020-02-09 11:03:58', '2020-02-12 11:03:58', null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('9', '王某', '女', '28', '睢宁县睢城镇奥体清华苑', '确诊病例的密切接触者。1月22日12时—14时曾在睢宁鸿发饭店就餐，18时许曾到天虹大道北康家药店购药，22时许到旭旺超市购物。1月23日11时曾到达铂丽百货店购物，11时40分左右到奥体清华苑北加油站为其私家车加油。1月25日晚19时40分曾到万象天地活动，21时许到睢宁县人民医院急诊牙科就诊。26日-29日正常上下班。1月30日被隔离治疗。2月8日确诊为新型冠状病毒感染肺炎，现在定点医疗机构隔离治疗。', '117.962247000', '33.919006000', null, '2020-02-09 11:03:58', '2020-02-12 11:03:58', null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('10', '刘某某', '女', '31', '睢宁县睢城镇瑞凯国际', '确诊病例的密切接触者。1月24日上午9—11时曾陪家人去新沂人民医院儿科就诊。25日12-13时曾去蓝鲸湾浴室。1月27日10时左右到鲜果优速水果店购物。28日18时曾朱淑红面皮店购物。29日17时左右曾到万家惠超市、鲜果优速水果店购买水果。1月30日被隔离治疗。2月8日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.959218000', '33.913301000', null, '2020-02-09 11:03:59', '2020-02-12 11:03:59', null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('11', '马某某', '男', '72', '睢宁县康馨花园小区东门对面巷子（清泉浴室附近）', '确诊病例的密切接触者。1月21—2月1日期间正常上下班。2月6日19时左右到睢宁县人民医院发热门诊就诊，被隔离治疗。2月8日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.960880000', '33.904152000', null, '2020-02-09 11:06:22', '2020-02-12 11:06:22', null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('12', '翟某某', '男', '50', '云龙区世茂天观', '1月23日经郭庄路于10:40左右到达骆驼山康馨园南附近，15:30左右原路返回家中。1月24日晚21时许经郭庄路，到民怡园民富园附近，21：30左右返回家中。1月26日8时-11:30许陪家人在东苑社区卫生服务中心输液, 11:20左右到七里沟批发市场附近。11:40到铁路医院、铁路三宿舍、和平大桥附近，12:20左右到家。1月27日8:00-10:20左右陪家人在东苑社区卫生服务中心输液，其中上午9点左右在七十一军医院（原九七医院）急诊活动。下午15:15-15:50陪其家人去七十一军医院（原九七医院）发热门诊就诊。患者当日出现发热。1月28日送家人8:40-10：10左右在东苑社区卫生服务中心输液。16:40经复兴路和平路到妇幼、丰储附近又返回，17:05左右到家。1月29日下午送家人14：12-15：40许在东苑社区卫生服务中心输液。1月30日与家人10:13-12:40许在东苑社区卫生服务中心共同输液，15:40左右到大黄山矿务局第一医院就诊被收治入院，患者随同陪护。2月2日再次出现发热，在矿务局第一医院就诊并输液治疗，2月3日被隔离收治。', '117.213949000', '34.242660000', null, '2020-02-08 11:08:55', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('13', '滕某某', '女', '51', '睢宁县高作镇高南村', '该患者是此前确诊病例的密切接触者。1月19日-30日因阑尾炎住睢宁县中医院。1月30日下午在高作卫生院就诊。1月31日和2月1日每天上午8-9时间到高作卫生院输液。由其儿子滕辉骑电动车往返。2月2日发烧，2月3日下午被救护车接到定点医院隔离治疗。', '118.039184000', '33.905146000', null, '2020-02-08 11:08:56', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('14', '赵某某', '男', '60', '睢宁县胡集村赵西组', '该患者是此前确诊病例的密切接触者。1月26日赵某某骑车前往胡集街采购，在“二跃五金”门市和胡集街买菜。1月27日患者陪家人去安徽省灵璧县高楼镇青谷堆刘峰诊所输液，之后到该镇青谷堆超市购物。1月29日作为位某某的密切接触者被隔离医学观察。', '117.718356000', '33.899617000', null, '2020-02-08 11:08:57', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('15', '崔某某', '女', '33', '睢宁县天华小区', '患者为确诊疫情密切接触者，1月28号在家中出现发烧症状，1月29日上午入院治疗，当日进行隔离医学治疗。', '117.975984000', '33.902191000', null, '2020-02-07 11:08:58', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('16', '陈某', '男', '33', '云龙区美的翰城', '患者曾居住安徽蚌埠市，1月25日晚乘火车K738次17车68座到达徐州站，乘坐出租车回家。1月26日—28日患者每天到高铁站维修班上班。1月28日中午出现发热、乏力等不适症状，于当日和2月1日到市中心医院（新城区分院）就诊。1月29日-2月2日（除1月31日外）到蝶梦社区诊所输液。2月4日再次到市中心医院（新城区分院）就诊，被隔离治疗。', '117.301392000', '34.208441000', null, '2020-02-07 11:22:00', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('17', '陈某某', '女', '47', '邳州市水杉御景小区', '1月24日从武汉乘私家车返邳州（同行者中有确诊病例柳某某），25日凌晨到达邳州市家中。1月25日—2月4日上午，居家未外出，后被集中隔离医学观察。目前隔离收治于市定点医院，病情稳定。', '117.969196000', '34.339888000', null, '2020-02-07 11:22:00', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('18', '仝某某', '女', '67', '睢宁县睢城街道帝壹城', '患者于1月30日作为密切接触者被隔离，目前隔离收治于市定点医院，病情危重。', '117.971051000', '33.899074000', null, '2020-02-07 11:22:01', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('19', '赵某某', '女', '55', '徐州市邳州市', '1月26日由丈夫潘某某驾车送患者至睢宁县中医院照料其母亲。1月27日下午，潘某某驾车将其接回邳州家中。1月28日在家未外出。1月29日发烧，其子潘某出门为其买药。1月31日，赵某某在丈夫陪同下邳州市人民医院南院就诊。2月1日在家中被120急救车送至定点医院隔离治疗。', '118.012331000', '34.338788000', null, '2020-02-05 11:22:01', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('20', '朱某某', '男', '38', '徐州市沛县', '患者长期居住在湖北省襄阳市，1月21日自驾车从襄阳市抵达沛县家中，被告知居家隔离，1月22日—24日未外出。1月24日晚上，朱某某一家与父母、哥哥一家在患者家中聚餐。1月25日早上，朱某某与哥哥、堂兄弟共五人一起，给朱庄本村邻居拜年。1月26日至1月31日居家未外出。1月31日下午开车带妻子周某某去沛县人民医院就诊，后120将妻子周某某（已被通报确认）送至嘉华医院治疗，自己驾车回到朱庄家中。2月1日中午感觉不适，晚20点左右测量体温37.3℃，由120救护车将其送至定点医院住院隔离观察。', '116.937532000', '34.721656000', null, '2020-02-05 11:26:05', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('21', '柳某某', '男', '50', '徐州市邳州市', '1月24日从武汉乘私家车返邳州，约22时左右至邳州市八义集下高速，当即被隔离至某酒店进行医学观察。目前收治于市定点医院，目前病情稳定。', '118.012231000', '34.338688000', null, '2020-02-05 11:26:06', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('22', '温某某', '女', '32', '徐州市邳州市', '1月23日乘私家车从武汉返回邳州，1月24日11时到达邳州市港上镇南荆邑村，在家隔离至20时，后由当地政府隔离至某酒店进行医学观察。目前收治于市定点医院，目前病情稳定。', '118.012131000', '34.338888000', null, '2020-02-05 11:26:06', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('23', '鹿某某', '女', '71', '徐州市贾汪区', '是确诊病例李某某的岳母。目前收治于市定点医院，目前病情稳定。1月23日-25日，在儿子张某某家过年；1月26日上午出现发热、畏寒等症状，自行服药后居家未外出；1月27日上午至泉城花都A区东北角“群众大药房”药店买药后居家未外出；1月28日-29日几次在小区内与邻居聊天，其余时间居家休息；1月30日出现发热症状，骑车前往贾汪区人民医院发热门诊就诊，后在发热门诊病房隔离观察。', '117.466187000', '34.435506000', null, '2020-02-05 11:26:07', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('24', '董某', '女', '37', ' 徐州市邳州市', '患者1月20日一家三口驾车自武汉出发，当晚抵达邳州。21日晚在婆婆家聚餐。其它时间待在家中。系已确诊病例李某某的密切接触者，于1月26日晚被集中隔离。', '118.011531000', '34.338588000', null, '2020-02-05 11:26:08', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('25', '周某某', '女', '35', '徐州市沛县', '2月1日隔离收治于市定点医院，目前病情稳定。', '116.937232000', '34.721656000', null, '2020-02-04 11:26:08', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('26', '张某', '女', '45', '徐州市贾汪区', '1月29日隔离收治于市定点医院，目前病情稳定。', '117.465687000', '34.435506000', null, '2020-02-04 11:30:19', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('27', '范某', '男', '35', '徐州市邳州市', '2月2日隔离收治于市定点医院，目前病情稳定。', '118.012541000', '34.338868000', null, '2020-02-04 11:32:29', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('28', '杜某', '男', '26', '徐州市沛县', '31日隔离收治于市定点医院，目前病情稳定。', '116.981278000', '34.720663000', null, '2020-02-03 11:34:39', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('29', '夏某某', '女', '51', '徐州市睢宁县', '31日隔离收治于市定点医院，目前病情稳定。', '117.927658000', '33.867776000', null, '2020-02-03 11:34:39', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('30', '戈某某', '男', '54', '徐州市睢宁县', '31日隔离收治于市定点医院，目前病情稳定。', '118.062241000', '33.880033000', null, '2020-02-03 11:34:40', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('31', '仇某某', '女', '22', '徐州市睢宁县', '31日隔离收治于市定点医院，目前病情稳定。', '117.876171000', '33.882290000', null, '2020-02-03 11:34:40', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('32', '赵某某', '女', '48', '徐州市睢宁县', '31日隔离收治于市定点医院，目前病情稳定。', '117.926382000', '33.893547000', null, '2020-02-03 11:34:44', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('33', '邓某', '女', '31', '徐州市鼓楼区', '31日隔离收治于市定点医院，目前病情稳定。', '117.186720000', '34.275626000', null, '2020-02-03 11:34:45', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('34', '柳某某', '男', '51', '徐州市邳州市', '有武汉近期旅居史，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.991073000', '34.353316000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('35', '范某', '男', '35', '徐州市邳州市', '有武汉近期旅居史，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.973480000', '34.307351000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('36', '温某某', '女', '33', '徐州市邳州市', '有武汉近期旅居史，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.956485000', '34.338966000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('37', '周某某', '女', '36', '徐州市沛县', '有湖北近期旅居史，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '116.899938000', '34.721769000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('38', '鹿某某', '女', '71', '徐州市贾汪区', '为贾汪区确诊病例李某某密切接触者，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.429951000', '34.429390000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('39', '张某', '女', '42', '徐州市贾汪区', '为贾汪区确诊病例李某某密切接触者，2月1日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.476643000', '34.406732000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('40', '施某某', '男', '45', '徐州市贾汪区', '为贾汪区确诊病例薛某某的密切接触者，30日隔离收治于市定点医院，目前病情稳定。', '117.471494000', '34.406307000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('41', '薛某某', '男', '42', '徐州市贾汪区', '为贾汪区确诊病例薛某某的密切接触者，29日隔离收治于市定点医院，目前病情稳定。', '117.496728000', '34.408290000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('42', '郑某', '男', '41', '徐州市贾汪区', '为贾汪区确诊病例薛某某的密切接触者，29日隔离收治于市定点医院，目前病情稳定。', '117.500676000', '34.450059000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('43', '陈某某', '女', '24', '徐州市云龙区', '有近期武汉旅居史，30日隔离收治于市定点医院，目前病情稳定。', '117.189735000', '34.257940000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('44', '李某某', '女', '49', '徐州市云龙区', '为患者陈某某密切接触者，30日隔离收治于市定点医院，目前病情稳定。', '117.257080000', '34.250175000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('45', '魏某', '女', '21', '徐州市沛县', '为沛县确诊病例杜某的密切接触者，30日隔离收治于市定点医院，目前病情稳定。', '116.929980000', '34.732813000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('46', '包某某', '男', '40', '徐州邳州市', '有近期武汉旅居史，28日隔离收治于市定点医院，目前病情稳定。', '117.969749000', '34.342839000', null, '2020-02-02 12:37:35', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('50', '刘某某', '女', '48', '徐州市睢宁县', '1月31日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.927927000', '33.921517000', null, '2020-02-01 12:46:40', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('51', '李某某', '女', '46', '徐州市睢宁县', '1月31日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.978739000', '33.910904000', null, '2020-02-01 12:46:40', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('52', '邓某', '女', '31', '徐州市鼓楼区', '1月31日检测为新型冠状病毒阳性，目前收治于市定点医院。', '117.186823000', '34.299549000', null, '2020-02-01 12:46:40', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('53', '张某某', '男', '21', '邳州市明德小区', '有武汉旅居史，29日隔离收治于市定点医院，目前病情稳定。', '117.973383000', '34.335195000', null, '2020-02-01 12:49:14', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('54', '周某某', '男', '55', '徐州新沂市', '湖北黄石人，新沂华宏钢厂上班，有近期武汉旅居史，28日隔离收治于市定点医院，目前病情稳定。', '118.372013000', '34.371209000', null, '2020-02-01 12:49:14', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('55', '位某某', '女', '60', '徐州市睢宁县', '常住湖北，有武汉旅居史，28日隔离收治于市定点医院，目前病情稳定。', '117.988180000', '33.923724000', null, '2020-02-01 12:49:15', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('66', '赵某某', '男', '64', '徐州市睢宁县', '1月30日检测为新型冠状病毒阳性，为睢宁县待确认病例位某某的密切接触者，目前收治于市定点医院。', '117.941813000', '33.912809000', null, '2020-01-31 12:55:02', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('67', '赵某某', '女', '3', '徐州市睢宁县', '1月30日检测为新型冠状病毒阳性，为睢宁县待确认病例位某某的密切接触者，目前收治于市定点医院。', '117.941464000', '33.912894000', null, '2020-01-31 12:55:02', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('68', '李某某', '男', '41', '徐州市贾汪区大泉街泉城花都', '28日隔离收治于市定点医院，目前病情稳定。', '117.477212000', '34.442839000', null, '2020-02-12 13:20:00', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('69', '薛某某', '男', '43', '徐州市贾汪区老矿街道泉旺头村', '29日隔离收治于市定点医院，目前病情稳定。', '117.435806000', '34.446393000', null, '2020-02-12 13:20:00', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('70', '杜某', '男', '50', '沛县沛城镇梦圆小区', '29日隔离收治于市定点医院，目前病情稳定。', '116.941517000', '34.739479000', null, '2020-02-12 13:20:01', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('71', '陈某某', '女', '69', '鼓楼区西站小区', '29日隔离收治于市定点医院，目前病情稳定。', '117.186720000', '34.275626000', null, '2020-02-13 09:26:03', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('72', '徐某某', '女', '56', '丰县华山镇邢桥村王庄', '29日隔离收治于市定点医院，目前病情稳定。', '116.747965000', '34.657844000', null, '2020-02-12 13:20:04', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('73', '李某', '男', '41', '贾汪区泉城花都', '有武汉旅居史，目前隔离治疗于贾汪区定点医院。', '117.477212000', '34.442839000', null, '2020-02-12 16:13:53', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('74', '王某', '女', '57', '新沂市马陵山风景区花厅村', '有武汉旅居史，目前隔离治疗于新沂市传染病院。', '118.332593000', '34.229969000', null, '2020-02-12 16:14:53', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('75', '张某', '男', '43', '鼓楼区西站小区', '有武汉旅居史，目前隔离治疗于徐州市肿瘤医院。', '117.186720000', '34.275626000', null, '2020-02-12 16:16:36', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('76', '王某', '男', '61', '丰县华山镇邢桥村郭楼王庄', '为泉山区确诊病例王某的密切接触者，目前隔离治疗于丰县定点医院。', '116.701251000', '34.681079000', null, '2020-02-12 16:17:05', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('77', '李某', '女', '23', '睢宁县睢城镇温馨嘉苑', '为确诊病例的密切接触者。1月28日上午、29日下午到县中医院内科门诊就诊。1月29日晚被隔离治疗。2月11日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.963757000', '33.894924000', null, '2020-02-12 16:28:23', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('78', '杨某某', '女', '65', '睢宁县康馨花园小区东门对面巷子（清泉浴室附近）', '为确诊病例的密切接触者。1月23日11时许去东北小区菜市场。1月24日—28日正常骑车上下班。1月29日12时许去县人民医院消化科及食堂，短暂停留。1月30日-31日正常上下班。2月1日-2日居家未外出。2月3日17时许到县人民医院发热门诊就诊。2月4日-5日居家未外出。2月6日被隔离治疗。2月11日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.960977000', '33.902250000', null, '2020-02-12 16:28:55', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('79', '刘某', '女', '20', '睢宁县幸福家园小区', '为确诊病例的密切接触者。1月25日-29日正常骑车上下班。1月30日10时许曾至兴美广场东20米药店，晚上至中医院西百盛润家超市购物。1月30日晚被确定为密切接触者进行隔离医学观察。2月11日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.974149000', '33.917754000', null, '2020-02-12 16:29:42', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('80', '李某某', '女', '22', '睢宁县东北小区', '为确诊病例的密切接触者。1月16日17时许到宁海学校附近过桥米线店就餐。1月17日18时许到人民东路路北铁板鸭店购物。1月21日18时许在宁海学校东面的米乐购购物。1月22日17时许到康馨花园对面百盛润家超市购物，19时许到中山路OPPO专卖店买手机。1月24日9时许、25日下午在九鼎商贸城活动。1月29日16时许在八一路百盛润家超市购物。1月30日晚被隔离观察。2月12日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.961426000', '33.909721000', null, '2020-02-13 11:10:17', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('81', '李某', '女', '25', '睢宁县睢城镇睢城街道红旗小区', '为确诊病例的密切接触者。1月21日8时到八一路百盛润家超市购物。1月22日17时-19时先后到八一路林成药店、太平洋东面“好想来”零食店、户大姐土豆粉（万宁店）购物。1月24日11时许到八一路百盛润家超市购物。1月30日晚被隔离观察。2月12日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.945798000', '33.904542000', null, '2020-02-13 11:10:18', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('82', '李某', '女', '32', '睢宁县睢城镇龙城国际', '为确诊病例的密切接触者。1月21日19时-21时在沐王府浴室洗浴。1月23日20时许及26日11时许均在八一公馆旭旺超市购物。1月29日14时许在成侯花园对面的真得味百货消费。1月30日晚被隔离观察。2月12日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.941290000', '33.921729000', null, '2020-02-13 11:10:18', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('83', '赵某某', '女', '20', '睢宁县睢城镇东方花园', '为确诊病例的密切接触者。1月21日9时-16时、22日14时-17时在睢宁县太平洋购物广场。1月24日19时许在东方花园百盛润家超市购物，1月24日20时许、25日中午、26日中午及27日16时去县中医院探视家人。1月30日19时许在东方花园百盛润家超市购物。2月1日被隔离观察。2月12日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.965478000', '33.903224000', null, '2020-02-13 11:10:19', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('84', '王某某', '男', '35', '丰县华山镇邢桥村郭楼王庄', '为确诊病例的密切接触者。1月20日16时许到丰县中阳大道南五光十色灯具店。1月22日10时许在金都对面北中国石化加油站为私家车加油，后至东方春城对面“鸡汤烧饼”小吃部用餐。1月25日9时许在王庄村活动。1月26日、27日陪家人到丰县人民医院就诊。1月27日当天被隔离观察。2月12日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '116.702048000', '34.674631000', null, '2020-02-13 11:10:19', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('86', '郭某', '女', '33', '睢宁县睢城镇睢中教师公寓', '1月21日17时许到人民西路红叶小区南门西面的杜氏酒业购物。1月30日下午被隔离观察。2月13日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.963705000', '33.899258000', null, '2020-02-14 16:07:13', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('87', '赵某某', '女', '22', '睢宁县桃园镇桃园村仔仙路', '1月21日7时许乘坐苏CQ286X出租车去睢城镇上班，17时许乘坐公交车（苏C60335）返回桃园镇。1月22日乘坐同一牌号出租车上班，18时许在天虹小吃街就餐，21时许骑车去梁集镇联群村附近浴室洗浴。1月23日10时许在县二中附近黄桥烧饼店就餐，随后乘坐公交车（苏CQ6319）返回桃园镇。1月24日9时许在桃园镇供销社浴室洗浴，中午在天马装饰城东门对面的尚味居饭店就餐。1月29日10时许在桃园街汇金乐购超市购物。2月2日晚被隔离观察。2月13日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.772673000', '33.855855000', null, '2020-02-14 16:08:38', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('88', '孙某', '男', '33', '睢宁县岚山镇土山村', '1月22日自外地返回睢宁。1月27日9时许、30日9时许陪家人到县人民医院就诊。2月5日15时许自驾车送家人去徐州高铁站（本人未进站）。2月6日10时、12时许分别自驾至岚山镇医院、县人民医院发热门诊就诊。2月7日被隔离观察。2月13日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.697404000', '33.927918000', null, '2020-02-14 16:09:31', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('89', '季某', '女', '32', '睢宁县欧洲城', '1月21日18-20时乘坐私家车去百饺园饭店就餐。1月22-23日正常骑车上下班。1月26日-29日正常上下班，中间2次（1月28日20-21时，29日11-13时）去高作镇高作村活动。1月30日晚被隔离观察。2月13日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '117.963880000', '33.917020000', null, '2020-02-14 16:10:26', null, null, null, null, null, null);
INSERT INTO `xz_patient` VALUES ('90', '陶某某', '女', '31', '安徽宿州市埇桥区西关街道西关村', '上海华铁旅服公司保洁员。1月23日之前值乘武汉线路。1月29日-2月7日正常值乘，期间值乘1月29日的G420与G1569、1月30日的G1570与G419、2月3日的G420与G1569、2月4日的G1570与G419、2月7日的G419、2月8日的G420与G1569等11个车次途经徐州。2月8日20时许因在高铁上出现发热症状，21时许就近在徐州高铁站下车诊治，及时由120专用车辆送至徐医附三院隔离治疗。2月13日确诊为新型冠状病毒肺炎，现在定点医疗机构隔离治疗。', '116.960499000', '33.637173000', null, '2020-02-14 16:11:48', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for xz_region_epidemic_situation
-- ----------------------------
DROP TABLE IF EXISTS `xz_region_epidemic_situation`;
CREATE TABLE `xz_region_epidemic_situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(20) DEFAULT NULL COMMENT '区域',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `confirm` int(10) DEFAULT NULL COMMENT '确诊',
  `dead` int(10) DEFAULT NULL COMMENT '死亡',
  `heal` int(10) DEFAULT NULL COMMENT '治愈',
  `suspect` int(10) DEFAULT NULL COMMENT '疑似',
  `update_time` datetime DEFAULT NULL,
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  `extend4` varchar(255) DEFAULT NULL,
  `extend5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='徐州下级区域疫情';

-- ----------------------------
-- Records of xz_region_epidemic_situation
-- ----------------------------
INSERT INTO `xz_region_epidemic_situation` VALUES ('1', '泉山区', null, '5', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('2', '云龙区', null, '5', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('3', '鼓楼区', null, '3', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('4', '贾汪区', null, '7', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('5', '铜山区', null, '0', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('6', '睢宁县', null, '24', null, null, null, '2020-02-13 11:22:57', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('7', '邳州市', null, '15', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('8', '新沂市', null, '2', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('9', '沛县', null, '7', null, null, null, '2020-02-11 14:11:50', null, null, null, null, null);
INSERT INTO `xz_region_epidemic_situation` VALUES ('10', '丰县', null, '3', null, null, null, '2020-02-13 11:23:00', null, null, null, null, null);
