package test;

import main.*;

// -------------------------------------------------------------------------
/**
 * Tests the Order class. These tests check that items can be added, removed,
 * searched for, cleared, etc. and confirmed that they correctly exist. They
 * also check boundaries such as an empty order or invalid removal.
 * 
 * @author madisonnitti
 * @version Oct 16, 2026
 */
public class TestOrder
    extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests that a newly created Order starts empty. Expected result: new order
     * should contain 0.
     */
    public void testNewOrder()
    {
        Order order = new Order();

        assertEquals(0, order.getSize());
    }


    // ----------------------------------------------------------
    /**
     * Tests adding an item to order. Expected result: size should increase to 1
     * and added item stored at index 0.
     */
    public void testAddItem()
    {
        Order order = new Order();

        Drink drink = new Drink("Latte", "Medium", "Caramel");
        order.addItem(drink);

        assertEquals(1, order.getSize());
        assertEquals(drink, order.getItem(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests adding two different menu items objects. Expected: order should
     * contain both items and preserve the order in which they were added.
     */
    public void testAddTwoItems()
    {
        Order order = new Order();

        Drink drink = new Drink("Latte", "Medium", "Caramel");
        FoodItem food = new FoodItem("Muffin", "Bakery");

        order.addItem(drink);
        order.addItem(food);

        assertEquals(2, order.getSize());
        assertEquals(drink, order.getItem(0));
        assertEquals(food, order.getItem(1));
    }


    // ----------------------------------------------------------
    /**
     * Tests removing an existing item from an order. Expected result:
     * removeitem should return true, and size should decrease and remaining
     * item should still be in the order.
     */
    public void testRemoveItem()
    {
        Order order = new Order();

        Drink drink = new Drink("Latte", "Medium", "Caramel");
        FoodItem food = new FoodItem("Muffin", "Bakery");

        order.addItem(drink);
        order.addItem(food);

        assertTrue(order.removeItem(0));
        assertEquals(1, order.getSize());
        assertEquals(food, order.getItem(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests removing an item from an invalid index Expected: method should
     * return false and order should remain empty
     */
    public void testRemoveInvalidIndex()
    {
        Order order = new Order();

        assertFalse(order.removeItem(0));
        assertEquals(0, order.getSize());
    }


    // ----------------------------------------------------------
    /**
     * tests searching the order for an item by name. Expected: serching for an
     * existing name should return true, and an item not present should return
     * false.
     */
    public void testGetItem()
    {
        Order order = new Order();

        Drink drink = new Drink("Coffee", "Medium", "Caramel");
        order.addItem(drink);

        assertEquals(drink, order.getItem(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests getsize method before and after adding an item New order should
     * have size 0, after one item should have size 1
     */
    public void testContainsName()
    {
        Order order = new Order();
        order.addItem(new Drink("Latte", "Medium", "Caramel"));

        assertTrue(order.containsName("Latte"));
        assertFalse(order.containsName("Tea"));
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetSize()
    {
        Order order = new Order();
        assertEquals(0, order.getSize());

        order.addItem(new FoodItem("Bagel", "Bakery"));
        assertEquals(1, order.getSize());

    }


    // ----------------------------------------------------------
    /**
     * Tests clearing an order that contains items.
     */
    public void testClearOrder()
    {
        Order order = new Order();

        order.addItem(new Drink("Coffee", "Medium", "Caramel"));
        order.addItem(new FoodItem("Muffin", "Bakery"));

        order.clearOrder();

        assertEquals(0, order.getSize());
    }


    // ----------------------------------------------------------
    /**
     * tests clearing an already empty order.
     */
    public void testClearEmpty()
    {
        Order order = new Order();

        order.clearOrder();

        assertEquals(0, order.getSize());
    }


    // ----------------------------------------------------------
    /**
     * Tests whether an order is allowed to be confirmed.. Empty order should
     * not be confirmable, and order contaning at least one should be.
     */
    public void testConfirm()
    {
        Order order = new Order();

        assertFalse(order.canConfirm());

        order.addItem(new Drink("Latte", "Medium", "Caramel"));

        assertTrue(order.canConfirm());
    }

}
