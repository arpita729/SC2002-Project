package menus.users.applicant;

import java.util.ArrayList;
import java.util.Arrays;

import menus.*;
import managers.*;
import arrays.Applications;
import items.users.*;
import items.Application;

public class HistoryMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Applicant)) {  //typecast check
                println("Error: Only applicants can apply for projects.");
                return;
            }
            Applicant applicant = (Applicant) currentUser; // safe cast
            ArrayList<Application> list = Applications.filter(applicant);
            for (Application a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "View Application History",
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
