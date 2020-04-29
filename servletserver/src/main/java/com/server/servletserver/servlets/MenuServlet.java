package com.server.servletserver.servlets;


import com.server.servletserver.utils.DBConfig;
import com.server.servletserver.utils.JDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author gaobaishun
 * @Date 2020-04-28 13:21
 * imformation：管理菜单
 */
public class MenuServlet extends HttpServlet {

    private static Logger logger= LogManager.getLogger(MenuServlet.class);

    @Override
    public void init(){
        System.out.println("初始化");
        //先加载DB配置文件
        DBConfig.Loading();

        //JDBC创建连接
        JDBC.createCon();

        //userDao=new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //logger
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

        System.out.println("摧毁");
        try {
            JDBC.closeJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
