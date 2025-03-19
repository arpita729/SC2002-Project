package menus;

import java.util.Arrays;

import managers.AppUserManager;

public class HomeMenu {
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
        "Welcome to HDB Management App."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(LogoutMenu.get(),ExitMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
