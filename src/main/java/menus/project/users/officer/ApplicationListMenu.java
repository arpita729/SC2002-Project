package menus.project.users.officer;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

/**
 * The ApplicationListMenu class provides a menu interface for officers to view
 * applications associated with a specific project.
 */
public class ApplicationListMenu {

    /**
     * A private static inner class extending IdMenu to handle application listing.
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
         * Displays the menu and lists applications for the selected project.
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
            for (Application a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Applications", 
        "Applications:"
    );

    /**
     * Sets the options for the application list menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get(),
            BookMenu.get()
        ));
    }

    /**
     * Retrieves the application list menu instance.
     * 
     * @return The application list menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
