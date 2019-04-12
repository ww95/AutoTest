package com.course.testng;

import org.testng.annotations.Test;

/**
 * 异常测试用来测试结果为异常的时候 一般是系统出现异常
 * 当数据不合法的时候 会返回异常
 */
public class ExpectedExceptionTest {
    //失败异常测试
    @Test(expectedExceptions = Runtime.class)
    public void runTimeFail(){
        System.out.println("这是一个失败的测试异常");
    }

    //成功异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeSuccess(){
        System.out.println("这是一个成功的测试异常");
        throw new RuntimeException();
    }
}
