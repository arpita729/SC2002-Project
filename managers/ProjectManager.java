package managers;

import java.time.LocalDate;

import arrays.Projects;
import items.Project;
import items.users.Manager;

/**
 * ProjectManager is responsible for managing the lifecycle of a project.
 * It allows the creation of new projects and handles validations for project attributes.
 */
public class ProjectManager {

    /**
     * Creates a new project.
     * This method validates the project details, creates a new Project instance, and adds it to the project list.
     *
     * @param name      the name of the project
     * @param neigh     the neighborhood where the project will be located
     * @param room2     the number of 2-room flats in the project
     * @param room3     the number of 3-room flats in the project
     * @param od        the opening date of the project
     * @param cd        the closing date of the project
     * @param oSlots    the number of officer slots available for the project
     * @return          the created Project object
     * @throws IllegalArgumentException if any of the validation criteria are not met (e.g., opening date, closing date, etc.)
     */
    public static Project create(String name, String neigh, int room2, int room3, LocalDate od, LocalDate cd, int oSlots) throws IllegalArgumentException {
        Manager m = (Manager) AppUserManager.getCurrentUser();
        // Validate the project details using Validator class
        Validator.validateNewProject(od, cd, m.getProjectsInCharge());

        // Create the new project
        Project p = new Project(name, neigh, room2, room3, od, cd, oSlots, m);

        // Add the project to the Projects list
        Projects.newProject(p);
        return p;
    }
}
