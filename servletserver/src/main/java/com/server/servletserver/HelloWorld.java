package com.server.servletserver; /**
 * @Author gaobaishun
 * @Date 2020-04-19 18:30
 * imformation：
 */
// 导入必需的 java 库

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 扩展 HttpServlet 类
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置响应内容类型
        response.setContentType("text/html");

        System.out.println("request URL"+request.getRequestURL());
        System.out.println("requeat URI"+request.getRequestURI());
        System.out.println("request getQueryString（请求行）:"+request.getQueryString());
        System.out.println("request getRemoteAddr(客户端的Ip)"+request.getRemoteAddr());
        System.out.println("request getRemoteHost(返回客户机的主机名)"+request.getRemoteHost());
        System.out.println("request getRemotePort(返回客户机所使用的端口号)"+request.getRemotePort());
        System.out.println("request getLocalAddr(返回WEB服务器的ip地址)"+request.getLocalAddr());
        System.out.println("request getLocalName(返回WEB服务器的主机名)"+request.getLocalName());
        System.out.println("request getMethoD(获取请求方法)");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy()
    {
        // 什么也不做
    }
}

