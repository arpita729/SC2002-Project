package menus;

import java.util.List;
import java.util.Scanner;

/**
 * The abstract Menu class provides a template for different menu types
 * in the system. Each menu has a description, additional information,
 * and navigation options to other menus.
 */
public abstract class Menu {
    private String description;
    private String info;
    private List<Menu> navigationOptions = null;
    public static Scanner sc = new Scanner(System.in);

    /**
     * Constructs a Menu object with the specified description and information.
     * 
     * @param d The description of the menu.
     * @param i Additional information about the menu.
     */
    public Menu(String d, String i) {
        description = d;
        info = i;
    }

    /**
     * Displays the additional information about the menu.
     */
    public void displayInfo() {
        System.out.println(info);
    }

    /**
     * Abstract method that must be implemented by subclasses
     * to define the menu behavior.
     */
    public abstract void menu();

    /**
     * Displays navigation options and redirects to the selected menu.
     */
    public void options() {
        int n = navigationOptions.size();
        if (n == 0) return;
        if (n == 1) {
            navigationOptions.get(0).display();
            return;
        }
        // More than one option available
        println("Select an option:");
        for (int i = 1; i < n; i++) {
            println(
                i + ": " +
                navigationOptions.get(i).getDescription()
            );
        }
        println(
            "Default: " + 
            navigationOptions.get(0).getDescription()
        );
        
        try {
            int selected = getInt("Option: ");
            navigationOptions.get(selected).display();
        } catch (Exception e) {
            navigationOptions.get(0).display();
        }
    }

    /**
     * Displays the menu, handles exceptions, and presents options to navigate.
     */
    public void display() {
        println(""); // Create some empty space
        displayInfo();
        while (true) {
            try {
                menu();
                break;
            } catch (Exception e) {
                println("Error: " + e.getMessage());
            }    
        }
        options();
    }

    /**
     * Prompts the user for an integer input. 
     * If it's not an integer, returns -1.
     * 
     * @param prompt The message displayed to prompt the user.
     * @return The integer input from the user.
     */
    public int getInt(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        return (s.length() == 0) ? -1 : Integer.parseInt(s);
    }

    /**
     * Prompts the user for a string input.
     * 
     * @param prompt The message displayed to prompt the user.
     * @return The string input from the user.
     */
    public String getString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * Prints a string message to the console.
     * 
     * @param s The message to be printed.
     */
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * Gets the description of the menu.
     * 
     * @return The menu description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks whether the navigation options have been instantiated.
     * 
     * @return true if the navigation options are null, otherwise false.
     */
    public boolean isInsantiated() {
        return navigationOptions == null;
    }
    
    /**
     * Gets the navigationOptions of the menu.
     * 
     * @return navigationOptions
     */
    public List<Menu> getOptions() {
        return navigationOptions;
    }

    /**
     * Sets the navigation options for the menu.
     * Called by the child object to define nagivation options.
     * Exists to prevent circular import nonsense.
     * 
     * @param o The list of menu options.
     */
    public void setOptions(List<Menu> o) {
        navigationOptions = o;
    }
}
