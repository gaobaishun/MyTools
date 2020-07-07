package UI;

import Entity.MenuDO;
import UI.treetableview.TreeNode;
import Utils.HttpUtils;
import client.ClientContext;
import javafx.scene.Node;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;

import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 15:22
 * imformation：主页UI
 */
public class MainUI extends BorderPane{

    private TreeTableView<String> treeTableView;


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

        return treeTableView;
    }

    private Node addBottom() {
        return null;
    }

    private Node addTop(){
        return null;
    }

    public void loadLeft(){

    }

    private List<TreeNode<String>> getRootList(){
        String httpUrl=ClientContext.getValueFromProperitiesByKey("base","baseUrl")
                +ClientContext.getValueFromProperitiesByKey("uri","menu");
        List<MenuDO> menuList = (List<MenuDO>)HttpUtils.getRequest(httpUrl,List.class);
        return null;
    }

    public static void main(String[] args) {

    }
}
