package menus.projectFilter;

import java.util.Arrays;

import menus.*;
import managers.ProjectFilterManager;

public class NameFilterMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            String s = getString("Type your query: ");
            if (s.length() == 0) s = null;
            ProjectFilterManager.setName(s);;
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Name", 
        "Please input your name search query or leave blank to clear. "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(ProjectFilterMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
