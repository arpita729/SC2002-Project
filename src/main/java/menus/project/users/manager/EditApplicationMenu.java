package menus.project.users.manager;

import java.util.Arrays;

import arrays.Applications;
import items.*;
import managers.ApplicationManager;
import menus.*;

public class EditApplicationMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("Select an application by ID: ");
            Application ap = Applications.getApplication(i);
            println("Select an option:\n1: Approve \n2: Reject \n3: Approve Withdrawal \n4: Reject Withdrawal \nDefault: Cancel");
            int j = getInt("Option: ");
            switch (j) {
                case 1 -> ApplicationManager.approve(ap, true);
                case 2 -> ApplicationManager.approve(ap, false);
                case 3 -> ApplicationManager.approveWithdraw(ap, true);
                case 4 -> ApplicationManager.approveWithdraw(ap, false);
                default -> {}
            }
            println("Completed.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Modify Application ", 
        "Modify Application "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicationMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}

