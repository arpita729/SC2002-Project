package menus.project.users.manager;

import java.time.LocalDate;

import items.Project;
import menus.GetDate;
import menus.Menu;
import managers.ProjectManager;

/**
 * The ProjectDetails class provides an abstract menu for handling project details.
 * It allows users to create or edit project details.
 */
public abstract class ProjectDetails extends Menu {

    /**
     * Constructs a ProjectDetails instance with a description and instructions.
     * 
     * @param d The description of the menu.
     * @param i The instructions for the menu.
     */
    public ProjectDetails(String d, String i) {
        super(d, i);
    }

    /**
     * Prompts the user to enter project details and updates the project.
     * If the provided project is null, a new project is created.
     * 
     * @param p The project to edit, or null to create a new project.
     * @return The created or updated project.
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
