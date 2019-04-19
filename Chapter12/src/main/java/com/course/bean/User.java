package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `userName` varchar(255) DEFAULT NULL,
 *   `password` varchar(255) DEFAULT NULL,
 *   `age` varchar(255) DEFAULT NULL,
 *   `sex` varchar(255) DEFAULT NULL,
 *   `permission` varchar(255) DEFAULT NULL,
 *   `isDelete` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
 */

/**
 * 用户类
 */
@Data
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}
