package main;
/**
 * An order
 */
public class Order {
    private LinkedChain<MenuItem> items;

    public Order() {
        // init the order
    }

    /**
     * Adds an item to the end of the order
     * @param item item to add
     */
    public void addItem(MenuItem item) {
        
    }

    /**
     * Removes the item at the index
     * @param index position to remove
     * @return true if removed, false if it fails
     */
    public boolean removeItem(int index) {
        return false;
    }

    /**
     * Gets an item at the index
     * @param index position to retrieve
     * @return item at index
     */
    public MenuItem getItem(int index) {
        return null;
    }

    /**
     * Checks whether an item with the given name
     * @param name name to search for
     * @return true if found
     */
    public boolean containsName(String name) {
        return false;
    }

    /**
     * Replaces the item at the index
     * @param index position to update
     * @param item replacement item
     */
    public void updateItem(int index, MenuItem item) {
    }

    /** 
     * @return number of items in the order
    */
    public int getSize() {
        return 0;
    }

    /** Removes all items from the order. */
    public void clearOrder() {
    }

    /** @return true only if the order is nonempty */
    public boolean canConfirm() {
        return false;
    }

    /** @return readable order summary in insertion order */
    public String reviewOrder() {
        return "";
    }
}
