package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `getUserListCase` (
 *   `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
 *   `userName` varchar(255) DEFAULT NULL,
 *   `age` int(11) DEFAULT NULL,
 *   `sex` varchar(255) DEFAULT NULL,
 *   `expected` varchar(200) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */

/**
 * 获取用户列表
 */
@Data
public class GetUserListCase {
    private Integer id;
    private String userName;
    private String age;
    private String sex;
    private String expected;
}
