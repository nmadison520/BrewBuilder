package main;
import java.util.Scanner;

/**
 * Console user interface for BrewBuilder.
 * Displays menu choices, reads user input,
 * and adds the selected item to an order.
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
     * Runs the customer ordering workflow.
     * Displays choices, reads the customer's
     * selection, and adds the item to the order.
     */
    public void run()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to BrewBuilder!");
        System.out.println("1 - Coffee");
        System.out.println("2 - Latte");
        System.out.println("3 - Muffin");
        System.out.println("4 - Bagel");

        System.out.println("Enter your choice:");

        int choice = input.nextInt();

        if (choice == 1)
        {
            Drink drink =
                new Drink("Coffee", "Medium", "None");

            currentOrder.addItem(drink);
        }
        else if (choice == 2)
        {
            Drink drink =
                new Drink("Latte", "Medium", "Vanilla");

            currentOrder.addItem(drink);
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
}