
package test;

import main.Ingredient;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Ingredient class.
 *
 * @author Sebastian Pacheco
 * @version October 2026
 */
public class TestIngredient
{
    private Ingredient ingredient;

    /**
     * Sets up an ingredient before each test.
     */
    @Before
    public void setUp()
    {
        ingredient = new Ingredient("Milk");
    }

    /**
     * Tests creating an ingredient.
     */
    @Test
    public void testConstructor()
    {
        assertEquals("Milk", ingredient.getName());
    }

    /**
     * Tests trimming whitespace from ingredient names.
     */
    @Test
    public void testConstructorTrimsWhitespace()
    {
        Ingredient test = new Ingredient("  Sugar  ");

        assertEquals("Sugar", test.getName());
    }

    /**
     * Tests creating an ingredient with a null name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNull()
    {
        new Ingredient(null);
    }

    /**
     * Tests creating an ingredient with an empty name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmpty()
    {
        new Ingredient("");
    }

    /**
     * Tests creating an ingredient with only whitespace.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWhitespace()
    {
        new Ingredient("   ");
    }

    /**
     * Tests getting the ingredient name.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Milk", ingredient.getName());
    }

    /**
     * Tests the string representation.
     */
    @Test
    public void testToString()
    {
        assertEquals("Milk", ingredient.toString());
    }

    /**
     * Tests equality with the same object.
     */
    @Test
    public void testEqualsSameObject()
    {
        assertTrue(ingredient.equals(ingredient));
    }

    /**
     * Tests equality with another ingredient.
     */
    @Test
    public void testEqualsSameName()
    {
        Ingredient other = new Ingredient("Milk");

        assertTrue(ingredient.equals(other));
    }

    /**
     * Tests case-insensitive equality.
     */
    @Test
    public void testEqualsIgnoreCase()
    {
        Ingredient other = new Ingredient("MILK");

        assertTrue(ingredient.equals(other));
        assertTrue(other.equals(ingredient));
    }

    /**
     * Tests inequality with different ingredient names.
     */
    @Test
    public void testEqualsDifferentName()
    {
        Ingredient other = new Ingredient("Sugar");

        assertFalse(ingredient.equals(other));
    }

    /**
     * Tests equality with null.
     */
    @Test
    public void testEqualsNull()
    {
        assertFalse(ingredient.equals(null));
    }

    /**
     * Tests equality with a different object type.
     */
    @Test
    public void testEqualsDifferentType()
    {
        assertFalse(ingredient.equals("Milk"));
    }

    /**
     * Tests matching hash codes for equal ingredients.
     */
    @Test
    public void testHashCodeEqual()
    {
        Ingredient other = new Ingredient("Milk");

        assertEquals(ingredient.hashCode(), other.hashCode());
    }

    /**
     * Tests hash code consistency across capitalization.
     */
    @Test
    public void testHashCodeIgnoreCase()
    {
        Ingredient other = new Ingredient("MILK");

        assertEquals(ingredient.hashCode(), other.hashCode());
    }

    /**
     * Tests hash code consistency across repeated calls.
     */
    @Test
    public void testHashCodeConsistent()
    {
        assertEquals(ingredient.hashCode(), ingredient.hashCode());
    }
}
