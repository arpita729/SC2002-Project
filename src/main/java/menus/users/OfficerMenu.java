package menus.users;

import java.util.Arrays;

import menus.*;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
import menus.users.officer.*;
import managers.AppUserManager;

/**
 * The OfficerMenu class provides the main menu interface for officers.
 * It allows officers to navigate through various functionalities such as
 * applying for projects, managing applications, and viewing project details.
 */
public class OfficerMenu {

    /**
     * A private static inner class extending Menu to define the officer's home page.
     */
    private static class BaseClass extends Menu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d, i);
        }

        /**
         * Displays the menu and shows the current user's name.
         */
        public void menu() {
            println("User: " + AppUserManager.getCurrentUser().getName());
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Home Page", 
        "Welcome to HDB Management App, Officer"
    );

    /**
     * Sets the options for the officer menu, including navigation to project-related
     * menus, application management menus, and account settings.
     */
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

    /**
     * Retrieves the officer menu instance.
     * 
     * @return The officer menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
