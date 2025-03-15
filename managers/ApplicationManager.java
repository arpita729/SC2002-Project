package managers;

import items.Application;
import items.Project;
import items.users.Applicant;

public class ApplicationManager {
    
    public static void applyProject(Project p) throws IllegalAccessException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        if (a.getProject() != null) throw new IllegalAccessException("already have a project!");
        a.setProject(p);
        new Application(p);
    }

    public static void withdrawApplication() throws IllegalAccessException {
        Applicant a = (Applicant) AppUserManager.getCurrentUser();
        // Implementation here
        Application ap = a.getApplication();
        if (ap == null) throw new IllegalAccessException("don't have a project!");
    }
}
