package menus.project;

import static menus.IdMenu.getId;

import java.util.Arrays;

import menus.HomeMenu;
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
        public Menu options() {
            if (getId() == -1) return getOptions().get(0);
            return getOptions().get(1);
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Select a Project", 
        "Select a Project by ID to View, or blank to go back. "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ProjectViewMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
