package menus;

import java.util.Arrays;

import items.users.User.UserType;
import menus.project.*;
import menus.users.*;
import menus.projectFilter.ProjectFilterMenu;
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
                case APPLICANT -> getOptions().get(0);
                case OFFICER -> getOptions().get(1);
                case MANAGER -> getOptions().get(2);
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
        ExitMenu.setOptions();
        LoginMenu.setOptions();
        LogoutMenu.setOptions();
        
        ApplicantMenu.setOptions();
        OfficerMenu.setOptions();
        ManagerMenu.setOptions();

        ProjectFilterMenu.setOptions();
        ProjectListMenu.setOptions();
        ProjectSelectMenu.setOptions();
        ProjectViewMenu.setOptions();

        PasswordChangeMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
