package menus.applicantFilter;

import java.util.Arrays;

import menus.*;
import managers.ApplicantFilterManager;

public class AgeFilterMenu  {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int a = getInt("Select age A (Blank to clear): ");
            ApplicantFilterManager.setStartAge(a);
            int b = getInt("Select age B (Blank to clear): ");
            ApplicantFilterManager.setEndAge(b);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Applicant's Age", 
        "Filter for ages between A and B. (A should be before B)"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
