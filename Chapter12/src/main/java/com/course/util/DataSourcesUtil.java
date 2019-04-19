package com.course.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 数据库有操作
 */
public class DataSourcesUtil {
    public static SqlSession getSession() throws IOException {
        //获取配置文件
        Reader reader = Resources.getResourceAsReader("dataBaseConfig.xml");
        //将文档builder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //sqlSession就能执行sql语句操作
        return sqlSessionFactory.openSession();
    }
}

