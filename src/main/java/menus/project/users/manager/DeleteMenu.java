package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import managers.ProjectManager;
import menus.*;
import menus.project.*;

/**
 * The DeleteMenu class provides a menu interface for deleting a project.
 * It allows users to confirm the deletion of a selected project.
 */
public class DeleteMenu {

    /**
     * A private static inner class extending ProjectDetails to handle project deletion.
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
         * Displays the menu and processes the deletion of a project.
         * Prompts the user to confirm the deletion before proceeding.
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
            int i = getInt("Confirm Delete? Type 1 to accept: ");
            if (i == 1) {
                ProjectManager.delete(p);
                println("Project Deleted.");
            } else {
                println("Delete Cancelled, returning to main menu.");
            }
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Delete Project", 
        "Deleting Project..."
    );

    /**
     * Sets the options for the delete project menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
        ));
    }

    /**
     * Retrieves the delete project menu instance.
     * 
     * @return The delete project menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
