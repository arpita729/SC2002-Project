package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.OfficerApplication;
import items.Project;
import arrays.OfficerApplications;
import arrays.Enquiries;

public class Officer extends Applicant {
    private Project projectInCharge=null;
    public Officer(String name, UserType type, String password, int age, MaritalStatus maritalStatus) {
        super(name, UserType.OFFICER, password, age, maritalStatus);
    }

    public Project getProjectInCharge() {
        return projectInCharge;
    }

    public void setProjectInCharge(Project p) {
        projectInCharge = p;
    }

    public OfficerApplication getOfficerApplication() {
        return (OfficerApplication)OfficerApplications.filter(this);
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}