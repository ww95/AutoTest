package com.course.util;

import com.course.bean.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 用来加载配置文件
 * 利用单例模式来进行加载配置文件
 * 工具类一般是静态方法 不需要new直接操作
 */
public class ConfigFile {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application", Locale.CHINA);
    public ResourceBundle getResourceBundle(){
        return resourceBundle;
    }
    public static String getStringUrl(InterfaceName interfaceName){
        String address = resourceBundle.getString("test.url");
        String uri="";
        String testurl;
        if (interfaceName.equals(InterfaceName.ADDUSER)){
            uri = resourceBundle.getString("addUser.uri");
        }else if(interfaceName.equals(InterfaceName.LOGIN)){
            uri = resourceBundle.getString("login.uri");
        }
        else if(interfaceName.equals(InterfaceName.GETUSERINFO)){
            uri = resourceBundle.getString("getUserInfo.uri");
        }else if(interfaceName.equals(InterfaceName.GETUSERLIST)){
            uri = resourceBundle.getString("getUserList.uri");
        }
        else if (interfaceName.equals(InterfaceName.UPDATEUSERINFO)){
            uri = resourceBundle.getString("updateUserInfo.uri");
        }
        testurl=address+uri;
        return testurl;
    }
}
