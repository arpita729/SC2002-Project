package menus.users.officer;

import arrays.Projects;
import items.OfficerApplication;
import managers.OfficerApplicationManager;
import menus.HomeMenu;
import menus.IdMenu;
import menus.Menu;
import menus.project.ProjectSelectMenu;

import java.util.Arrays;

public class ApplyMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            int id = IdMenu.getId();
            if (id == -1) {
                ProjectSelectMenu.get().display();
            }
            items.Project p = Projects.getProject(id);
            println("Applying for: " + p.toString());
            OfficerApplication oa = OfficerApplicationManager.apply(p);
            println(oa.toString());
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Apply as officer for project",
            "Applying for project"
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
