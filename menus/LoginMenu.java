package menus;

import java.util.Arrays;

import managers.AppUserManager;

public class LoginMenu { 
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() throws IllegalArgumentException {
            String ic = getString("NRIC: ");
            String password = getString("Password: ");
            AppUserManager.login(ic, password);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Login Page", 
        "Welcome to HDB Management App. Please login to continue." 
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
