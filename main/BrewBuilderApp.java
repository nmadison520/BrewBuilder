package main;
import java.util.Scanner;

/**
 * Console user interface for BrewBuilder
 */
public class BrewBuilderApp {
    private Order currentOrder;
    private Menu menu;

    // ----------------------------------------------------------
    /**
     * Create a new BrewBuilderApp object.
     */
    public BrewBuilderApp() {
        // initialize menu and order
    }

    /**
     * Starts the customer interaction workflow
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // handle user input/output
        BrewBuilderApp app = new BrewBuilderApp();
        app.run();
    }

    /**
     * Runs the basic customer ordering workflow.
     * The customer chooses one menu item and
     * the selected item is added to the order.
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
        
        if(choice==1)
        {
            currentOrder.addItem(
                new Drink("Coffee", "Medium"));
        }
        else if (choice == 2)
        {
            currentOrder.addItem(
                new Drink("Latte", "Medium"));
        }
        else if(choice==3)
        {
            currentOrder.addItem(
                new FoodItem("Muffin"));
        }
        else if (choice==4)
        {
            currentOrder.addItem(
                new FoodItem("Bagel"));
        }
        else
        {
            System.out.println("Invalid choice.");
        }

        System.out.println("Your order:");
        System.out.println(currentOrder.reviewOrder());

        input.close();
        
        
        }
}
    