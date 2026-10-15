package main;
/**
 * Shared parent type for items that can be added to a BrewBuilder order
 */
public abstract class MenuItem {
    private String name;

    /**
     * Creates a menu item
     * @param name the name
     */
    public MenuItem(String name) {
        this.name = name;
    }

    /**
     * @return the item's display name
    */
    public String getName() {
        return name;
    }

    /**
     * Creates copy of the item
     * @return the copy
     */
    public abstract MenuItem copy();

    @Override
    public String toString() {
        // maybe toString should return a description of the item
        // like ingredients temperature etc
        return name;
    }
}
