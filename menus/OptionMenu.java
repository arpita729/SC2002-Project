package menus;

/**
 * The abstract Menu class provides a template for different menu types
 * in the system. Each menu has a description, additional information,
 * and navigation options to other menus.
 */
public abstract class OptionMenu extends Menu {
    /**
     * Constructs a Menu object with the specified description and information.
     * 
     * @param d The description of the menu.
     * @param i Additional information about the menu.
     */
    public OptionMenu(String d, String i) {
        super(d,i);
    }

    
    /**
     * Abstract method that must be implemented by subclasses
     * to define the menu behavior.
     */
    public abstract void menu(int option);

    public void menu() {menu(0);};

    /**
     * Displays the menu, handles exceptions, and presents options to navigate.
     */
    public void display(int option) {
        println(""); // Create some empty space
        displayInfo();
        while (true) {
            try {
                menu(option);
                break;
            } catch (Exception e) {
                println("Error: " + e.getMessage());
            }    
        }
        options();
    }
}