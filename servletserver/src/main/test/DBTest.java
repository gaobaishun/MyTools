import Entity.MenuDO;
import com.server.servletserver.HelloWorld;
import com.server.servletserver.dao.MenuDao;
import com.server.servletserver.utils.DBConfig;
import com.server.servletserver.utils.JDBC;
import org.junit.Test;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author gaobaishun
 * @Date 2020-05-09 10:40
 * imformation：
 */
public class DBTest {
    private void init(){
        //先加载DB配置文件
        DBConfig.Loading();

        //JDBC创建连接
        JDBC.createCon();
    }

    @Test
    public void JDBCTest() throws IOException {
        //init();
        String url=DBTest.class.getResource("").getPath();
        System.out.println("1:"+url);
        url=DBTest.class.getResource("/").getPath();
        System.out.println("2:"+url);

        File directory = new File("");//参数为空 
        String courseFile = directory.getCanonicalPath();
        System.out.println("3:"+courseFile);

        url=this.getClass().getClassLoader().getResource("").getPath();
        System.out.println("4:"+url);

        //url= HelloWorld.class.getClassLoader().getResource("/resource").getPath();

        System.out.println("5:"+url);



//        MenuDao menuDao=new MenuDao();
//        try {
//            List<MenuDO> list=menuDao.selectAllMenu();
//            ListIterator<MenuDO> menuDOListIterator = list.listIterator();
//            while (menuDOListIterator.hasNext()){
//                MenuDO menuDO=menuDOListIterator.next();
//                System.out.println(menuDO);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
