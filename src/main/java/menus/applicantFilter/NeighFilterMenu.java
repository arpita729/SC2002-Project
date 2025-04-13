package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

/**
 * The NeighFilterMenu class provides a menu interface for filtering applicants
 * based on their neighbourhood. It allows users to input a search query or clear it.
 */
public class NeighFilterMenu {

    /**
     * A private static inner class extending Menu to handle neighbourhood filtering.
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
         * Displays the menu and processes the user's input for neighbourhood filtering.
         */
        public void menu() {
            String s = getString("Type your query: ");
            if (s.length() == 0) s = null;
            ApplicantFilterManager.setNeigh(s);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Neighbourhood", 
        "Please input your neighbourhood search query or leave blank to clear. "
    );

    /**
     * Sets the options for the neighbourhood filter menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    /**
     * Retrieves the neighbourhood filter menu instance.
     * 
     * @return The neighbourhood filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
