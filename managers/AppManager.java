package managers;

import menus.ExitMenu;
import menus.HomeMenu;
import menus.LoginMenu;
import menus.LogoutMenu;

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

        // display login
        LoginMenu.get().display();
    }
}
