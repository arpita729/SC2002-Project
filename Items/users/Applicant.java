package items.users;

import java.util.ArrayList;

import items.Application;
import items.Enquiry;
import items.Project;
import arrays.*;

public class Applicant extends User {
    private Project project=null;

    public Applicant(String name, UserType type, String password, int age, MaritalStatus maritalStatus) {
        super(name, UserType.APPLICANT, password, age, maritalStatus);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project p) {
        project = p;
    }

    public Application getApplication() {
        return Applications.filter(this);
    }

    public ArrayList<Enquiry> getEnquiries() {
        return Enquiries.filter(this);
    }


}
