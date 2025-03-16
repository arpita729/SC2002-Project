package managers;

import java.time.LocalDate;

import arrays.Projects;
import items.Project;
import items.users.Manager;

public class ProjectManager {
    public static Project create(String name, String neigh, int room2, int room3, LocalDate od, LocalDate cd, int oSlots) throws IllegalArgumentException {
        Manager m = (Manager)AppUserManager.getCurrentUser();
        Validator.validateNewProject(od, cd, m.getProjectsInCharge());
        Project p = new Project(name, neigh, room2, room3, od, cd, oSlots,m);
        Projects.newProject(p);
        return p;
    }
    // TODO filters, save filters between menu pages
}
