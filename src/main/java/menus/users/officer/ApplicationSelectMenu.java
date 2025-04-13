package menus.users.officer;

import java.util.Arrays;

import arrays.OfficerApplications;
import items.OfficerApplication;
import managers.AppUserManager;
import menus.HomeMenu;
import menus.IdMenu;
import menus.Menu;

/**
 * The ApplicationSelectMenu class provides a menu interface for officers to select
 * an officer application by ID. It validates the selection and redirects accordingly.
 */
public class ApplicationSelectMenu {

    /**
     * A private static inner class extending Menu to handle officer application selection.
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
         * Displays the menu and prompts the user to input an officer application ID.
         * Validates the selection and sets the ID for further actions.
         * If the selection is invalid, the user is redirected to the home menu.
         */
        public void menu() {
            int i = getInt("ID: ");
            if (i == -1) return; // redirect to home
            OfficerApplication ap = null;
            try {
                ap = OfficerApplications.getOfficerApplication(i);
            } catch (Exception e) {
                IdMenu.setId(-1);
                return;
            }
            if (ap.getApplicant() != AppUserManager.getCurrentUser()) {
                println("Invalid Selection!");
                IdMenu.setId(-1);
                return;
            }
            IdMenu.setId(i); // set the ID of the project to display
        }

        /**
         * Determines the next menu option based on the selected officer application ID.
         * 
         * @return The next menu option.
         */
        public Menu options() {
            if (IdMenu.getId() == -1) return getOptions().get(0);
            return getOptions().get(1);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Select an Officer Application", 
        "Select an Officer Application by ID to View, or blank to go back. "
    );

    /**
     * Sets the options for the application select menu, including navigation to the home menu
     * and the withdraw menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            WithdrawMenu.get()
        ));
    }

    /**
     * Retrieves the application select menu instance.
     * 
     * @return The application select menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
