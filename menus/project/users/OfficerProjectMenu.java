package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.EnquiryMenu;
import menus.project.ReplyEnquiryMenu;
import menus.project.users.officer.BookMenu;
import menus.project.users.officer.ApplicationListMenu;
import menus.project.users.officer.ReceiptMenu;
import menus.users.applicant.ApplyMenu;

public class OfficerProjectMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {};
    }

    private static BaseClass baseClass = new BaseClass(
        "Officer Project Options", 
        ""
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            HomeMenu.get(),
            ApplyMenu.get(),
            EnquiryMenu.get(),
            ReplyEnquiryMenu.get(),
            ApplicationListMenu.get(),
            ReceiptMenu.get()
        ));
        EnquiryMenu.setOptions();
        ReplyEnquiryMenu.setOptions();
        ApplicationListMenu.setOptions();
        BookMenu.setOptions();
        ReceiptMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
