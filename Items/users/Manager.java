package items.users;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import arrays.Enquiries;

public class Manager extends User {
    private Project projectInCharge = null;
    public Manager(String name, UserType type, String password, int age, MaritalStatus maritalStatus) {
        super(name, UserType.MANAGER, password, age, maritalStatus);
    }

    public Project getProjectInCharge() {
        return projectInCharge;
    }

    public void setProjectInCharge(Project p) {
        projectInCharge = p;
    }

    public Project createProject() {
        // Implementation here
        return new Project();
    }

    public ArrayList<Enquiry> getReplies() {
        return Enquiries.filter(this);
    }
}
