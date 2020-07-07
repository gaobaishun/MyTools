package com.server.servletserver.servlets;


import Entity.MenuDO;
import com.alibaba.fastjson.JSONObject;
import com.server.servletserver.dao.MenuDao;
import com.server.servletserver.utils.DBConfig;
import com.server.servletserver.utils.JDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @Author gaobaishun
 * @Date 2020-04-28 13:21
 * imformation：管理菜单
 */
public class MenuServlet extends HttpServlet {

    private static Logger logger= LogManager.getLogger(MenuServlet.class);

    private MenuDao menuDao;
    @Override
    public void init(){
        System.out.println("初始化");
        //先加载DB配置文件
        DBConfig.Loading();

        //JDBC创建连接
        JDBC.createCon();

        //userDao=new UserDao();
        menuDao=new MenuDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //logger
            //logger.debug(MarkerManager.getMarker("TEST"), (Message) new SimpleMessage("messagetest"));
            logger.info("获取菜单");
        List<MenuDO> menuDOList= null;
        try {
            menuDOList=menuDao.selectAllMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        printWriter.print(JSONObject.toJSON(menuDOList));

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
