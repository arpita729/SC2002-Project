package menus.projectFilter;

import java.util.Arrays;

import managers.ProjectFilterManager;
import menus.HomeMenu;
import menus.Menu;

/**
 * The ProjectFilterMenu class provides a menu interface for applying filters
 * to projects. It allows users to filter projects by various fields such as
 * flat type, name, neighbourhood, opening date, and closing date.
 */
public class ProjectFilterMenu {

    /**
     * A private static inner class extending Menu to handle project filtering.
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
         * Displays the menu and shows the current filters applied to projects.
         * Prompts the user to select a field to filter by.
         */
        public void menu() {
            println(ProjectFilterManager.getString());
            println("Please select which field to filter by.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Filter Projects", 
        "Current Filters:"
    );

    /**
     * Sets the options for the project filter menu, including various filter menus
     * such as flat type, name, neighbourhood, opening date, and closing date.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(), 
            FlatTypeFilterMenu.get(),
            NameFilterMenu.get(),
            NeighFilterMenu.get(),
            ODFilterMenu.get(),
            CDFilterMenu.get()
        ));
        // call the other setOptions here to reduce clutter
        FlatTypeFilterMenu.setOptions();
        NameFilterMenu.setOptions();
        NeighFilterMenu.setOptions();
        ODFilterMenu.setOptions();
        CDFilterMenu.setOptions();
    }

    /**
     * Retrieves the project filter menu instance.
     * 
     * @return The project filter menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
