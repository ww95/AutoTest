package com.course.ceses;

import com.course.bean.UpdateUserInfoCase;
import com.course.config.TestCase;
import com.course.util.DataSourcesUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestCase.UPDATEUSERURL);
    }
    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUserInfo() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestCase.UPDATEUSERURL);
    }
}
