package menus;

import java.time.LocalDate;

/**
 * The GetDate class provides a utility method for prompting the user to input a date.
 * It parses the input into a LocalDate object or returns null if the input is empty.
 */
public class GetDate {

    /**
     * Prompts the user to enter a date in the format "yyyy-mm-dd".
     * 
     * @return A LocalDate object representing the entered date, or null if the input is empty.
     */
    public static LocalDate getDate() {
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String s = Menu.sc.nextLine();
        return s.length() == 0 ? null : LocalDate.parse(s);
    }
}