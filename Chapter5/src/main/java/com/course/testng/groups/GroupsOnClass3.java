package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher01(){
        System.out.println("GroupsOnClass3的teacher01运行");
    }

    public void teacher02(){
        System.out.println("GroupsOnClass3的teacher02运行");
    }
}
