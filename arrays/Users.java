package arrays;

import java.util.ArrayList;

import items.Project;
import items.users.*;
import items.users.User.UserType;

/**
 * The `Users` class manages the collection of all users in the system.
 * It provides methods to filter users, add new users, and manage existing users.
 */
public class Users {

    // Private static list to store users of type User
    private static ItemArray<User> users = new ItemArray<>();

    /**
     * Filters the list of users by their IC (Identity Card) number.
     * 
     * @param ic The IC number of the user to search for.
     * @return The user with the specified IC, or null if no user is found.
     */
    public static User filterIc(String ic) {
        for (User user : users.get()) {
            if (user.getDeleted()) continue;
            if (user.getIc().equals(ic)) return user;
        }
        return null;
    }

    /**
     * Filters applicants who are associated with a specific project.
     * 
     * @param p The project to filter applicants by.
     * @return A list of applicants who are associated with the given project.
     */
    public static ArrayList<Applicant> filterApplicants(Project p) {
        ArrayList<Applicant> applicants = new ArrayList<>();
        
        for (User user : users.get()) {
            if (user.getDeleted()) continue;
            if (user.getType() != UserType.APPLICANT) continue;
            if (((Applicant)user).getProject() == p) {
                applicants.add((Applicant) user);
            }
        }
        
        return applicants;
    }

    /**
     * Gets the user by their ID from the user list.
     * 
     * @param id The ID of the user.
     * @return The user at the specified ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public static User getUser(int id) throws IllegalArgumentException {
        return users.getItem(id);
    }

    /**
     * Adds a new user to the user list.
     * 
     * @param user The user to add.
     */
    public static void newUser(User user) {
        users.newItem(user);
    }

    /**
     * Deletes a user from the user list by marking them as deleted.
     * 
     * @param user The user to delete.
     */
    public static void deleteUser(User user) {
        users.deleteItem(user);
    }

    /**
     * Retrieves a list of all users.
     * 
     * @return A list containing all users in the system.
     */
    public static ArrayList<User> getAllUsers() {
        return users.get();
    }

    /**
     * Gets the total number of users in the system.
     * 
     * @return The total number of users.
     */
    public static int getSize() {
        return users.getSize();
    }

    /**
     * Sets the entire list of users and updates the size accordingly.
     * 
     * @param u The new list of users.
     */
    public static void setUsers(ArrayList<User> u) {
        users.setItems(u);
    }
}
