package menus.users;

import java.util.Arrays;

import menus.*;
import menus.applicantFilter.ApplicantFilterMenu;
import menus.project.*;
import menus.project.users.manager.CreateMenu;
import menus.projectFilter.ProjectFilterMenu;
import menus.users.manager.ApplicantListMenu;
import menus.users.manager.ProjectInchargeMenu;
import managers.AppUserManager;

public class ManagerMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println("User: " + AppUserManager.getCurrentUser().getName());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Home Page", 
        "Welcome to HDB Management App, Manager"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            CreateMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            ProjectInchargeMenu.get(),
            ApplicantListMenu.get(),
            ApplicantFilterMenu.get(),
            PasswordChangeMenu.get(),
            ExitMenu.get()
        ));
        ProjectInchargeMenu.setOptions();
        ApplicantListMenu.setOptions();
        ApplicantFilterMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
