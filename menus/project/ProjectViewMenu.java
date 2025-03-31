package menus.project;

import java.util.Arrays;

import arrays.Projects;
import items.Project;
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
            Project p = Projects.getProject(getId());
            println(p.toLongString());
        };
        public Menu options() {
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
        "Project Details:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ApplicantProjectMenu.get(), 
            ManagerProjectMenu.get(), 
            OfficerProjectMenu.get()
        ));
        ApplicantProjectMenu.setOptions();
        ManagerProjectMenu.setOptions();
        OfficerProjectMenu.setOptions();
    }

    public static Menu get() {
        return baseClass;
    }
}
