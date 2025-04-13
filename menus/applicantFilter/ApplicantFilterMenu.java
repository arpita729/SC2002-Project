package menus.applicantFilter;

import java.util.Arrays;

import managers.ApplicantFilterManager;
import menus.HomeMenu;
import menus.Menu;

public class ApplicantFilterMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println(ApplicantFilterManager.getString());
            println("Please select which field to filter by.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Filter Applications", 
        "Current Filters:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(), 
            AgeFilterMenu.get(),
            MaritalFilterMenu.get(),
            FlatTypeFilterMenu.get(),
            NameFilterMenu.get(),
            NeighFilterMenu.get(),
            ODFilterMenu.get(),
            CDFilterMenu.get()
        ));
        // call the other setOptions here to reduce clutter
        AgeFilterMenu.setOptions();
        MaritalFilterMenu.setOptions();
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
