package items.users;

import java.util.ArrayList;

import items.Application;
import items.Application.Status;
import items.Enquiry;
import items.Project;
import arrays.*;

public class Applicant extends User {
    private Application application;

    public Applicant(String ic, String password, int age, MaritalStatus maritalStatus) {
        super(ic, UserType.APPLICANT, password, age, maritalStatus);
    }
    public Applicant(String ic, UserType u, String password, int age, MaritalStatus maritalStatus) {
        super(ic, u, password, age, maritalStatus);
    }

    // Getters
    public Project getProject() {
        if (application != null && application.getStatus() == Status.BOOKED) return application.getProject();
        return null;
    }

    public Application getApplication() {
        return application;
    }

    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }

    // Setters
    public void setApplication(Application a) {
        application = a;
    }
}
