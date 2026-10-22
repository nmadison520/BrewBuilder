package main;

/**
 * Shared parent type for items that can be added to a BrewBuilder order.
 */
public abstract class MenuItem
{
    private String name;
    private LinkedChain<Ingredient> ingredients;

    /**
     * Creates a menu item.
     *
     * @param name the name
     */
    public MenuItem(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                "Menu item name cannot be null or blank");
        }

        this.name = name;
        ingredients = new LinkedChain<Ingredient>();
    }

    /**
     * @return the item's display name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Adds an ingredient to the end of the ingredient list.
     *
     * @param ingredient the ingredient to add
     */
    public void addIngredient(Ingredient ingredient)
    {
        if (ingredient == null)
        {
            throw new IllegalArgumentException(
                "Ingredient cannot be null");
        }

        ingredients.addToEnd(ingredient);
    }

    /**
     * Creates and adds an ingredient using its name.
     *
     * @param str the ingredient name
     */
    public void addIngredient(String str)
    {
        addIngredient(new Ingredient(str));
    }

    /**
     * Removes the first ingredient matching the given name.
     *
     * @param str the ingredient name
     * @return true if an ingredient was removed
     */
    public boolean removeIngredient(String str)
    {
        if (str == null || str.trim().isEmpty())
        {
            return false;
        }

        return ingredients.remove(new Ingredient(str));
    }

    /**
     * Removes an ingredient at a given position.
     *
     * @param index the zero-based position
     * @return true if an ingredient was removed
     */
    public boolean removeIngredient(int index)
    {
        if (index < 0 || index >= ingredients.size())
        {
            return false;
        }

        LinkedChain<Ingredient> newIngredients =
            new LinkedChain<Ingredient>();

        for (int i = 0; i < ingredients.size(); i++)
        {
            if (i != index)
            {
                newIngredients.addToEnd(ingredients.get(i));
            }
        }

        ingredients = newIngredients;
        return true;
    }

    /**
     * @param name the ingredient name
     * @return true if the ingredient is present
     */
    public boolean hasIngredient(String name)
    {
        if (name == null)
        {
            return false;
        }

        return ingredients.contains(new Ingredient(name));
    }

    /**
     * @return the ingredient at the given position
     */
    public Ingredient getIngredient(int index)
    {
        return ingredients.get(index);
    }

    /**
     * @return the number of ingredients
     */
    public int getIngredientCount()
    {
        return ingredients.size();
    }

    /**
     * @return true if there are no ingredients
     */
    public boolean hasNoIngredients()
    {
        return ingredients.isEmpty();
    }

    /**
     * @return a readable list of ingredients
     */
    public String getIngredients()
    {
        return ingredients.toString();
    }

    /**
     * Copies ingredients into another menu item.
     *
     * @param target the item receiving the ingredients
     */
    protected void copyIngredientsTo(MenuItem target)
    {
        for (int i = 0; i < ingredients.size(); i++)
        {
            Ingredient ingredient = ingredients.get(i);

            target.addIngredient(
                new Ingredient(ingredient.getName()));
        }
    }

    /**
     * Creates a copy of this item.
     *
     * @return the copy
     */
    public abstract MenuItem copy();

    @Override
    public String toString()
    {
        return name + " " + ingredients;
    }
}
