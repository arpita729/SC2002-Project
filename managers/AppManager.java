package managers;

import menus.*;
import menus.project.ProjectListMenu;
import menus.project.ProjectViewMenu;
import menus.projectFilter.ProjectFilterMenu;
import menus.users.applicant.ApplyMenu;

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
