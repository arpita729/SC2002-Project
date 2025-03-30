package menus.projectFilter;

import java.util.Arrays;

import menus.*;
import managers.ProjectFilterManager;

public class CDFilterMenu  {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println("Select date A: ");
            ProjectFilterManager.setStartCD(GetDate.getDate());
            println("Select date B:");
            ProjectFilterManager.setEndCD(GetDate.getDate());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Closing Date", 
        "Filter for closing dates between dates A and B. (A should be before B)"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
