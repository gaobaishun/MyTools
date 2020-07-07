package UI;

import Entity.User;
import Message.LoginRespMessage;
import Utils.HttpUtils;
import client.StageSingle;
import com.alibaba.fastjson.JSONObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
 * @Date 2020-04-24 10:18
 * imformation：
 */
public class LoginUI extends GridPane {
        private Label userNameLabel;
        private Label passwordLabel;
        private Button btn;

        //文本输入框
        final TextField userNameField=new TextField();

        //密码输入框
        final PasswordField pwBox = new PasswordField();
        public LoginUI(){
            super();
            init();
            //Label userNameLabel = new Label("UserName");

        }

        private void init(){
            userNameLabel = new Label("UserName");
            passwordLabel = new Label("Password");
            btn= new Button();
            btn.setText("登录");
            Text scenetitle = new Text("请输入账号密码");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            this.add(scenetitle, 0, 0, 2, 1);
            this.setPadding(new Insets(25,50,25,50));
            this.add(userNameLabel, 0, 1);
            this.add(passwordLabel, 0,2);
            this.add(userNameField, 1, 1);
            this.add(pwBox,1,2);
            this.add(btn,0,3);
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
                    String result= HttpUtils.postRequest("http://localhost:8081/servletserver_war/login",
                            param);
                    LoginRespMessage respMessage=JSONObject.parseObject(result,LoginRespMessage.class);
                    System.out.println(respMessage.toString());
                    Stage primaryStage=StageSingle.getStage();
                    primaryStage.setScene(null);
//                    Stage stage=(Stage)threadLocal.get();
                    //stage.setScene(null);
                    //primaryStage.setScene(null);
                }
            });
        }
}
