package menus.users;

import java.util.Arrays;

import menus.*;
import menus.enquiry.EnquiryListMenu;
import menus.project.*;
import menus.projectFilter.ProjectFilterMenu;
import managers.AppUserManager;
import menus.users.applicant.*;

/**
 * The ApplicantMenu class provides the main menu interface for applicants.
 * It allows applicants to navigate through various functionalities such as
 * applying for projects, viewing application status, and managing their account.
 */
public class ApplicantMenu {

    /**
     * A private static inner class extending Menu to define the applicant's home page.
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
        "Welcome to HDB Management App, Applicant."
    );

    /**
     * Sets the options for the applicant menu, including navigation to project-related
     * menus, application management menus, and account settings.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            LogoutMenu.get(),
            ProjectListMenu.get(),
            ProjectFilterMenu.get(),
            ProjectSelectMenu.get(),
            ApplyMenu.get(),
            StatusMenu.get(),
            HistoryMenu.get(),
            EnquiryListMenu.get(),
            PasswordChangeMenu.get(),
            ExitMenu.get()
        ));
        ApplyMenu.setOptions();
        StatusMenu.setOptions();
        HistoryMenu.setOptions();
        WithdrawMenu.setOptions();
    }

    /**
     * Retrieves the applicant menu instance.
     * 
     * @return The applicant menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
