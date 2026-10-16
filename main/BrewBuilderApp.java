package main;

import java.util.Scanner;

/**
 * Console user interface for BrewBuilder.
 * Allows a customer to choose food or a drink
 * and customize a drink's size and flavor.
 *
 * @author Madison
 * @version October 2026
 */
public class BrewBuilderApp
{
    private Order currentOrder;
    private Menu menu;


    /**
     * Creates a new BrewBuilder application.
     * Initializes the menu and an empty order.
     */
    public BrewBuilderApp()
    {
        menu = new Menu();
        currentOrder = new Order();
    }


    /**
     * Starts the BrewBuilder application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        BrewBuilderApp app = new BrewBuilderApp();
        app.run();
    }


    /**
     * Runs the customer ordering process.
     * The customer chooses a menu item.
     * Drinks can be customized by size and flavor.
     */
    public void run()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to BrewBuilder!");
        System.out.println();
        System.out.println("Choose an item:");
        System.out.println("1 - Coffee");
        System.out.println("2 - Latte");
        System.out.println("3 - Muffin");
        System.out.println("4 - Bagel");

        System.out.println("Enter your choice:");

        int choice = input.nextInt();


        if (choice == 1)
        {
            String size = chooseSize(input);
            String flavor = chooseFlavor(input);

            if (!size.equals("") && !flavor.equals(""))
            {
                Drink drink =
                    new Drink("Coffee", size, flavor);

                currentOrder.addItem(drink);
            }
        }
        else if (choice == 2)
        {
            String size = chooseSize(input);
            String flavor = chooseFlavor(input);

            if (!size.equals("") && !flavor.equals(""))
            {
                Drink drink =
                    new Drink("Latte", size, flavor);

                currentOrder.addItem(drink);
            }
        }
        else if (choice == 3)
        {
            FoodItem food =
                new FoodItem("Muffin", "Bakery");

            currentOrder.addItem(food);
        }
        else if (choice == 4)
        {
            FoodItem food =
                new FoodItem("Bagel", "Bakery");

            currentOrder.addItem(food);
        }
        else
        {
            System.out.println("Invalid choice.");
        }


        System.out.println();
        System.out.println("Your order:");
        System.out.println(currentOrder.reviewOrder());

        input.close();
    }


    /**
     * Allows the customer to choose a drink size.
     *
     * @param input Scanner used for user input
     * @return selected size or an empty String
     *         if the choice is invalid
     */
    public String chooseSize(Scanner input)
    {
        System.out.println();
        System.out.println("Choose a size:");
        System.out.println("1 - Small");
        System.out.println("2 - Medium");
        System.out.println("3 - Large");

        int sizeChoice = input.nextInt();

        if (sizeChoice == 1)
        {
            return "Small";
        }
        else if (sizeChoice == 2)
        {
            return "Medium";
        }
        else if (sizeChoice == 3)
        {
            return "Large";
        }
        else
        {
            System.out.println("Invalid size.");
            return "";
        }
    }


    /**
     * Allows the customer to choose a drink flavor.
     *
     * @param input Scanner used for user input
     * @return selected flavor or an empty String
     *         if the choice is invalid
     */
    public String chooseFlavor(Scanner input)
    {
        System.out.println();
        System.out.println("Choose a flavor:");
        System.out.println("1 - None");
        System.out.println("2 - Vanilla");
        System.out.println("3 - Caramel");
        System.out.println("4 - Hazelnut");
        System.out.println("5 - Pumpkin");

        int flavorChoice = input.nextInt();

        if (flavorChoice == 1)
        {
            return "None";
        }
        else if (flavorChoice == 2)
        {
            return "Vanilla";
        }
        else if (flavorChoice == 3)
        {
            return "Caramel";
        }
        else if (flavorChoice == 4)
        {
            return "Hazelnut";
        }
        else if (flavorChoice == 5)
        {
            return "Pumpkin";
        }
        else
        {
            System.out.println("Invalid flavor.");
            return "";
        }
    }
}