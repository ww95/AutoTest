package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {

    @Test
    public void test01(){
        System.out.println("线程 ID="+Thread.currentThread().getId());
    }
    @Test
    public void test02(){
        System.out.println("线程 ID="+Thread.currentThread().getId());
    }
    @Test
    public void test03(){
        System.out.println("线程 ID="+Thread.currentThread().getId());
    }
}
