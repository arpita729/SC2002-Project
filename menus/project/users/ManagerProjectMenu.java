package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.ReplyEnquiryMenu;

public class ManagerProjectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {};
    }

    private static BaseClass baseClass = new BaseClass(
        "Manager Project Options", 
        ""
    );

    public static void setOptions() {
        // TODO add manager's available options
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ReplyEnquiryMenu.get(),
            ReceiptMenu.get(),
            ToggleVisibilityMenu.get()
        ));
        ToggleVisibilityMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
