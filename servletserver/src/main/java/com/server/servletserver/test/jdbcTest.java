package com.server.servletserver.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author gaobaishun
 * @Date 2020-04-21 09:35
 * imformation：
 */
public class jdbcTest {
        public static final String URL = "jdbc:mysql://localhost:3306/sqltest?useSSL=true";
        public static final String USER = "root";
        public static final String PASSWORD = "root";

        public static void main(String[] args) {
            try {
                //1.加载驱动程序
                Class.forName("com.mysql.jdbc.Driver");
                //2. 获得数据库连接
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                //3.操作数据库，实现增删改查
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from sqltest.course");
                //如果有数据，rs.next()返回true
                while (rs.next()) {
                    System.out.println(rs.getString("coursename"));
                }

            }catch (Exception e){

            }finally {

            }
        }

}
