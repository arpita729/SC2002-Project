package managers;

import java.time.LocalDate;
import java.util.ArrayList;

import items.Application.FlatType;
import items.users.Applicant;
import items.users.User;
import items.Project;

public class ProjectFilterManager {
    private static String name = null;
    private static String neigh = null;
    private static FlatType hasFlatType = null;
    private static LocalDate startOD = null;
    private static LocalDate endOD = null;
    private static LocalDate startCD = null;
    private static LocalDate endCD = null;

    public static ArrayList<Project> filter(ArrayList<Project> list) {
        ArrayList<Project> newList = new ArrayList<>();
        User u = AppUserManager.getCurrentUser();
        Applicant a = (u instanceof Applicant) ? (Applicant)u : null;

        boolean allowThreeRoom = true;

        if (a != null) {
            try {
                Validator.validateApplication(a, FlatType.TWO_ROOM);
            } catch (Exception e) { 
                return newList; // no applications will be valid.
            }

            try {
                Validator.validateApplication(a, FlatType.THREE_ROOM);
            } catch (Exception e) {
                allowThreeRoom = false; // not allowed to apply for 3 room
            }
        }

        for (Project p : list) {
            if (p.getDeleted()) continue;

            // flat types
            if ((hasFlatType == FlatType.TWO_ROOM || !allowThreeRoom) && p.getNum2Room()<=0) continue;
            if (hasFlatType == FlatType.THREE_ROOM && p.getNum3Room()<=0) continue;

            // strings
            if (name != null && !contains(p.getName(), name)) continue;
            if (neigh != null && !contains(p.getNeighborhood(), neigh)) continue;
            
            // dates
            if (!betweenDates(p.getOpeningDate(), startOD, endOD)) continue;
            if (!betweenDates(p.getClosingDate(), startCD, endCD)) continue;

            

            newList.add(p);
        }
        // sort by alphabetical order
        newList.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return newList;
    }

    private static boolean contains(String str, String substr) {
        return str.toLowerCase().contains(substr.toLowerCase());
    };

    private static boolean betweenDates(LocalDate d, LocalDate start, LocalDate end) {
        if (start != null && d.isBefore(start)) return false;
        if (end != null && d.isAfter(end)) return false;
        return true;
    }

    public static String getString() {
        String s = "";
        if (hasFlatType != null) s += "Available Flat Types: " + 
            ((hasFlatType == FlatType.TWO_ROOM) ? "Two Room" : "Three Room") + "\n";
        if (name != null) s += "Name: " + name + "\n";
        if (neigh != null) s += "Neighbourhood: " + neigh + "\n";
        if (startOD != null || endOD != null) s += "Opening Date: " + dateString(startOD, endOD);
        if (startCD != null || endCD != null) s += "Closing Date: " + dateString(startCD, endCD);
        if (s.length() == 0) s += "None. \n";
        return s;
    }

    private static String dateString(LocalDate start, LocalDate end) {
        return "Between " +
            ((start == null) ? "Any" : start.toString()) +
            " and " +
            ((end == null) ? "Any" : end.toString());
    }

    // Setters
    public static void reset() {
        name = null;
        neigh = null;
        hasFlatType = null;
        startOD = null;
        endOD = null;
        startCD = null;
        endCD = null;
    }

    public static void setName(String newName) { name = newName; }
    public static void setNeigh(String newNeigh) { neigh = newNeigh; }
    public static void setHasFlatType(FlatType newHasFlatType) { hasFlatType = newHasFlatType; }
    public static void setStartOD(LocalDate newStartOD) { startOD = newStartOD; }
    public static void setEndOD(LocalDate newEndOD) { endOD = newEndOD; }
    public static void setStartCD(LocalDate newStartCD) { startCD = newStartCD; }
    public static void setEndCD(LocalDate newEndCD) { endCD = newEndCD; }
}
