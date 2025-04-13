package menus.project.users.manager;

import java.time.LocalDate;

import items.Project;
import menus.GetDate;
import menus.Menu;
import managers.ProjectManager;

public abstract class ProjectDetails extends Menu {
    public ProjectDetails(String d, String i) {
        super(d, i);
    }

    /**
     * Prompts user to enter project details, then updates.
     * @param p null to create, if not edits the project provided
     */
    public Project getProjectDetails(Project p) {
        String name = getString("Enter name: ");
        String neigh = getString("Enter neighbourhood: ");
        int room2 = getInt("Enter number of 2-room units: ");
        int room3 = getInt("Enter number of 3-room units: ");
        println("Enter opening date: ");
        LocalDate od = GetDate.getDate();
        println("Enter closing date: ");
        LocalDate cd = GetDate.getDate();
        int oSlots = getInt("Enter number of officer slot: ");

        if (p == null) {
            p = ProjectManager.create(name, neigh, room2, room3, od, cd, oSlots);
        } else {
            ProjectManager.edit(p, name, neigh, room2, room3, od, cd, oSlots);    
        }
        return p;
    }
}
