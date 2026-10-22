
package test;

import main.BrewBuilderApp;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Tests the BrewBuilderApp class.
 *
 * @author Sebastian Pacheco
 * @version October 2026
 */
public class TestBrewBuilderApp
{
    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    /**
     * Sets up input and output streams.
     */
    @Before
    public void setUp()
    {
        originalIn = System.in;
        originalOut = System.out;
        output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));
    }

    /**
     * Restores the original streams.
     */
    @After
    public void tearDown()
    {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    /**
     * Runs the application with simulated input.
     *
     * @param input simulated user input
     * @return console output
     */
    private String runApp(String input)
    {
        System.setIn(new ByteArrayInputStream(
            input.getBytes(StandardCharsets.UTF_8)));

        BrewBuilderApp app = new BrewBuilderApp();
        app.run();

        return output.toString();
    }

    /**
     * Tests the welcome message.
     */
    @Test
    public void testWelcomeMessage()
    {
        String result = runApp("3\n3\n5\n2\n");

        assertTrue(result.contains("Welcome to BrewBuilder!"));
    }

    /**
     * Tests adding a coffee.
     */
    @Test
    public void testAddCoffee()
    {
        String result = runApp("1\n1\n1\n3\n5\n2\n");

        assertTrue(result.contains("Coffee added to order."));
    }

    /**
     * Tests adding a latte.
     */
    @Test
    public void testAddLatte()
    {
        String result = runApp("2\n2\n2\n3\n5\n2\n");

        assertTrue(result.contains("Latte added to order."));
    }

    /**
     * Tests adding a muffin.
     */
    @Test
    public void testAddMuffin()
    {
        String result = runApp("3\n3\n5\n2\n");

        assertTrue(result.contains("Muffin added to order."));
    }

    /**
     * Tests adding a bagel.
     */
    @Test
    public void testAddBagel()
    {
        String result = runApp("4\n3\n5\n2\n");

        assertTrue(result.contains("Bagel added to order."));
    }

    /**
     * Tests all three drink sizes.
     */
    @Test
    public void testDrinkSizes()
    {
        String small = runApp("1\n1\n1\n3\n5\n2\n");
        assertTrue(small.contains("Coffee added to order."));

        output.reset();

        String medium = runApp("1\n2\n1\n3\n5\n2\n");
        assertTrue(medium.contains("Coffee added to order."));

        output.reset();

        String large = runApp("1\n3\n1\n3\n5\n2\n");
        assertTrue(large.contains("Coffee added to order."));
    }

    /**
     * Tests all five drink flavors.
     */
    @Test
    public void testDrinkFlavors()
    {
        for (int i = 1; i <= 5; i++)
        {
            output.reset();

            String result = runApp(
                "1\n1\n" + i + "\n3\n5\n2\n");

            assertTrue(result.contains("Coffee added to order."));
        }
    }

    /**
     * Tests an invalid menu choice.
     */
    @Test
    public void testInvalidMenuChoice()
    {
        String result = runApp("9\n3\n3\n5\n2\n");

        assertTrue(result.contains("Invalid choice."));
    }


    /**
     * Tests an invalid drink size.
     */
    @Test
    public void testInvalidSize()
    {
        String result = runApp(
            "1\n9\n1\n3\n3\n5\n2\n");

        assertTrue(result.contains("Invalid size."));
    }


    /**
     * Tests an invalid drink flavor.
     */
    @Test
    public void testInvalidFlavor()
    {
        String result = runApp(
            "1\n1\n9\n3\n3\n5\n2\n");

        assertTrue(result.contains("Invalid flavor."));
    }

    /**
     * Tests adding an ingredient.
     */
    @Test
    public void testAddIngredient()
    {
        String result = runApp(
            "3\n1\nChocolate\n3\n5\n2\n");

        assertTrue(result.contains("Chocolate added."));
    }

    /**
     * Tests removing an ingredient.
     */
    @Test
    public void testRemoveIngredient()
    {
        String result = runApp(
            "3\n1\nChocolate\n2\n1\n3\n5\n2\n");

        assertTrue(result.contains("Ingredient removed."));
    }

    /**
     * Tests removing when no ingredients exist.
     */
    @Test
    public void testRemoveFromEmptyIngredients()
    {
        String result = runApp("3\n2\n3\n5\n2\n");

        assertTrue(result.contains(
            "There are no ingredients to remove."));
    }

    /**
     * Tests an invalid ingredient number.
     */
    @Test
    public void testInvalidIngredientNumber()
    {
        String result = runApp(
            "3\n1\nChocolate\n2\n99\n3\n5\n2\n");

        assertTrue(result.contains(
            "Invalid ingredient number."));
    }

    /**
     * Tests an invalid customization choice.
     */
    @Test
    public void testInvalidCustomizationChoice()
    {
        String result = runApp("3\n9\n3\n5\n2\n");

        assertTrue(result.contains("Invalid choice."));
    }

    /**
     * Tests attempting to finish an empty order.
     */
    @Test
    public void testFinishEmptyOrder()
    {
        String result = runApp("5\n3\n3\n5\n2\n");

        assertTrue(result.contains(
            "You cannot finish an empty order."));
    }

    /**
     * Tests reward points after one item.
     */
    @Test
    public void testRewardsOutput()
    {
        String result = runApp("3\n3\n5\n2\n");

        assertTrue(result.contains("Reward Points: 15"));
        assertTrue(result.contains("Reward Level: Bronze!"));
        assertTrue(result.contains("Orders Completed: 1"));
    }

    /**
     * Tests starting another order.
     */
    @Test
    public void testMultipleOrders()
    {
        String result = runApp(
            "3\n3\n5\n1\n4\n3\n5\n2\n");

        assertTrue(result.contains("Muffin added to order."));
        assertTrue(result.contains("Bagel added to order."));
        assertTrue(result.contains("Orders Completed: 2"));
        assertTrue(result.contains("Final reward points: 30"));
    }

    /**
     * Tests earning enough points to redeem a reward.
     */
    @Test
    public void testRewardEligibility()
    {
        String result = runApp(
            "3\n3\n" +
            "3\n3\n" +
            "3\n3\n" +
            "3\n3\n" +
            "3\n3\n" +
            "5\n2\n");

        assertTrue(result.contains(
            "You have enough points to redeem a reward!"));

        assertTrue(result.contains("Reward Points: 55"));
    }

    /**
     * Tests the final goodbye message.
     */
    @Test
    public void testGoodbyeMessage()
    {
        String result = runApp("3\n3\n5\n2\n");

        assertTrue(result.contains(
            "Thanks for using BrewBuilder!"));
    }

    /**
     * Tests the application's main method.
     */
    @Test
    public void testMain()
    {
        System.setIn(new ByteArrayInputStream(
            "3\n3\n5\n2\n".getBytes(StandardCharsets.UTF_8)));

        BrewBuilderApp.main(new String[0]);

        assertTrue(output.toString().contains(
            "Welcome to BrewBuilder!"));
    }
}
