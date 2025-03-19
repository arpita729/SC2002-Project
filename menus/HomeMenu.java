package menus;

import java.util.Arrays;

import items.users.User.UserType;
import menus.users.*;
import managers.AppUserManager;

public class HomeMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {};
        public void options() {
            UserType ut = AppUserManager.getCurrentUser().getType();
            if (ut == UserType.APPLICANT) getOptions().get(0).display();
            if (ut == UserType.OFFICER) getOptions().get(1).display();
            if (ut == UserType.MANAGER) getOptions().get(2).display();
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Home Page", 
        ""
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicantMenu.get(),
            OfficerMenu.get(),
            ManagerMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
