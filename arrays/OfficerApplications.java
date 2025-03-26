package arrays;

import java.util.ArrayList;

import items.Application;
import items.OfficerApplication;
import items.Project;
import items.Application.Status;
import items.users.Applicant;
import items.users.Officer;

/**
 * OfficerApplications is a utility class that handles operations related to officer applications.
 * It allows filtering officer applications by project or applicant, as well as managing the 
 * officer application list.
 */
public class OfficerApplications {

    private static ItemArray<OfficerApplication> officerApplications = new ItemArray<>();

    /**
     * Filters officer applications for a specific officer based on a successful status.
     *
     * @param o The officer whose applications are being filtered.
     * @return A list of projects the officer has successfully applied to.
     */
    public static ArrayList<Project> getProjects(Officer o) {
        ArrayList<Project> al = new ArrayList<>();
        
        for (Application item : officerApplications.get()) {
            if (item.getDeleted()) continue;
            if (item.getStatus() != Status.SUCCESSFUL) continue;
            if (item.getApplicant() == o) {
                al.add(item.getProject());
            }
        }
        return al;
    }

    /**
     * Gets all projects an officer has applied to, including unsuccessful or withdrawn applications.
     *
     * @param o The officer whose applications are being retrieved.
     * @return A list of all projects the officer has applied to.
     */
    public static ArrayList<Project> getAllProjects(Officer o) {
        ArrayList<Project> al = new ArrayList<>();
        
        for (Application item : officerApplications.get()) {
            if (item.getDeleted()) continue;
            if (item.getStatus() == Status.WITHDRAWN || item.getStatus() == Status.UNSUCCESSFUL) continue;
            if (item.getApplicant() == o) {
                al.add(item.getProject());
            }
        }
        return al;
    }

    /**
     * Retrieves all officers that have successfully applied to a specific project.
     *
     * @param p The project to check for officer applicants.
     * @return A list of officers who have successfully applied for the project.
     */
    public static ArrayList<Officer> getOfficers(Project p) {
        ArrayList<Officer> al = new ArrayList<>();
        
        for (Application item : officerApplications.get()) {
            if (item.getDeleted()) continue;
            if (item.getStatus() != Status.SUCCESSFUL) continue;
            if (item.getProject() == p) {
                al.add((Officer)item.getApplicant());
            }
        }
        return al;
    }

    /**
     * Filters officer applications for a specific project.
     *
     * @param p The project to filter officer applications by.
     * @return A list of officer applications for the specified project.
     */
    public static ArrayList<OfficerApplication> filter(Project p) {
        ArrayList<OfficerApplication> applicationsForProject = new ArrayList<>();
        
        for (OfficerApplication item : officerApplications.get()) {
            if (item.getDeleted()) continue;
            if (item.getProject() == p) {
                applicationsForProject.add(item);
            }
        }
        return applicationsForProject;
    }

    /**
     * Filters officer applications by the applicant.
     *
     * @param a The applicant whose officer application is to be retrieved.
     * @return The officer application associated with the given applicant.
     */
    public static OfficerApplication filter(Applicant a) {
        for (OfficerApplication item : officerApplications.get()) {
            if (item.getDeleted()) continue;
            if (item.getApplicant() == a) {
                return item;
            }
        }
        return null;
    }

    /**
     * Retrieves an officer application by its unique ID.
     *
     * @param id The ID of the officer application.
     * @return The officer application corresponding to the given ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public static OfficerApplication getOfficerApplication(int id) throws IllegalArgumentException {
        return officerApplications.getItem(id);
    }

    /**
     * Adds a new officer application to the list.
     *
     * @param officerApplication The officer application to be added.
     */
    public static void newOfficerApplication(OfficerApplication officerApplication) {
        officerApplications.newItem(officerApplication);
    }

    /**
     * Deletes an officer application from the list.
     *
     * @param officerApplication The officer application to be deleted.
     */
    public static void deleteOfficerApplication(OfficerApplication officerApplication) {
        officerApplications.deleteItem(officerApplication);
    }

    /**
     * Retrieves all officer applications from the list.
     *
     * @return A list of all officer applications.
     */
    public static ArrayList<OfficerApplication> getAllOfficerApplications() {
        return officerApplications.get();
    }

    /**
     * Returns the size of the officer application list.
     *
     * @return The number of officer applications in the list.
     */
    public static int getSize() {
        return officerApplications.getSize();
    }
}
