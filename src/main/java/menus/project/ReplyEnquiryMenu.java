package menus.project;

import java.util.Arrays;

import arrays.Enquiries;
import arrays.Projects;
import items.*;
import managers.EnquiryManager;
import menus.*;

public class ReplyEnquiryMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            Project p = null;
            if (getId() == -1) return;
            try {
                p = Projects.getProject(getId());
            } catch (Exception e) {
                setId(-1);
                return;
            }
            
            if (p.getDeleted()) throw new IllegalArgumentException("Deleted Entry!");

            int i = getInt("Select an enquiry by ID: ");
            Enquiry e = Enquiries.getEnquiry(i);
            String s = getString("Type your enquiry: ");
            EnquiryManager.reply(e, s);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Reply to Enquiry", 
        "Reply to Enquiry: "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
