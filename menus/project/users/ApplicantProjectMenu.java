package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;

public class ApplicantProjectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {};
    }

    private static BaseClass baseClass = new BaseClass(
        "Applicant Project Options", 
        ""
    );

    public static void setOptions() {
        // TODO add applicant's available options
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
