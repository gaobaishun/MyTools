package com.server.servletserver.Filter;

import Utils.HttpUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author gaobaishun
 * @Date 2020-04-29 12:37
 * imformation：
 */
public class LogFilter implements Filter {

    private static Logger logger= LogManager.getLogger(LogFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info(filterConfig.getFilterName()+" start");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("servletServe 收到请求");
        String protocol=servletRequest.getProtocol();
        logger.debug("协议及版本号"+protocol);
        if ("HTTP/1.1".equals(protocol)){
            HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;

            //请求行
            StringBuilder reqLine=new StringBuilder();
            reqLine.append(httpServletRequest.getMethod()+"  "+httpServletRequest.getRequestURI()+"   "+protocol);
            logger.debug("请求行："+reqLine);


            //请求头
            StringBuilder reqHeadStrBuild =new StringBuilder();
            Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String tempHeaderName=headerNames.nextElement();
                String tempHeaderValue=httpServletRequest.getHeader(tempHeaderName);
                reqHeadStrBuild.append(tempHeaderName+":"+tempHeaderValue+" | ");
            }
            logger.debug("请求头："+reqHeadStrBuild);


            // 请求体内容
            if("POST".equals(httpServletRequest.getMethod())){
                //这里执行两次servletInputStreamToString
                String body=HttpUtils.servletInputStreamToString(httpServletRequest.getInputStream());
                logger.debug("请求体："+body);
                servletRequest.setAttribute("requestBody",body);
            }

        }

        filterChain.doFilter(servletRequest,servletResponse);


        logger.debug("过滤器执行完毕");
    }

    @Override
    public void destroy() {
        logger.info(LogFilter.class.getName()+" destroy");
    }
}
