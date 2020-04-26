package com.server.servletserver.dao;

import Entity.User;
import com.server.servletserver.utils.JDBC;

import java.sql.ResultSet;

/**
 * @Author gaobaishun
 * @Date 2020-04-22 10:33
 * imformation：
 */
public class UserDao {

    public int selectUserByUser(User user) throws Exception {
        String sql="SELECT COUNT(u.userId) as nums FROM myprotest.user u WHERE u.userName = \""
                +user.getUserName()+
                "\" AND u.password = \""+user.getPassword()+"\";";
        ResultSet resultSet=JDBC.simpleQuery(sql);

        return resultSet.next()? resultSet.getInt("nums") : 0;
    }

}
