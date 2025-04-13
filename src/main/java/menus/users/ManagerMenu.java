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

/**
 * The ManagerMenu class provides the main menu interface for managers.
 * It allows managers to navigate through various functionalities such as
 * creating projects, managing applications, and filtering projects or applicants.
 */
public class ManagerMenu {

    /**
     * A private static inner class extending Menu to define the manager's home page.
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
        "Welcome to HDB Management App, Manager"
    );

    /**
     * Sets the options for the manager menu, including navigation to project-related
     * menus, applicant management menus, and account settings.
     */
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

    /**
     * Retrieves the manager menu instance.
     * 
     * @return The manager menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
