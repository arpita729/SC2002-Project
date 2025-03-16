package arrays;

import java.util.ArrayList;

import items.Application;
import items.OfficerApplication;
import items.Project;
import items.Application.Status;
import items.users.Applicant;
import items.users.Officer;

public class OfficerApplications {
    private static ArrayList<OfficerApplication> officerApplicationList = new ArrayList<>();
    private static int size = 0;

    public static ArrayList<Project> getProjects(Officer o) {
        ArrayList<Project> al = new ArrayList<>();
        
        for (Application item : officerApplicationList) {
            if (item.getDeleted()) continue;
            if (item.getStatus() != Status.SUCCESSFUL) continue;
            if (item.getApplicant() == o) {
                al.add(item.getProject());
            }
        }
        return al;
    }

    public static ArrayList<Project> getAllProjects(Officer o) {
        ArrayList<Project> al = new ArrayList<>();
        
        for (Application item : officerApplicationList) {
            if (item.getDeleted()) continue;
            // check for 'no longer active' states
            if (item.getStatus() == Status.WITHDRAWN || item.getStatus() == Status.UNSUCCESSFUL) continue;
            if (item.getApplicant() == o) {
                al.add(item.getProject());
            }
        }
        return al;
    }

    public static ArrayList<Officer> getOfficers(Project p) {
        ArrayList<Officer> al = new ArrayList<>();
        
        for (Application item : officerApplicationList) {
            if (item.getDeleted()) continue;
            if (item.getStatus() != Status.SUCCESSFUL) continue;
            if (item.getProject() == p) {
                al.add((Officer)item.getApplicant());
            }
        }
        return al;
    }

    public static ArrayList<OfficerApplication> filter(Project p) {
        ArrayList<OfficerApplication> applicationsForProject = new ArrayList<>();
        
        for (OfficerApplication item : officerApplicationList) {
            if (item.getDeleted()) continue;
            if (item.getProject() == p) {
                applicationsForProject.add(item);
            }
        }
        return applicationsForProject;
    }

    // Filter application by applicant
    public static OfficerApplication filter(Applicant a) {
        for (OfficerApplication item : officerApplicationList) {
            if (item.getDeleted()) continue;
            if (item.getApplicant() == a) {
                return item;
            }
        }
        return null;
    }
        

    public static OfficerApplication getOfficerApplication(int id) {
        return officerApplicationList.get(id);
    }

    public static void newOfficerApplication(OfficerApplication officerApplication) {
        officerApplication.setId(officerApplicationList.size());
        officerApplicationList.add(officerApplication);
        size++;
    }

    public static void deleteOfficerApplication(OfficerApplication officerApplication) {
        officerApplication.delete();
        size--;
    }

    public static ArrayList<OfficerApplication> getAllOfficerApplications() {
        return new ArrayList<>(officerApplicationList);
    }

    public static int getSize() {
        return size;
    }
}
