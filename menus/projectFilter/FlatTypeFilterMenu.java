package menus.projectFilter;

import java.util.Arrays;

import items.Application.FlatType;
import menus.*;
import managers.ProjectFilterManager;

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
            ProjectFilterManager.setHasFlatType(f);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Available Flat Types", 
        "Please choose between:\n2: Two Room\n3: Three Room\nDefault: Clear filter"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
