package com.course.testng;

import org.testng.annotations.Test;

/**
 * 忽略测试
 */
public class IgnoreTest {
    @Test
    private void ignoretest1(){
        System.out.println("用例1执行");
    }

    /**
     * 忽略测试
     */
    @Test(enabled = false)
    private void ignoretest2(){
        System.out.println("用例2执行");
    }
    @Test(enabled = true)
    private void ignoretest3(){
        System.out.println("用例3执行");
    }
}
