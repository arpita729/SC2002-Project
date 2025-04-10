package menus;

import java.time.LocalDate;

public class GetDate {
    public static LocalDate getDate() {
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String s = Menu.sc.nextLine();
        return s.length() == 0 ? null :LocalDate.parse(s);
    }
}