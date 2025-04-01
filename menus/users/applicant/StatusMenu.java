package menus.users.applicant;

import arrays.Projects;
import items.Application;
import managers.AppUserManager;
import managers.ApplicationManager;
import menus.IdMenu;
import menus.Menu;
import menus.project.ProjectViewMenu;
import menus.project.users.ApplicantProjectMenu;

import java.util.Arrays;

import static menus.IdMenu.getId;

public class StatusMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            items.users.User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof items.users.Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            items.users.Applicant applicant = (items.users.Applicant) currentUser; // safe cast
            items.Application ap = applicant.getApplication();
            println("Application Status: " + ap.getStatus().name());
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Check Application Status",
            ""
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
