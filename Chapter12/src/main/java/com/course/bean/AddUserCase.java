package com.course.bean;

import lombok.Data;

/**
 * CREATE TABLE `addusercase` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `userName` varchar(255) DEFAULT NULL,
 *   `password` varchar(255) DEFAULT NULL,
 *   `sex` varchar(255) DEFAULT NULL,
 *   `age` varchar(255) DEFAULT NULL,
 *   `permission` varchar(255) DEFAULT NULL,
 *   `isDelete` varchar(255) DEFAULT NULL,
 *   `expected` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 */

/**
 * 添加用户
 */
@Data
public class AddUserCase {

    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;

}
