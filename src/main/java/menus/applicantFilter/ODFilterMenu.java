package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

public class ODFilterMenu  {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println("Select date A (Blank to clear): ");
            ApplicantFilterManager.setStartOD(GetDate.getDate());
            println("Select date B (Blank to clear): ");
            ApplicantFilterManager.setEndOD(GetDate.getDate());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Opening Date", 
        "Filter for opening dates between dates A and B. (A should be before B)"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
