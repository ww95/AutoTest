package com.course.ceses;

import com.course.bean.GetUserInfoCase;
import com.course.config.TestCase;
import com.course.util.DataSourcesUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestCase.GETUSERINFOURL);
    }
}
