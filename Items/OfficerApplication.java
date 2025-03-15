package items;

import items.users.User;
import items.users.User.UserType;
import managers.AppUserManager;

public class OfficerApplication extends Application {
    public OfficerApplication(Project project) throws IllegalAccessException {
        super(project);
        User user = AppUserManager.getCurrentUser();
        if (user.getType() != UserType.OFFICER) throw new IllegalAccessException("not an officer!");
    }
}
