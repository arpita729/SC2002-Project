package menus.project.users.manager;

import java.util.Arrays;

import arrays.OfficerApplications;
import items.*;
import managers.OfficerApplicationManager;
import menus.*;

/**
 * The EditOApplicationMenu class provides a menu interface for modifying officer applications.
 * It allows users to approve, reject, or handle withdrawal requests for officer applications.
 */
public class EditOApplicationMenu {

    /**
     * A private static inner class extending IdMenu to handle officer application modifications.
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
         * Displays the menu and processes the modification of an officer application.
         * Users can select an application by ID and choose an action to perform.
         */
        public void menu() {
            int i = getInt("Select an application by ID: ");
            OfficerApplication ap = OfficerApplications.getOfficerApplication(i);
            println("Select an option:\n1: Approve \n2: Reject \n3: Approve Withdrawal \n4: Reject Withdrawal \nDefault: Cancel");
            int j = getInt("Option: ");
            switch (j) {
                case 1 -> OfficerApplicationManager.approve(ap, true);
                case 2 -> OfficerApplicationManager.approve(ap, false);
                case 3 -> OfficerApplicationManager.approveWithdraw(ap, true);
                case 4 -> OfficerApplicationManager.approveWithdraw(ap, false);
                default -> {}
            }
            println("Completed.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Modify Officer Application ", 
        "Modify Officer Application "
    );

    /**
     * Sets the options for the edit officer application menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            OfficerApplicationMenu.get()
        ));
    }

    /**
     * Retrieves the edit officer application menu instance.
     * 
     * @return The edit officer application menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}

