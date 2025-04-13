package menus.users.applicant;

import arrays.Projects;
import items.Application;
import managers.ApplicationManager;
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
            int r = getInt("Desired number of rooms: ");
            switch (r) {
                case 2:
                    ApplicationManager.apply(p, Application.FlatType.TWO_ROOM);
                    break;
                case 3:
                    ApplicationManager.apply(p, Application.FlatType.THREE_ROOM);
                    break;
                default:
                    println("Invalid number of rooms selected");
                    break;
            }

        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Apply for project",
            "Applying for project"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            StatusMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
