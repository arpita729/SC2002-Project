package arrays;

import java.util.ArrayList;

import items.Item;

public class ItemArray<T extends Item> {
    /**
     * Stores all the items in the array
     */
    private ArrayList<T> list = new ArrayList<>();

    /**
     * Keeps track of the actual size of the array without the deleted items.
     */
    private int size = 0;
    
    /**
     * Retrieves an item by its ID.
     * 
     * @param id The ID of the item to retrieve.
     * @return The item with the given ID.
     * @throws IllegalArgumentException if item is deleted
     */
    public T getItem(int id) throws IllegalArgumentException {
        T item = list.get(id);
        if (item.getDeleted()) throw new IllegalArgumentException("item is deleted!");
        return item;
    }

    /**
     * Adds a new item to the list.
     * 
     * @param item The item to be added to the list.
     */
    public void newItem(T item) {
        item.setId(list.size());
        list.add(item);
        size++;
    }

    /**
     * Deletes an item from the list.
     * 
     * @param item The item to be deleted.
     */
    public void deleteItem(T item) {
        item.delete();
        size--;
    }

    /**
     * Retrieves all items in the list.
     * 
     * @return A list of all items.
     */
    public ArrayList<T> get() {
        return new ArrayList<>(list);  
    }

    /**
     * Retrieves the size of the item list.
     * 
     * @return The number of items in the list.
     */
    public int getSize() {
        return size;  
    }

    /**
     * Sets the item list directly.
     * 
     * @param a The list of items to be set.
     */
    public void setItems(ArrayList<T> a) {
        list = a;
        size = a.size(); // assume no deletions
    }
}
