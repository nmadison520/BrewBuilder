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
        
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Food category cannot be null or blank"
            );
        }
        
        this.category = category;
    }

    /** @return the food category */
    public String getCategory() {
        return category;
    }

    @Override
    public FoodItem copy() {
        FoodItem result = new FoodItem(getName(), category);
        copyIngredientsTo(result);
        return result;
    }

    @Override
    public String toString() {
        if (hasNoIngredients()) {
            return getName();
        }
        return getName() + " (Ingredients: " + getIngredients() + ")";
    }
}
