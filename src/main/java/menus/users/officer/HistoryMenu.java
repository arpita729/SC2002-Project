package menus.users.officer;

import java.util.ArrayList;
import java.util.Arrays;

import menus.*;
import managers.*;
import arrays.OfficerApplications;
import items.users.*;
import items.OfficerApplication;

/**
 * The HistoryMenu class provides a menu interface for officers to view their
 * application history. It displays all officer applications submitted by the current user.
 */
public class HistoryMenu {

    /**
     * A private static inner class extending Menu to handle officer application history viewing.
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
         * Displays the menu and lists the application history of the current officer.
         * If the current user is not an officer, an error message is displayed.
         */
        public void menu() {
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Officer)) {  //typecast check
                println("Error: Only officers can apply for this.");
                return;
            }
            Officer applicant = (Officer) currentUser; // safe cast
            ArrayList<OfficerApplication> list = OfficerApplications.filter(applicant);
            for (OfficerApplication a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
            println("");
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Officer Positions & Applications (Withdraw from Here)",
            "Officer Applications: "
    );

    /**
     * Sets the options for the history menu, including navigation to the home menu,
     * view menu, and withdraw menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ViewMenu.get(),
            WithdrawMenu.get()
        ));
    }

    /**
     * Retrieves the history menu instance.
     * 
     * @return The history menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
