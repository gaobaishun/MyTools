package javaFxDemo;

import UI.treetableview.TreeNode;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
//import javafx.scene.control.TreeNode;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 16:16
 * imformation：
 */
public class TreeNodeViewDemo extends Application {
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tree Table View Samples");
        final Scene scene = new Scene(new Group(), 600, 400);
        Group sceneRoot = (Group)scene.getRoot();

        //Creating tree items
        final TreeNode<String> childNode1 = new TreeNode<>("Child Node 1");
        final TreeNode<String> childNode2 = new TreeNode<>("Child Node 2");
        final TreeNode<String> childNode3 = new TreeNode<>("Child Node 3");
        List<TreeNode<String>> list=new ArrayList<>();
        list.add(childNode1);
        list.add(childNode2);
        list.add(childNode3);
        //Creating the root element
        final TreeNode<String> root = new TreeNode<String>("Root node");
        //root.setExpanded(true);

//        //Adding tree items to the root
//        root.getChildren().setAll(childNode1, childNode2, childNode3);
        root.addSons(list);
        //Creating a column
        TreeTableColumn<String,String> column = new TreeTableColumn<String, String>("Column");
        column.setPrefWidth(150);

        //Defining cell content
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue().getValue()));

        //Creating a tree table view
        final TreeTableView<String> treeTableView = new TreeTableView<>(root);
        treeTableView.getColumns().add(column);
        treeTableView.setPrefWidth(152);
        treeTableView.setShowRoot(true);
        sceneRoot.getChildren().add(treeTableView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
