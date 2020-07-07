package com.server.servletserver.dao;

import Entity.MenuDO;
import com.server.servletserver.utils.JDBC;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-05-09 10:25
 * imformation：
 */
public class MenuDao {
    public List<MenuDO> selectAllMenu() throws Exception {
        String sql="select * from myprotest.menu";
        ResultSet resultSet= JDBC.simpleQuery(sql);
        List<MenuDO> list=new LinkedList<>();
        while(resultSet.next()){
            MenuDO menuDO=new MenuDO();
            menuDO.setFatherId(resultSet.getInt("fatherId"));
            menuDO.setMenuId(resultSet.getInt("menuId"));
            menuDO.setMenuName(resultSet.getString("menuName"));

            list.add(menuDO);
        }
        return list;
    }
}
