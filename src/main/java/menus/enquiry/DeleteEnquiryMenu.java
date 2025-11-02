package menus.enquiry;

import java.util.Arrays;

import arrays.Enquiries;
import items.Enquiry;
import managers.EnquiryManager;
import menus.*;

/**
 * The EnquiryMenu class provides a menu interface for deleting enquiries
 */
public class DeleteEnquiryMenu {

    /**
     * A private static inner class extending IdMenu to handle enquiry deleting.
     */
    private static class BaseClass extends IdMenu {
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
         * Displays the menu and processes the deleting of an enquiry.
         * If the enquiry is deleted or invalid, an exception is thrown.
         */
        public void menu() {
            EnquirySelectMenu.get().display();
            Enquiry e = Enquiries.getEnquiry(getId());

            if (e.getDeleted()) throw new IllegalArgumentException("Deleted Entry!");
            EnquiryManager.delete(e);
            println("Enquiry deleted.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Delete Enquiry", 
        "Delete Enquiry: "
    );

    /**
     * Sets the options for the enquiry menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            EnquiryListMenu.get()
        ));
    }

    /**
     * Retrieves the enquiry menu instance.
     * 
     * @return The enquiry menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
