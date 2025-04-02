package menus.users.applicant;

import managers.AppUserManager;
import menus.*;

import java.util.Arrays;


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
            if(ap == null){
                println("No application found. You have not applied for any project yet.");
            }else {
                println("Project: " + ap.getProject().toString());
                println("Application Status: " + ap.getStatus().name());
            }
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Check Application Status",
            ""
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
