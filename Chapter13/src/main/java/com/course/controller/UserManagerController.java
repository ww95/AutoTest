package com.course.controller;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@Api(value = "/",description = "用户管理系统")
@RequestMapping(value = "/")
public class UserManagerController {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        int i = sqlSessionTemplate.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("查询到的结果是="+i);
        if (1==i){
            log.info("登录用户名是"+user.getUserName());
            return true;
        }
        return false;
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public Boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean flag = CookieisTrue(request);
        int result = 0;
        if (flag!=null){
            result = sqlSessionTemplate.insert("addUser",user);
        }
        if (result>0){
            log.info("添加用户数量"+request);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息",httpMethod = "POST")
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean x = CookieisTrue(request);
        if (x==true){
            List<User> list = sqlSessionTemplate.selectList("getUserInfo",user);
            log.info("获取到的用户数量"+list.size());
            return list;
        }
        return null;
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新或删除用户信息",httpMethod = "POST")
    public Integer updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = CookieisTrue(request);
        int i = 0;
        if (x==true){
            i = sqlSessionTemplate.update("updateUser",user);
            log.info("更新数据条数"+i);
        }
        return i;
    }
    private Boolean CookieisTrue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookie信息为空");
            return false;
        }
        for (Cookie c:cookies){
            if("login".equals(c.getName())&&"true".equals(c.getValue())){
                log.info("cookie信息验证正确~~~~~~~~~~~~");
                return true;
            }
        }
        return false;
    }
}
