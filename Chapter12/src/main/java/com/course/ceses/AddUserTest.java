package com.course.ceses;

import com.course.bean.AddUserCase;
import com.course.config.TestCase;
import com.course.util.DataSourcesUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户")
    public void addUser() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestCase.ADDUSERURL);
    }
}
