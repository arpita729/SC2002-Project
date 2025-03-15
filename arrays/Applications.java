package arrays;

import java.util.ArrayList;

import items.Application;
import items.Project;
import items.users.Applicant;

public class Applications {
    private static ArrayList<Application> applicationList = new ArrayList<>();
    private static int size = 0;

    public static ArrayList<Application> filter(Project p) {
        ArrayList<Application> applicationsForProject = new ArrayList<>();
        
        for (Application item : applicationList) {
            if (item.getDeleted()) continue;
            if (item.getProject() == p) {
                applicationsForProject.add(item);
            }
        }
        return applicationsForProject;
    }

    // Filter application by applicant
    public static Application filter(Applicant a) {
        for (Application item : applicationList) {
            if (item.getDeleted()) continue;
            if (item.getApplicant() == a) {
                return item;
            }
        }
        
        return null; // If no application for the given applicant is found
    }

    // Static method to get an application by its ID
    public static Application getApplication(int id) {
        return applicationList.get(id);  
    }

    // Static method to add a new application
    public static void newApplication(Application application) {
        application.setId(applicationList.size()); 
        applicationList.add(application);  // Add the application to the list
        size++; 
    }

    // Static method to delete an application
    public static void deleteApplication(Application application) {
        application.delete(); 
        size--;
    }

    // Static method to get all applications in the list
    public static ArrayList<Application> getAllApplications() {
        return new ArrayList<>(applicationList);  
    }

    // Static method to get the size of the application list
    public static int getSize() {
        return size;  
    }

    public static void setApplications(ArrayList<Application> a) {
        applicationList = a;
        size = a.size(); // assume no deleteds
    }
}
