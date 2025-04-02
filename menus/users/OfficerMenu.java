package menus.users;

import java.util.Arrays;

import menus.*;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
import menus.users.applicant.*;
import managers.AppUserManager;

public class OfficerMenu {
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
        "Welcome to HDB Management App, Officer"
    );

    public static void setOptions() {
        // TODO add more options here (applicant options, projects in charge, etc.)
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            ApplyMenu.get(),
            StatusMenu.get(),
            ExitMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
