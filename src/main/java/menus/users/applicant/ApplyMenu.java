package menus.users.applicant;

import arrays.Projects;
import items.Application;
import managers.ApplicationManager;
import menus.IdMenu;
import menus.Menu;
import menus.project.ProjectSelectMenu;


import java.util.Arrays;

/**
 * The ApplyMenu class provides a menu interface for applicants to apply for a project.
 * It allows users to select a project and specify the desired number of rooms.
 */
public class ApplyMenu {

    /**
     * A private static inner class extending Menu to handle project applications.
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
         * Displays the menu and processes the application for a project.
         * Prompts the user to select a project and specify the desired number of rooms.
         */
        public void menu() {
            int id = IdMenu.getId();
            if (id == -1) {
                ProjectSelectMenu.get().display();
                id = IdMenu.getId();
            }
            items.Project p = Projects.getProject(id);
            println("Applying for: " + p.toString());
            int r = getInt("Desired number of rooms: ");
            switch (r) {
                case 2:
                    ApplicationManager.apply(p, Application.FlatType.TWO_ROOM);
                    break;
                case 3:
                    ApplicationManager.apply(p, Application.FlatType.THREE_ROOM);
                    break;
                default:
                    println("Invalid number of rooms selected");
                    break;
            }
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Apply for project",
            "Applying for project"
    );

    /**
     * Sets the options for the apply menu, including navigation to the status menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            StatusMenu.get()
        ));
    }

    /**
     * Retrieves the apply menu instance.
     * 
     * @return The apply menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
