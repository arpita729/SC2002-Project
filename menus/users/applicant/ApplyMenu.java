package menus.users.applicant;

import arrays.Applications;
import arrays.Projects;
import items.Application;
import managers.AppUserManager;
import managers.ApplicationManager;
import menus.ExitMenu;
import menus.IdMenu;
import menus.LogoutMenu;
import menus.Menu;
import menus.project.ProjectListMenu;
import menus.project.ProjectSelectMenu;
import menus.project.ProjectViewMenu;
import menus.project.users.ApplicantProjectMenu;
import menus.projectFilter.ProjectFilterMenu;
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
            int i = getInt("ID of desired project: ");
            if (i == -1) return; // redirect to home
            IdMenu.setId(i); // set the ID of the project to display
            ProjectViewMenu.get().display();
            items.Project p = Projects.getProject(getId());
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
            "Apply for a project",
            "Please select which project you want to apply for"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
                ApplicantProjectMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
