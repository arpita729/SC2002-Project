package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

/**
 * CDFilterMenu provides a user interface for filtering housing applications
 * based on the closing date of the housing project.
 * <p>
 * The user can filter projects by selecting a date range for the closing date (date A and date B).
 * </p>
 */
public class CDFilterMenu {

    /**
     * Inner class extending {@link Menu}, defines the main display for
     * the project closing date filter menu.
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
         * Displays prompts for the user to select two dates (A and B) to filter projects
         * by their closing date range. Sets the dates using {@link ApplicantFilterManager#setStartCD(LocalDate)}
         * and {@link ApplicantFilterManager#setEndCD(LocalDate)}.
         */
        @Override
        public void menu() {
            println("Select date A (Blank to clear): ");
            ApplicantFilterManager.setStartCD(GetDate.getDate());
            println("Select date B (Blank to clear):");
            ApplicantFilterManager.setEndCD(GetDate.getDate());
        }
    }

    /** Singleton instance of the project closing date filter menu. */
    private static BaseClass baseClass = new BaseClass(
        "Project Closing Date", 
        "Filter for closing dates between dates A and B. (A should be before B)"
    );

    /**
     * Sets the submenu options for the project closing date filter menu.
     * <p>
     * Links this filter menu to the main applicant filter menu for navigation.
     * </p>
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    /**
     * Returns the project closing date filter menu.
     *
     * @return A {@link Menu} representing the project closing date filter option.
     */
    public static Menu get() {
        return baseClass;
    }
}
