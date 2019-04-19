package com.http.client.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 使用Httpclient框架来开发接口测试
 * 一个接口需要一个uri 所有地址存取到配置文件之中
 * 读取properties文件有两种读取方式
 */
public class MyCookiesForGet {
    private String url;
    //读取配置文件的工具类 默认会读取properties文件 所有文件名是不用谢后缀名
    private ResourceBundle resourceBundle;
    //存取Cookie信息
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        //ResourceBundle读取文件中有中文 后面添加Locale.CHINA
        resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = resourceBundle.getString("test.url");
    }

    /**
     * 返回cookie信息的个体请求
     * @throws IOException
     */
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //获取cookie信息需要DefaultHttpClient类来获取信息
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(this.url+resourceBundle.getString("getCookies.uri"));
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        /**
         * 这是获取response的Cookie信息
         */
        //获取cookie信息
        //首先获取client的CookieStore
        cookieStore = client.getCookieStore();
        //在CookieStore中获取Cookies的list
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie:cookies) {
            System.out.println("Cookies name="+cookie.getName()+";Cookie value="+cookie.getValue());
        }
    }

    /**
     * 携带cookie信息的get请求
     * @throws IOException
     */
    @Test(dependsOnMethods = "testGetCookies")
    private void testGetWithCookie() throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(this.url+resourceBundle.getString("getWithCookie.uri"));
        //设置cookie信息 在HttpClient中
        client.setCookieStore(cookieStore);
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+statusCode);
        if(statusCode == 200){
            String result;
            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
        }
}
