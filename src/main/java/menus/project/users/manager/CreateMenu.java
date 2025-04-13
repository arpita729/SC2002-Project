package menus.project.users.manager;

import java.util.Arrays;

import menus.*;
import menus.project.ProjectViewMenu;


public class CreateMenu {
    private static class BaseClass extends ProjectDetails {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int id = getProjectDetails(null).getId();
            println("Project created with ID " + id + ".");
            IdMenu.setId(id);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Create New Project", 
        "Enter the New Project's Details."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
