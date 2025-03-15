package items.users;

import items.Item;

public class User extends Item {
    public enum UserType {
        APPLICANT, OFFICER, MANAGER
    }
    
    public enum MaritalStatus {
        SINGLE, MARRIED
    }
    
    private String ic;
    private UserType type;
    private String password="password";
    private int age;
    private MaritalStatus maritalStatus;

    // Constructor
    public User(String ic, UserType type, String password, int age, MaritalStatus maritalStatus) {
        this.ic = ic;
        this.type = type;
        this.password = password;
        this.age = age;
        this.maritalStatus = maritalStatus;
    }

    public String toString() {
        // implementation here
        return "";
    }    

    // Getters
    public String getIc() {
        return ic;
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

    //Setters
    public void setPassword(String p) {
        password = p;
    }

}

