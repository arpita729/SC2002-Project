package managers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import items.Project;

public class Validator {
    static String regex = "^[ST]\\d{7}[A-Z]$";
    static Pattern pattern = Pattern.compile(regex);

    public static boolean validateNRIC(String ic) {
        return pattern.matcher(ic).matches();
    }

    public static boolean validateDates(LocalDate start, LocalDate end) {
        return !end.isBefore(start);
    }

    public static boolean validateProjectOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        // Check if the projects overlap
        return end1.isBefore(start2) || end2.isBefore(start1);  // No overlap if one ends before the other starts
    }

    public static void validateNewProject(LocalDate start, LocalDate end, ArrayList<Project> pa) throws IllegalArgumentException {
        if (!validateDates(start, end)) throw new IllegalArgumentException("end before start!");
        for (Project p:pa) {
            if (!validateProjectOverlap(start, end, p.getOpeningDate(), p.getClosingDate())) throw new IllegalArgumentException("overlapping dates!");
        }
    }
}
