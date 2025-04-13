package menus.applicantFilter;

import java.util.Arrays;

import items.Application.FlatType;
import menus.*;
import managers.ApplicantFilterManager;

/**
 * The FlatTypeFilterMenu class provides a menu for filtering applicants
 * based on the type of flat they have applied for. It allows users to
 * select specific flat types or clear the filter.
 */
public class FlatTypeFilterMenu {

    /**
     * A private static inner class that extends the Menu class to provide
     * functionality for selecting flat types.
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
         * Displays the menu and processes the user's input to set the flat type filter.
         */
        public void menu() {
            int i = getInt("Option: ");
            FlatType f = switch (i) {
                case 2 -> FlatType.TWO_ROOM;
                case 3 -> FlatType.THREE_ROOM;
                default -> null;
            };
            ApplicantFilterManager.setFlatType(f);
        }
    }

    // Static instance of the BaseClass
    private static BaseClass baseClass = new BaseClass(
        "Applied Flat Types", 
        "Please choose between:\n2: Two Room\n3: Three Room\nDefault: Clear filter"
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
