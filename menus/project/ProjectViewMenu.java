package menus.project;

import java.util.Arrays;

import arrays.Projects;
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
            if (getId() == -1) return;
            Project p = Projects.getProject(getId());

            if (p.getDeleted()) throw new IllegalArgumentException("Deleted Entry!");

            println(p.toLongString());
            println("STAFF DETAILS");
            println("Manager: " + p.getManager().getName());
            println("Officers:");
            for (Officer o : p.getOfficers()) println(o.getName());
        };
        public Menu options() {
            if (getId() == -1) return HomeMenu.get();
            UserType ut = AppUserManager.getCurrentUser().getType();
            return switch (ut) {
                case UserType.APPLICANT -> getOptions().get(0);
                case UserType.OFFICER -> getOptions().get(1);
                case UserType.MANAGER -> getOptions().get(2);
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
    }

    public static Menu get() {
        return baseClass;
    }
}
