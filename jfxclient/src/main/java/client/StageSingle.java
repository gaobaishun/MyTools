package client;

import javafx.stage.Stage;

/**
 * @Author gaobaishun
 * @Date 2020-04-30 15:58
 * imformation：stage单例
 */
public class StageSingle {
    private static Stage singleStage=null;

    public static void setStage(Stage stage){
        if (singleStage==null) {
            synchronized (StageSingle.class) {
                if (singleStage == null) {
                    singleStage = stage;
                }
            }
        }
    }

    public static Stage getStage(){
        if (singleStage!=null){
                    return singleStage;
        }
        return null;
    }


}
