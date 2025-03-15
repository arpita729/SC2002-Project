package arrays;

import java.util.ArrayList;

import items.Project;
import items.users.*;
import items.users.User.UserType;

public class Users {

    // Private static userList to store users of type User
    private static ArrayList<User> userList = new ArrayList<>();
    private static int size = 0;

    public static User filterIc(String ic) {
        for (User user : userList) {
            if (user.getDeleted()) continue;
            if (user.getIc() == ic) return user;
        }
        
        return null;
    }
    /**
     * Filter applicants for a specific project
     * @param p project
     * @return only applicants who are already accepted.
     */
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

    /**
     * Filter officers for a specific project
     * @param p project
     * @return only officers who are already accepted.
     */
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

    // Find the manager in charge of a specific project
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

    public static User getUser(int id) {
        return userList.get(id);
    }

    public static void newUser(User user) {
        user.setId(userList.size());
        userList.add(user);
        size++;
    }

    public static void deleteUser(User user) {
        user.delete();
        size--;
    }

    public static ArrayList<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    public static int getSize() {
        return size;
    }

    public static void setUsers(ArrayList<User> u) {
        userList = u;
        size = u.size(); // assume no deleteds
    }
}