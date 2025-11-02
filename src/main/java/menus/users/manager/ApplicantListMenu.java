package menus.users.manager;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Applications;
import items.Application;
import managers.ApplicantFilterManager;
import menus.HomeMenu;
import menus.Menu;

/**
 * The ApplicantListMenu class provides a menu interface for managers to view
 * a filtered list of applications. It displays detailed information about each application.
 */
public class ApplicantListMenu {

    /**
     * A private static inner class extending Menu to handle the listing of applications.
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
         * Displays the menu and lists applications based on the applied filters.
         * If no applications match the filters, a message is displayed.
         */
        public void menu() {
            ArrayList<Application> list = ApplicantFilterManager.filter(Applications.getAllApplications());
            for (Application p : list) println(p.toLongString());
            if (list.isEmpty()) println("No Applications Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Applications", 
        "Applications:"
    );

    /**
     * Sets the options for the applicant list menu, including navigation to the home menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    /**
     * Retrieves the applicant list menu instance.
     * 
     * @return The applicant list menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
