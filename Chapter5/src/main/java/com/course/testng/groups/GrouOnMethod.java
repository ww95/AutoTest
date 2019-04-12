package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 方法组测试
 */
public class GrouOnMethod {
    @Test(groups = "server")
    public void test01(){
        System.out.println("服务端测试1");
    }
    @Test(groups = "server")
    public void test02(){
        System.out.println("服务端测试2");
    }
    @Test(groups = "client")
    public void test03(){
        System.out.println("客户端测试1");
    }
    @Test(groups = "client")
    public void test04(){
        System.out.println("客户端测试2");
    }
    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("服务端运行前");
    }
    @AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("服务端运行后");
    }
    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("客户端运行前");
    }
    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.println("客户端运行后");
    }
}
