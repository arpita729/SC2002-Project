package arrays;

import java.util.ArrayList;

import items.Enquiry;
import items.Project;
import items.users.Applicant;
import items.users.Manager;
import items.users.Officer;

public class Enquiries {
    private static ArrayList<Enquiry> enquiryList = new ArrayList<>();
    private static int size = 0;

    // Filter enquiries by project (for Applicant role)
    public static ArrayList<Enquiry> filter(Project p) {
        ArrayList<Enquiry> enquiriesForProject = new ArrayList<>();
        
        for (Enquiry item : enquiryList) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getProject() == p) {
                enquiriesForProject.add(item);
            }
        }
        
        return enquiriesForProject;
    }

    // Filter enquiries by applicant (for Applicant role)
    public static ArrayList<Enquiry> filter(Applicant a) {
        ArrayList<Enquiry> enquiriesForApplicant = new ArrayList<>();
        
        for (Enquiry item : enquiryList) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getApplicant() == a) {
                enquiriesForApplicant.add(item);
            }
        }
        
        return enquiriesForApplicant;
    }

    // Filter enquiries by manager (for Manager role)
    public static ArrayList<Enquiry> filter(Manager m) {
        ArrayList<Enquiry> enquiriesForManager = new ArrayList<>();
        
        for (Enquiry item : enquiryList) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getReplier() == m) {
                enquiriesForManager.add(item);
            }
        }
        
        return enquiriesForManager;
    }

    // Filter enquiries by officer (for Officer role)
    public static ArrayList<Enquiry> filter(Officer o) {
        ArrayList<Enquiry> enquiriesForOfficer = new ArrayList<>();
        
        for (Enquiry item : enquiryList) {
            if (item.getDeleted()) continue; // Skip deleted items
            if (item.getReplier() == o) {
                enquiriesForOfficer.add(item);
            }
        }
        
        return enquiriesForOfficer;
    }


    public static Enquiry getEnquiry(int id) {
        return enquiryList.get(id);
    }

    public static void newEnquiry(Enquiry enquiry) {
        enquiry.setId(enquiryList.size());
        enquiryList.add(enquiry);
        size++;
    }

    public static void deleteEnquiry(Enquiry enquiry) {
        enquiry.delete();
        size--;
    }

    public static ArrayList<Enquiry> getAllEnquiries() {
        return new ArrayList<>(enquiryList);
    }

    public static int getSize() {
        return size;
    }
}