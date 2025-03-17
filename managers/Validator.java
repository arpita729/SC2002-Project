package managers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import items.Project;
import items.Application.FlatType;
import items.users.Applicant;
import items.users.User.*;

/**
 * The Validator class provides utility methods for validating various user inputs and project details.
 * It includes validation for NRIC format, date ranges, and project overlaps and applications.
 */
public class Validator {

    /**
     * A regular expression String to validate the NRIC format.
     */
    static String regex = "^[ST]\\d{7}[A-Z]$";

    /**
     * A regular expression pattern to validate the NRIC format.
     */
    static Pattern pattern = Pattern.compile(regex);

    /**
     * Validates the format of an NRIC number.
     * 
     * @param ic The NRIC string to validate.
     * @return true if the NRIC is valid, false otherwise.
     */
    public static boolean validateNRIC(String ic) {
        return pattern.matcher(ic).matches();
    }

    /**
     * Validates if the end date is not before the start date.
     * 
     * @param start The start date of the range.
     * @param end The end date of the range.
     * @return true if the end date is equal to or after the start date, false otherwise.
     */
    private static boolean validateDates(LocalDate start, LocalDate end) {
        return !end.isBefore(start);
    }

    /**
     * Validates that two projects do not overlap in time.
     * 
     * @param start1 The start date of the first project.
     * @param end1 The end date of the first project.
     * @param start2 The start date of the second project.
     * @param end2 The end date of the second project.
     * @return true if the projects do not overlap, false otherwise.
     */
    private static boolean validateProjectOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        // Check if the projects overlap
        return end1.isBefore(start2) || end2.isBefore(start1);  // No overlap if one ends before the other starts
    }

    /**
     * Validates a new project by checking the dates and ensuring no overlap with existing projects.
     * 
     * @param start The start date of the new project.
     * @param end The end date of the new project.
     * @param pa A list of existing projects to check for date overlap.
     * @throws IllegalArgumentException if the project dates are invalid or overlap with existing projects.
     */
    public static void validateNewProject(LocalDate start, LocalDate end, ArrayList<Project> pa) throws IllegalArgumentException {
        if (!validateDates(start, end)) throw new IllegalArgumentException("end before start!");
        for (Project p : pa) {
            if (!validateProjectOverlap(start, end, p.getOpeningDate(), p.getClosingDate())) 
                throw new IllegalArgumentException("overlapping dates!");
        }
    }

    /**
     * Validates if an applicant is allowed to apply for a flat type
     * @param a the Applicant applying
     * @param f the FlatType the applicant is applying for 
     * @throws IllegalArgumentException if the application is invalid
     */
    public static void validateApplication(Applicant a, FlatType f) throws IllegalArgumentException {
        if (a.getMaritalStatus() == MaritalStatus.MARRIED) {
            if (a.getAge() < 21) throw new IllegalArgumentException("not of age!");
        } else { // not married
            if (a.getAge() < 35) throw new IllegalArgumentException("not of age!");
            if (f != FlatType.TWO_ROOM) throw new IllegalArgumentException("inapplicable flattype!");
        }
    }
    
}
