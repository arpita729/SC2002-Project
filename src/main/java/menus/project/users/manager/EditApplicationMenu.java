package menus.project.users.manager;

import java.util.Arrays;

import arrays.Applications;
import items.*;
import managers.ApplicationManager;
import menus.*;

/**
 * The EditApplicationMenu class provides a menu interface for modifying applications.
 * It allows users to approve, reject, or handle withdrawal requests for applications.
 */
public class EditApplicationMenu {

    /**
     * A private static inner class extending IdMenu to handle application modifications.
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
         * Displays the menu and processes the modification of an application.
         * Users can select an application by ID and choose an action to perform.
         */
        public void menu() {
            int i = getInt("Select an application by ID: ");
            Application ap = Applications.getApplication(i);
            println("Select an option:\n1: Approve \n2: Reject \n3: Approve Withdrawal \n4: Reject Withdrawal \nDefault: Cancel");
            int j = getInt("Option: ");
            switch (j) {
                case 1 -> ApplicationManager.approve(ap, true);
                case 2 -> ApplicationManager.approve(ap, false);
                case 3 -> ApplicationManager.approveWithdraw(ap, true);
                case 4 -> ApplicationManager.approveWithdraw(ap, false);
                default -> {}
            }
            println("Completed.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Modify Application ", 
        "Modify Application "
    );

    /**
     * Sets the options for the edit application menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicationMenu.get()
        ));
    }

    /**
     * Retrieves the edit application menu instance.
     * 
     * @return The edit application menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}

