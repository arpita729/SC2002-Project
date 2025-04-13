package menus.applicantFilter;

import java.util.Arrays;

import items.Application.FlatType;
import menus.*;
import managers.ApplicantFilterManager;

public class FlatTypeFilterMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("Option: ");
            FlatType f = switch (i) {
                case 2 -> FlatType.TWO_ROOM;
                case 3 -> FlatType.THREE_ROOM;
                default -> null;
            };
            ApplicantFilterManager.setFlatType(f);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Applied Flat Types", 
        "Please choose between:\n2: Two Room\n3: Three Room\nDefault: Clear filter"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ApplicantFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
