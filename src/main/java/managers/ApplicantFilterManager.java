package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import items.Application.FlatType;
import items.users.User.MaritalStatus;
import items.*;

/**
 * The {@code ApplicantFilterManager} class provides filtering capabilities
 * for a list of {@link Application} objects based on various user-defined criteria.
 * <p>
 * These criteria include project name, neighborhood, flat type, project,
 * opening/closing dates, marital status, and applicant age range.
 */
public class ApplicantFilterManager {
    // Filter parameters
    private static String name = null;
    private static String neigh = null;
    private static FlatType flatType = null;
    private static Project project = null;
    private static LocalDate startOD = null;
    private static LocalDate endOD = null;
    private static LocalDate startCD = null;
    private static LocalDate endCD = null;
    private static MaritalStatus maritalStatus = null;
    private static int startAge = -1;
    private static int endAge = -1;

    /**
     * Filters a given list of applications based on the current filter settings.
     *
     * @param list the original list of applications to filter
     * @return a new list containing only applications that match the filter criteria
     */
    public static ArrayList<Application> filter(ArrayList<Application> list) {
        ArrayList<Application> newList = new ArrayList<>();

        for (Application a : list) {
            if (a.getDeleted()) continue;

            if (flatType != null && a.getFlatType() != flatType) continue;
            if (project != null && a.getProject() != project) continue;
            if (name != null && !contains(a.getProject().getName(), name)) continue;
            if (neigh != null && !contains(a.getProject().getNeighborhood(), neigh)) continue;
            if (!betweenDates(a.getProject().getOpeningDate(), startOD, endOD)) continue;
            if (!betweenDates(a.getProject().getClosingDate(), startCD, endCD)) continue;
            if (maritalStatus != null && a.getApplicant().getMaritalStatus() != maritalStatus) continue;
            if (startAge != -1 && a.getApplicant().getAge() < startAge) continue;
            if (endAge != -1 && a.getApplicant().getAge() > endAge) continue;

            newList.add(a);
        }
        return newList;
    }

    /**
     * Checks if a string contains another string, case-insensitive.
     */
    private static boolean contains(String str, String substr) {
        return str.toLowerCase().contains(substr.toLowerCase());
    }

    /**
     * Checks whether a date falls within a specified range.
     */
    private static boolean betweenDates(LocalDate d, LocalDate start, LocalDate end) {
        if (start != null && d.isBefore(start)) return false;
        if (end != null && d.isAfter(end)) return false;
        return true;
    }

    /**
     * Returns a summary string of all currently applied filters.
     *
     * @return a human-readable summary of the current filters
     */
    public static String getString() {
        String s = "";
        if (flatType != null) s += "Available Flat Types: " +
                ((flatType == FlatType.TWO_ROOM) ? "Two Room" : "Three Room") + "\n";
        if (project != null) s += "Project: " + project.toString() + "\n";
        if (name != null) s += "Project Name: " + name + "\n";
        if (neigh != null) s += "Neighbourhood: " + neigh + "\n";
        if (startOD != null || endOD != null) s += "Opening Date: " + dateString(startOD, endOD) + "\n";
        if (startCD != null || endCD != null) s += "Closing Date: " + dateString(startCD, endCD) + "\n";
        if (maritalStatus != null) s += "Marital Status: " + maritalStatus.toString() + "\n";
        if (startAge != -1 || endAge != -1) s += "Age: " + ageString(startAge, endAge) + "\n";
        if (s.length() == 0) s += "None. \n";
        return s;
    }

    /**
     * Converts a date range to a string.
     */
    private static String dateString(LocalDate start, LocalDate end) {
        return "Between " +
                ((start == null) ? "Any" : start.toString()) +
                " and " +
                ((end == null) ? "Any" : end.toString());
    }

    /**
     * Converts an age range to a string.
     */
    private static String ageString(int start, int end) {
        return "Between " +
                ((start == -1) ? "Any" : start) +
                " and " +
                ((end == -1) ? "Any" : end);
    }

    // Setters

    /**
     * Resets all filter parameters to their default (unfiltered) state.
     */
    public static void reset() {
        project = null;
        name = null;
        neigh = null;
        flatType = null;
        startOD = null;
        endOD = null;
        startCD = null;
        endCD = null;
        maritalStatus = null;
        startAge = -1;
        endAge = -1;
    }

    public static void setProject(Project newProject) { project = newProject; }

    public static void setName(String newName) { name = newName; }

    public static void setNeigh(String newNeigh) { neigh = newNeigh; }

    public static void setFlatType(FlatType newFlatType) { flatType = newFlatType; }

    public static void setStartOD(LocalDate newStartOD) { startOD = newStartOD; }

    public static void setEndOD(LocalDate newEndOD) { endOD = newEndOD; }

    public static void setStartCD(LocalDate newStartCD) { startCD = newStartCD; }

    public static void setEndCD(LocalDate newEndCD) { endCD = newEndCD; }

    public static void setMaritalStatus(MaritalStatus newms) { maritalStatus = newms; }

    public static void setStartAge(int newAge) { startAge = newAge; }

    public static void setEndAge(int newAge) { endAge = newAge; }
}
