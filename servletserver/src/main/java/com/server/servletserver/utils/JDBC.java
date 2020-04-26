package com.server.servletserver.utils;


import java.sql.*;

/**
 * @Author gaobaishun
 * @Date 2020-04-21 11:10
 * imformation：
 */
public class JDBC {
    private static Connection connection;
    public  static void  createCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                        DBConfig.getValueByKey("url"),
                        DBConfig.getValueByKey("user"),
                        DBConfig.getValueByKey("password"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet simpleQuery(String querySQL) throws Exception{
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery(querySQL);
        return rs;
    }

    public static void closeJDBC() throws Exception{

            connection.close();

    }
}
