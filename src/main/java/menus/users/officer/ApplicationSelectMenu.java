package menus.users.officer;

import java.util.Arrays;

import arrays.OfficerApplications;
import items.OfficerApplication;
import managers.AppUserManager;
import menus.HomeMenu;
import menus.IdMenu;
import menus.Menu;

public class ApplicationSelectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("ID: ");
            if (i == -1) return; // redirect to home
            OfficerApplication ap = null;
            try {
                ap = OfficerApplications.getOfficerApplication(i);
            } catch (Exception e) {
                IdMenu.setId(-1);
                return;
            }
            if (ap.getApplicant() != AppUserManager.getCurrentUser()) {
                println("Invalid Selection!");
                IdMenu.setId(-1);
                return;
            }
            IdMenu.setId(i); // set the ID of the project to display
        };
        public Menu options() {
            if (IdMenu.getId() == -1) return getOptions().get(0);
            return getOptions().get(1);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Select an Officer Application", 
        "Select an Officer Application by ID to View, or blank to go back. "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            WithdrawMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
