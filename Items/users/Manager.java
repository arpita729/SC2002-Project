package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;
import arrays.Projects;

public class Manager extends User {
    public Manager(String ic, String password, int age, MaritalStatus maritalStatus) {
        super(ic, UserType.MANAGER, password, age, maritalStatus);
    }

    public ArrayList<Project> getProjectsInCharge() {
        return Projects.filter(this);
    }

    public boolean inCharge(Project p) {
        return getProjectsInCharge().contains(p);
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}
