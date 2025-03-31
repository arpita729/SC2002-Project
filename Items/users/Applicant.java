package items.users;

import java.util.ArrayList;

import items.Application;
import items.Application.Status;
import items.Enquiry;
import items.Project;
import arrays.*;

/**
 * The Applicant class represents a user in the system who is an applicant.
 * This class extends the User class and adds functionality for managing applications 
 * and enquiries related to the applicant's projects.
 */
public class Applicant extends User {
    private Application application; // The application of the applicant.

    /**
     * Constructor to create an Applicant instance.
     * 
     * @param ic            The identification card number of the applicant.
     * @param password      The password for the applicant.
     * @param age           The age of the applicant.
     * @param maritalStatus The marital status of the applicant.
     */
    public Applicant(String ic, String name, String password, int age, MaritalStatus maritalStatus) {
        super(ic, name, UserType.APPLICANT, password, age, maritalStatus);
    }

    /**
     * Constructor to create an Applicant instance with a custom user type.
     * 
     * @param ic            The identification card number of the applicant.
     * @param u             The user type (Applicant, Officer, or Manager).
     * @param password      The password for the applicant.
     * @param age           The age of the applicant.
     * @param maritalStatus The marital status of the applicant.
     */
    public Applicant(String ic, String name, UserType u, String password, int age, MaritalStatus maritalStatus) {
        super(ic, name, u, password, age, maritalStatus);
    }

    /**
     * Gets the project associated with the applicant if the application is booked.
     * 
     * @return The project if the application is booked, otherwise null.
     */
    public Project getProject() {
        if (application != null && application.getStatus() == Status.BOOKED) {
            return application.getProject();
        }
        return null;
    }

    /**
     * Gets the application of the applicant.
     * 
     * @return The application of the applicant.
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Gets the list of enquiries made by the applicant.
     * 
     * @return A list of enquiries made by the applicant.
     */
    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }

    /**
     * Sets the application for the applicant.
     * 
     * @param a The application to set for the applicant.
     */
    public void setApplication(Application a) {
        application = a;
    }
}
