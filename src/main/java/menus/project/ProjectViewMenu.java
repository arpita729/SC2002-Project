package menus.project;

import java.util.Arrays;

import arrays.Projects;
import items.Enquiry;
import items.Project;
import items.users.*;
import items.users.User.UserType;
import managers.AppUserManager;
import menus.*;
import menus.project.users.*;

/**
 * The ProjectViewMenu class provides a menu interface for viewing detailed information
 * about a specific project. It displays project details, staff information, and enquiries.
 */
public class ProjectViewMenu {

    /**
     * A private static inner class extending IdMenu to handle project detail viewing.
     */
    private static class BaseClass extends IdMenu {
        /**
         * Constructs a BaseClass instance with a description and instructions.
         * 
         * @param d The description of the menu.
         * @param i The instructions for the menu.
         */
        public BaseClass(String d, String i) {
            super(d,i);
        };

        /**
         * Displays the menu and shows detailed information about the selected project.
         * If the project is deleted or not visible to the current user, an exception is thrown.
         */
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

            if (!p.isVisible() && AppUserManager.getCurrentUser().getType() == UserType.APPLICANT) {
                if (((Applicant)AppUserManager.getCurrentUser()).getProject() != p) throw new IllegalArgumentException("Not Allowed!");
            }

            println(p.toLongString());
            println("STAFF DETAILS");
            println("Manager: " + p.getManager().getName());
            println("Officers:");
            for (Officer o : p.getOfficers()) println(o.getName());

            println("\nENQUIRIES");
            for (Enquiry e : p.getEnquiries()) println(e.toString());
        }

        /**
         * Determines the next menu option based on the user's role and the selected project.
         * 
         * @return The next menu option.
         */
        public Menu options() {
            if (getId() == -1) {
                println("No project, returning to main menu.");
                return HomeMenu.get();
            }
            UserType ut = AppUserManager.getCurrentUser().getType();
            return switch (ut) {
                case APPLICANT -> getOptions().get(0);
                case MANAGER -> getOptions().get(1);
                case OFFICER -> getOptions().get(2);
            };
        }
    }

    private static BaseClass baseClass = new BaseClass(
        "Project Detail", 
        "PROJECT DETAILS"
    );

    /**
     * Sets the options for the project view menu, including role-specific menus
     * for applicants, managers, and officers.
     */
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

    /**
     * Retrieves the project view menu instance.
     * 
     * @return The project view menu instance.
     */
    public static Menu get() {
        return baseClass;
    }
}
