package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.EnquiryMenu;
import menus.project.ReplyEnquiryMenu;
import menus.project.users.officer.BookMenu;
import menus.project.users.officer.ApplicationListMenu;
import menus.project.users.officer.ReceiptMenu;
import menus.users.applicant.ApplyMenu;

/**
 * The OfficerProjectMenu class provides a menu interface for officers to interact
 * with project-related options such as managing applications, viewing receipts, and replying to enquiries.
 */
public class OfficerProjectMenu {
    /**
     * A private static inner class extending Menu to define the officer project menu.
     */
    private static class BaseClass extends Menu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d,i);
        };

        /**
         * Displays the menu. This method is currently empty and can be overridden
         * for specific functionality.
         */
        public void menu() {};
    }

    private static BaseClass baseClass = new BaseClass(
        "Officer Project Options", 
        ""
    );

    /**
     * Sets the options for the officer project menu, including functionalities
     * such as replying to enquiries, managing applications, and viewing receipts.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ApplyMenu.get(),
            EnquiryMenu.get(),
            ReplyEnquiryMenu.get(),
            ApplicationListMenu.get(),
            ReceiptMenu.get()
        ));
        EnquiryMenu.setOptions();
        ReplyEnquiryMenu.setOptions();
        ApplicationListMenu.setOptions();
        BookMenu.setOptions();
        ReceiptMenu.setOptions();
    }

    /**
     * Retrieves the officer project menu instance.
     * 
     * @return The officer project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
