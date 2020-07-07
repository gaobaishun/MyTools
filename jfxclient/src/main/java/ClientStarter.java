import UI.LoginUI;
import Utils.PropertiesHandler;
import client.ClientContext;
import client.StageSingle;
import javaFxDemo.ClientStart;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @Author gaobaishun
 * @Date 2020-04-24 11:04
 * imformation：
 */
public class ClientStarter extends Application {
    private static Logger logger= LogManager.getLogger(ClientStarter.class);
    public static void initLocal(){
        logger.info("开始加载properties配置文件");
        String basePropertiesUrl= ClientStarter.class.getResource("/").getPath()+"base.properties";
        String uriPropertiesUrl=ClientStarter.class.getResource("/").getPath()+"uri.properties";
        logger.debug("默认base.properties文件路径为："+basePropertiesUrl);
        logger.debug("默认uri.properties文件路径为："+uriPropertiesUrl);

        try {
            PropertiesHandler baseProHandler=new PropertiesHandler(basePropertiesUrl);
            PropertiesHandler uriProHandler=new PropertiesHandler(uriPropertiesUrl);
            ClientContext.setPropertiesHandler("base",baseProHandler);
            ClientContext.setPropertiesHandler("uri",uriProHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("加载properties配置文件结束");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initLocal();
        StageSingle.setStage(primaryStage);
        LoginUI loginUI=new LoginUI();
        Scene scene=new Scene(loginUI,300,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
