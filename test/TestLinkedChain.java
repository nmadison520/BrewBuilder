package test;

import main.LinkedChain;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author madisonnitti
 * @version Oct 23, 2026
 */
public class TestLinkedChain
    extends TestCase
{
    private LinkedChain<String> chain;

    /**
     * Create an empty chain before each test.
     */
    public void setUp()
    {
        chain = new LinkedChain<String>();
    }


    // ----------------------------------------------------------
    /**
     * tests the constructor method.
     */
    public void testConstructor()
    {
        assertTrue(chain.isEmpty());
        assertEquals(0, chain.size());
        assertEquals("[]", chain.toString());

    }


    /**
     * Tests adding an entry to the front.
     */
    public void testAdd()
    {
        assertTrue(chain.add("Coffee"));
        assertTrue(chain.add("Latte"));

        assertEquals(2, chain.size());
        assertEquals("Latte", chain.get(0));
        assertEquals("Coffee", chain.get(1));
    }


    /**
     * Tests adding entries to end of linked chain.
     */
    public void testAddToEnd()
    {
        assertTrue(chain.addToEnd("Coffee"));
        assertTrue(chain.addToEnd("Latte"));
        assertTrue(chain.addToEnd("Muffin"));

        assertEquals(3, chain.size());
        assertEquals("Coffee", chain.get(0));
        assertEquals("Latte", chain.get(1));
        assertEquals("Muffin", chain.get(2));

    }


    /**
     * tests adding to the front of an existing chain.
     */
    public void testAddToFront()
    {
        chain.addToEnd("Coffee");
        chain.add("Muffin");

        assertEquals("Muffin", chain.get(0));
        assertEquals("Coffee", chain.get(1));
    }


    /**
     * tests rejecting entries that are null.
     */
    public void testAddNull()
    {
        Exception thrown = null;
        try
        {
            chain.add(null);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;

        }
        assertNotNull(thrown);
        assertTrue(chain.isEmpty());
    }


    /**
     * Tests rejecting null entries at end.
     */
    public void testAddToEndNull()
    {
        Exception thrown = null;
        try
        {
            chain.addToEnd(null);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;

        }
        assertNotNull(thrown);
        assertTrue(chain.isEmpty());

    }


    /**
     * Tests removing from an empty chain
     */
    public void testRemoveEmpty()
    {
        assertNull(chain.remove());
        assertEquals(0, chain.size());
    }


    /**
     * Tests removing the first entry.
     */
    public void testRemoveFirst()
    {
        chain.addToEnd("Coffee");
        chain.addToEnd("Latte");

        assertEquals("Coffee", chain.remove());
        assertEquals(1, chain.size());
        assertEquals("Latte", chain.get(0));

    }


    /**
     * Tests removing a matching entry.
     */
    public void testRemoveEntry()
    {
        chain.addToEnd("Coffee");
        chain.addToEnd("Latte");
        chain.addToEnd("Muffin");

        assertTrue(chain.remove("Latte"));
        assertEquals(2, chain.size());
        assertFalse(chain.contains("Latte"));
        assertEquals("Muffin", chain.get(1));
    }


    /**
     * Tetss clearing an empty chain
     */
    public void testClearEmpty()
    {
        chain.clear();
        assertTrue(chain.isEmpty());

    }


    /**
     * Tests clearing a chain with items.
     */
    public void testClear()
    {
        chain.addToEnd("Coffee");
        chain.addToEnd("Muffin");

        chain.clear();

        assertTrue(chain.isEmpty());
        assertEquals(0, chain.size());
        assertEquals("[]", chain.toString());

    }


    /**
     * Tests rejecting negative indices.
     */
    public void testGetNegIndex()
    {
        Exception thrown = null;
        try
        {
            chain.get(-1);

        }
        catch (IndexOutOfBoundsException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);

    }


    /**
     * Tests rejecting an index equal to the size.
     */
    public void testGetInvalidIndex()
    {
        chain.addToEnd("Coffee");

        Exception thrown = null;
        try
        {
            chain.get(1);

        }
        catch (IndexOutOfBoundsException e)
        {
            thrown = e;

        }
        assertNotNull(thrown);
    }


    /**
     * Tests counting duplicate entries.
     */
    public void testCount()
    {
        chain.addToEnd("Coffee");
        chain.addToEnd("Latte");
        chain.addToEnd("Coffee");

        assertEquals(2, chain.count("Coffee"));
        assertEquals(1, chain.count("Latte"));
        assertEquals(0, chain.count("Muffin"));
        assertEquals(0, chain.count(null));
    }


    /**
     * Tests converting chain to an array.
     */
    public void testToArray()
    {
        chain.addToEnd("Coffee");
        chain.addToEnd("Latte");

        String[] result = chain.toArray(new String[2]);

        assertEquals("Coffee", result[0]);
        assertEquals("Latte", result[1]);

    }

}
