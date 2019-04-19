package com.wangwei.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我的第一个测试接口文档")
public class MyGetMethod {
    /**
     * 返回cookie信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过方法获取Cookie信息",httpMethod = "GET")
    public String getCookies(HttpServletRequest request, HttpServletResponse response){
        //request 请求信息 response 响应信息
        Cookie cookie = new Cookie("login","true");
        //在浏览器上保存cookie信息
        response.addCookie(cookie);
        return "恭喜获取cookie信息成功";
    }

    /**
     * 要求客户端携带cookie信息访问
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookie才能访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request,HttpServletResponse response){
        Cookie[] list = request.getCookies();
        if(Objects.isNull(list)){
            return "你必须携带cookie信息来访问";
        }
        for (Cookie cookie:list) {
            if(Objects.equals("login",cookie.getName())&&Objects.equals("true",cookie.getValue())){
                return "恭喜你，携带cookie信息访问成功";
            }
        }
        return "你必须携带cookie信息来访问";
    }

    /**
     * 开发get的参数请求
     * 第1种
     */
    @RequestMapping(value = "/getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问1",httpMethod = "GET")
    public Map<String,Integer> getWithParam( @RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("衣服",100);
        myList.put("鞋",200);
        myList.put("寸衫",500);
        return myList;
    }
    /**
     * 第二种
     * PathVariable 表示参数的注解 比 RequestParam好用点
     */
    @RequestMapping(value = "/getmyList/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问2",httpMethod = "GET")
    public Map<String,Integer> getmyList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("衣服",100);
        myList.put("鞋",200);
        myList.put("寸衫",400);
        return myList;
    }
}
