package menus;

import java.util.Arrays;

import managers.AppUserManager;

/**
 * The PasswordChangeMenu class provides a menu interface for users to change their password.
 * It validates the current password and ensures the new passwords match before updating.
 */
public class PasswordChangeMenu { 

    /**
     * A private static inner class extending Menu to handle the password change functionality.
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
         * Displays the menu and processes the password change request.
         * Prompts the user for the current password, new password, and confirmation.
         * Throws an exception if the new passwords do not match.
         * 
         * @throws IllegalArgumentException If the new passwords do not match.
         */
        public void menu() throws IllegalArgumentException {
            String old = getString("Current Password: ");
            String new1 = getString("New Password: ");
            String new2 = getString("Confirm Password: ");
            if (!new1.equals(new2)) throw new IllegalArgumentException("passwords are different!");
            AppUserManager.changePassword(old, new2);
            println("Password Changed Successfully.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Change Password", 
        "Please fill in the following details." 
    );

    /**
     * Sets the options for the password change menu, including navigation to the home menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    /**
     * Retrieves the password change menu instance.
     * 
     * @return The password change menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
