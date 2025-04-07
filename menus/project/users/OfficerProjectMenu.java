package menus.project.users;

import java.util.Arrays;

import menus.HomeMenu;
import menus.Menu;
import menus.project.EnquiryMenu;
import menus.project.ReplyEnquiryMenu;
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
            OfficerApplicationMenu.get(),
            ReceiptMenu.get()
        ));
        EnquiryMenu.setOptions();
        ReplyEnquiryMenu.setOptions();
        OfficerApplicationMenu.setOptions();
        BookMenu.setOptions();
        ReceiptMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
