package com.server.servletserver.servlets;




import Entity.User;
import Enumration.ResponseMessageStatus;
import Message.LoginRespMessage;
import com.alibaba.fastjson.JSONObject;
import com.server.servletserver.dao.UserDao;
import com.server.servletserver.utils.DBConfig;
import com.server.servletserver.utils.JDBC;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author gaobaishun
 * @Date 2020-04-19 21:04
 * imformation：
 */
public class LoginServlet extends HttpServlet {

    UserDao userDao=null;
    @Override
    public void init(){
        System.out.println("初始化");
        //先加载DB配置文件
        DBConfig.Loading();

        //JDBC创建连接
        JDBC.createCon();

        userDao=new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAuthType());
        System.out.println(req.getAttributeNames().toString());
        ServletInputStream servletInputStream = req.getInputStream();

        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens;
        while ((lens = servletInputStream.read(b)) > 0) {
            content.append(new String(b, 0, lens));
        }

        String strContent = content.toString(); // 请求体内容

//        try {
//            ResultSet resultSet=JDBC.simpleQuery(
//                    "select  from ");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("请求体中的内容："+strContent);
        //String jsonString= JSONObject.toJSONString(strContent);

        JSONObject.toJSON(strContent);
        User user = JSONObject.parseObject(strContent,User.class);
        System.out.println("user:"+user);

        int nums=0;

        try {
            nums=userDao.selectUserByUser(user);
        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("nums:"+nums);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        LoginRespMessage loginRespMessage=new LoginRespMessage();
        if(nums>0) {
            loginRespMessage.setResponseMessageStatus(ResponseMessageStatus.SUCCESS);
            loginRespMessage.setMessageInfo("用户名和密码正确");
        }else{
            loginRespMessage.setMessageInfo("用户名或者密码不正确");
            loginRespMessage.setResponseMessageStatus(ResponseMessageStatus.FAIL);
        }

        PrintWriter printWriter=resp.getWriter();
        //printWriter.print(JSONObject.toJSON(strContent));
        printWriter.print(JSONObject.toJSON(loginRespMessage));

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
