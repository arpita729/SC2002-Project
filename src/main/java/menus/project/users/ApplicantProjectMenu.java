package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.users.applicant.*;
import menus.Menu;
import menus.enquiry.DeleteEnquiryMenu;
import menus.enquiry.EditEnquiryMenu;
import menus.project.EnquiryMenu;

/**
 * The ApplicantProjectMenu class provides a menu interface for applicants to interact
 * with project-related options such as applying for a project or making enquiries.
 */
public class ApplicantProjectMenu {

    /**
     * A private static inner class extending Menu to define the applicant project menu.
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
         * Displays the menu. This method is currently empty and can be overridden
         * for specific functionality.
         */
        public void menu() {}
    }

    private static BaseClass baseClass = new BaseClass(
        "Applicant Project Options", 
        ""
    );

    /**
     * Sets the options for the applicant project menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ApplyMenu.get(),
            EnquiryMenu.get(),
            EditEnquiryMenu.get(),
            DeleteEnquiryMenu.get()
        ));
    }

    /**
     * Retrieves the applicant project menu instance.
     * 
     * @return The applicant project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
