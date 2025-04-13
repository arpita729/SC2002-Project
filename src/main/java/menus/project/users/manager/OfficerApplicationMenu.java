package menus.project.users.manager;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

/**
 * The OfficerApplicationMenu class provides a menu interface for managing and viewing
 * officer applications associated with a specific project.
 */
public class OfficerApplicationMenu {

    /**
     * A private static inner class extending IdMenu to handle officer application listing.
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
         * Displays the menu and lists officer applications for the selected project.
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
            println("Remaining Officer Slots: " + p.getOfficerSlots() + "\n");
            ArrayList<OfficerApplication> list = OfficerApplications.filter(p);
            for (OfficerApplication a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "List Officer Applications", 
        "OFFICER APPLICATIONS"
    );

    /**
     * Sets the options for the officer application menu.
     */
    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get(),
            EditOApplicationMenu.get()
        ));
    }

    /**
     * Retrieves the officer application menu instance.
     * 
     * @return The officer application menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
