package menus;

import java.util.Arrays;

import managers.AppUserManager;

/**
 * The LoginMenu class provides a menu interface for users to log in to the application.
 * It prompts users for their NRIC and password and validates their credentials.
 */
public class LoginMenu { 

    /**
     * A private static inner class extending Menu to handle the login functionality.
     */
    private static class BaseClass extends Menu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d, i, true);
        }

        /**
         * Displays the login menu and prompts the user for their NRIC and password.
         * Validates the credentials using the AppUserManager.
         * 
         * @throws IllegalArgumentException If the login credentials are invalid.
         */
        public void menu() throws IllegalArgumentException {
            String ic = getString("NRIC: ");
            String password = getString("Password: ");
            AppUserManager.login(ic, password);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Login Page", 
        "Welcome to HDB Management App. Please login to continue." 
    );

    /**
     * Sets the options for the login menu, including navigation to the home menu upon successful login.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    /**
     * Retrieves the login menu instance.
     * 
     * @return The login menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
