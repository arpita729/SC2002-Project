package menus.users.manager;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Projects;
import items.Project;
import items.users.Manager;
import managers.AppUserManager;
import managers.ProjectFilterManager;
import menus.Menu;
import menus.project.*;

/**
 * The ProjectInchargeMenu class provides a menu interface for managers to view
 * the list of projects they are in charge of. It displays filtered projects based on the manager.
 */
public class ProjectInchargeMenu {

    /**
     * A private static inner class extending Menu to handle the listing of projects
     * managed by the current user.
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
         * Displays the menu and lists projects managed by the current user.
         * If no projects are found, a message is displayed.
         */
        public void menu() {
            ArrayList<Project> list = ProjectFilterManager.filter(Projects.filter((Manager)AppUserManager.getCurrentUser()));
            for (Project p : list) println(p.toString());
            if (list.isEmpty()) println("No Projects Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Projects In-Charge", 
        "Projects:"
    );

    /**
     * Sets the options for the project in-charge menu, including navigation to the project select menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectSelectMenu.get()));
    }

    /**
     * Retrieves the project in-charge menu instance.
     * 
     * @return The project in-charge menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
