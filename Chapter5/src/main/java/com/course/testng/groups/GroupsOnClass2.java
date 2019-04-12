package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupsOnClass2 {
    public void student01(){
        System.out.println("GroupsOnClass2的stu01运行");
    }

    public void student02(){
        System.out.println("GroupsOnClass2的stu02运行");
    }
}
