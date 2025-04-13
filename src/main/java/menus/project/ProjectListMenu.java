package menus.project;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Projects;
import items.Project;
import managers.ProjectFilterManager;
import menus.Menu;

/**
 * The ProjectListMenu class provides a menu interface for listing projects.
 * It displays a filtered list of projects based on the applied filters.
 */
public class ProjectListMenu {

    /**
     * A private static inner class extending Menu to handle project listing.
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
         * Displays the menu and lists projects based on the applied filters.
         * If no projects match the filters, a message is displayed.
         */
        public void menu() {
            ArrayList<Project> list = ProjectFilterManager.filter(Projects.getAllProjects());
            for (Project p : list) println(p.toString());
            if (list.isEmpty()) println("No Projects Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Projects", 
        "Projects:"
    );

    /**
     * Sets the options for the project list menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectSelectMenu.get()));
    }

    /**
     * Retrieves the project list menu instance.
     * 
     * @return The project list menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
