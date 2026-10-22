
package test;

import main.RewardsAccount;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the RewardsAccount class.
 *
 * @author Sebastian Pacheco
 * @version October 2026
 */
public class TestRewardsAccount
{
    private RewardsAccount account;

    /**
     * Sets up a new rewards account before each test.
     */
    @Before
    public void setUp()
    {
        account = new RewardsAccount();
    }

    /**
     * Tests the initial account values.
     */
    @Test
    public void testConstructor()
    {
        assertEquals(0, account.getPoints());
        assertEquals(0, account.getLifetimePoints());
        assertEquals(0, account.getOrdersFulfilled());
        assertEquals("Bronze!", account.getRewardLevel());
        assertFalse(account.canRedeem());
    }

    /**
     * Tests adding points from a valid order.
     */
    @Test
    public void testAddOrderPoints()
    {
        account.addOrderPoints(2);

        assertEquals(25, account.getPoints());
        assertEquals(25, account.getLifetimePoints());
        assertEquals(1, account.getOrdersFulfilled());

        account.addOrderPoints(3);

        assertEquals(60, account.getPoints());
        assertEquals(60, account.getLifetimePoints());
        assertEquals(2, account.getOrdersFulfilled());
    }

    /**
     * Tests adding points with zero or negative items.
     */
    @Test
    public void testInvalidOrderPoints()
    {
        account.addOrderPoints(0);
        account.addOrderPoints(-2);

        assertEquals(0, account.getPoints());
        assertEquals(0, account.getLifetimePoints());
        assertEquals(0, account.getOrdersFulfilled());
    }

    /**
     * Tests the Bronze reward level.
     */
    @Test
    public void testBronzeLevel()
    {
        assertEquals("Bronze!", account.getRewardLevel());

        account.addOrderPoints(6);

        assertEquals(65, account.getLifetimePoints());
        assertEquals("Bronze!", account.getRewardLevel());
    }

    /**
     * Tests the Silver reward level.
     */
    @Test
    public void testSilverLevel()
    {
        account.addOrderPoints(7);

        assertEquals(75, account.getLifetimePoints());
        assertEquals("Silver!", account.getRewardLevel());
    }

    /**
     * Tests the Gold reward level.
     */
    @Test
    public void testGoldLevel()
    {
        account.addOrderPoints(14);

        assertEquals(145, account.getLifetimePoints());
        assertEquals("Silver!", account.getRewardLevel());

        account.addOrderPoints(1);

        assertEquals(160, account.getLifetimePoints());
        assertEquals("Gold!", account.getRewardLevel());
    }

    /**
     * Tests redemption eligibility below and above 50 points.
     */
    @Test
    public void testCanRedeem()
    {
        assertFalse(account.canRedeem());

        account.addOrderPoints(4);
        assertFalse(account.canRedeem());

        account.addOrderPoints(1);
        assertTrue(account.canRedeem());
    }

    /**
     * Tests redeeming a reward successfully.
     */
    @Test
    public void testRedeemReward()
    {
        account.addOrderPoints(5);

        assertTrue(account.canRedeem());
        assertTrue(account.redeemReward());

        assertEquals(5, account.getPoints());
        assertEquals(55, account.getLifetimePoints());
        assertEquals(1, account.getOrdersFulfilled());
        assertFalse(account.canRedeem());
    }

    /**
     * Tests attempting to redeem without enough points.
     */
    @Test
    public void testRedeemRewardInsufficientPoints()
    {
        account.addOrderPoints(2);

        assertFalse(account.redeemReward());
        assertEquals(25, account.getPoints());
        assertEquals(25, account.getLifetimePoints());
    }

    /**
     * Tests redeeming multiple rewards.
     */
    @Test
    public void testMultipleRedemptions()
    {
        account.addOrderPoints(10);

        assertEquals(105, account.getPoints());

        assertTrue(account.redeemReward());
        assertTrue(account.redeemReward());
        assertFalse(account.redeemReward());

        assertEquals(5, account.getPoints());
        assertEquals(105, account.getLifetimePoints());
        assertEquals(1, account.getOrdersFulfilled());
        assertEquals("Silver!", account.getRewardLevel());
    }
}
