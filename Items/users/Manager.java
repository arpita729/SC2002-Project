package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;
import arrays.Projects;

/**
 * The Manager class represents a user in the system who is a manager.
 * This class extends the User class and adds functionality for managing projects 
 * and replies to enquiries related to the projects under their charge.
 */
public class Manager extends User {

    /**
     * Constructor to create a Manager instance.
     * 
     * @param ic            The identification card number of the manager.
     * @param password      The password for the manager.
     * @param age           The age of the manager.
     * @param maritalStatus The marital status of the manager.
     */
    public Manager(String ic, String name, String password, int age, MaritalStatus maritalStatus) {
        super(ic, name, UserType.MANAGER, password, age, maritalStatus);
    }

    /**
     * Gets the list of projects the manager is in charge of.
     * 
     * @return A list of projects the manager is responsible for.
     */
    public ArrayList<Project> getProjectsInCharge() {
        return Projects.filter(this);
    }

    /**
     * Checks if the manager is in charge of a specific project.
     * 
     * @param p The project to check.
     * @return True if the manager is in charge of the project, otherwise false.
     */
    public boolean inCharge(Project p) {
        return getProjectsInCharge().contains(p);
    }

    /**
     * Gets the list of replies to enquiries made by the manager.
     * 
     * @return A list of replies to enquiries made by the manager.
     */
    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}
