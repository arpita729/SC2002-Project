package arrays;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import items.users.Applicant;
import items.users.Manager;
import items.users.Officer;

/**
 * This class manages a collection of enquiries and provides methods to filter them
 * based on different roles (Applicant, Manager, Officer) and project.
 */
public class Enquiries {
    
    // Using ItemArray to manage enquiries
    private static ItemArray<Enquiry> enquiries = new ItemArray<>();

    /**
     * Filters enquiries related to a specific project.
     * @param p The project to filter enquiries by.
     * @return A list of enquiries related to the given project.
     */
    public static ArrayList<Enquiry> filter(Project p) {
        ArrayList<Enquiry> enquiriesForProject = new ArrayList<>();
        
        for (Enquiry item : enquiries.get()) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getProject() == p) {
                enquiriesForProject.add(item);
            }
        }
        
        return enquiriesForProject;
    }

    /**
     * Filters enquiries related to a specific applicant.
     * @param a The applicant to filter enquiries by.
     * @return A list of enquiries related to the given applicant.
     */
    public static ArrayList<Enquiry> filter(Applicant a) {
        ArrayList<Enquiry> enquiriesForApplicant = new ArrayList<>();
        
        for (Enquiry item : enquiries.get()) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getApplicant() == a) {
                enquiriesForApplicant.add(item);
            }
        }
        
        return enquiriesForApplicant;
    }

    /**
     * Filters enquiries related to a specific manager.
     * @param m The manager to filter enquiries by.
     * @return A list of enquiries related to the given manager.
     */
    public static ArrayList<Enquiry> filter(Manager m) {
        ArrayList<Enquiry> enquiriesForManager = new ArrayList<>();
        
        for (Enquiry item : enquiries.get()) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getReplier() == m) {
                enquiriesForManager.add(item);
            }
        }
        
        return enquiriesForManager;
    }

    /**
     * Filters enquiries related to a specific officer.
     * @param o The officer to filter enquiries by.
     * @return A list of enquiries related to the given officer.
     */
    public static ArrayList<Enquiry> filter(Officer o) {
        ArrayList<Enquiry> enquiriesForOfficer = new ArrayList<>();
        
        for (Enquiry item : enquiries.get()) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getReplier() == o) {
                enquiriesForOfficer.add(item);
            }
        }
        
        return enquiriesForOfficer;
    }

    /**
     * Retrieves an enquiry by its ID.
     * @param id The ID of the enquiry to retrieve.
     * @return The enquiry with the given ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public static Enquiry getEnquiry(int id) throws IllegalArgumentException {
        return enquiries.getItem(id);
    }

    /**
     * Adds a new enquiry to the list.
     * @param enquiry The enquiry to be added.
     */
    public static void newEnquiry(Enquiry enquiry) {
        enquiries.newItem(enquiry);
    }

    /**
     * Deletes a specific enquiry from the list.
     * @param enquiry The enquiry to be deleted.
     */
    public static void deleteEnquiry(Enquiry enquiry) {
        enquiries.deleteItem(enquiry);
    }

    /**
     * Retrieves all enquiries in the list.
     * @return A list of all enquiries.
     */
    public static ArrayList<Enquiry> getAllEnquiries() {
        return enquiries.get();
    }

    /**
     * Gets the size of the enquiry list.
     * @return The size of the enquiry list.
     */
    public static int getSize() {
        return enquiries.getSize();
    }

    /**
     * Sets the enquiry list directly.
     * @param e The list of enquiries to be set.
     */
    public static void setEnquiries(ArrayList<Enquiry> e) {
        enquiries.setItems(e);
    }
}
