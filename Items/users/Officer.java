package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;
import arrays.OfficerApplications;

public class Officer extends Applicant {
    public Officer(String ic, String password, int age, MaritalStatus maritalStatus) {
        super(ic, UserType.OFFICER, password, age, maritalStatus);
    }

    public ArrayList<Project> getProjectsInCharge() {
        return OfficerApplications.getProjects(this);
    }

    public boolean inCharge(Project p) {
        return getProjectsInCharge().contains(p);
    }

    public boolean hasApplication(Project p) {
        return OfficerApplications.getAllProjects(this).contains(p);
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}