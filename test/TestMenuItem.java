package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the MenuItem class.
 */
public class MenuItemTest {

    private MenuItem item;

    /**
     * Runs before each test.
     */
    @Before
    public void setUp() {
        item = new FoodItem("Muffin", "Bakery");
    }

    /**
     * Tests retrieving the item's name.
     */
    @Test
    public void testGetName() {
        assertEquals("Muffin", item.getName());
    }

    /**
     * Tests the string representation.
     */
    @Test
    public void testToString() {
        assertEquals("Muffin", item.toString());
    }

    /**
     * Tests creating an independent copy.
     */
    @Test
    public void testCopy() {
        MenuItem copy = item.copy();

        assertNotSame(item, copy);
        assertEquals(item.getName(), copy.getName());
    }

    /**
     * Tests rejecting a null name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new FoodItem(null, "Bakery");
    }

    /**
     * Tests rejecting a blank name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBlankName() {
        new FoodItem("   ", "Bakery");
    }
}
