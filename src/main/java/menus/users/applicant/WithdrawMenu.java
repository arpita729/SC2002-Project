package menus.users.applicant;

import java.util.Arrays;

import managers.ApplicationManager;
import menus.*;

public class WithdrawMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            ApplicationManager.withdraw();
            println("Withdrawal Pending... ");
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "Request Withdraw Application",
            ""
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
