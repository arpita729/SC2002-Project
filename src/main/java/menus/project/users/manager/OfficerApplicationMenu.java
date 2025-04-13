package menus.project.users.manager;

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
            println("Remaining Officer Slots: " + p.getOfficerSlots() + "\n");
            ArrayList<OfficerApplication> list = OfficerApplications.filter(p);
            for (OfficerApplication a : list) println(a.toString());
            if (list.isEmpty()) println("No Applications Found.");
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "List Officer Applications", 
        "OFFICER APPLICATIONS"
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(
            ProjectViewMenu.get(),
            EditOApplicationMenu.get()
        ));
    }

    public static Menu get() {
        return baseClass;
    }
}
