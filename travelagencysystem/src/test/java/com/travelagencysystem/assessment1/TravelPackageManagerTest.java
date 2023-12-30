package com.travelagencysystem.assessment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageManagerTest {

    /**
     * Tests the addPackage and removePackage methods in the TravelPackageManager class.
     * Verifies that a travel package can be added to and removed from the travel package manager.
     */
    @Test
    public void testAddAndRemovePackage() {
        TravelPackageManager travelPackageManager = new TravelPackageManager();
        TravelPackage travelPackage = new TravelPackage("Package 1", 20);

        // Test adding a travel package to the manager
        travelPackageManager.addPackage(travelPackage);
        assertTrue(travelPackageManager.getPackages().contains(travelPackage));

        // Test removing a travel package from the manager
        travelPackageManager.removePackage(travelPackage);
        assertFalse(travelPackageManager.getPackages().contains(travelPackage));
    }
}
