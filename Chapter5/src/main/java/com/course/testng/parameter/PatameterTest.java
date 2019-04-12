package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试
 */
public class PatameterTest {
    @Test
    @Parameters({"name","age"})
    public void paraTest(String name,int age){
        System.out.println(name+"========="+age);
    }
}
