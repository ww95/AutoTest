package com.http.client.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * httpClient框架实现post请求并且对post请求中添加参数以及头信息支持json格式
 */
public class MyCookieForPost {

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
    private void testPostWithCookie() throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(this.url+resourceBundle.getString("postWithCookie.uri"));
        //由于这个请求是json格式数据个参数 所以添加参数以及设置请求头 因为请求参数是json传输
        //创建json对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","30");
        //在方法中添加头信息 支持json格式数据
        post.setHeader("content-type","application/json");
        //将json数据转化成字符串
        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
        //    表单方式
        //    List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        //    pairList.add(new BasicNameValuePair("name", "admin"));
        //    pairList.add(new BasicNameValuePair("pass", "123456"));
        //    httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
        /**
         * 不管是json数据格式还是表单数据
         * 不过post表单数据是键值对来存储的，BasicNameValuePair是存储键值对的对象
         * 然后将这个键值对对象存储在BasicNameValuePair
         * 都是通过setEntity方法来进行设置参数 post表单数据，是通过UrlEncodedFormEntity对象设置
         */
        //在post上面设置json数据
        post.setEntity(stringEntity);
        //设置Cookie信息 就是HttpClient设置cookieStore 属性
        client.setCookieStore(cookieStore);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //将响应结果字符串转化json
        JSONObject resultJson = new JSONObject(result);
        //判断结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",success);
    }
}
