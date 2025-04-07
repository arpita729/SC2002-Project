package menus.project;

import java.util.Arrays;

import arrays.Projects;
import items.Project;
import managers.EnquiryManager;
import menus.*;

public class EnquiryMenu {
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

            String s = getString("Type your enquiry: ");
            EnquiryManager.create(p, s);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Create New Enquiry", 
        "Create New Enquiry: "
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
