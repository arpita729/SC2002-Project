package menus.project;

import java.util.Arrays;

import menus.IdMenu;
import menus.Menu;

public class ProjectSelectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("ID: ");
            if (i == -1) return; // redirect to home
            IdMenu.setId(i); // set the ID of the project to display
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Select a Project", 
        "Select a Project by ID to View, or blank to go back. "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectViewMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
