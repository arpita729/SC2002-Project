package menus.projectFilter;

import java.util.Arrays;

import menus.*;
import managers.ProjectFilterManager;

/**
 * The NameFilterMenu class provides a menu interface for filtering projects
 * based on their names. It allows users to input a search query or clear the filter.
 */
public class NameFilterMenu {

    /**
     * A private static inner class extending Menu to handle name-based filtering.
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
         * Displays the menu and processes the user's input for name-based filtering.
         * Users can input a search query or leave it blank to clear the filter.
         */
        public void menu() {
            String s = getString("Type your query: ");
            if (s.length() == 0) s = null;
            ProjectFilterManager.setName(s);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Name", 
        "Please input your name search query or leave blank to clear. "
    );

    /**
     * Sets the options for the name filter menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    /**
     * Retrieves the name filter menu instance.
     * 
     * @return The name filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
