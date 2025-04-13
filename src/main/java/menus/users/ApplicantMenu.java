package menus.users;

import java.util.Arrays;

import menus.*;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
import managers.AppUserManager;
import menus.users.applicant.*;

public class ApplicantMenu {
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
        "Welcome to HDB Management App, Applicant."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            ApplyMenu.get(),
            StatusMenu.get(),
            HistoryMenu.get(),
            PasswordChangeMenu.get(),
            ExitMenu.get()
        ));
        ApplyMenu.setOptions();
        StatusMenu.setOptions();
        HistoryMenu.setOptions();
        WithdrawMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
