package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `getUserInfoCase` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `userId` varchar(11) DEFAULT NULL,
 *   `expected` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */

/**
 * 获取用户信息
 */
@Data
public class GetUserInfoCase {

    private Integer id;
    private String userId;
    private String expected;
}
