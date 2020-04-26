package com.server.servletserver.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author gaobaishun
 * @Date 2020-04-21 10:46
 * imformation：
 */
public class DBConfig {
    private static Properties properties;

    public static void Loading(){
        String url= DBConfig.class.getResource("/").getPath()+"db.properties";
        System.out.println(url);
        properties=new Properties();
        try {
            FileInputStream fileInputStream=new FileInputStream(url);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String username = properties.getProperty("user");
//        String password =properties.getProperty("password");
//        System.out.println(username);
//        System.out.println(password);
    }

    public static String getValueByKey(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        Loading();
    }
}
