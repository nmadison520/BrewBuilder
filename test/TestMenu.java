
package test;

import main.Menu;
import main.MenuItem;
import main.Drink;
import main.FoodItem;
import student.TestCase;

/**
 * Tests the Menu class.
 */
public class TestMenu extends TestCase {

    private Menu menu;

    /**
     * Sets up a menu before each test.
     */
    public void setUp() {
        menu = new Menu();
    }

    /**
     * Tests finding a drink by name.
     */
    public void testFindDrink() {
        MenuItem item = menu.findItem("Latte");

        assertNotNull(item);
        assertTrue(item instanceof Drink);
        assertEquals("Latte", item.getName());
    }

    /**
     * Tests finding a food item by name.
     */
    public void testFindFood() {
        MenuItem item = menu.findItem("Croissant");

        assertNotNull(item);
        assertTrue(item instanceof FoodItem);
        assertEquals("Croissant", item.getName());
    }

    /**
     * Tests case-insensitive menu searching.
     */
    public void testFindItemCaseInsensitive() {
        MenuItem item = menu.findItem("LATTE");

        assertNotNull(item);
        assertEquals("Latte", item.getName());

        item = menu.findItem("croissant");

        assertNotNull(item);
        assertEquals("Croissant", item.getName());
    }

    /**
     * Tests ignoring surrounding whitespace when searching.
     */
    public void testFindItemWhitespace() {
        MenuItem item = menu.findItem("  Latte  ");

        assertNotNull(item);
        assertEquals("Latte", item.getName());
    }

    /**
     * Tests searching for an item that does not exist.
     */
    public void testFindMissingItem() {
        assertNull(menu.findItem("Pizza"));
    }

    /**
     * Tests searching with a null name.
     */
    public void testFindNullItem() {
        assertNull(menu.findItem(null));
    }

    /**
     * Tests searching with an empty or blank name.
     */
    public void testFindBlankItem() {
        assertNull(menu.findItem(""));
        assertNull(menu.findItem("   "));
    }

    /**
     * Tests retrieving the available menu items.
     */
    public void testGetItems() {
        MenuItem[] items = menu.getItems();

        assertNotNull(items);
        assertEquals(6, items.length);

        assertEquals("Latte", items[0].getName());
        assertEquals("Cold Brew", items[1].getName());
        assertEquals("Cappuccino", items[2].getName());
        assertEquals("Iced Coffee", items[3].getName());
        assertEquals("Blueberry Muffin", items[4].getName());
        assertEquals("Croissant", items[5].getName());
    }

    /**
     * Tests that findItem returns independent copies.
     */
    public void testFindItemIndependentCopies() {
        Drink first = (Drink)menu.findItem("Latte");
        Drink second = (Drink)menu.findItem("Latte");

        assertNotNull(first);
        assertNotNull(second);
        assertNotSame(first, second);

        first.setSize("Large");
        first.setFlavor("Caramel");

        assertEquals("Medium", second.getSize());
        assertEquals("None", second.getFlavor());

        Drink third = (Drink)menu.findItem("Latte");

        assertEquals("Medium", third.getSize());
        assertEquals("None", third.getFlavor());
    }

    /**
     * Tests that getItems returns independent copies.
     */
    public void testGetItemsIndependentCopies() {
        MenuItem[] first = menu.getItems();
        MenuItem[] second = menu.getItems();

        assertNotSame(first, second);
        assertNotSame(first[0], second[0]);

        Drink drink = (Drink)first[0];
        drink.setSize("Large");

        Drink original = (Drink)second[0];

        assertEquals("Medium", original.getSize());
    }

    /**
     * Tests that all default menu entries have valid names.
     */
    public void testDefaultMenuItems() {
        MenuItem[] items = menu.getItems();

        for (int i = 0; i < items.length; i++) {
            assertNotNull(items[i]);
            assertNotNull(items[i].getName());
            assertFalse(items[i].getName().trim().isEmpty());
        }
    }
}
