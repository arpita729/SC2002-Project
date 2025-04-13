package menus;

import java.util.Arrays;

/**
 * The ExitMenu class provides a menu option to exit the application.
 * It terminates the program when selected.
 */
public class ExitMenu {

    /**
     * A private static inner class extending Menu to handle the exit functionality.
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
         * Exits the application by terminating the program.
         */
        public void menu() {
            System.exit(0);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Quit", 
        "Shutting Down..."
    );

    /**
     * Sets the options for the exit menu, including navigation to the login menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(LoginMenu.get()));
    }

    /**
     * Retrieves the exit menu instance.
     * 
     * @return The exit menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
