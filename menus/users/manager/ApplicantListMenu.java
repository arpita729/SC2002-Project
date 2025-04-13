package menus.users.manager;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.Applications;
import items.Application;
import managers.ApplicantFilterManager;
import menus.HomeMenu;
import menus.Menu;

public class ApplicantListMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            ArrayList<Application> list = ApplicantFilterManager.filter(Applications.getAllApplications());
            for (Application p : list) println(p.toLongString());
            if (list.isEmpty()) println("No Applications Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "List Applications", 
        "Applications:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
