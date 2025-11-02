package menus.project.users.officer;

import java.util.Arrays;

import arrays.Applications;
import items.*;
import managers.ApplicationManager;
import menus.*;
import menus.project.*;

/**
 * The BookMenu class provides a menu interface for officers to book an application.
 * It allows users to select an application by ID and mark it as booked.
 */
public class BookMenu {

    /**
     * A private static inner class extending IdMenu to handle application booking.
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
         * Displays the menu and processes the booking of an application.
         * Users can select an application by ID to mark it as booked.
         */
        public void menu() {
            int i = getInt("Select an application by ID: ");
            Application ap = Applications.getApplication(i);
            ApplicationManager.book(ap);
            println("Application booked.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Book Application ", 
        "Book Application "
    );

    /**
     * Sets the options for the book application menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the book application menu instance.
     * 
     * @return The book application menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}

