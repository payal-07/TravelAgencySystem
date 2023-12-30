package com.travelagencysystem.assessment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    /**
     * Tests the signUpForActivity method in the Passenger class for a standard passenger.
     * Verifies that the passenger can sign up for an activity, and the balance is correctly deducted.
     */
    @Test
    public void testSignUpForActivity() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);

        // Test signing up a standard passenger for an activity
        passenger.signUpForActivity(activity);

        assertTrue(passenger.getSignedUpActivities().contains(activity));
        assertEquals(50.0, passenger.getBalance(), 0.01); // Check balance deduction for standard passenger
    }

    /**
     * Tests the signUpForActivity method in the Passenger class for a gold passenger.
     * Verifies that the gold passenger can sign up for an activity with a discount, and the balance is correctly deducted.
     */
    @Test
    public void testSignUpForActivityGoldPassenger() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);
        Passenger goldPassenger = new Passenger("Alice", 2, PassengerType.GOLD, 200.0);

        // Test signing up a gold passenger for an activity with a discount
        goldPassenger.signUpForActivity(activity);

        assertTrue(goldPassenger.getSignedUpActivities().contains(activity));
        assertEquals(195, goldPassenger.getBalance(), 0.01); // Check balance deduction for gold passenger (with 10% discount)
    }

    /**
     * Tests the signUpForActivity method in the Passenger class for a premium passenger.
     * Verifies that the premium passenger can sign up for an activity for free.
     */
    @Test
    public void testSignUpForActivityPremiumPassenger() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);
        Passenger premiumPassenger = new Passenger("Bob", 3, PassengerType.PREMIUM, 0.0);

        // Test signing up a premium passenger for an activity (activity should be free)
        premiumPassenger.signUpForActivity(activity);

        assertTrue(premiumPassenger.getSignedUpActivities().contains(activity));
        assertEquals(0.0, premiumPassenger.getBalance(), 0.01); // Check balance deduction for premium passenger (activity should be free)
    }
}
