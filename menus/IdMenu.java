package menus;

/**
 * The abstract IdMenu class provides a template for menus that require an
 * ID to function, such as displaying a single Project's details
 */
public abstract class IdMenu extends Menu {
    /**
     * option is static to be shared among menus that need it
     */
    private static int id = 0;

    /**
     * Constructs a Menu object with the specified description and information.
     * 
     * @param d The description of the menu.
     * @param i Additional information about the menu.
     */
    public IdMenu(String d, String i) {
        super(d,i);
    }

    public static int getId() { return id; }
    public static void setId(int o) { id = o; }
}