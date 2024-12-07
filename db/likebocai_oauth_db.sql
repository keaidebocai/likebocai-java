/*
SQLyog Ultimate v10.00 Beta1
MySQL - 8.0.26 : Database - likebocai_oauth_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`likebocai_oauth_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `likebocai_oauth_db`;

/*Table structure for table `oauth_action_log` */

DROP TABLE IF EXISTS `oauth_action_log`;

CREATE TABLE `oauth_action_log` (
  `id` bigint unsigned NOT NULL COMMENT '用户行为记录日志表,主键',
  `user_id` bigint unsigned NOT NULL COMMENT '用户id',
  `action_type` tinyint unsigned NOT NULL COMMENT '行为类型，例如：0: 登录,1: 查看页面, 2:更新操作',
  `action_detail` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '具体行为，页面路径，或更新的接口信息',
  `ip_adder` binary(16) DEFAULT NULL COMMENT '用户的IP地址，适配IPv4和IPv6',
  `user_nation` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家',
  `user_province` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份',
  `user_city` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `user_district` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在区',
  `user_agent` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户的设备信息或浏览器标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户行为记录日志表';

/*Table structure for table `oauth_permission` */

DROP TABLE IF EXISTS `oauth_permission`;

CREATE TABLE `oauth_permission` (
  `id` bigint unsigned NOT NULL COMMENT '权限表,主键',
  `permission_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
  `permission_desc` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限描述',
  `permission_uri` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '该权限下所需要的uri',
  `is_active` tinyint unsigned NOT NULL COMMENT '权限是否有效(1: 有效,0: 无效)',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除(1: 删除,0:未删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表';

/*Table structure for table `oauth_role` */

DROP TABLE IF EXISTS `oauth_role`;

CREATE TABLE `oauth_role` (
  `id` bigint unsigned NOT NULL COMMENT '角色表,主键',
  `role_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色描述',
  `is_active` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '角色是否有效(1: 有效,0: 无效)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除(1: 删除,0:未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色表';

/*Table structure for table `oauth_role_permission` */

DROP TABLE IF EXISTS `oauth_role_permission`;

CREATE TABLE `oauth_role_permission` (
  `id` bigint unsigned NOT NULL COMMENT '角色权限关联表',
  `role_id` bigint unsigned NOT NULL COMMENT '角色id',
  `permission_id` bigint unsigned NOT NULL COMMENT '权限id',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除(1: 删除,0:未删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`,`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色权限关联表';

/*Table structure for table `oauth_user` */

DROP TABLE IF EXISTS `oauth_user`;

CREATE TABLE `oauth_user` (
  `id` bigint unsigned NOT NULL COMMENT '主键，雪花算法',
  `user_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名,用于登录',
  `password` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加密后的密码(Argon2复合加密，设置为128位)',
  `nick_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户昵称，用于显示',
  `user_email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户的邮箱',
  `user_sex` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '性别(0: 未知,1: 男,2: 女, 3: 阿帕奇武装直升机)',
  `role_id` bigint unsigned NOT NULL COMMENT '用户的角色信息',
  `user_status` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '用户账户状态(0: 正常,1: 审核中,2: 封禁)',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除(1: 删除,0:未删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户基本的信息表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
