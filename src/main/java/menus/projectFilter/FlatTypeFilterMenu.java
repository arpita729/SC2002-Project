package menus.projectFilter;

import java.util.Arrays;

import items.Application.FlatType;
import menus.*;
import managers.ProjectFilterManager;

/**
 * The FlatTypeFilterMenu class provides a menu interface for filtering projects
 * based on the availability of specific flat types (e.g., Two Room, Three Room).
 */
public class FlatTypeFilterMenu {

    /**
     * A private static inner class extending Menu to handle flat type filtering.
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
         * Displays the menu and processes the user's input for flat type filtering.
         * Users can select between Two Room, Three Room, or clear the filter.
         */
        public void menu() {
            int i = getInt("Option: ");
            FlatType f = switch (i) {
                case 2 -> FlatType.TWO_ROOM;
                case 3 -> FlatType.THREE_ROOM;
                default -> null;
            };
            ProjectFilterManager.setHasFlatType(f);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Available Flat Types", 
        "Please choose between:\n2: Two Room\n3: Three Room\nDefault: Clear filter"
    );

    /**
     * Sets the options for the flat type filter menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    /**
     * Retrieves the flat type filter menu instance.
     * 
     * @return The flat type filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
