package menus.projectFilter;

import java.time.LocalDate;

import menus.Menu;

public class GetDate {
    public static LocalDate getDate() {
        System.out.print("Enter a date (yyyy-mm-dd) or blank to clear: ");
        String s = Menu.sc.nextLine();
        return s.length() == 0 ? null :LocalDate.parse(s);
    }
}