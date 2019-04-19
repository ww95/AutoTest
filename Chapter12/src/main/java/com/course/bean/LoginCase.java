package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `loginCase` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `userName` varchar(255) DEFAULT NULL,
 *   `password` varchar(255) DEFAULT NULL,
 *   `expected` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */

/**
 * 用户登录
 */
@Data
public class LoginCase {
    private Integer id;
    private String userName;
    private String password;
    private String expected;
}
