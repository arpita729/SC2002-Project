package menus.project;

import java.util.Arrays;

import arrays.Projects;
import items.Project;
import managers.EnquiryManager;
import menus.*;

/**
 * The EnquiryMenu class provides a menu interface for creating new enquiries
 * related to a specific project.
 */
public class EnquiryMenu {

    /**
     * A private static inner class extending IdMenu to handle enquiry creation.
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
         * Displays the menu and processes the creation of a new enquiry.
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

            String s = getString("Type your enquiry: ");
            EnquiryManager.create(p, s);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Create New Enquiry", 
        "Create New Enquiry: "
    );

    /**
     * Sets the options for the enquiry menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
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
