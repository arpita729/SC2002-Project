package menus.users.officer;

import java.util.Arrays;

import arrays.OfficerApplications;
import managers.OfficerApplicationManager;
import items.OfficerApplication;
import menus.*;

/**
 * The WithdrawMenu class provides a menu interface for officers to request
 * the withdrawal of their officer application. It processes the withdrawal request.
 */
public class WithdrawMenu {

    /**
     * A private static inner class extending Menu to handle officer application withdrawal requests.
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
         * Displays the menu and processes the withdrawal request for the selected officer application.
         * If no application is selected, it redirects to the application selection menu.
         */
        public void menu() {
            int id = IdMenu.getId();
            if (id == -1) {
                ApplicationSelectMenu.get().display();
                id = IdMenu.getId();
            }
            OfficerApplication ap = OfficerApplications.getOfficerApplication(id);
            OfficerApplicationManager.withdraw(ap);
            println("Withdrawal Pending... ");
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Request Withdraw Officer Application",
            ""
    );

    /**
     * Sets the options for the withdraw menu, including navigation to the home menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
        ));
    }

    /**
     * Retrieves the withdraw menu instance.
     * 
     * @return The withdraw menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
