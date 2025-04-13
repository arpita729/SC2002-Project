package menus;

import java.util.Arrays;

import managers.AppUserManager;

public class LogoutMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            AppUserManager.logout();
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Logout", 
        "Logging out..."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(LoginMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
