package menus.users;

import java.util.Arrays;

import menus.*;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
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
        // TODO add more options here (apply, application status, etc.)
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            ExitMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
