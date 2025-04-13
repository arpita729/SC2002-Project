package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.ReplyEnquiryMenu;
import menus.project.users.manager.*;
import menus.project.users.officer.ReceiptMenu;

/**
 * The ManagerProjectMenu class provides a menu interface for managers to interact
 * with project-related options such as editing, deleting, and managing applications.
 */
public class ManagerProjectMenu {

    /**
     * A private static inner class extending Menu to define the manager project menu.
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
        "Manager Project Options", 
        ""
    );

    /**
     * Sets the options for the manager project menu, including various project management
     * functionalities such as editing, deleting, toggling visibility, and managing applications.
     */
    public static void setOptions() {
        // TODO add filter applicants, etc.
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            EditMenu.get(),
            DeleteMenu.get(),
            ReceiptMenu.get(),
            ToggleVisibilityMenu.get(),
            ApplicationMenu.get(),
            OfficerApplicationMenu.get(),
            ReplyEnquiryMenu.get()
        ));
        ToggleVisibilityMenu.setOptions();
        ApplicationMenu.setOptions();
        OfficerApplicationMenu.setOptions();
        EditApplicationMenu.setOptions();
        EditOApplicationMenu.setOptions();
        CreateMenu.setOptions();
        DeleteMenu.setOptions();
        EditMenu.setOptions();
    }

    /**
     * Retrieves the manager project menu instance.
     * 
     * @return The manager project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
