package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;
import arrays.OfficerApplications;

/**
 * The Officer class represents a user in the system who is an officer.
 * This class extends the Applicant class and adds functionality for managing 
 * projects the officer is in charge of, handling officer-specific applications,
 * and replying to enquiries related to the projects they oversee.
 */
public class Officer extends Applicant {

    /**
     * Constructor to create an Officer instance.
     * 
     * @param ic            The identification card number of the officer.
     * @param password      The password for the officer.
     * @param age           The age of the officer.
     * @param maritalStatus The marital status of the officer.
     */
    public Officer(String ic, String name, String password, int age, MaritalStatus maritalStatus) {
        super(ic, name, UserType.OFFICER, password, age, maritalStatus);
    }

    /**
     * Gets the list of projects the officer is in charge of.
     * 
     * @return A list of projects the officer is responsible for.
     */
    public ArrayList<Project> getProjectsInCharge() {
        return OfficerApplications.getProjects(this);
    }

    /**
     * Checks if the officer is in charge of a specific project.
     * 
     * @param p The project to check.
     * @return True if the officer is in charge of the project, otherwise false.
     */
    public boolean inCharge(Project p) {
        return getProjectsInCharge().contains(p);
    }

    /**
     * Checks if the officer has an application for a given project.
     * 
     * @param p The project to check.
     * @return True if the officer has an application for the project, otherwise false.
     */
    public boolean hasApplication(Project p) {
        return OfficerApplications.getAllProjects(this).contains(p);
    }

    /**
     * Gets the list of replies to enquiries made by the officer.
     * 
     * @return A list of replies to enquiries made by the officer.
     */
    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}
