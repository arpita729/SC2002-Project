package menus.enquiry;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Enquiries;
import items.Enquiry;
import items.users.Applicant;
import managers.AppUserManager;
import menus.HomeMenu;
import menus.Menu;

/**
 * The EnquiryListMenu class provides a menu interface for listing enquiries.
 * It displays a filtered list of enquiries.
 */
public class EnquiryListMenu {

    /**
     * A private static inner class extending Menu to handle enquiry listing.
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
         * Displays the menu and lists enquiries based on the applied filters.
         * If no enquiries match the filters, a message is displayed.
         */
        public void menu() {
            ArrayList<Enquiry> list = Enquiries.filter((Applicant)AppUserManager.getCurrentUser());
            for (Enquiry p : list) println(p.toString());
            if (list.isEmpty()) println("No Enquiries Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Enquiries", 
        "Enquiries:"
    );

    /**
     * Sets the options for the enquiry list menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            EditEnquiryMenu.get(),
            DeleteEnquiryMenu.get()
        ));
        DeleteEnquiryMenu.setOptions();
        EditEnquiryMenu.setOptions();
        EnquirySelectMenu.setOptions();
    }

    /**
     * Retrieves the enquiry list menu instance.
     * 
     * @return The enquiry list menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
