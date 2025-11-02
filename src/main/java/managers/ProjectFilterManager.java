package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import items.Application.FlatType;
import items.users.Applicant;
import items.users.User;
import items.Project;

/**
 * ProjectFilterManager provides static filtering functionality for a list of housing projects
 * based on various criteria such as flat type availability, project name, neighborhood, and dates.
 * 
 * <p>It also considers the current user's eligibility to apply for specific flat types.
 * 
 * <p>Note: This class uses static fields to store filters and is not thread-safe.
 */
public class ProjectFilterManager {

    /** Project name filter (substring match, case-insensitive). */
    private static String name = null;

    /** Neighborhood filter (substring match, case-insensitive). */
    private static String neigh = null;

    /** Required flat type availability filter. */
    private static FlatType hasFlatType = null;

    /** Opening date start range. */
    private static LocalDate startOD = null;

    /** Opening date end range. */
    private static LocalDate endOD = null;

    /** Closing date start range. */
    private static LocalDate startCD = null;

    /** Closing date end range. */
    private static LocalDate endCD = null;

    /**
     * Filters the provided list of {@link Project}s based on the currently set filter criteria.
     * Also applies validation based on the current user's eligibility (if the user is an {@link Applicant}).
     * 
     * @param list The list of projects to filter.
     * @return A filtered list of projects, sorted alphabetically by project name.
     */
    public static ArrayList<Project> filter(ArrayList<Project> list) {
        ArrayList<Project> newList = new ArrayList<>();
        User u = AppUserManager.getCurrentUser();
        Applicant a = (u instanceof Applicant) ? (Applicant)u : null;

        boolean allowThreeRoom = true;

        if (a != null) {
            try {
                Validator.validateApplication(a, FlatType.TWO_ROOM);
            } catch (Exception e) {
                return newList; // Applicant is not eligible for any application
            }

            try {
                Validator.validateApplication(a, FlatType.THREE_ROOM);
            } catch (Exception e) {
                allowThreeRoom = false;
            }
        }

        for (Project p : list) {
            if (p.getDeleted()) continue;
            if (!p.isVisible()) continue;

            // Flat type constraints
            if ((hasFlatType == FlatType.TWO_ROOM || !allowThreeRoom) && p.getNum2Room() <= 0) continue;
            if (hasFlatType == FlatType.THREE_ROOM && p.getNum3Room() <= 0) continue;

            // String filters
            if (name != null && !contains(p.getName(), name)) continue;
            if (neigh != null && !contains(p.getNeighborhood(), neigh)) continue;

            // Date filters
            if (!betweenDates(p.getOpeningDate(), startOD, endOD)) continue;
            if (!betweenDates(p.getClosingDate(), startCD, endCD)) continue;

            newList.add(p);
        }

        newList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return newList;
    }

    /**
     * Returns a string describing the currently active filters.
     * 
     * @return A string listing all active filters.
     */
    public static String getString() {
        String s = "";
        if (hasFlatType != null) s += "Available Flat Types: " +
            ((hasFlatType == FlatType.TWO_ROOM) ? "Two Room" : "Three Room") + "\n";
        if (name != null) s += "Name: " + name + "\n";
        if (neigh != null) s += "Neighbourhood: " + neigh + "\n";
        if (startOD != null || endOD != null) s += "Opening Date: " + dateString(startOD, endOD) + "\n";
        if (startCD != null || endCD != null) s += "Closing Date: " + dateString(startCD, endCD) + "\n";
        if (s.length() == 0) s += "None. \n";
        return s;
    }

    /**
     * Resets all filter criteria to their default (null or -1) values.
     */
    public static void reset() {
        name = null;
        neigh = null;
        hasFlatType = null;
        startOD = null;
        endOD = null;
        startCD = null;
        endCD = null;
    }

    // ─── Setters ────────────────────────────────────────────────────────────────

    /**
     * Sets the name filter.
     * @param newName The substring to match project names against.
     */
    public static void setName(String newName) { name = newName; }

    /**
     * Sets the neighborhood filter.
     * @param newNeigh The substring to match neighborhood names against.
     */
    public static void setNeigh(String newNeigh) { neigh = newNeigh; }

    /**
     * Sets the required flat type availability.
     * @param newHasFlatType The flat type to filter projects by.
     */
    public static void setHasFlatType(FlatType newHasFlatType) { hasFlatType = newHasFlatType; }

    /**
     * Sets the opening date range start.
     * @param newStartOD The start date for project opening.
     */
    public static void setStartOD(LocalDate newStartOD) { startOD = newStartOD; }

    /**
     * Sets the opening date range end.
     * @param newEndOD The end date for project opening.
     */
    public static void setEndOD(LocalDate newEndOD) { endOD = newEndOD; }

    /**
     * Sets the closing date range start.
     * @param newStartCD The start date for project closing.
     */
    public static void setStartCD(LocalDate newStartCD) { startCD = newStartCD; }

    /**
     * Sets the closing date range end.
     * @param newEndCD The end date for project closing.
     */
    public static void setEndCD(LocalDate newEndCD) { endCD = newEndCD; }

    // ─── Helper Methods ─────────────────────────────────────────────────────────

    /**
     * Case-insensitive substring check.
     * 
     * @param str The full string.
     * @param substr The substring to check.
     * @return True if substr is in str.
     */
    private static boolean contains(String str, String substr) {
        return str.toLowerCase().contains(substr.toLowerCase());
    }

    /**
     * Checks if a date is within a given start and end range.
     * 
     * @param d The date to test.
     * @param start The start of the range (nullable).
     * @param end The end of the range (nullable).
     * @return True if the date is within the specified range.
     */
    private static boolean betweenDates(LocalDate d, LocalDate start, LocalDate end) {
        if (start != null && d.isBefore(start)) return false;
        if (end != null && d.isAfter(end)) return false;
        return true;
    }

    /**
     * Returns a string representing a date range.
     * 
     * @param start Start of the range.
     * @param end End of the range.
     * @return A formatted string indicating the range.
     */
    private static String dateString(LocalDate start, LocalDate end) {
        return "Between " +
            ((start == null) ? "Any" : start.toString()) +
            " and " +
            ((end == null) ? "Any" : end.toString());
    }
}
