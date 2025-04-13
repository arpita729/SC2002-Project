package menus.applicantFilter;

import java.util.Arrays;

import managers.ApplicantFilterManager;
import menus.HomeMenu;
import menus.Menu;

/**
 * ApplicantFilterMenu provides a user interface for filtering housing applications
 * based on various applicant attributes such as age, marital status, and project details.
 * <p>
 * It displays the current filters applied via {@link ApplicantFilterManager}
 * and provides navigation to specific submenus to update each filter type.
 */
public class ApplicantFilterMenu {

    /**
     * Inner class extending {@link Menu}, defines the main display for
     * the applicant filter menu.
     */
    private static class BaseClass extends Menu {
        
        /**
         * Constructs the base class menu with a title and description.
         *
         * @param d Description or title of the menu.
         * @param i Instruction text displayed to the user.
         */
        public BaseClass(String d, String i) {
            super(d, i);
        }

        /**
         * Displays the current filters using {@link ApplicantFilterManager#getString()}
         * and prompts the user to select a field to filter by.
         */
        @Override
        public void menu() {
            println(ApplicantFilterManager.getString());
            println("Please select which field to filter by.");
        }
    }

    /** Singleton instance of the main applicant filter menu. */
    private static BaseClass baseClass = new BaseClass(
        "Filter Applications", 
        "Current Filters:"
    );

    /**
     * Sets all available submenu options for filtering.
     * <p>
     * Includes filters such as:
     * - Age
     * - Marital Status
     * - Flat Type
     * - Project Name
     * - Neighborhood
     * - Opening Date
     * - Closing Date
     * <p>
     * Also recursively sets options for each submenu to initialize their internal trees.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(), 
            AgeFilterMenu.get(),
            MaritalFilterMenu.get(),
            FlatTypeFilterMenu.get(),
            NameFilterMenu.get(),
            NeighFilterMenu.get(),
            ODFilterMenu.get(),
            CDFilterMenu.get()
        ));
        
        // Initialize submenus
        AgeFilterMenu.setOptions();
        MaritalFilterMenu.setOptions();
        FlatTypeFilterMenu.setOptions();
        NameFilterMenu.setOptions();
        NeighFilterMenu.setOptions();
        ODFilterMenu.setOptions();
        CDFilterMenu.setOptions();
    }

    /**
     * Returns the main filter menu for applicants.
     *
     * @return A {@link Menu} representing the root of the filter system.
     */
    public static Menu get() {
        return baseClass;
    }
}
