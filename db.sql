/*
 Navicat Premium Data Transfer

 Source Server         : mydatabase
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : abc

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 06/01/2022 18:22:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accountinfo
-- ----------------------------
DROP TABLE IF EXISTS `accountinfo`;
CREATE TABLE `accountinfo`  (
  `accountid` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`accountid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accountinfo
-- ----------------------------
INSERT INTO `accountinfo` VALUES (2016001, '1234567', 'admin');
INSERT INTO `accountinfo` VALUES (2016002, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016003, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016004, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016005, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016006, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016007, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016008, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016009, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016010, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016011, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016012, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016013, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016014, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016015, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016016, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016017, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016018, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016019, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016020, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016021, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016022, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016023, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016024, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016025, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016026, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016027, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016028, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016029, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016030, '1234567', 'student');
INSERT INTO `accountinfo` VALUES (2016031, '1234567', 'teacher');
INSERT INTO `accountinfo` VALUES (2016032, '1234567', 'teacher');
INSERT INTO `accountinfo` VALUES (2016033, '1234567', 'teacher');
INSERT INTO `accountinfo` VALUES (2016034, '1234567', 'teacher');
INSERT INTO `accountinfo` VALUES (2016035, '1234567', 'teacher');
INSERT INTO `accountinfo` VALUES (2016036, '2016036', 'teacher');
INSERT INTO `accountinfo` VALUES (2016037, '2016037', 'teacher');

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo`  (
  `classno` int(11) NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES (2016211, '网络工程');
INSERT INTO `classinfo` VALUES (2016230, '计算机科学与技术');
INSERT INTO `classinfo` VALUES (2016231, '计算机科学与技术');
INSERT INTO `classinfo` VALUES (2016234, '网络工程');
INSERT INTO `classinfo` VALUES (2016235, '机械工程');
INSERT INTO `classinfo` VALUES (2016455, '计算机科学与技术');
INSERT INTO `classinfo` VALUES (2016456, '机械工程');
INSERT INTO `classinfo` VALUES (2016789, '网络安全');

-- ----------------------------
-- Table structure for courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo`  (
  `courseid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `courseplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weektime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '周次(第几周到第几周上课)',
  `coursename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '星期几',
  `jieci` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节次',
  PRIMARY KEY (`courseid`, `teacherid`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE,
  INDEX `courseinfo_ibfk_1`(`teacherid`) USING BTREE,
  CONSTRAINT `courseinfo_ibfk_1` FOREIGN KEY (`teacherid`) REFERENCES `teacherinfo` (`teacherid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseinfo
-- ----------------------------
INSERT INTO `courseinfo` VALUES (1221, 2016031, '教三-339', '3-8', '网络安全技术1', '5', '3-4');
INSERT INTO `courseinfo` VALUES (1222, 2016032, '教四-201', '3-16', '数据结构', '3,5', '1-2');
INSERT INTO `courseinfo` VALUES (1223, 2016033, '教三-211', '3-16', '计算机系统结构', '4', '5-6');
INSERT INTO `courseinfo` VALUES (1224, 2016031, '教三-213', '3-16', '数据库原理', '1,3', '7-8');
INSERT INTO `courseinfo` VALUES (1225, 2016034, '教四-203', '3-16', '离散数学', '3', '1-2');
INSERT INTO `courseinfo` VALUES (1226, 2016034, '教四-303', '3-15', '嵌入式系统1', '4', '1-2');
INSERT INTO `courseinfo` VALUES (1227, 2016032, '教三-339', '9-16', '网络安全技术2', '5', '3-4');
INSERT INTO `courseinfo` VALUES (1228, 2016035, '主楼-910', '16-18', '嵌入式系统2', '5', '1-2');

-- ----------------------------
-- Table structure for studentcourse
-- ----------------------------
DROP TABLE IF EXISTS `studentcourse`;
CREATE TABLE `studentcourse`  (
  `studentid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  `score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`studentid`, `courseid`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE,
  CONSTRAINT `studentcourse_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `studentinfo` (`studentid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studentcourse_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `courseinfo` (`courseid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentcourse
-- ----------------------------
INSERT INTO `studentcourse` VALUES (2016002, 1222, 66);
INSERT INTO `studentcourse` VALUES (2016003, 1223, 78);
INSERT INTO `studentcourse` VALUES (2016004, 1224, 87);
INSERT INTO `studentcourse` VALUES (2016005, 1225, 93);
INSERT INTO `studentcourse` VALUES (2016006, 1227, 78);
INSERT INTO `studentcourse` VALUES (2016006, 1228, 34);
INSERT INTO `studentcourse` VALUES (2016007, 1222, 87);
INSERT INTO `studentcourse` VALUES (2016007, 1227, 56);
INSERT INTO `studentcourse` VALUES (2016008, 1222, 45);
INSERT INTO `studentcourse` VALUES (2016008, 1223, 93);
INSERT INTO `studentcourse` VALUES (2016009, 1223, 66);
INSERT INTO `studentcourse` VALUES (2016009, 1224, 34);
INSERT INTO `studentcourse` VALUES (2016010, 1224, 78);
INSERT INTO `studentcourse` VALUES (2016010, 1225, 56);
INSERT INTO `studentcourse` VALUES (2016011, 1225, 87);
INSERT INTO `studentcourse` VALUES (2016011, 1228, 45);
INSERT INTO `studentcourse` VALUES (2016012, 1227, 66);
INSERT INTO `studentcourse` VALUES (2016012, 1228, 93);
INSERT INTO `studentcourse` VALUES (2016013, 1222, 78);
INSERT INTO `studentcourse` VALUES (2016013, 1227, 34);
INSERT INTO `studentcourse` VALUES (2016014, 1222, 56);
INSERT INTO `studentcourse` VALUES (2016014, 1223, 87);
INSERT INTO `studentcourse` VALUES (2016015, 1223, 45);
INSERT INTO `studentcourse` VALUES (2016015, 1224, 93);
INSERT INTO `studentcourse` VALUES (2016016, 1224, 66);
INSERT INTO `studentcourse` VALUES (2016016, 1225, 34);
INSERT INTO `studentcourse` VALUES (2016017, 1225, 78);
INSERT INTO `studentcourse` VALUES (2016018, 1228, 87);
INSERT INTO `studentcourse` VALUES (2016019, 1227, 93);
INSERT INTO `studentcourse` VALUES (2016020, 1222, 34);
INSERT INTO `studentcourse` VALUES (2016021, 1223, 56);
INSERT INTO `studentcourse` VALUES (2016022, 1224, NULL);
INSERT INTO `studentcourse` VALUES (2016023, 1225, 66);
INSERT INTO `studentcourse` VALUES (2016024, 1228, 78);
INSERT INTO `studentcourse` VALUES (2016025, 1227, 87);
INSERT INTO `studentcourse` VALUES (2016026, 1222, 93);
INSERT INTO `studentcourse` VALUES (2016027, 1223, 34);
INSERT INTO `studentcourse` VALUES (2016028, 1224, 56);
INSERT INTO `studentcourse` VALUES (2016029, 1225, 45);
INSERT INTO `studentcourse` VALUES (2016030, 1228, 66);

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo`  (
  `studentid` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classno` int(11) NULL DEFAULT NULL COMMENT '班级号',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`studentid`) USING BTREE,
  INDEX `studentinfo_ibfk_1`(`classno`) USING BTREE,
  CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`classno`) REFERENCES `classinfo` (`classno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES (2016002, '刘俊亮', '123456790@qq.com', '12345678901', 2016211, '男');
INSERT INTO `studentinfo` VALUES (2016003, '李承彧', '123456791@qq.com', '12345678901', 2016211, '男');
INSERT INTO `studentinfo` VALUES (2016004, '王朝远', '123456792@qq.com', '12345678901', 2016211, '男');
INSERT INTO `studentinfo` VALUES (2016005, '刘琛', '123456793@qq.com', '12345678901', 2016211, '男');
INSERT INTO `studentinfo` VALUES (2016006, '徐亮亮', '123456794@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016007, '张超', '123456795@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016008, '苏旭浩', '123456796@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016009, '崔江平', '123456797@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016010, '唐飞', '123456798@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016011, '林昕', '123456799@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016012, '操牡丹', '123456800@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016013, '雷爽', '123456801@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016014, '秦灵伶', '123456802@qq.com', '12345678901', 2016234, '男');
INSERT INTO `studentinfo` VALUES (2016015, '黄金花', '123456803@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016016, '张敏', '123456804@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016017, '吴磊', '123456805@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016018, '袁青春', '123456806@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016019, '唐雷', '123456807@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016020, '吴霏', '123456808@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016021, '连洪炽', '123456809@qq.com', '12345678901', 2016231, '女');
INSERT INTO `studentinfo` VALUES (2016022, '王金柱', '123456810@qq.com', '12345678901', 2016231, '女');
INSERT INTO `studentinfo` VALUES (2016023, '苏广学', '123456811@qq.com', '12345678901', 2016231, '女');
INSERT INTO `studentinfo` VALUES (2016024, '唐元亮', '123456812@qq.com', '12345678901', 2016231, '女');
INSERT INTO `studentinfo` VALUES (2016025, '葛艳杰', '123456813@qq.com', '12345678901', 2016231, '女');
INSERT INTO `studentinfo` VALUES (2016026, '张永超', '123456814@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016027, '张伟', '123456815@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016028, '孙刚', '123456816@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016029, '车平跃', '123456817@qq.com', '12345678901', 2016231, '男');
INSERT INTO `studentinfo` VALUES (2016030, '张鑫', '123456818@qq.com', '12345678901', 2016231, '男');

-- ----------------------------
-- Table structure for teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo`  (
  `teacherid` int(11) NOT NULL,
  `teachername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacherid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES (2016001, '管理员', '122354322@qq.com', '1234567', NULL, NULL, NULL);
INSERT INTO `teacherinfo` VALUES (2016031, '王凯', '123456819@qq.com', '12345678901', '计算机网络技术中心', '教三-201', '男');
INSERT INTO `teacherinfo` VALUES (2016032, '马涛', '123456820@qq.com', '12345678901', '大数据中心', '教三-203', '男');
INSERT INTO `teacherinfo` VALUES (2016033, '王佳楠', '123456821@qq.com', '12345678901', '大数据中心', '教三-203', '男');
INSERT INTO `teacherinfo` VALUES (2016034, '马浩', '123456822@qq.com', '12345678901', '人文学院', '教一-211', '男');
INSERT INTO `teacherinfo` VALUES (2016035, '邵苏杰', '123456823@qq.com', '12345678901', '信息与网络安全中心', '教四-223', '男');
INSERT INTO `teacherinfo` VALUES (2016036, '马冬梅', '123456776@qq.com', '123555421', '人文学院', '教二', '女');
INSERT INTO `teacherinfo` VALUES (2016037, '张三', '123343321@163.com', '123322111', '大数据中心', '教三', '女');

SET FOREIGN_KEY_CHECKS = 1;
