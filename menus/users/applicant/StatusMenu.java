package menus.users.applicant;

import managers.AppUserManager;
import menus.*;
import menus.project.ProjectViewMenu;
import items.users.*;
import items.Application;

import java.util.Arrays;


public class StatusMenu {
    private static class BaseClass extends Menu {
        private Application ap;
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            Applicant applicant = (Applicant) currentUser; // safe cast
            ap = applicant.getApplication();
            if(ap == null){
                println("No application found. You have not applied for any project yet.");
            } else {
                println(ap.toString());
                IdMenu.setId(ap.getProject().getId());
            }
        };
        public Menu options() {
            if (ap == null) return getOptions().get(0);
            return super.options();
        }
    }

    private static BaseClass baseClass = new BaseClass(
            "Check Application Status",
            ""
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ProjectViewMenu.get(),
            WithdrawMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
