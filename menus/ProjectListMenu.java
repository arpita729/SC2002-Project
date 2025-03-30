package menus;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Projects;
import items.Project;
import managers.ProjectFilterManager;

public class ProjectListMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            ArrayList<Project> list = ProjectFilterManager.filter(Projects.getAllProjects());
            for (Project p : list) println(p.toString());
            if (list.isEmpty()) println("No Projects Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "List Projects", 
        "Projects:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
