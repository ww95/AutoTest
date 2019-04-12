package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 这是基于注解的方式来实现多线程
 */
public class MultiThreadOnAnnotation {
    /**
     * invocationCount表示执行次数
     * threadPoolSize表示线程池内线程的个数
     */
    @Test(invocationCount = 10,threadPoolSize = 3)
    private void test(){
        System.out.println(1);
        System.out.println("Thread ID="+Thread.currentThread().getId());
    }
}
