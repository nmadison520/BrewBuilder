
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Drink;

/**
 * Tests the Drink class.
 */
public class TestDrink {

    private Drink drink;

    /**
     * Runs before each test.
     */
    @Before
    public void setUp() {
        drink = new Drink("Latte", "Medium", "Vanilla");
    }

    /**
     * Tests the constructor and getters.
     */
    @Test
    public void testConstructor() {
        assertEquals("Latte", drink.getName());
        assertEquals("Medium", drink.getSize());
        assertEquals("Vanilla", drink.getFlavor());
    }

    /**
     * Tests changing the drink size.
     */
    @Test
    public void testSetSize() {
        drink.setSize("Large");
        assertEquals("Large", drink.getSize());

        drink.setSize("Small");
        assertEquals("Small", drink.getSize());
    }

    /**
     * Tests case-insensitive size validation.
     */
    @Test
    public void testSizeCaseInsensitive() {
        drink.setSize("small");
        assertEquals("small", drink.getSize());

        drink.setSize("LARGE");
        assertEquals("LARGE", drink.getSize());
    }

    /**
     * Tests rejecting an unsupported size.
     */
    @Test
    public void testInvalidSize() {
        try {
            drink.setSize("XXL");
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Medium", drink.getSize());
        }
    }

    /**
     * Tests rejecting a null size.
     */
    @Test
    public void testNullSize() {
        try {
            drink.setSize(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Medium", drink.getSize());
        }
    }

    /**
     * Tests rejecting an empty size.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptySize() {
        drink.setSize("");
    }

    /**
     * Tests changing the drink flavor.
     */
    @Test
    public void testSetFlavor() {
        drink.setFlavor("Caramel");
        assertEquals("Caramel", drink.getFlavor());

        drink.setFlavor("Hazelnut");
        assertEquals("Hazelnut", drink.getFlavor());
    }

    /**
     * Tests case-insensitive flavor validation.
     */
    @Test
    public void testFlavorCaseInsensitive() {
        drink.setFlavor("pumpkin");
        assertEquals("pumpkin", drink.getFlavor());

        drink.setFlavor("VANILLA");
        assertEquals("VANILLA", drink.getFlavor());
    }

    /**
     * Tests rejecting an unsupported flavor.
     */
    @Test
    public void testInvalidFlavor() {
        try {
            drink.setFlavor("Strawberry");
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Vanilla", drink.getFlavor());
        }
    }

    /**
     * Tests rejecting a null flavor.
     */
    @Test
    public void testNullFlavor() {
        try {
            drink.setFlavor(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Vanilla", drink.getFlavor());
        }
    }

    /**
     * Tests rejecting an empty flavor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFlavor() {
        drink.setFlavor("");
    }

    /**
     * Tests rejecting an invalid size in the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorSize() {
        new Drink("Latte", "XXL", "Vanilla");
    }

    /**
     * Tests rejecting an invalid flavor in the constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorFlavor() {
        new Drink("Latte", "Medium", "Strawberry");
    }

    /**
     * Tests rejecting a blank drink name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidName() {
        new Drink("", "Medium", "Vanilla");
    }

    /**
     * Tests creating an independent copy.
     */
    @Test
    public void testCopy() {
        Drink copy = drink.copy();

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
     * Tests the string representation of a drink.
     */
    @Test
    public void testToString() {
        assertEquals(
            "Medium Vanilla Latte",
            drink.toString()
        );
    }

    /**
     * Tests the string representation after customization.
     */
    @Test
    public void testToStringAfterChange() {
        drink.setSize("Large");
        drink.setFlavor("Caramel");

        assertEquals(
            "Large Caramel Latte",
            drink.toString()
        );
    }
}
