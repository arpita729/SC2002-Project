package arrays;

import java.util.ArrayList;

import items.Application;
import items.Project;
import items.users.Applicant;

/**
 * The Applications class manages the list of applications in the system.
 * It provides methods to filter applications by project or applicant,
 * add new applications, delete applications, and retrieve the list of all applications.
 */
public class Applications {
    
    private static ItemArray<Application> applications = new ItemArray<>();

    /**
     * Filters the applications for a given project.
     * 
     * @param p The project to filter applications for.
     * @return A list of applications associated with the given project.
     */
    public static ArrayList<Application> filter(Project p) {
        ArrayList<Application> applicationsForProject = new ArrayList<>();
        
        for (Application item : applications.get()) {
            if (item.getDeleted()) continue;
            if (item.getProject() == p) {
                applicationsForProject.add(item);
            }
        }
        return applicationsForProject;
    }

    /**
     * Filters the application for a given applicant.
     * 
     * @param a The applicant whose application is to be retrieved.
     * @return The application associated with the given applicant, or null if not found.
     */
    public static Application filter(Applicant a) {
        for (Application item : applications.get()) {
            if (item.getDeleted()) continue;
            if (item.getApplicant() == a) {
                return item;
            }
        }
        
        return null; // If no application for the given applicant is found
    }

    /**
     * Retrieves an application by its ID.
     * 
     * @param id The ID of the application to retrieve.
     * @return The application with the given ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public static Application getApplication(int id) throws IllegalArgumentException {
        return applications.getItem(id);
    }

    /**
     * Adds a new application to the list.
     * 
     * @param application The application to be added to the list.
     */
    public static void newApplication(Application application) {
        applications.newItem(application);
    }

    /**
     * Deletes an application from the list.
     * 
     * @param application The application to be deleted.
     */
    public static void deleteApplication(Application application) {
        applications.deleteItem(application);
    }

    /**
     * Retrieves all applications in the list.
     * 
     * @return A list of all applications.
     */
    public static ArrayList<Application> getAllApplications() {
        return applications.get();
    }

    /**
     * Retrieves the size of the application list.
     * 
     * @return The number of applications in the list.
     */
    public static int getSize() {
        return applications.getSize();  
    }

    /**
     * Sets the application list directly.
     * 
     * @param a The list of applications to be set.
     */
    public static void setApplications(ArrayList<Application> a) {
        applications.setItems(a);
    }
}
