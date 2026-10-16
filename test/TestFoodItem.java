
package test;

import main.FoodItem;
import student.TestCase;

/**
 * Tests the FoodItem class.
 */
public class TestFoodItem extends TestCase {

    private FoodItem food;

    /**
     * Sets up a food item before each test.
     */
    public void setUp() {
        food = new FoodItem("Croissant", "Bakery");
    }

    /**
     * Tests the constructor and getters.
     */
    public void testConstructor() {
        assertEquals("Croissant", food.getName());
        assertEquals("Bakery", food.getCategory());
    }

    /**
     * Tests the string representation.
     */
    public void testToString() {
        assertEquals("Croissant", food.toString());
    }

    /**
     * Tests creating an independent copy.
     */
    public void testCopy() {
        FoodItem copy = food.copy();

        assertNotNull(copy);
        assertNotSame(food, copy);

        assertEquals(food.getName(), copy.getName());
        assertEquals(food.getCategory(), copy.getCategory());
    }

    /**
     * Tests rejecting a null category.
     */
    public void testNullCategory() {
        Exception thrown = null;

        try {
            new FoodItem("Croissant", null);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an empty category.
     */
    public void testEmptyCategory() {
        Exception thrown = null;

        try {
            new FoodItem("Croissant", "");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting a category containing only whitespace.
     */
    public void testBlankCategory() {
        Exception thrown = null;

        try {
            new FoodItem("Croissant", "   ");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an invalid food name.
     */
    public void testInvalidName() {
        Exception thrown = null;

        try {
            new FoodItem("", "Bakery");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }
}
