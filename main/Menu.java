package main;

/**
 * Holds the fixed menu
 */
public class Menu
{
    private MenuItem[] items;
    
    
    /**
     * Creates a new Menu object.
     */
    public Menu()
    {
        items = new MenuItem[6];
        items[0] = new Drink("Latte", "Medium", "None");
        items[1] = new Drink("Cold Brew", "Medium", "None");
        items[2] = new Drink("Cappuccino", "Medium", "None");
        items[3] = new Drink("Iced Coffee", "Medium", "None");
        items[4] = new FoodItem("Blueberry Muffin", "Bakery");
        items[5] = new FoodItem("Croissant", "Bakery");
    }


    /**
     * Finds a menu item by name.
     * 
     * @param name
     *            item name to find
     * @return a matching menuItem
     */
    public MenuItem findItem(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            return null;
        }

        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getName().equalsIgnoreCase(name.trim()))
            {
                return items[i].copy();
            }
        }

        return null;
    }


    /**
     * Place a description of your method here.
     * 
     * @return a array of all the available menu items
     */

    // I added this because I figured it could help once we need to display the
    // menu in the console
    public MenuItem[] getItems()
    {
        MenuItem[] copies = new MenuItem[items.length];

        for (int i = 0; i < items.length; i++)
        {
            copies[i] = items[i].copy();
        }

        return copies;
    }

}
