package menus.project;

import java.util.Arrays;

import menus.HomeMenu;
import menus.IdMenu;
import menus.Menu;

/**
 * The ProjectSelectMenu class provides a menu interface for selecting a project by ID.
 * It allows users to navigate to the selected project's view or return to the home menu.
 */
public class ProjectSelectMenu {

    /**
     * A private static inner class extending IdMenu to handle project selection.
     */
    private static class BaseClass extends IdMenu {
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
         * Displays the menu and prompts the user to input a project ID.
         * If the input is -1, the user is redirected to the home menu.
         */
        public void menu() {
            int i = getInt("ID: ");
            if (i == -1) return; // redirect to home
            setId(i); // set the ID of the project to display
        }

        /**
         * Determines the next menu option based on the selected project ID.
         * 
         * @return The next menu option.
         */
        public Menu options() {
            if (getId() == -1) return getOptions().get(0);
            return getOptions().get(1);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Select a Project", 
        "Select a Project by ID to View, or blank to go back. "
    );

    /**
     * Sets the options for the project select menu, including navigation to the home menu
     * or the project view menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the project select menu instance.
     * 
     * @return The project select menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
