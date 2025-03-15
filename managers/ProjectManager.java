package managers;

import java.util.Date;

import arrays.Projects;
import items.Project;
import items.users.Manager;

public class ProjectManager {
    public static Project create(String name, String neigh, int room2, int room3, Date od, Date cd, int oSlots) {
        Manager m = (Manager)AppUserManager.getCurrentUser();
        Project p = new Project(name, neigh, room2, room3, od, cd, oSlots);
        Projects.newProject(p);
        m.setProjectInCharge(p);
        return p;
    }
    // TODO filters, save filters between menu pages
}
