package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

public class CDFilterMenu  {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            println("Select date A (Blank to clear): ");
            ApplicantFilterManager.setStartCD(GetDate.getDate());
            println("Select date B (Blank to clear):");
            ApplicantFilterManager.setEndCD(GetDate.getDate());
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Closing Date", 
        "Filter for closing dates between dates A and B. (A should be before B)"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
