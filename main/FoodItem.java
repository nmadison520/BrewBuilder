package main;
/**
 * A food item available from the menu
 */
public class FoodItem extends MenuItem {
    private String category;

    /**
     * Creates a food item
     * @param name food name
     * @param category food category
     */
    public FoodItem(String name, String category) {
        super(name);
        this.category = category;
    }

    /** @return the food category */
    public String getCategory() {
        return category;
    }

    @Override
    public FoodItem copy() {
        return new FoodItem(getName(), category);
    }

    @Override
    public String toString() {
        return getName();
    }
}
