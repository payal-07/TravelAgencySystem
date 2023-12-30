package com.travelagencysystem.assessment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package with destinations and passengers.
 */
public class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Destination> destinations;
    private final List<Passenger> passengers;

    /**
     * Constructs a travel package with the given name and passenger capacity.
     *
     * @param name             The name of the travel package.
     * @param passengerCapacity The maximum number of passengers the package can accommodate.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds a destination to the travel package.
     *
     * @param destination The destination to be added.
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Removes a destination from the travel package.
     *
     * @param destination The destination to be removed.
     */
    public void removeDestination(Destination destination) {
        destinations.remove(destination);
    }

    /**
     * Finds a destination in the travel package based on its name.
     *
     * @param destinationName The name of the destination to find.
     * @return The found destination or null if not found.
     */
    public Destination findDestination(String destinationName) {
        for (Destination destination : destinations) {
            if (destination.getName().equals(destinationName)) {
                return destination;
            }
        }
        return null;
    }

    /**
     * Signs up a passenger for a specific activity in a destination.
     *
     * @param passenger       The passenger to sign up.
     * @param destinationName The name of the destination.
     * @param activityName    The name of the activity.
     */
    public void signUpForActivity(Passenger passenger, String destinationName, String activityName) {
        Destination destination = findDestination(destinationName);
        if (destination != null) {
            Activity activity = destination.getActivity(activityName);
            if (activity != null) {
                if (passenger.getSignedUpActivities().contains(activity)) {
                    System.out.println("Passenger " + passenger.getName() + " is already signed up for activity " + activity.getName());
                } else {
                    activity.signUpPassenger(passenger);
                    System.out.println("Passenger " + passenger.getName() + " signed up for activity " + activity.getName());
                    passengers.add(passenger);  // Add the passenger to the list
                }
            } else {
                System.out.println("Activity " + activityName + " not found at destination " + destinationName);
            }
        } else {
            System.out.println("Destination " + destinationName + " not found in the travel package");
        }
    }

    /**
     * Gets the list of destinations in the travel package.
     *
     * @return The list of destinations.
     */
    public List<Destination> getDestinations() {
        return destinations;
    }

    /**
     * Gets the list of passengers in the travel package.
     *
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Gets the name of the travel package.
     *
     * @return The name of the travel package.
     */
    public String getName() {
        return name;
    }

    /**
     * Prints the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");
        for (Destination destination : destinations) {
            destination.printDetails();
        }
    }

    /**
     * Prints the passenger list of the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger List:");
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            passenger.printDetails();
        }
    }
}