package menus.project.users.manager;

import java.util.Arrays;

import menus.*;
import menus.project.ProjectViewMenu;

/**
 * The CreateMenu class provides a menu interface for creating a new project.
 * It allows users to input project details and generates a new project ID.
 */
public class CreateMenu {

    /**
     * A private static inner class extending ProjectDetails to handle project creation.
     */
    private static class BaseClass extends ProjectDetails {
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
         * Displays the menu and processes the creation of a new project.
         * It retrieves project details from the user and assigns a new project ID.
         */
        public void menu() {
            int id = getProjectDetails(null).getId();
            println("Project created with ID " + id + ".");
            IdMenu.setId(id);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Create New Project", 
        "Enter the New Project's Details."
    );

    /**
     * Sets the options for the create project menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the create project menu instance.
     * 
     * @return The create project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
