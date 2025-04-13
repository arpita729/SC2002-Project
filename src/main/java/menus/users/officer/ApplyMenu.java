package menus.users.officer;

import arrays.Projects;
import items.OfficerApplication;
import managers.OfficerApplicationManager;
import menus.HomeMenu;
import menus.IdMenu;
import menus.Menu;
import menus.project.ProjectSelectMenu;

import java.util.Arrays;

/**
 * The ApplyMenu class provides a menu interface for officers to apply for a project.
 * It allows officers to select a project and submit an application.
 */
public class ApplyMenu {

    /**
     * A private static inner class extending Menu to handle officer project applications.
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
         * Prompts the officer to select a project and submits the application.
         */
        public void menu() {
            int id = IdMenu.getId();
            if (id == -1) {
                ProjectSelectMenu.get().display();
            }
            items.Project p = Projects.getProject(id);
            println("Applying for: " + p.toString());
            OfficerApplication oa = OfficerApplicationManager.apply(p);
            println(oa.toString());
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Apply as officer for project",
            "Applying for project"
    );

    /**
     * Sets the options for the apply menu, including navigation to the home menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
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
