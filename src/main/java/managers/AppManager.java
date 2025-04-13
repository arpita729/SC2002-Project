/**
 * The {@code AppManager} class serves as the main entry point of the application.
 * It is responsible for initializing data from external sources (e.g., Excel files)
 * and starting the application's user interface through a series of menus.
 */
package managers;

import data.ExcelReader;
import menus.*;

/**
 * The {@code AppManager} class manages application startup procedures,
 * including loading user and project data, and displaying the login menu.
 */
public class AppManager {

    /**
     * The main method that launches the application.
     * <p>
     * It performs the following steps:
     * <ul>
     *     <li>Loads user data from an Excel file.</li>
     *     <li>Loads project data from an Excel file.</li>
     *     <li>Starts the application by displaying the login menu.</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ExcelReader.loadUsers();
        ExcelReader.loadProjects();
        startApp();
    }

    /**
     * Starts the application by initializing menus and entering the main menu loop.
     * <p>
     * The login menu is displayed first, and then menu navigation continues
     * in a loop based on user interaction.
     */
    public static void startApp() {
        // Initialise menus
        HomeMenu.setOptions();

        Menu menu = LoginMenu.get();
        // Display login and handle navigation
        while (true) {
            menu = menu.display();
        }
    }
}

