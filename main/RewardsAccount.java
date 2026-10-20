package main;

/**
 * Represents a customer's rewards account. Customers earn points when they
 * complete orders and can redeem a reward after earning enough points.
 *
 * @author Madison
 * @version October 2026
 */
public class RewardsAccount
{
    private int points;
    private int lifetimePoints;
    private int ordersFulfilled;

    /**
     * Creates a new rewards account with zero reward points.
     */
    public RewardsAccount()
    {
        points = 0;
        lifetimePoints = 0;
        ordersFulfilled = 0;
    }


    /**
     * Returns the customer's current number of reward points.
     *
     * @return the number of reward points
     */
    public int getPoints()
    {
        return points;
    }


    // ----------------------------------------------------------
    /**
     * Returns all points that the customer has.
     * 
     * @return lifetime rewards
     */
    public int getLifetimePoints()
    {
        return lifetimePoints;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of orders that have been fulfilled.
     * 
     * @return number of orders that have been fulfilled
     */
    public int getOrdersFulfilled()
    {
        return ordersFulfilled;
    }


    /**
     * Adds ten points to the customer's rewards account after an order.
     * 
     * @param numberOfItems
     */
    public void addOrderPoints(int numberOfItems)
    {
        if (numberOfItems > 0)
        {
            int earnedPoints = numberOfItems * 10 + 5;

            points = points + earnedPoints;
            lifetimePoints = lifetimePoints + earnedPoints;
            ordersFulfilled = ordersFulfilled + 1;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the customer's reward system level.
     * 
     * @return Bronze, Silver, Gold level reward member
     */
    public String getRewardLevel()
    {
        if (lifetimePoints >= 150)
        {
            return "Gold!";
        }
        else if (lifetimePoints >= 75)
        {
            return "Silver!";
        }
        else
        {
            return "Bronze!";
        }
    }


    /**
     * Checks whether the customer has enough points to redeem a reward.
     *
     * @return true if the customer has at least 50 points
     */
    public boolean canRedeem()
    {
        return points >= 50;
    }


    /**
     * Redeems a reward if the customer has at least 50 points.
     *
     * @return true if the reward was redeemed, false if there were not enough
     *             points
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
