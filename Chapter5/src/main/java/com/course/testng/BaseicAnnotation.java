package com.course.testng;

import org.testng.annotations.*;

public class BaseicAnnotation {

    /**
     * @Test 是最基础的注解，将方法标记为测试的一部分
     */
    @Test
    private void test01(){
        System.out.println("这是testng用例1");
    }

    @Test
    private void test02(){
        System.out.println("这是testng用例2");
    }

    @BeforeMethod
    public void beforeMeyhod(){
        System.out.println("这是测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass 在类之前运行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass 在类之后运行");
    }

    @BeforeSuite
    private void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }
    @AfterSuite
    private void afterSuite(){
        System.out.println("afterSuite测试套件");
    }
}
