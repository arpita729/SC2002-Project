package managers;

import menus.*;
import menus.project.ProjectListMenu;
import menus.projectFilter.ProjectFilterMenu;

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

        Menu menu = LoginMenu.get();
        // display login
        while (true) {
            menu = menu.display();
        }
    }
}
