package menus.project;

import java.util.Arrays;

import arrays.Enquiries;
import arrays.Projects;
import items.*;
import managers.EnquiryManager;
import menus.*;

/**
 * The ReplyEnquiryMenu class provides a menu interface for replying to enquiries
 * related to a specific project.
 */
public class ReplyEnquiryMenu {

    /**
     * A private static inner class extending IdMenu to handle replying to enquiries.
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
         * Displays the menu and processes the reply to a selected enquiry.
         * If the project is deleted or invalid, an exception is thrown.
         */
        public void menu() {
            Project p = null;
            if (getId() == -1) return;
            try {
                p = Projects.getProject(getId());
            } catch (Exception e) {
                setId(-1);
                return;
            }
            
            if (p.getDeleted()) throw new IllegalArgumentException("Deleted Entry!");

            int i = getInt("Select an enquiry by ID: ");
            Enquiry e = Enquiries.getEnquiry(i);
            String s = getString("Type your enquiry: ");
            EnquiryManager.reply(e, s);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Reply to Enquiry", 
        "Reply to Enquiry: "
    );

    /**
     * Sets the options for the reply enquiry menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the reply enquiry menu instance.
     * 
     * @return The reply enquiry menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
