package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupsOnClass1 {
    public void test01(){
        System.out.println("GroupsOnClass1的stu01运行");
    }

    public void test02(){
        System.out.println("GroupsOnClass1的stu02运行");
    }
}
