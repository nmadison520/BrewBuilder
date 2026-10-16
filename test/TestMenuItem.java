import student.TestCase;
import main.MenuItem;
import main.FoodItem;

package test;
// -------------------------------------------------------------------------
/**
 * Tests the MenuItem class.
 * Since MenuItem is abstract, FoodItem is used
 * to create MenuItem objects for testing.
 * 
 *  @author madisonnitti
 *  @version Oct 16, 2026
 */
public class TestMenuItem extends TestCase
{
    /**
     * Tests that getName returns the name
     * given to the MenuItem.
     */
    public void testGetName()
    {
        MenuItem item = new FoodItem("Muffin");

        assertEquals("Muffin", item.getName());
    }

    /**
     * Tests that toString returns the name
     * of the MenuItem.
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
    }




    

}