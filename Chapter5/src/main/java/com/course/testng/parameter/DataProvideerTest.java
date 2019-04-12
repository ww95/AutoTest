package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * DataProvider实现参数化
 */
public class DataProvideerTest {
    @Test(dataProvider = "dataProvider")
    public void testDataProviderTest(String name,int age){
        System.out.println(name+"=============="+age);
        System.out.println("线程 ID"+Thread.currentThread().getId());
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider(){
        Object[][] objects= new Object[][]{
                {"王伟",25},{"haha",26},{"xixi",30},{"gg",85},
        };
        return objects;
    }
}
