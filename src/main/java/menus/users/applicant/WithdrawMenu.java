package menus.users.applicant;

import java.util.Arrays;

import managers.ApplicationManager;
import menus.*;

/**
 * The WithdrawMenu class provides a menu interface for applicants to request
 * the withdrawal of their application. It processes the withdrawal request.
 */
public class WithdrawMenu {

    /**
     * A private static inner class extending Menu to handle application withdrawal requests.
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
         * Displays the menu and processes the withdrawal request for the current user's application.
         * A message is displayed indicating that the withdrawal is pending.
         */
        public void menu() {
            ApplicationManager.withdraw();
            println("Withdrawal Pending... ");
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Request Withdraw Application",
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
