package managers;

import menus.*;

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
        ProjectListMenu.setOptions();
        ProjectFilterMenu.setOptions();

        // display login
        LoginMenu.get().display();
    }
}
