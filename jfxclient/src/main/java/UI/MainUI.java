package UI;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 15:22
 * imformation：主页UI
 */
public class MainUI extends BorderPane{


    public MainUI(){
        super();
        init();
    }

    private void init(){
        this.setTop(addTop());
        this.setBottom(addBottom());
        this.setLeft(addLeft());
        this.setRight(addRight());
        this.setCenter(addCenter());
    }

    private Node addCenter() {
        return null;
    }

    private Node addRight() {
            return null;
    }

    private Node addLeft() {

        return null;
    }

    private Node addBottom() {
        return null;
    }

    private Node addTop(){
        return null;
    }




}
