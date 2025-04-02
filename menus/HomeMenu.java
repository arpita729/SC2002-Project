package menus;

import java.util.Arrays;

import items.users.User.UserType;
import menus.project.*;
import menus.users.*;
import managers.AppUserManager;

/**
 * Redirects to the usertype's menu.
 */
public class HomeMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            IdMenu.setId(-1);
        };
        public Menu options() {
            UserType ut = AppUserManager.getCurrentUser().getType();
            return switch (ut) {
                case UserType.APPLICANT -> getOptions().get(0);
                case UserType.OFFICER -> getOptions().get(1);
                case UserType.MANAGER -> getOptions().get(2);
            };
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Home Page", 
        ""
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicantMenu.get(),
            OfficerMenu.get(),
            ManagerMenu.get()
        ));
        // set here to reduce clutter
        ApplicantMenu.setOptions();
        OfficerMenu.setOptions();
        ManagerMenu.setOptions();

        ProjectListMenu.setOptions();
        ProjectSelectMenu.setOptions();
        ProjectViewMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
