package menus.users.officer;

import java.util.Arrays;

import menus.*;
import menus.project.ProjectViewMenu;
import arrays.OfficerApplications;

public class ViewMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {super(d,i);};
        public void menu(){
            int id = IdMenu.getId();
            if (id == -1) {
                ApplicationSelectMenu.get().display();
                id = IdMenu.getId();
            }
            IdMenu.setId(OfficerApplications.getOfficerApplication(id).getProject().getId());
        };
    }

    private static BaseClass baseClass = new BaseClass(
            "View Application's Project",
            ""
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
