package arrays;

import java.util.ArrayList;

import items.Project;
import items.users.*;
import items.users.User.UserType;

public class Users {

    // Private static userList to store users of type User
    private static ArrayList<User> userList = new ArrayList<>();

    // Filter applicants for a specific project
    public static ArrayList<Applicant> filterApplicants(Project p) {
        ArrayList<Applicant> applicants = new ArrayList<>();
        
        for (User user : userList) {
            if (user.getDeleted()) continue;
            if (user.getType() != UserType.APPLICANT) continue;
            if (((Applicant)user).getProject() == p) {
                applicants.add((Applicant) user);
            }
        }
        
        return applicants;
    }

    // Filter officers for a specific project
    public static ArrayList<Officer> filterOfficers(Project p) {
        ArrayList<Officer> officers = new ArrayList<>();
        
        for (User user : userList) {
            if (user.getDeleted()) continue;
            if (user.getType() != UserType.OFFICER) continue;
            if (((Officer)user).getProjectInCharge() == p) {
                officers.add((Officer) user);
            }
        }
        
        return officers;
    }

    // Filter the manager in charge of a specific project
    public static Manager filterManager(Project p) {
        for (User user : userList) {
            if (user.getDeleted()) continue;
            if (user.getType() != UserType.MANAGER) continue;
            if (((Manager)user).getProjectInCharge() == p) {
                return (Manager) user;
            }
        }
        
        return null;
    }
}