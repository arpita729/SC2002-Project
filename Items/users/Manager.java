package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;

public class Manager extends User {
    private Project projectInCharge = null;
    public Manager(String ic, String password, int age, MaritalStatus maritalStatus) {
        super(ic, UserType.MANAGER, password, age, maritalStatus);
    }

    public Project getProjectInCharge() {
        return projectInCharge;
    }

    public void setProjectInCharge(Project p) {
        projectInCharge = p;
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}
