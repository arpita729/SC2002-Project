package menus.users.applicant;

import arrays.Projects;
import items.Application;
import managers.AppUserManager;
import managers.ApplicationManager;
import menus.IdMenu;
import menus.Menu;
import menus.project.ProjectSelectMenu;
import items.users.User;
import items.users.Applicant;


import java.util.Arrays;

import static menus.IdMenu.getId;

public class ApplyMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            Applicant applicant = (Applicant) currentUser; // safe cast
            if (IdMenu.getId() == -1) {
                ProjectSelectMenu.get().display();
            }
            items.Project p = Projects.getProject(getId());
            println("Applying for: " + p.toString());
            int r = getInt("Desired number of rooms: ");
            switch (r) {
                case 2:
                    applicant.setApplication(ApplicationManager.apply(p, Application.FlatType.TWO_ROOM));
                    break;
                case 3:
                    applicant.setApplication(ApplicationManager.apply(p, Application.FlatType.THREE_ROOM));
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
