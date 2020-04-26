package javaFxDemo;


import Entity.User;
import Message.LoginRespMessage;
import UI.LoginUI;
import Utils.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @Author gaobaishun
 * @Date 2020-04-05 16:36
 * imformation：https://www.cnblogs.com/hhhshct/p/8523697.html
 */
public class ClientStart extends Application{
    public void start(final Stage primaryStage) throws Exception {
        Button btn = new Button();
        btn.setText("登录");


        Button btn2 = new Button();
        btn2.setText("登录2");

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World!2");
            }
        });
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(btn2);

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);

        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,50,25,50));
        gridPane.add(btn,0,3);
        gridPane.add(btn2,1,3);
        Text scenetitle = new Text("请输入账号密码或者登记");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(scenetitle, 0, 0, 2, 1);

        Label userNameLabel = new Label("UserName");
        Label passwordLabel = new Label("Password");

        //文本输入框
        final TextField userNameField=new TextField();

        //密码输入框
        final PasswordField pwBox = new PasswordField();
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(passwordLabel, 0,2);
        gridPane.add(userNameField, 1, 1);
        gridPane.add(pwBox,1,2);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                System.out.println("用户名文本框输入内容是："+userNameField.getText());
                System.out.println("密码框输入的内容为："+pwBox.getText());
                String userName=userNameField.getText();
                String password=pwBox.getText();
                User user=new User();
                user.setUserName(userName);
                user.setPassword(password);

                String param= JSONObject.toJSONString(user);
                String result=HttpUtils.postRequest("http://localhost:8081/Servlet_war_exploded2/login",
                        param);
                LoginRespMessage respMessage=JSONObject.parseObject(result,LoginRespMessage.class);
                System.out.println(respMessage.toString());
                primaryStage.setScene(new Scene(new LoginUI()));
            }
        });
        gridPane.setGridLinesVisible(true);


        Scene scene = new Scene(gridPane,600,400);

        primaryStage.setTitle("GBS");
        primaryStage.setScene(scene);

        //不可放大
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
