package com.course.ceses;

import com.course.bean.InterfaceName;
import com.course.bean.LoginCase;
import com.course.config.TestCase;
import com.course.util.ConfigFile;
import com.course.util.DataSourcesUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 用户登录
 */
public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){
        /**
         * 在登陆之前 初始化操作
         */
        TestCase.GETUSERINFOURL= ConfigFile.getStringUrl(InterfaceName.GETUSERINFO);
        TestCase.GETUSERLISTURL= ConfigFile.getStringUrl(InterfaceName.GETUSERLIST);
        TestCase.ADDUSERURL= ConfigFile.getStringUrl(InterfaceName.ADDUSER);
        TestCase.UPDATEUSERURL= ConfigFile.getStringUrl(InterfaceName.UPDATEUSERINFO);
        TestCase.LOGINURL= ConfigFile.getStringUrl(InterfaceName.LOGIN);
        TestCase.DEFAULTHTTPCLIENT = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue",description = "用户登录成功接口")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestCase.LOGINURL);
    }
    @Test(groups = "loginFalse",description = "用户登陆失败接口")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestCase.LOGINURL);
    }
}
