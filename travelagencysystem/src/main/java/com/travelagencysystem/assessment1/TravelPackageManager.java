package com.travelagencysystem.assessment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of travel packages.
 */
public class TravelPackageManager {
    private final List<TravelPackage> travelPackages;

    /**
     * Constructs a travel package manager with an empty list of travel packages.
     */
    public TravelPackageManager() {
        this.travelPackages = new ArrayList<>();
    }

    /**
     * Adds a travel package to the manager.
     *
     * @param travelPackage The travel package to be added.
     */
    public void addPackage(TravelPackage travelPackage) {
        travelPackages.add(travelPackage);
    }

    /**
     * Removes a travel package from the manager.
     *
     * @param travelPackage The travel package to be removed.
     */
    public void removePackage(TravelPackage travelPackage) {
        travelPackages.remove(travelPackage);
    }

    /**
     * Gets a travel package based on its name.
     *
     * @param packageName The name of the travel package to find.
     * @return The found travel package or null if not found.
     */
    public TravelPackage getPackage(String packageName) {
        for (TravelPackage travelPackage : travelPackages) {
            if (travelPackage.getName().equals(packageName)) {
                return travelPackage;
            }
        }
        return null;
    }

    /**
     * Gets the list of travel packages managed by the manager.
     *
     * @return The list of travel packages.
     */
    public List<TravelPackage> getPackages() {
        return travelPackages;
    }

    /**
     * Prints the itinerary of all travel packages managed by the manager.
     */
    public void printItinerary() {
        System.out.println("All Travel Packages Itinerary:");
        for (TravelPackage travelPackage : travelPackages) {
            travelPackage.printItinerary();
        }
    }

    /**
     * Prints the passenger list of all travel packages managed by the manager.
     */
    public void printPassengerList() {
        System.out.println("All Travel Packages Passenger Lists:");
        for (TravelPackage travelPackage : travelPackages) {
            travelPackage.printPassengerList();
        }
    }
}
