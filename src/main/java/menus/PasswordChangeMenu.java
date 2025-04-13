package menus;

import java.util.Arrays;

import managers.AppUserManager;

public class PasswordChangeMenu { 
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i,true);
        };
        public void menu() throws IllegalArgumentException {
            String old = getString("Current Password: ");
            String new1 = getString("New Password: ");
            String new2 = getString("Confirm Password: ");
            if (!new1.equals(new2)) throw new IllegalArgumentException("passwords are different!");
            AppUserManager.changePassword(old, new2);
            println("Password Changed Successfully.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Change Password", 
        "Please fill in the following details." 
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(HomeMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
