package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import managers.ProjectManager;
import menus.*;
import menus.project.*;

public class DeleteMenu {
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
            int i = getInt("Confirm Delete? Type 1 to accept: ");
            if (i == 1) {
                ProjectManager.delete(p);
                println("Project Deleted.");
            } else {
                println("Delete Cancelled, returning to main menu.");
            }
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Delete Project", 
        "Deleting Project..."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
