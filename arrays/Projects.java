package arrays;

import java.util.ArrayList;

import items.Project;
import items.users.*;

/**
 * The `Projects` class manages the list of projects in the system. 
 * It provides methods to filter, retrieve, add, delete, and manage projects.
 * It is a static utility class that holds all projects and can be accessed for project-related operations.
 */
public class Projects {
    
    /** List holding all projects. */
    private static ItemArray<Project> projects = new ItemArray<>();

    /**
     * Filters and retrieves all projects managed by a specific manager.
     * 
     * @param m The manager whose projects are to be retrieved.
     * @return A list of projects managed by the specified manager.
     */
    public static ArrayList<Project> filter(Manager m) {
        ArrayList<Project> al = new ArrayList<>();
        
        for (Project item : projects.get()) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getManager() == m) {
                al.add(item);
            }
        }
        return al;
    }

    /**
     * Retrieves a project by its ID.
     * 
     * @param id The ID of the project to retrieve.
     * @return The project with the specified ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public static Project getProject(int id) throws IllegalArgumentException {
        return projects.getItem(id);
    }

    /**
     * Adds a new project to the project list.
     * 
     * @param project The project to be added.
     */
    public static void newProject(Project project) {
        projects.newItem(project);
    }

    /**
     * Deletes a specified project from the project list.
     * 
     * @param project The project to be deleted.
     */
    public static void deleteProject(Project project) {
        projects.deleteItem(project);
    }

    /**
     * Retrieves all projects in the project list.
     * 
     * @return A list of all projects.
     */
    public static ArrayList<Project> getAllProjects() {
        return projects.get();
    }

    /**
     * Retrieves the total number of projects (excluding deleted projects).
     * 
     * @return The number of active projects.
     */
    public static int getSize() {
        return projects.getSize();
    }

    /**
     * Sets the list of projects and updates the size.
     * 
     * @param p The new list of projects.
     */
    public static void setProjects(ArrayList<Project> p) {
        projects.setItems(p);
    }
    
    // TODO: Additional filters for flat type, location, etc.
}
