package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

public class EditMenu {
    private static class BaseClass extends ProjectDetails {
        public BaseClass(String d, String i) {
            super(d,i);
        };
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
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Edit Project Details", 
        "Editting Project Details..."
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
