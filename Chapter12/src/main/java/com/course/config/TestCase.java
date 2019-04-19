package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 规定接口路径
 */
public class TestCase {
    public static String LOGINURL;
    public static String UPDATEUSERURL;
    public static String ADDUSERURL;
    public static String GETUSERINFOURL;
    public static String GETUSERLISTURL;
    public static DefaultHttpClient DEFAULTHTTPCLIENT;
    public static CookieStore COOKIESTORE;
}
