package com.wangwei.server;

import com.wangwei.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Api(value = "/",description = "post接口请求")
@RequestMapping(value = "/")
public class MyPostMethod {
    @RequestMapping("login")
    @ApiOperation(value = "用户登录返回Cookie信息",httpMethod = "POST")
    public void login(HttpServletResponse response,@RequestBody User user){
        if (Objects.equals("wangwei",user.getName())&&Objects.equals("wangwei",user.getPassword())){
            response.addCookie(new Cookie("user","true"));
        }
    }

    /**
     * 需要携带cookie信息餐能访问并且返回user列表
     */
    @RequestMapping("getUserList")
    @ApiOperation(value = "携带Cookie信息放回用户信息",httpMethod = "POST")
    public String getUserList(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        List<User> list = new ArrayList<>();
        if (Objects.isNull(cookies)){
            return "cookie信息为空";
        }
        for (Cookie c:cookies){
            if (Objects.equals("user",c.getName())&&Objects.equals("true",c.getValue())){
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.setName("haha"+i);
                    user.setPassword("123456");
                    list.add(user);
                }

                return list.toString();
            }
        }
        return "参数不合法";
    }
}
