package menus;

import java.util.Arrays;

import items.users.User.UserType;
import menus.project.*;
import menus.users.*;
import menus.projectFilter.ProjectFilterMenu;
import managers.AppUserManager;

/**
 * The HomeMenu class redirects users to their respective menus based on their user type.
 * It serves as the entry point after login and provides navigation to user-specific functionalities.
 */
public class HomeMenu {

    /**
     * A private static inner class extending Menu to define the home page functionality.
     */
    private static class BaseClass extends Menu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d, i);
        }

        /**
         * Resets the ID to -1 when the home menu is displayed.
         */
        public void menu() {
            IdMenu.setId(-1);
        }

        /**
         * Determines the next menu option based on the current user's type.
         * 
         * @return The next menu option for the user.
         */
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

    /**
     * Sets the options for the home menu, including navigation to user-specific menus
     * and other global functionalities such as login, logout, and password change.
     */
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

    /**
     * Retrieves the home menu instance.
     * 
     * @return The home menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
