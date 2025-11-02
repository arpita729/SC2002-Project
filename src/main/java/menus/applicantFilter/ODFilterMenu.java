package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

/**
 * The ODFilterMenu class provides a menu interface for filtering applicants
 * based on project opening dates. It allows users to specify a date range.
 */
public class ODFilterMenu  {

    /**
     * A private static inner class extending Menu to handle opening date filtering.
     */
    private static class BaseClass extends Menu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d,i);
        };

        /**
         * Displays the menu and processes the user's input for opening date filtering.
         */
        public void menu() {
            println("Select date A (Blank to clear): ");
            ApplicantFilterManager.setStartOD(GetDate.getDate());
            println("Select date B (Blank to clear): ");
            ApplicantFilterManager.setEndOD(GetDate.getDate());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Opening Date", 
        "Filter for opening dates between dates A and B. (A should be before B)"
    );

    /**
     * Sets the options for the opening date filter menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    /**
     * Retrieves the opening date filter menu instance.
     * 
     * @return The opening date filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
