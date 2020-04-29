package javaFxDemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 13:18
 * imformation：列表视图demo
 */
public class ListViewDemo extends Application {

    //滚条测试
    public void scrollTest(ListView<String> list){
        //以index为30的节点为焦点。
        list.getFocusModel().focus(30);
        //滚至91
        //list.scrollTo(91);
        //滚至节点"30的位置"
        list.scrollTo("30");
    }
    @Override
    public void start(final Stage primaryStage) {
        ListView<String> list = new ListView<String>();
        List<String> list2=new ArrayList();
        for (int i = 0; i <100 ; i++) {
            if(i==1){
                list2.add(i+"sdfdddddddddddddddddddddddddddddddddddddddddddddd");
            }else {
                list2.add(i + "");
            }
        }
//        ObservableList<String> items = FXCollections.observableArrayList (
//                "Single", "Double", "Suite", "Family App");
        ObservableList<String> items = FXCollections.observableArrayList (list2);
        list.setItems(items);

        list.setFixedCellSize(50);
        scrollTest(list);
        //设置宽度和长度
        list.setPrefWidth(200);
        //list.setPrefHeight(400);

        GridPane gridPane=new GridPane();
        gridPane.add(list,0,0);

        Scene scene=new Scene(gridPane,600,400);

//        list.setPrefWidth(scene.getWidth());
//        list.setPrefHeight(scene.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
