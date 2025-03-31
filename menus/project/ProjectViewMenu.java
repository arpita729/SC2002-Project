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
            UserType ut = AppUserManager.getCurrentUser().getType();

            Project p = Projects.getProject(getId());
            println(p.toLongString());

            if (ut == UserType.APPLICANT) getOptions().get(0).display();
            if (ut == UserType.OFFICER) getOptions().get(1).display();
            if (ut == UserType.MANAGER) getOptions().get(2).display();
        };
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
