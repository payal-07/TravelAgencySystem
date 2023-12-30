package com.travelagencysystem.assessment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    /**
     * Tests the signUpPassenger method for a standard passenger.
     * Verifies that the passenger is correctly added to the signed-up passengers list
     * and their balance is deducted accordingly.
     */
    @Test
    public void testSignUpPassenger() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);

        activity.signUpPassenger(passenger);

        assertTrue(activity.getSignedUpPassengers().contains(passenger));
        assertEquals(50.0, passenger.getBalance(), 0.01); // Check balance deduction for standard passenger
    }

    /**
     * Tests the signUpPassenger method for a premium passenger.
     * Verifies that the premium passenger is correctly added to the signed-up passengers list
     * and their balance remains unaffected as premium passengers sign up for free.
     */
    @Test
    public void testSignUpPassengerPremium() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);
        Passenger premiumPassenger = new Passenger("Bob", 3, PassengerType.PREMIUM, 0.0);

        activity.signUpPassenger(premiumPassenger);

        assertTrue(activity.getSignedUpPassengers().contains(premiumPassenger));
        assertEquals(0.0, premiumPassenger.getBalance(), 0.01); // Premium passengers sign up for free
    }

}
