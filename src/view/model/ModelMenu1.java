
package view.model;

import javax.swing.Icon;

public class ModelMenu1 {
    public Icon getMenuName() {
        return menuName;
    }

    public void setMenuName(Icon menuName) {
        this.menuName = menuName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public ModelMenu1(Icon menuName, Icon icon) {
        this.menuName = menuName;
        this.icon = icon;
    }

    public ModelMenu1() {
    }

    private Icon menuName;
    private Icon icon;
}
