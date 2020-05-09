package Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author gaobaishun
 * @Date 2020-04-23 13:13
 * imformation：发送http请求的工具
 */
public class HttpUtils {
    private static Logger logger= LogManager.getLogger(HttpUtils.class);
    public static String postRequest(String httpUrl,String param){
        logger.info("Post请求url：",httpUrl);
        logger.info("");
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }

    public static Object postRequest(String httpUrl,String param,Class cla){
        String result=postRequest(httpUrl,param);
        return JSONObject.parseObject(result,cla);
    }

    public static String getRequest(String httpurl){
        HttpURLConnection httpURLConnection=null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串

            // 创建远程url连接对象
        URL url = null;
        try {
            url = new URL(httpurl);

            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            httpURLConnection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            httpURLConnection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            httpURLConnection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            httpURLConnection.setReadTimeout(60000);

            // 发送请求
            httpURLConnection.connect();

            // 通过connection连接，获取输入流
            if (httpURLConnection.getResponseCode() == 200) {
                is = httpURLConnection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            httpURLConnection.disconnect();// 关闭远程连接
        }

        return result;
    }

    public static Object getRequest(String url,Class claz){
        String result=getRequest(url);
        return JSONObject.parseObject(result,claz);
    }


    public static String servletInputStreamToString(ServletInputStream servletInputStream) throws IOException {

        StringBuilder reqContent = new StringBuilder();
        byte[] b = new byte[1024];
        int lens;
        while ((lens = servletInputStream.read(b)) > 0) {
            reqContent.append(new String(b, 0, lens));
        }

        return reqContent.toString();
    }

    public static void main(String[] args) {
        //System.out.println(getRequest("http://localhost:8081/Servlet_war_exploded2/HelloWorld"));
        String param="{\n" +
                "\t\"username\":\"gaobaishun\",\n" +
                "\t\"password\":\"123\",\n" +
                "\t\"success\": true\n" +
                "}";
        System.out.println(postRequest("http://localhost:8081/Servlet_war_exploded2/login",param));
    }



}
