package main;

/**
 * Represents one customer order. Stores MenuItem objects using a LinkedChain.
 *
 * @author Madisonnitti
 * @version October 2026
 */
public class Order
{
    private LinkedChain<MenuItem> items;

    /**
     * Creates a new empty order.
     */
    public Order()
    {
        items = new LinkedChain<MenuItem>();
    }


    /**
     * Adds an item to the end of the order
     * 
     * @param item
     *            item to add
     */
    public void addItem(MenuItem item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("Item cannot be null");
        }

        items.addToEnd(item);
    }


    /**
     * Removes the item at the index
     * 
     * @param index
     *            position to remove
     * @return true if removed, false if it fails
     */
    public boolean removeItem(int index)
    {
        if (index < 0 || index >= items.size())
        {
            return false;
        }
        LinkedChain<MenuItem> newItems = new LinkedChain<MenuItem>();

        for (int i = 0; i < items.size(); i++)
        {
            if (i != index)
            {
                newItems.addToEnd(items.get(i));
            }
        }

        items = newItems;

        return true;
    }


    /**
     * Gets an item at the index
     * 
     * @param index
     *            position to retrieve
     * @return item at index
     */
    public MenuItem getItem(int index)
    {
        return items.get(index);
    }


    /**
     * Checks whether an item with the given name
     * 
     * @param name
     *            name to search for
     * @return true if found
     */
    public boolean containsName(String name)
    {
        for (int i = 0; i < items.size(); i++)
        {
            MenuItem item = items.get(i);

            if (item.getName().equals(name))
            {
                return true;
            }
        }

    }


    /**
     * Replaces the item at the index
     * 
     * @param index
     *            position to update
     * @param item
     *            replacement item
     */
    public void updateItem(int index, MenuItem item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (index < 0 || index >= items.size())
        {
            return;
        }
        LinkedChain<MenuItem> newItems = new LinkedChain<MenuItem>();

        for (int i = 0; i < items.size(); i++)
        {
            if (i == index)
            {
                newItems.addToEnd(item);
            }
            else
            {
                newItems.addToEnd(items.get(i));
            }
        }

        items = newItems;
    }


    /**
     * @return number of items in the order
     */
    public int getSize()
    {
        return items.size();
        ;
    }


    /** Removes all items from the order. */
    public void clearOrder()
    {
        return items.clear();
    }


    /** @return true only if the order is nonempty */
    public boolean canConfirm()
    {
        return !items.isEmpty();
    }


    /** @return readable order summary in insertion order */
    public String reviewOrder()
    {
        return items.toString();
        ;
    }
}
