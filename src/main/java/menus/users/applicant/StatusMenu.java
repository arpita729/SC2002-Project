package menus.users.applicant;

import managers.AppUserManager;
import menus.*;
import menus.project.ProjectViewMenu;
import items.users.*;
import items.Application;

import java.util.Arrays;

/**
 * The StatusMenu class provides a menu interface for applicants to check the status
 * of their current application. It displays the application details if available.
 */
public class StatusMenu {

    /**
     * A private static inner class extending Menu to handle application status checking.
     */
    private static class BaseClass extends Menu {
        private Application ap;

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
         * Displays the menu and shows the status of the current user's application.
         * If no application is found, a message is displayed.
         */
        public void menu() {
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            Applicant applicant = (Applicant) currentUser; // safe cast
            ap = applicant.getApplication();
            if(ap == null){
                println("No application found. You have not applied for any project yet.");
            } else {
                println(ap.toString());
                IdMenu.setId(ap.getProject().getId());
            }
        }

        /**
         * Determines the next menu option based on whether the user has an application.
         * 
         * @return The next menu option.
         */
        public Menu options() {
            if (ap == null) return getOptions().get(0);
            return super.options();
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Check Application Status",
            ""
    );

    /**
     * Sets the options for the status menu, including navigation to the home menu,
     * project view menu, and withdraw menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ProjectViewMenu.get(),
            WithdrawMenu.get()
        ));
    }

    /**
     * Retrieves the status menu instance.
     * 
     * @return The status menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
