package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

/**
 * The EditMenu class provides a menu interface for editing project details.
 * It allows users to modify the details of a selected project.
 */
public class EditMenu {

    /**
     * A private static inner class extending ProjectDetails to handle project editing.
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
         * Displays the menu and processes the editing of a project's details.
         * If no project is selected, it prompts the user to select one.
         */
        public void menu() {
            Project p = null;
            if (IdMenu.getId() == -1) ProjectSelectMenu.get().display();
            try {
                p = Projects.getProject(IdMenu.getId());
            } catch (Exception e) {
                IdMenu.setId(-1);
                return;
            }
            
            println("Enter the new details: ");
            getProjectDetails(p);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Edit Project Details", 
        "Editting Project Details..."
    );

    /**
     * Sets the options for the edit project menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the edit project menu instance.
     * 
     * @return The edit project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
