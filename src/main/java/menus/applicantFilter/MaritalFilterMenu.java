package menus.applicantFilter;

import java.util.Arrays;

import items.users.User.MaritalStatus;
import menus.*;
import managers.ApplicantFilterManager;

/**
 * The MaritalFilterMenu class provides a menu for filtering applicants
 * based on their marital status. It allows users to select specific
 * marital statuses or clear the filter.
 */
public class MaritalFilterMenu {

    /**
     * A private static inner class that extends the Menu class to provide
     * functionality for selecting marital statuses.
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
         * Displays the menu and processes the user's input to set the marital status filter.
         */
        public void menu() {
            int i = getInt("Option: ");
            MaritalStatus f = switch (i) {
                case 1 -> MaritalStatus.MARRIED;
                case 2 -> MaritalStatus.SINGLE;
                default -> null;
            };
            ApplicantFilterManager.setMaritalStatus(f);
        }
    }

    // Static instance of the BaseClass
    private static BaseClass baseClass = new BaseClass(
        "Applicant's Marital Status", 
        "Please choose between:\n1: Married\n2: Single\nDefault: Clear filter"
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
