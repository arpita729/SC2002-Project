package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

/**
 * The NameFilterMenu class provides a menu for filtering applicants
 * based on their names. It allows users to input a name query or clear
 * the filter by leaving the input blank.
 */
public class NameFilterMenu {

    /**
     * A private static inner class that extends the Menu class to provide
     * functionality for filtering by name.
     */
    private static class BaseClass extends Menu {

        /**
         * Constructs a BaseClass instance with the given description and instructions.
         *
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d, i);
        }

        /**
         * Displays the menu and processes the user's input to set the name filter.
         * If the input is blank, the filter is cleared.
         */
        public void menu() {
            String s = getString("Type your query: ");
            if (s.length() == 0) s = null;
            ApplicantFilterManager.setName(s);
        }
    }

    // Static instance of the BaseClass
    private static BaseClass baseClass = new BaseClass(
        "Project Name", 
        "Please input your name search query or leave blank to clear."
    );

    /**
     * Sets the options for the BaseClass menu using the ApplicantFilterMenu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    /**
     * Retrieves the BaseClass menu instance.
     *
     * @return The BaseClass menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
