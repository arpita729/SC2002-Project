package menus.project.users.manager;

import java.util.Arrays;

import arrays.*;
import items.*;
import menus.*;
import menus.project.*;

public class ToggleVisibilityMenu {
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
            p.setVisibility(!p.isVisible());
            println("Visibility set to " + (p.isVisible() ? "yes" : "no"));
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Toggle Visibility", 
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
