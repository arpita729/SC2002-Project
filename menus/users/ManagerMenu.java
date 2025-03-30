package menus.users;

import java.util.Arrays;

import menus.*;
import managers.AppUserManager;

public class ManagerMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println("User: " + AppUserManager.getCurrentUser().getIc());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Home Page", 
        "Welcome to HDB Management App, Manager"
    );

    public static void setOptions() {
        // add navigation options here
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ExitMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
