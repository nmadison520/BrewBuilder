package main;
/**
 * A customizable drink available from the menu
 */
public class Drink extends MenuItem {
    private String size;
    private String type;

    /**
     * Creates a drink
     * @param name drink name
     * @param size selected size
     * @param flavor selected type
     */
    public Drink(String name, String size, String type) {
        super(name);
        
        this.size = size;
        this.type = type;
    }

    /** @return selected size */
    public String getSize() {
        return size;
    }

    /** @return selected flavor */
    public String getFlavor() {
        return type;
    }

    /**
     * Changes the drink size
     * @param size requested size
     * @throws IllegalArgumentException if unsupported
     */
    public void setSize(String size) {
        
    }

    /**
     * Changes the drink flavor.
     * @param flavor requested flavor
     * @throws IllegalArgumentException if unsupported
     */
    public void setFlavor(String flavor) {
        // TODO: Validate and update flavor.
    }

    @Override
    public Drink copy() {
        return new Drink(getName(), size, type);
    }

    @Override
    public String toString() {
        return "Name: " + getName();
    }
}
