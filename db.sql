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
INSERT INTO `classinfo` VALUES (2016211, '????????????');
INSERT INTO `classinfo` VALUES (2016230, '????????????????????????');
INSERT INTO `classinfo` VALUES (2016231, '????????????????????????');
INSERT INTO `classinfo` VALUES (2016234, '????????????');
INSERT INTO `classinfo` VALUES (2016235, '????????????');
INSERT INTO `classinfo` VALUES (2016455, '????????????????????????');
INSERT INTO `classinfo` VALUES (2016456, '????????????');
INSERT INTO `classinfo` VALUES (2016789, '????????????');

-- ----------------------------
-- Table structure for courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo`  (
  `courseid` int(11) NOT NULL,
  `teacherid` int(11) NOT NULL,
  `courseplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weektime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????(???????????????????????????)',
  `coursename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '?????????',
  `jieci` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????',
  PRIMARY KEY (`courseid`, `teacherid`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE,
  INDEX `courseinfo_ibfk_1`(`teacherid`) USING BTREE,
  CONSTRAINT `courseinfo_ibfk_1` FOREIGN KEY (`teacherid`) REFERENCES `teacherinfo` (`teacherid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseinfo
-- ----------------------------
INSERT INTO `courseinfo` VALUES (1221, 2016031, '??????-339', '3-8', '??????????????????1', '5', '3-4');
INSERT INTO `courseinfo` VALUES (1222, 2016032, '??????-201', '3-16', '????????????', '3,5', '1-2');
INSERT INTO `courseinfo` VALUES (1223, 2016033, '??????-211', '3-16', '?????????????????????', '4', '5-6');
INSERT INTO `courseinfo` VALUES (1224, 2016031, '??????-213', '3-16', '???????????????', '1,3', '7-8');
INSERT INTO `courseinfo` VALUES (1225, 2016034, '??????-203', '3-16', '????????????', '3', '1-2');
INSERT INTO `courseinfo` VALUES (1226, 2016034, '??????-303', '3-15', '???????????????1', '4', '1-2');
INSERT INTO `courseinfo` VALUES (1227, 2016032, '??????-339', '9-16', '??????????????????2', '5', '3-4');
INSERT INTO `courseinfo` VALUES (1228, 2016035, '??????-910', '16-18', '???????????????2', '5', '1-2');

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
  `classno` int(11) NULL DEFAULT NULL COMMENT '?????????',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????',
  PRIMARY KEY (`studentid`) USING BTREE,
  INDEX `studentinfo_ibfk_1`(`classno`) USING BTREE,
  CONSTRAINT `studentinfo_ibfk_1` FOREIGN KEY (`classno`) REFERENCES `classinfo` (`classno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES (2016002, '?????????', '123456790@qq.com', '12345678901', 2016211, '???');
INSERT INTO `studentinfo` VALUES (2016003, '?????????', '123456791@qq.com', '12345678901', 2016211, '???');
INSERT INTO `studentinfo` VALUES (2016004, '?????????', '123456792@qq.com', '12345678901', 2016211, '???');
INSERT INTO `studentinfo` VALUES (2016005, '??????', '123456793@qq.com', '12345678901', 2016211, '???');
INSERT INTO `studentinfo` VALUES (2016006, '?????????', '123456794@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016007, '??????', '123456795@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016008, '?????????', '123456796@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016009, '?????????', '123456797@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016010, '??????', '123456798@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016011, '??????', '123456799@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016012, '?????????', '123456800@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016013, '??????', '123456801@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016014, '?????????', '123456802@qq.com', '12345678901', 2016234, '???');
INSERT INTO `studentinfo` VALUES (2016015, '?????????', '123456803@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016016, '??????', '123456804@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016017, '??????', '123456805@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016018, '?????????', '123456806@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016019, '??????', '123456807@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016020, '??????', '123456808@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016021, '?????????', '123456809@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016022, '?????????', '123456810@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016023, '?????????', '123456811@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016024, '?????????', '123456812@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016025, '?????????', '123456813@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016026, '?????????', '123456814@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016027, '??????', '123456815@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016028, '??????', '123456816@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016029, '?????????', '123456817@qq.com', '12345678901', 2016231, '???');
INSERT INTO `studentinfo` VALUES (2016030, '??????', '123456818@qq.com', '12345678901', 2016231, '???');

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
INSERT INTO `teacherinfo` VALUES (2016001, '?????????', '122354322@qq.com', '1234567', NULL, NULL, NULL);
INSERT INTO `teacherinfo` VALUES (2016031, '??????', '123456819@qq.com', '12345678901', '???????????????????????????', '??????-201', '???');
INSERT INTO `teacherinfo` VALUES (2016032, '??????', '123456820@qq.com', '12345678901', '???????????????', '??????-203', '???');
INSERT INTO `teacherinfo` VALUES (2016033, '?????????', '123456821@qq.com', '12345678901', '???????????????', '??????-203', '???');
INSERT INTO `teacherinfo` VALUES (2016034, '??????', '123456822@qq.com', '12345678901', '????????????', '??????-211', '???');
INSERT INTO `teacherinfo` VALUES (2016035, '?????????', '123456823@qq.com', '12345678901', '???????????????????????????', '??????-223', '???');
INSERT INTO `teacherinfo` VALUES (2016036, '?????????', '123456776@qq.com', '123555421', '????????????', '??????', '???');
INSERT INTO `teacherinfo` VALUES (2016037, '??????', '123343321@163.com', '123322111', '???????????????', '??????', '???');

SET FOREIGN_KEY_CHECKS = 1;
