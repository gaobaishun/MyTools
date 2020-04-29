package javaFxDemo.PaneTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 14:26
 * imformation：
 */
public class BorderPaneTest extends Application {
    public void start(Stage primaryStage) throws Exception {


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


        BorderPane borderPane=new BorderPane();

        borderPane.setLeft(list);


        borderPane.setTop(new Label("Top"));
        borderPane.setCenter(new Label("Center"));
        borderPane.setBottom(new Label("Bottom"));
        borderPane.setRight(new Label("Right"));
        //borderPane.getBaselineOffset();
        borderPane.setVisible(true);
        Scene scene=new Scene(borderPane,900,600);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
