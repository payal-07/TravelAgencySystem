package com.travelagencysystem.assessment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageTest {

    /**
     * Tests the addDestination and removeDestination methods in the TravelPackage class.
     * Verifies that a destination can be added to and removed from the travel package.
     */
    @Test
    public void testAddAndRemoveDestination() {
        TravelPackage travelPackage = new TravelPackage("Package 1", 20);
        Destination destination = new Destination("City 1");

        // Test adding a destination to the travel package
        travelPackage.addDestination(destination);
        assertTrue(travelPackage.getDestinations().contains(destination));

        // Test removing a destination from the travel package
        travelPackage.removeDestination(destination);
        assertFalse(travelPackage.getDestinations().contains(destination));
    }
}