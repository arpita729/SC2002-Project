package menus.users.applicant;

import java.util.ArrayList;
import java.util.Arrays;

import menus.*;
import managers.*;
import arrays.Applications;
import items.users.*;
import items.Application;

/**
 * The HistoryMenu class provides a menu interface for applicants to view their
 * application history. It displays all applications submitted by the current user.
 */
public class HistoryMenu {

    /**
     * A private static inner class extending Menu to handle application history viewing.
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
         * Displays the menu and lists the application history of the current user.
         * If the current user is not an applicant, an error message is displayed.
         */
        public void menu() {
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            Applicant applicant = (Applicant) currentUser; // safe cast
            ArrayList<Application> list = Applications.filter(applicant);
            for (Application a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "View Application History",
            ""
    );

    /**
     * Sets the options for the history menu, including navigation to the home menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
        ));
    }

    /**
     * Retrieves the history menu instance.
     * 
     * @return The history menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
