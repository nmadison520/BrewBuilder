import student.TestCase;
import main.MenuItem;
import main.FoodItem;

package test;

<<<<<<< Updated upstream
// -------------------------------------------------------------------------
/**
 * Tests the MenuItem class. Since MenuItem is abstract, FoodItem is used to
 * create MenuItem objects for testing.
 * 
 * @author madisonnitti
 * @version Oct 16, 2026
 */
public class TestMenuItem
    extends TestCase
{
    /**
     * Tests that getName returns the name given to the MenuItem.
     */
    public void testGetName()
    {
        MenuItem item = new FoodItem("Muffin");

        assertEquals("Muffin", item.getName());
    }


    /**
     * Tests that toString returns the name of the MenuItem.
     */
    public void testToString()
    {
        MenuItem item = new FoodItem("Bagel");

        assertEquals("Bagel", item.toString());
    }


    /**
     * Tests that a MenuItem cannot be created
     * with a null name.
     */
    public void testNullName()
    {
        try
        {
            new FoodItem(null);
            fail("An exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }


    /**
     * Tests that a MenuItem cannot be created with an empty name.
     */
    public void testEmptyName()
    {
        try
        {
            new FoodItem("");
            fail("An exception should have been thrown");
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }


    /**
     * Tests that copy creates another MenuItem with the same name.
     */
    public void testCopy()
    {
        MenuItem item = new FoodItem("Muffin");

        MenuItem copy = item.copy();

        assertEquals("Muffin", copy.getName());
    }
}

}

}
=======
import main.MenuItem;
import main.FoodItem;
import student.TestCase;

/**
 * Tests the MenuItem class using FoodItem as a subclass.
 */
public class TestMenuItem extends TestCase {

    private MenuItem item;

    /**
     * Sets up a menu item before each test.
     */
    public void setUp() {
        item = new FoodItem("Muffin", "Bakery");
    }

    /**
     * Tests getting the item name.
     */
    public void testGetName() {
        assertEquals("Muffin", item.getName());
    }

    /**
     * Tests the string representation.
     */
    public void testToString() {
        assertEquals("Muffin", item.toString());
    }

    /**
     * Tests creating an independent copy.
     */
    public void testCopy() {
        MenuItem copy = item.copy();

        assertNotNull(copy);
        assertNotSame(item, copy);
        assertEquals(item.getName(), copy.getName());
        assertTrue(copy instanceof FoodItem);
    }

    /**
     * Tests rejecting a null name.
     */
    public void testNullName() {
        Exception thrown = null;

        try {
            new FoodItem(null, "Bakery");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Tests rejecting an empty name.
     */
    public void testEmptyName() {
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

    /**
     * Tests rejecting a name containing only whitespace.
     */
    public void testBlankName() {
        Exception thrown = null;

        try {
            new FoodItem("   ", "Bakery");
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }
}
>>>>>>> Stashed changes
