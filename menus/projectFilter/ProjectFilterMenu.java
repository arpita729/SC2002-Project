package menus.projectFilter;

import java.util.Arrays;

import managers.ProjectFilterManager;
import menus.HomeMenu;
import menus.Menu;

public class ProjectFilterMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println(ProjectFilterManager.getString());
            println("Please select which field to filter by.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Filter Projects", 
        "Current Filters:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(), 
            FlatTypeFilterMenu.get(),
            NameFilterMenu.get(),
            NeighFilterMenu.get(),
            ODFilterMenu.get(),
            CDFilterMenu.get()
        ));
        // call the other setOptions here to reduce clutter
        FlatTypeFilterMenu.setOptions();
        NameFilterMenu.setOptions();
        NeighFilterMenu.setOptions();
        ODFilterMenu.setOptions();
        CDFilterMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
