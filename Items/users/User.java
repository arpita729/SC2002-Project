package items.users;

import items.Item;

/**
 * The User class represents a user in the system. It is an abstract class that 
 * defines the basic properties and behaviors of a user such as ID, password, age, and marital status.
 */
public class User extends Item {

    /**
     * Enum representing the different types of users.
     */
    public enum UserType {
        APPLICANT, OFFICER, MANAGER
    }

    /**
     * Enum representing the marital status of a user.
     */
    public enum MaritalStatus {
        SINGLE, MARRIED
    }

    private String ic; // Identification card number for the user.
    private UserType type; // Type of the user (Applicant, Officer, or Manager).
    private String password = "password"; // Default password for the user.
    private int age; // Age of the user.
    private MaritalStatus maritalStatus; // Marital status of the user.

    /**
     * Constructor to create a User instance.
     * 
     * @param ic           The identification card number of the user.
     * @param type         The type of the user (Applicant, Officer, or Manager).
     * @param password     The password of the user.
     * @param age          The age of the user.
     * @param maritalStatus The marital status of the user.
     */
    public User(String ic, UserType type, String password, int age, MaritalStatus maritalStatus) {
        this.ic = ic;
        this.type = type;
        this.password = password;
        this.age = age;
        this.maritalStatus = maritalStatus;
    }

    /**
     * Returns a string representation of the User object.
     * 
     * @return A string representing the User.
     */
    public String toString() {
        // Implementation should provide a meaningful string representation of the User.
        return "";
    }

    /**
     * Gets the identification card number of the user.
     * 
     * @return The IC of the user.
     */
    public String getIc() {
        return ic;
    }

    /**
     * Gets the type of the user (Applicant, Officer, or Manager).
     * 
     * @return The type of the user.
     */
    public UserType getType() {
        return type;
    }

    /**
     * Gets the password of the user.
     * 
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the age of the user.
     * 
     * @return The age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the marital status of the user.
     * 
     * @return The marital status of the user.
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets a new password for the user.
     * 
     * @param p The new password for the user.
     */
    public void setPassword(String p) {
        password = p;
    }
}
