package menus.project.users.manager;

import java.util.Arrays;

import arrays.OfficerApplications;
import items.*;
import managers.OfficerApplicationManager;
import menus.*;

public class EditOApplicationMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("Select an application by ID: ");
            OfficerApplication ap = OfficerApplications.getOfficerApplication(i);
            println("Select an option:\n1: Approve \n2: Reject \n3: Approve Withdrawal \n4: Reject Withdrawal \nDefault: Cancel");
            int j = getInt("Option: ");
            switch (j) {
                case 1 -> OfficerApplicationManager.approve(ap, true);
                case 2 -> OfficerApplicationManager.approve(ap, false);
                case 3 -> OfficerApplicationManager.approveWithdraw(ap, true);
                case 4 -> OfficerApplicationManager.approveWithdraw(ap, false);
                default -> {}
            }
            println("Completed.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Modify Officer Application ", 
        "Modify Officer Application "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            OfficerApplicationMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}

