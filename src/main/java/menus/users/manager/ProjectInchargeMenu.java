package menus.users.manager;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Projects;
import items.Project;
import items.users.Manager;
import managers.AppUserManager;
import managers.ProjectFilterManager;
import menus.Menu;
import menus.project.*;

public class ProjectInchargeMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            ArrayList<Project> list = ProjectFilterManager.filter(Projects.filter((Manager)AppUserManager.getCurrentUser()));
            for (Project p : list) println(p.toString());
            if (list.isEmpty()) println("No Projects Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "List Projects In-Charge", 
        "Projects:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectSelectMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
