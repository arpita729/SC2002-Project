package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.users.applicant.*;
import menus.Menu;
import menus.project.EnquiryMenu;

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
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ApplyMenu.get(),
            EnquiryMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
