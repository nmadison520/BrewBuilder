package test;

import main.Ingredient;
import main.MenuItem;
import main.FoodItem;
import student.TestCase;

/**
 * Tests the MenuItem class using FoodItem as a subclass.
 */
public class TestMenuItem
    extends TestCase
{

    private MenuItem item;

    /**
     * Sets up a menu item before each test.
     */
    public void setUp()
    {
        item = new FoodItem("Muffin", "Bakery");
    }


    /**
     * Tests getting the item name.
     */
    public void testGetName()
    {
        assertEquals("Muffin", item.getName());
    }


    /**
     * Tests the string representation.
     */
    public void testToString()
    {
        assertEquals("Muffin", item.toString());
    }


    /**
     * Tests creating an independent copy.
     */
    public void testCopy()
    {
        MenuItem copy = item.copy();

        assertNotNull(copy);
        assertNotSame(item, copy);
        assertEquals(item.getName(), copy.getName());
        assertTrue(copy instanceof FoodItem);
    }


    /**
     * tests adding ingredients.
     */
    public void testAddIngredients()
    {
        item.addIngredient("Milk");
        item.addIngredient("Sugar");

        assertEquals(2, item.getIngredientCount());
        assertEquals("Milk", item.getIngredient(0).getName());
        assertEquals("Sugar", item.getIngredient(1).getName());
    }


    /**
     * Tests rejecting a null ingredient
     */
    public void testAddNullIngredient()
    {
        Exception thrown = null;

        try
        {
            item.addIngredient((Ingredient)null);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(item.hasNoIngredients());
    }


    /**
     * Tests rejecting a null name.
     */
    public void testNullName()
    {
        Exception thrown = null;

        try
        {
            new FoodItem(null, "Bakery");
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests rejecting an empty name.
     */
    public void testEmptyName()
    {
        Exception thrown = null;

        try
        {
            new FoodItem("", "Bakery");
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Tests rejecting a name containing only whitespace.
     */
    public void testBlankName()
    {
        Exception thrown = null;

        try
        {
            new FoodItem("", "Bakery");
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }
}
