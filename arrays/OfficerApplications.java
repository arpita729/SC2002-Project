package arrays;

import java.util.ArrayList;

import items.OfficerApplication;

public class OfficerApplications extends Applications {
    private static ArrayList<OfficerApplication> officerApplicationList = new ArrayList<>();
    private static int size = 0;

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
