package menus.users;

import java.util.Arrays;

import menus.*;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
import menus.users.officer.*;
import managers.AppUserManager;

public class OfficerMenu {
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
        "Welcome to HDB Management App, Officer"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            menus.users.applicant.ApplyMenu.get(),
            menus.users.applicant.StatusMenu.get(),
            menus.users.applicant.HistoryMenu.get(),
            ApplyMenu.get(),
            HistoryMenu.get(),
            WithdrawMenu.get(),
            PasswordChangeMenu.get(),
            ExitMenu.get()
        ));
        ApplyMenu.setOptions();
        HistoryMenu.setOptions();
        ApplicationSelectMenu.setOptions();
        ViewMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
