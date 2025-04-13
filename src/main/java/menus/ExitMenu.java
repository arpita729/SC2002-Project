package menus;

import java.util.Arrays;

public class ExitMenu {
    private static class BaseClass extends Menu {
        public BaseClass(String d, String i) {
            super(d,i);
        };
        public void menu() {
            System.exit(0);
        };
    }

    private static BaseClass baseClass = new BaseClass(
        "Quit", 
        "Shutting Down..."
    );

    public static void setOptions() {
        baseClass.setOptions(Arrays.asList(LoginMenu.get()));
    }

    public static Menu get() {
        return baseClass;
    }
}
