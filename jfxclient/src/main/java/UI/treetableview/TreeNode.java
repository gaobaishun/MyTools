package UI.treetableview;

import javafx.scene.control.TreeItem;

import java.util.List;

/**
 * @Author gaobaishun
 * @Date 2020-04-27 16:01
 * imformation：
 */
public class TreeNode<T> extends TreeItem<T> {
    private boolean isLeafNode=Boolean.TRUE;

    public TreeNode(T t){
        super(t);
    }

    public void addSons(List<TreeNode<T>> list){
        if (list!=null&& list.size()>0) {
            //一旦添加子节点成功，则就不是叶子节点。
            isLeafNode = Boolean.FALSE;
            this.setExpanded(true);
            this.getChildren().addAll(list);
        }
    }
}
