package menus.project;

import java.util.Arrays;

import arrays.Projects;
import items.Enquiry;
import items.Project;
import items.users.Officer;
import items.users.User.UserType;
import managers.AppUserManager;
import menus.*;
import menus.project.users.*;

public class ProjectViewMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            // TODO prevent unauthed viewing 
            Project p = null;
            if (getId() == -1) return;
            try {
                p = Projects.getProject(getId());
            } catch (Exception e) {
                setId(-1);
                return;
            }
            

            if (p.getDeleted()) throw new IllegalArgumentException("Deleted Entry!");

            println(p.toLongString());
            println("STAFF DETAILS");
            println("Manager: " + p.getManager().getName());
            println("Officers:");
            for (Officer o : p.getOfficers()) println(o.getName());

            println("\nENQUIRIES");
            for (Enquiry e : p.getEnquiries()) println(e.toString());
        }
        public Menu options() {
            if (getId() == -1) {
                println("hi");
                return HomeMenu.get();
            }
            UserType ut = AppUserManager.getCurrentUser().getType();
            return switch (ut) {
                case UserType.APPLICANT -> getOptions().get(0);
                case UserType.MANAGER -> getOptions().get(1);
                case UserType.OFFICER -> getOptions().get(2);
            };
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Detail", 
        "PROJECT DETAILS"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicantProjectMenu.get(), 
            ManagerProjectMenu.get(), 
            OfficerProjectMenu.get(),
            HomeMenu.get()
        ));
        ApplicantProjectMenu.setOptions();
        ManagerProjectMenu.setOptions();
        OfficerProjectMenu.setOptions();
        EnquiryMenu.setOptions();
        ReplyEnquiryMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
