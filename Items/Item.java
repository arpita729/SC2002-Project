package items;

/**
 * Abstract class representing a general item with an ID and a deleted status.
 */
public abstract class Item {
    /**
     * Unique identifier for the item.
     */
    private int id;
    
    /**
     * Boolean flag indicating whether the item is deleted.
     * Default value is false.
     */
    private boolean deleted = false;

    /**
     * Retrieves the ID of the item.
     * 
     * @return the item's ID
     */
    public int getId() { return id; }

    /**
     * Checks if the item is marked as deleted.
     * 
     * @return true if the item is deleted, false otherwise
     */
    public boolean getDeleted() { return deleted; }

    /**
     * Returns a string representation of the item.
     * 
     * @return a string describing the item
     */
    public abstract String toString();

    /**
     * Marks the item as deleted by setting the deleted flag to true.
     */
    public void delete() { deleted = true; }

    /**
     * Sets the ID of the item.
     * 
     * @param id the new ID for the item
     */
    public void setId(int id) { this.id = id; }
}
