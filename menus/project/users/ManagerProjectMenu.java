package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.ReplyEnquiryMenu;
import menus.project.users.manager.*;
import menus.project.users.officer.ReceiptMenu;

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
        // TODO add filter applicants, etc.
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            EditMenu.get(),
            DeleteMenu.get(),
            ReceiptMenu.get(),
            ToggleVisibilityMenu.get(),
            ApplicationMenu.get(),
            OfficerApplicationMenu.get(),
            ReplyEnquiryMenu.get()
        ));
        ToggleVisibilityMenu.setOptions();
        ApplicationMenu.setOptions();
        OfficerApplicationMenu.setOptions();
        EditApplicationMenu.setOptions();
        EditOApplicationMenu.setOptions();
        CreateMenu.setOptions();
        DeleteMenu.setOptions();
        EditMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
