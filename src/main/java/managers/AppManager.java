package managers;

import data.ExcelReader;
import menus.*;

public class AppManager {
    public static void main(String[] args) {
        ExcelReader.loadUsers();
        ExcelReader.loadProjects();
        startApp();
    }

    public static void startApp() {
        // initialise menus
        HomeMenu.setOptions();

        Menu menu = LoginMenu.get();
        // display login
        while (true) {
            menu = menu.display();
        }
    }
}
