package com.course.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 */
public class TimeOutTest {

    @Test(timeOut = 3000)//单位为毫秒值
    public void timeoutSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)//单位为毫秒值
    public void timeoutFail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
