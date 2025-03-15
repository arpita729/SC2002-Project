package managers;

import items.users.User;

public class AppUserManager {
    private static User currentUser;

    public static User getCurrentUser() { return currentUser; }; 
}
