package com.course.ceses;

import com.course.bean.GetUserListCase;
import com.course.config.TestCase;
import com.course.util.DataSourcesUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue",description = "或区域用户列表")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DataSourcesUtil.getSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestCase.GETUSERLISTURL);
    }
}
