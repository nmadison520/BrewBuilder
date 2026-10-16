package main;

/**
 * Represents a customer's rewards account.
 * Customers earn points when they complete orders
 * and can redeem a reward after earning enough points.
 *
 * @author Madison
 * @version October 2026
 */
public class RewardsAccount
{
    private int points;


    /**
     * Creates a new rewards account
     * with zero reward points.
     */
    public RewardsAccount()
    {
        points = 0;
    }


    /**
     * Returns the customer's current
     * number of reward points.
     *
     * @return the number of reward points
     */
    public int getPoints()
    {
        return points;
    }


    /**
     * Adds ten points to the customer's
     * rewards account after an order.
     */
    public void addOrderPoints()
    {
        points = points + 10;
    }


    /**
     * Checks whether the customer has
     * enough points to redeem a reward.
     *
     * @return true if the customer has
     *         at least 50 points
     */
    public boolean canRedeem()
    {
        return points >= 50;
    }


    /**
     * Redeems a reward if the customer
     * has at least 50 points.
     *
     * @return true if the reward was redeemed,
     *         false if there were not enough points
     */
    public boolean redeemReward()
    {
        if (canRedeem())
        {
            points = points - 50;
            return true;
        }

        return false;
    }
}