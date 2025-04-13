package menus.applicantFilter;

import java.util.Arrays;

import items.users.User.MaritalStatus;
import menus.*;
import managers.ApplicantFilterManager;

public class MaritalFilterMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("Option: ");
            MaritalStatus f = switch (i) {
                case 1 -> MaritalStatus.MARRIED;
                case 2 -> MaritalStatus.SINGLE;
                default -> null;
            };
            ApplicantFilterManager.setMaritalStatus(f);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Applicant's Marital Status", 
        "Please choose between:\n1: Married\n2: Single\nDefault: Clear filter"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
