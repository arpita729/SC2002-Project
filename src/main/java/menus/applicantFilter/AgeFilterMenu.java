package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

/**
 * AgeFilterMenu handles the UI logic for filtering applicants by their age.
 * <p>
 * This menu prompts the user to input an age range (A to B), then applies
 * the filter using {@link ApplicantFilterManager}.
 */
public class AgeFilterMenu {

    /**
     * Inner class that defines a base age filtering menu.
     * Extends {@link Menu} and overrides the {@code menu()} method to capture user input.
     */
    private static class BaseClass extends Menu {
        
        /**
         * Constructs the BaseClass menu with a description and instructions.
         * 
         * @param d Description of the filter.
         * @param i Instructions to be displayed to the user.
         */
        public BaseClass(String d, String i) {
            super(d, i);
        }

        /**
         * Displays the menu and captures user input for age filtering.
         * Sets the start and end age filters in {@link ApplicantFilterManager}.
         */
        @Override
        public void menu() {
            int a = getInt("Select age A (Blank to clear): ");
            ApplicantFilterManager.setStartAge(a);
            int b = getInt("Select age B (Blank to clear): ");
            ApplicantFilterManager.setEndAge(b);
        }
    }

    /** Singleton instance of the BaseClass menu. */
    private static BaseClass baseClass = new BaseClass(
        "Applicant's Age", 
        "Filter for ages between A and B. (A should be before B)"
    );

    /**
     * Sets the options/submenus available under this filter menu.
     * Typically called before displaying the menu hierarchy.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    /**
     * Retrieves the base menu instance for this filter.
     * 
     * @return The age filter menu.
     */
    public static Menu get() {
        return baseClass;
    }
}
