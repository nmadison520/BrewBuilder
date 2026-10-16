
package test;

import main.Drink;
import student.TestCase;

/**
 * Tests the Drink class.
 */
public class TestDrink extends student.TestCase {

    private Drink drink;

    /**
     * Sets up a drink before each test.
     */
    public void setUp() {
        drink = new Drink("Latte", "Medium", "Vanilla");
    }

    /**
     * Tests the constructor and getters.
     */
    public void testConstructor() {
        assertEquals("Latte", drink.getName());
        assertEquals("Medium", drink.getSize());
        assertEquals("Vanilla", drink.getFlavor());
    }

    /**
     * Tests changing the drink size.
     */
    public void testSetSize() {
        drink.setSize("Large");
        assertEquals("Large", drink.getSize());

        drink.setSize("Small");
        assertEquals("Small", drink.getSize());
    }

    /**
     * Tests case-insensitive size validation.
     */
    public void testSizeCaseInsensitive() {
        drink.setSize("small");
        assertEquals("small", drink.getSize());

        drink.setSize("LARGE");
        assertEquals("LARGE", drink.getSize());
    }

    /**
     * Tests rejecting an invalid size.
     */
    public void testInvalidSize() {
        Exception thrown = null;

        try {
            drink.setSize("XXL");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Medium", drink.getSize());
    }

    /**
     * Tests rejecting a null size.
     */
    public void testNullSize() {
        Exception thrown = null;

        try {
            drink.setSize(null);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Medium", drink.getSize());
    }

    /**
     * Tests rejecting an empty size.
     */
    public void testEmptySize() {
        Exception thrown = null;

        try {
            drink.setSize("");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests changing the drink flavor.
     */
    public void testSetFlavor() {
        drink.setFlavor("Caramel");
        assertEquals("Caramel", drink.getFlavor());

        drink.setFlavor("Hazelnut");
        assertEquals("Hazelnut", drink.getFlavor());

        drink.setFlavor("None");
        assertEquals("None", drink.getFlavor());
    }

    /**
     * Tests case-insensitive flavor validation.
     */
    public void testFlavorCaseInsensitive() {
        drink.setFlavor("pumpkin");
        assertEquals("pumpkin", drink.getFlavor());

        drink.setFlavor("VANILLA");
        assertEquals("VANILLA", drink.getFlavor());
    }

    /**
     * Tests rejecting an invalid flavor.
     */
    public void testInvalidFlavor() {
        Exception thrown = null;

        try {
            drink.setFlavor("Strawberry");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Vanilla", drink.getFlavor());
    }

    /**
     * Tests rejecting a null flavor.
     */
    public void testNullFlavor() {
        Exception thrown = null;

        try {
            drink.setFlavor(null);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("Vanilla", drink.getFlavor());
    }

    /**
     * Tests rejecting an empty flavor.
     */
    public void testEmptyFlavor() {
        Exception thrown = null;

        try {
            drink.setFlavor("");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an invalid constructor size.
     */
    public void testInvalidConstructorSize() {
        Exception thrown = null;

        try {
            new Drink("Latte", "XXL", "Vanilla");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an invalid constructor flavor.
     */
    public void testInvalidConstructorFlavor() {
        Exception thrown = null;

        try {
            new Drink("Latte", "Medium", "Strawberry");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an invalid drink name.
     */
    public void testInvalidName() {
        Exception thrown = null;

        try {
            new Drink("", "Medium", "Vanilla");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests creating an independent copy.
     */
    public void testCopy() {
        Drink copy = drink.copy();

        assertNotNull(copy);
        assertNotSame(drink, copy);

        assertEquals(drink.getName(), copy.getName());
        assertEquals(drink.getSize(), copy.getSize());
        assertEquals(drink.getFlavor(), copy.getFlavor());

        copy.setSize("Large");
        copy.setFlavor("Caramel");

        assertEquals("Medium", drink.getSize());
        assertEquals("Vanilla", drink.getFlavor());

        assertEquals("Large", copy.getSize());
        assertEquals("Caramel", copy.getFlavor());
    }

    /**
     * Tests the string representation.
     */
    public void testToString() {
        assertEquals("Medium Vanilla Latte", drink.toString());
    }

    /**
     * Tests the string representation after customization.
     */
    public void testToStringAfterChange() {
        drink.setSize("Large");
        drink.setFlavor("Caramel");

        assertEquals("Large Caramel Latte", drink.toString());
    }
}
