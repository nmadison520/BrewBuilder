package main;

import java.util.Scanner;

/**
 * Console user interface for BrewBuilder. Allows the customer to select food or
 * drinks and customize drink size and flavor.
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
     * Creates a new BrewBuilder application. Initializes the menu and an empty
     * order.
     */
    public BrewBuilderApp()
    {
        menu = new Menu();
        currentOrder = new Order();
        rewards = new RewardsAccount();
    }


    /**
     * Starts the BrewBuilder application.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args)
    {
        BrewBuilderApp app = new BrewBuilderApp();
        app.run();
    }


    /**
     * Runs the customer ordering process. Allows the customer to select an item
     * and customize drinks by size and flavor.
     */
    public void run()
    {
        Scanner input = new Scanner(System.in);

        boolean keepRunning = true;

        System.out.println("Welcome to BrewBuilder!");

        while (keepRunning)
        {
            currentOrder = new Order();

            boolean buildingOrder = true;

            System.out.println();
            System.out.println("Starting a new order! ");

            while (buildingOrder)
            {

                System.out.println();
                System.out.println("Choose an item:");
                System.out.println("1 - Coffee");
                System.out.println("2 - Latte");
                System.out.println("3 - Muffin");
                System.out.println("4 - Bagel");
                System.out.println("5 - Finish Order");

                System.out.println("Enter your choice:");

                int choice = input.nextInt();

                if (choice == 1 || choice == 2)
                {
                    String drinkName;

                    if (choice == 1)
                    {
                        drinkName = "Coffee";
                    }
                    else
                    {
                        drinkName = "Latte";
                    }

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
                        Drink drink = new Drink(drinkName, size, flavor);

                        currentOrder.addItem(drink);

                        System.out.println();
                        System.out.println(drinkName + " added to order.");
                    }
                }

                else if (choice == 3)
                {
                    FoodItem food = new FoodItem("Muffin", "Bakery");

                    currentOrder.addItem(food);

                    System.out.println("Muffin added to order.");
                }
                else if (choice == 4)
                {
                    FoodItem food = new FoodItem("Bagel", "Bakery");

                    currentOrder.addItem(food);
                    System.out.println("Bagel added to order.");
                }
                else if (choice == 5)
                {
                    if (currentOrder.canConfirm())
                    {
                        buildingOrder = false;
                    }
                    else
                    {
                        System.out.println("You cannot finish an empty order.");
                    }
                }
                else
                {
                    System.out.println("Invalid choice.");
                }
                if (buildingOrder)
                {
                    System.out.println();
                    System.out.println("Current Order:");
                    System.out.println(currentOrder.reviewOrder());
                }

                System.out.println();
                System.out.println("Final Order:");
                System.out.println(currentOrder.reviewOrder());

                rewards.addOrderPoints(currentOrder.getSize());
                System.out.println();
                System.out.println("Order Completed!");
                System.out.println("Reward Points: " + rewards.getPoints());
                System.out.println("Reward Level: " + rewards.getRewardLevel());
                System.out.println(
                    "Orders Completed: " + rewards.getOrdersFulfilled());

                if (rewards.canRedeem())
                {
                    System.out.println();
                    System.out
                        .println("You have enough points to redeem a reward!");

                }

                System.out.println();
                System.out.println("Would you like to start a new order?");
                System.out.println("1- Yes");
                System.out.println("2- No");

                int again = input.nextInt();

                if (again == 1)
                {
                    keepRunning = true;
                }

                else
                {
                    keepRunning = false;
                }
            }
            System.out.println();
            System.out.println("Thanks for using BrewBuilder!");
            System.out.println("Final reward points: " + rewards.getPoints());
            input.close();
        }
    }
}
