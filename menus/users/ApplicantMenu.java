package menus.users;

import java.util.Arrays;

import menus.*;
import managers.AppUserManager;

public class ApplicantMenu {
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
        "Welcome to HDB Management App, Applicant."
    );

    public static void setOptions() {
        // add navigation options here
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ExitMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
