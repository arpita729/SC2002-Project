package menus.project.users.officer;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

/**
 * The ReceiptMenu class provides a menu interface for officers to view detailed
 * receipts of applications associated with a specific project.
 */
public class ReceiptMenu {

    /**
     * A private static inner class extending IdMenu to handle application receipt viewing.
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
         * Displays the menu and lists detailed receipts of applications for the selected project.
         * If no project is selected, it prompts the user to select one.
         */
        public void menu() {
            Project p = null;
            if (getId() == -1) ProjectSelectMenu.get().display();
            try {
                p = Projects.getProject(getId());
            } catch (Exception e) {
                setId(-1);
                return;
            }
            ArrayList<Application> list = Applications.filter(p);
            for (Application a : list) println(a.toLongString());
            if (list.isEmpty()) println("No Applications Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Application Receipt", 
        "APPLICATION RECEIPT"
    );

    /**
     * Sets the options for the application receipt menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the application receipt menu instance.
     * 
     * @return The application receipt menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
