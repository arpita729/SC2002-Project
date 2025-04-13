package menus.users.officer;

import java.util.Arrays;

import menus.*;
import menus.project.ProjectViewMenu;
import arrays.OfficerApplications;

/**
 * The ViewMenu class provides a menu interface for officers to view the project
 * associated with a selected officer application.
 */
public class ViewMenu {

    /**
     * A private static inner class extending Menu to handle viewing the project
     * associated with an officer application.
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
         * Displays the menu and sets the project ID associated with the selected
         * officer application. If no application is selected, it redirects to the
         * application selection menu.
         */
        public void menu() {
            int id = IdMenu.getId();
            if (id == -1) {
                ApplicationSelectMenu.get().display();
                id = IdMenu.getId();
            }
            IdMenu.setId(OfficerApplications.getOfficerApplication(id).getProject().getId());
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "View Application's Project",
            ""
    );

    /**
     * Sets the options for the view menu, including navigation to the project view menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the view menu instance.
     * 
     * @return The view menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
