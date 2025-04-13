package menus;

/**
 * The abstract IdMenu class provides a template for menus that require an
 * ID to function, such as displaying a single project's details or performing
 * operations on a specific item identified by an ID.
 */
public abstract class IdMenu extends Menu {
    /**
     * A static variable to store the shared ID among menus that require it.
     */
    private static int id = 0;

    /**
     * Constructs an IdMenu object with the specified description and information.
     * 
     * @param d The description of the menu.
     * @param i Additional information about the menu.
     */
    public IdMenu(String d, String i) {
        super(d, i);
    }

    /**
     * Retrieves the current ID used by the menu.
     * 
     * @return The current ID.
     */
    public static int getId() { 
        return id; 
    }

    /**
     * Sets the ID to be used by the menu.
     * 
     * @param o The ID to set.
     */
    public static void setId(int o) { 
        id = o; 
    }
}