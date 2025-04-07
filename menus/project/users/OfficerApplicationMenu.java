package menus.project.users;

import java.util.ArrayList;
import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

public class OfficerApplicationMenu {
    private static class BaseClass extends IdMenu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            Project p = null;
            if (getId() == -1) ProjectSelectMenu.get().display();
            try {
                p = Projects.getProject(getId());
            } catch (Exception e) {
                setId(-1);
                return;
            }
            ArrayList<Application> list = Applications.filter(p);
            for (Application a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "List Applications", 
        "Applications:"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get(),
            BookMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
