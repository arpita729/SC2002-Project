package menus.users.officer;

import java.util.ArrayList;
import java.util.Arrays;

import menus.*;
import managers.*;
import arrays.OfficerApplications;
import items.users.*;
import items.OfficerApplication;

public class HistoryMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            User currentUser = AppUserManager.getCurrentUser();
            if (!(currentUser instanceof Officer)) {  //typecast check
                println("Error: Only officers can apply for this.");
                return;
            }
            Officer applicant = (Officer) currentUser; // safe cast
            ArrayList<OfficerApplication> list = OfficerApplications.filter(applicant);
            for (OfficerApplication a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
            println("");
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Officer Positions & Applications (Withdraw from Here)",
            "Officer Applications: "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ViewMenu.get(),
            WithdrawMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
