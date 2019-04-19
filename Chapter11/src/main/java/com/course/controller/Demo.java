package com.course.controller;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Log4j
@RestController
@Api(value = "/",description = "这是springboot和mybatis结合框架")
@RequestMapping(value = "/")
public class Demo {
//    这是自动加载是sqlsession
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "这是获取用户数量",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是添加用户信息",httpMethod = "POST")
    public int add(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        int result =  template.insert("addUser",user);
        return result;
    }
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是添加用户信息",httpMethod = "POST")
    public int delete(@RequestParam(required = false) int id, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        int result =  template.delete("deleteUser",id);
        return result;
    }
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是添加用户信息",httpMethod = "POST")
    public int update(@RequestBody User user, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        int result =  template.update("updateUser",user);
        return result;
    }
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ApiOperation(value = "这是添加用户信息",httpMethod = "GET")
    public String get( HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        User user =  template.selectOne("selectUser",1);
        return user.toString();
    }
}
