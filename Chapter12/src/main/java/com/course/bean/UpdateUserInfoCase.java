package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `updateUserInfoCase` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `userId` int(11) DEFAULT NULL,
 *   `userName` varchar(255) DEFAULT NULL,
 *   `sex` varchar(255) DEFAULT NULL,
 *   `age` varchar(11) DEFAULT NULL,
 *   `permission` varchar(255) DEFAULT NULL,
 *   `isDelete` varchar(255) DEFAULT NULL,
 *   `expected` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */

/**
 * 用户更新
 */
@Data
public class UpdateUserInfoCase {
    private Integer id;
    private Integer userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;
}
