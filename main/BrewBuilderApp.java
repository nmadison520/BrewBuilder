package main;

import java.util.Scanner;

/**
 * Console user interface for BrewBuilder.
 * Allows the customer to select food or drinks
 * and customize drink size and flavor.
 *
 * @author Madison
 * @version October 2026
 */
public class BrewBuilderApp
{
    private Order currentOrder;
    private Menu menu;
    private RewardsAccount rewards;


    /**
     * Creates a new BrewBuilder application.
     * Initializes the menu and an empty order.
     */
    public BrewBuilderApp()
    {
        menu = new Menu();
        currentOrder = new Order();
        rewards= new RewardsAccount();
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
     * Allows the customer to select an item
     * and customize drinks by size and flavor.
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
            System.out.println();
            System.out.println("Choose a size:");
            System.out.println("1 - Small");
            System.out.println("2 - Medium");
            System.out.println("3 - Large");

            int sizeChoice = input.nextInt();

            String size = "";

            if (sizeChoice == 1)
            {
                size = "Small";
            }
            else if (sizeChoice == 2)
            {
                size = "Medium";
            }
            else if (sizeChoice == 3)
            {
                size = "Large";
            }
            else
            {
                System.out.println("Invalid size.");
            }


            System.out.println();
            System.out.println("Choose a flavor:");
            System.out.println("1 - None");
            System.out.println("2 - Vanilla");
            System.out.println("3 - Caramel");
            System.out.println("4 - Hazelnut");
            System.out.println("5 - Pumpkin");

            int flavorChoice = input.nextInt();

            String flavor = "";

            if (flavorChoice == 1)
            {
                flavor = "None";
            }
            else if (flavorChoice == 2)
            {
                flavor = "Vanilla";
            }
            else if (flavorChoice == 3)
            {
                flavor = "Caramel";
            }
            else if (flavorChoice == 4)
            {
                flavor = "Hazelnut";
            }
            else if (flavorChoice == 5)
            {
                flavor = "Pumpkin";
            }
            else
            {
                System.out.println("Invalid flavor.");
            }


            if (!size.equals("") && !flavor.equals(""))
            {
                Drink drink =
                    new Drink("Coffee", size, flavor);

                currentOrder.addItem(drink);
            }
        }


        else if (choice == 2)
        {
            System.out.println();
            System.out.println("Choose a size:");
            System.out.println("1 - Small");
            System.out.println("2 - Medium");
            System.out.println("3 - Large");

            int sizeChoice = input.nextInt();

            String size = "";

            if (sizeChoice == 1)
            {
                size = "Small";
            }
            else if (sizeChoice == 2)
            {
                size = "Medium";
            }
            else if (sizeChoice == 3)
            {
                size = "Large";
            }
            else
            {
                System.out.println("Invalid size.");
            }


            System.out.println();
            System.out.println("Choose a flavor:");
            System.out.println("1 - None");
            System.out.println("2 - Vanilla");
            System.out.println("3 - Caramel");
            System.out.println("4 - Hazelnut");
            System.out.println("5 - Pumpkin");

            int flavorChoice = input.nextInt();

            String flavor = "";

            if (flavorChoice == 1)
            {
                flavor = "None";
            }
            else if (flavorChoice == 2)
            {
                flavor = "Vanilla";
            }
            else if (flavorChoice == 3)
            {
                flavor = "Caramel";
            }
            else if (flavorChoice == 4)
            {
                flavor = "Hazelnut";
            }
            else if (flavorChoice == 5)
            {
                flavor = "Pumpkin";
            }
            else
            {
                System.out.println("Invalid flavor.");
            }


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
        
        System.out.println();
        System.out.println("Your order:");
        System.out.println(currentOrder.reviewOrder());

        if (currentOrder.canConfirm())
        {
            rewards.addOrderPoints();

            System.out.println();
            System.out.println("Order completed!");
            System.out.println("You earned 10 reward points.");
            System.out.println(
                "Current reward points: " + rewards.getPoints());

            if (rewards.canRedeem())
            {
                System.out.println(
                    "You have enough points to redeem a reward!");
            }
        }

        input.close();
    }
}