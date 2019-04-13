package com.testng.extentreport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {
    @Test
    public void test01(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test02(){
        Assert.assertEquals(2,2);
    }
    @Test
    public void test03(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void logDemo(){
        Reporter.log("这是我自己写的日志");
        throw new RuntimeException("这是我自己抛出异常");
    }
}
