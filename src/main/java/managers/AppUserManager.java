package managers;

import items.users.User;
import arrays.Users;

/**
 * The AppUserManager class is responsible for managing the authentication and user-related actions.
 * It handles login, logout, password changes, and fetching the current logged-in user.
 */
public class AppUserManager {

    // Private static variable to hold the current logged-in user
    private static User currentUser;

    /**
     * Logs in a user with the provided NRIC and password.
     * 
     * @param ic the NRIC of the user
     * @param password the password of the user
     * @throws IllegalArgumentException if the NRIC is invalid or the password is incorrect
     * @throws IllegalArgumentException if the user is already logged in
     */
    public static void login(String ic, String password) throws IllegalArgumentException {
        if (currentUser != null) throw new IllegalArgumentException("already logged in!");
        if (!Validator.validateNRIC(ic)) throw new IllegalArgumentException("not valid IC!");
        User u = Users.filterIc(ic);
    if (u == null) throw new IllegalArgumentException("user not found!");
        if (!u.getPassword().equals(password)) throw new IllegalArgumentException("wrong password!");
        currentUser = u;
    }

    /**
     * Logs out the currently logged-in user.
     */
    public static void logout() {
        currentUser = null;
        ProjectFilterManager.reset(); // reset the current filters.
        ApplicantFilterManager.reset();
    }

    /**
     * Changes the password for the currently logged-in user.
     * 
     * @param password the current password of the user
     * @param newPassword the new password to set
     * @throws IllegalArgumentException if the current password is incorrect
     */
    public static void changePassword(String password, String newPassword) throws IllegalArgumentException {
        if (!currentUser.getPassword().equals(password)) throw new IllegalArgumentException("wrong password!");
        currentUser.setPassword(newPassword);
    }

    /**
     * Gets the currently logged-in user.
     * 
     * @return the currently logged-in user
     */
    public static User getCurrentUser() { 
        return currentUser; 
    } 
}
