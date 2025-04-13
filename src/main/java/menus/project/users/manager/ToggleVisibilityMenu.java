package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

/**
 * The ToggleVisibilityMenu class provides a menu interface for toggling the visibility
 * of a project. It allows users to make a project visible or hidden.
 */
public class ToggleVisibilityMenu {

    /**
     * A private static inner class extending IdMenu to handle visibility toggling.
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
         * Displays the menu and toggles the visibility of the selected project.
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
            p.setVisibility(!p.isVisible());
            println("Visibility set to " + (p.isVisible() ? "yes" : "no"));
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Toggle Visibility", 
        ""
    );

    /**
     * Sets the options for the toggle visibility menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    /**
     * Retrieves the toggle visibility menu instance.
     * 
     * @return The toggle visibility menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
