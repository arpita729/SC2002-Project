package menus.users.officer;

import java.util.Arrays;

import arrays.OfficerApplications;
import managers.OfficerApplicationManager;
import items.OfficerApplication;
import menus.*;

public class WithdrawMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            int id = IdMenu.getId();
            if (id == -1) {
                ApplicationSelectMenu.get().display();
                id = IdMenu.getId();
            }
            OfficerApplication ap = OfficerApplications.getOfficerApplication(id);
            OfficerApplicationManager.withdraw(ap);
            println("Withdrawal Pending... ");
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Request Withdraw Officer Application",
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
