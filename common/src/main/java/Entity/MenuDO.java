package Entity;

import java.io.Serializable;

/**
 * @Author gaobaishun
 * @Date 2020-04-28 12:56
 * imformation：
 */
public class MenuDO implements Serializable {
    private int menuId;
    private String menuName;
    /**
     * 父节点id
     */
    private int fatherId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public String toString() {
        return "MenuDO{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", fatherId=" + fatherId +
                '}';
    }
}
