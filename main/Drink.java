package main;
/**
 * A customizable drink available from the menu
 */
public class Drink extends MenuItem {
    private String size;
    private String flavor;

    /**
     * Creates a drink
     * @param name drink name
     * @param size selected size
     * @param flavor selected flavor
     */
    public Drink(String name, String size, String flavor) {
        super(name);
        
        setSize(size);
        setFlavor(flavor);
    }

    /** @return selected size */
    public String getSize() {
        return size;
    }

    /** @return selected flavor */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Changes the drink size
     * @param size requested size
     * @throws IllegalArgumentException if unsupported
     */
    public void setSize(String size) {
        if (size == null ||
            (!size.equalsIgnoreCase("Small") &&
             !size.equalsIgnoreCase("Medium") &&
             !size.equalsIgnoreCase("Large"))) {

            throw new IllegalArgumentException(
                "Invalid drink size"
            );
        }

        this.size = size;
    }

    /**
     * Changes the drink flavor.
     * @param flavor requested flavor
     * @throws IllegalArgumentException if unsupported
     */
    public void setFlavor(String flavor) {
        if (flavor == null ||
            (!flavor.equalsIgnoreCase("None") &&
             !flavor.equalsIgnoreCase("Vanilla") &&
             !flavor.equalsIgnoreCase("Caramel") &&
             !flavor.equalsIgnoreCase("Hazelnut") &&
             !flavor.equalsIgnoreCase("Pumpkin"))) {

            throw new IllegalArgumentException(
                "Invalid drink flavor"
            );
        }

        this.flavor = flavor;
    }

    @Override
    public Drink copy() {
        return new Drink(getName(), size, flavor);
    }

    @Override
    public String toString() {
        return size + " " + flavor + " " + getName();
    }
}
