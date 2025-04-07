package menus.project.users;

import java.util.Arrays;

import arrays.Applications;
import items.*;
import managers.ApplicationManager;
import menus.*;
import menus.project.*;

public class BookMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            int i = getInt("Select an application by ID: ");
            Application ap = Applications.getApplication(i);
            ApplicationManager.book(ap);
            println("Application booked.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Book Application ", 
        "Book Application "
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}

