package items.users;

import java.util.ArrayList;

import items.Application.Status;
import items.Enquiry;
import items.OfficerApplication;
import items.Project;
import arrays.Enquiries;

public class Officer extends Applicant {
    private OfficerApplication oApplication;
    public Officer(String ic, String password, int age, MaritalStatus maritalStatus) {
        super(ic, UserType.OFFICER, password, age, maritalStatus);
    }

    public Project getProjectInCharge() {
        if (oApplication != null && oApplication.getStatus() == Status.SUCCESSFUL) return oApplication.getProject();
        return null;
    }

    public OfficerApplication getOfficerApplication() {
        return oApplication;
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }

    // setters
    public void setOfficerApplication(OfficerApplication o) {
        oApplication = o;
    }
}