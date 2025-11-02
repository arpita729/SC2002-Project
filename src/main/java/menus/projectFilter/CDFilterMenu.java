package menus.projectFilter;

import java.util.Arrays;

import menus.*;
import managers.ProjectFilterManager;

/**
 * The CDFilterMenu class provides a menu interface for filtering projects
 * based on their closing dates. It allows users to specify a date range.
 */
public class CDFilterMenu  {

    /**
     * A private static inner class extending Menu to handle closing date filtering.
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
         * Displays the menu and processes the user's input for closing date filtering.
         * Users can specify a start date (A) and an end date (B).
         */
        public void menu() {
            println("Select date A (Blank to clear): ");
            ProjectFilterManager.setStartCD(GetDate.getDate());
            println("Select date B (Blank to clear):");
            ProjectFilterManager.setEndCD(GetDate.getDate());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Closing Date", 
        "Filter for closing dates between dates A and B. (A should be before B)"
    );

    /**
     * Sets the options for the closing date filter menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    /**
     * Retrieves the closing date filter menu instance.
     * 
     * @return The closing date filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
