package menus;

import java.util.Arrays;

import managers.AppUserManager;

/**
 * The LogoutMenu class provides a menu interface for users to log out of the application.
 * It clears the current user's session and redirects to the login menu.
 */
public class LogoutMenu {

    /**
     * A private static inner class extending Menu to handle the logout functionality.
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
         * Logs out the current user by clearing their session using the AppUserManager.
         */
        public void menu() {
            AppUserManager.logout();
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Logout", 
        "Logging out..."
    );

    /**
     * Sets the options for the logout menu, including navigation to the login menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(LoginMenu.get()));
    }

    /**
     * Retrieves the logout menu instance.
     * 
     * @return The logout menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
