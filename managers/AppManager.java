package managers;

import menus.ExitMenu;
import menus.HomeMenu;
import menus.LoginMenu;
import menus.LogoutMenu;
import menus.users.ApplicantMenu;
import menus.users.ManagerMenu;
import menus.users.OfficerMenu;

public class AppManager {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        // initialise menus
        ExitMenu.setOptions();
        HomeMenu.setOptions();
        LoginMenu.setOptions();
        LogoutMenu.setOptions();
        ApplicantMenu.setOptions();
        ManagerMenu.setOptions();
        OfficerMenu.setOptions();

        // display login
        LoginMenu.get().display();
    }
}
