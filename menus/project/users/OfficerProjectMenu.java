package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;

public class OfficerProjectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {};
    }

    private static BaseClass baseClass = new BaseClass(
        "Officer Project Options", 
        ""
    );

    public static void setOptions() {
        // TODO add officer's available options
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
