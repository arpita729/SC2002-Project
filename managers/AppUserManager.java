package managers;

import items.users.User;
import arrays.Users;

public class AppUserManager {
    private static User currentUser;

    public static void login(String ic, String password) throws IllegalArgumentException, IllegalAccessException {
        if (currentUser != null) throw new IllegalAccessException("already logged in!");
        if (!Validator.validateNRIC(ic)) throw new IllegalArgumentException("not valid IC!");
        User u = Users.filterIc(ic);
        if (!u.getPassword().equals(password)) throw new IllegalArgumentException("wrong password!");
        currentUser = u;
    }

    public static void logout() {
        currentUser = null;
    }

    public static void changePassword(String password, String newPassword) throws IllegalArgumentException {
        if (!currentUser.getPassword().equals(password)) throw new IllegalArgumentException("wrong password!");
        currentUser.setPassword(newPassword);
    }

    public static User getCurrentUser() { return currentUser; }; 
}
