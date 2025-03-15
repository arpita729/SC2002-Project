package items.users;

import items.Item;

public class User extends Item {
    public enum UserType {
        APPLICANT, OFFICER, MANAGER
    }
    
    public enum MaritalStatus {
        SINGLE, MARRIED, DIVORCED, WIDOWED
    }
    
    private String name;
    private UserType type;
    private String password;
    private int age;
    private MaritalStatus maritalStatus;

    // Constructor
    public User(String name, UserType type, String password, int age, MaritalStatus maritalStatus) {
        this.name = name;
        this.type = type;
        this.password = password;
        this.age = age;
        this.maritalStatus = maritalStatus;
    }

    // Getters
    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public String toString() {
        // implementation here
        return "";
    }
}

