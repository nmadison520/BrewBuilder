package main;

/**
 * Represents an ingredient that can be added to a menu item.
 */
public class Ingredient
{
    private String name;

    /**
     * Creates an ingredient.
     *
     * @param name
     *            the ingredient name
     */
    public Ingredient(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                "Ingredient name cannot be null or blank");
        }

        this.name = name.trim();
    }


    /**
     * @return the ingredient name
     */
    public String getName()
    {
        return name;
    }


    @Override
    public String toString()
    {
        return name;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof Ingredient))
        {
            return false;
        }

        Ingredient other = (Ingredient)obj;
        return name.equalsIgnoreCase(other.name);
    }


    @Override
    public int hashCode()
    {
        return name.toLowerCase(java.util.Locale.ROOT).hashCode();
    }
}
