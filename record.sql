/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : record

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 04/07/2024 17:40:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成的文档名字',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文档格式',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文档的文本内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态（0：状态正常，1：状态异常）',
  `del_flag` tinyint NULL DEFAULT NULL COMMENT '逻辑删除（0：未删除，1：已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (2, '笔录', 'docx', 'ok', '2024-07-02 06:17:11', 0, 0);
INSERT INTO `record` VALUES (75, '笔录', 'docx', '测试文本', '2024-07-04 17:32:14', 0, 0);
INSERT INTO `record` VALUES (76, '123', 'docx', '123', '2024-07-04 17:32:17', 0, 0);
INSERT INTO `record` VALUES (77, '笔录', 'docx', '测试文本123435465', '2024-07-04 17:37:53', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
