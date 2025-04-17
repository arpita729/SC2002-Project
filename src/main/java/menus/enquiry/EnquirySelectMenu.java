package menus.enquiry;

import java.util.Arrays;

import menus.IdMenu;
import menus.Menu;

/**
 * The EnquirySelectMenu class provides a menu interface for selecting a enquiry by ID.
 * It allows users to navigate to the selected enquiry's view or return to the home menu.
 */
public class EnquirySelectMenu {

    /**
     * A private static inner class extending IdMenu to handle enquiry selection.
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
         * Displays the menu and prompts the user to input a enquiry ID.
         * If the input is -1, the user is redirected to the home menu.
         */
        public void menu() {
            int i = getInt("ID: ");
            if (i == -1) return; // redirect to home
            setId(i); // set the ID of the enquiry to display
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Select an Enquiry", 
        "Select an Enquiry by ID, or blank to go back. "
    );

    /**
     * Sets the options for the enquiry select menu, including navigation to the home menu
     * or the enquiry view menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            EnquiryListMenu.get() // back to list
        ));
    }

    /**
     * Retrieves the enquiry select menu instance.
     * 
     * @return The enquiry select menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
