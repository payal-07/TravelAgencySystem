package com.travelagencysystem.assessment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an activity available at a destination in a travel package.
 */
public class Activity {
    
    // Attributes
    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private final Destination destination;
    private final List<Passenger> signedUpPassengers;

    /**
     * Constructor to initialize an Activity.
     *
     * @param name        The name of the activity.
     * @param description The description of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.signedUpPassengers = new ArrayList<>();
    }

    /**
     * Signs up a passenger for the activity if there is available capacity.
     *
     * @param passenger The passenger to sign up for the activity.
     */
    public void signUpPassenger(Passenger passenger) {
        if (signedUpPassengers.size() < capacity) {
            double discountedCost = calculateDiscountedCost(passenger);
            if (passenger.getBalance() >= discountedCost || passenger.getType() == PassengerType.PREMIUM) {
                signedUpPassengers.add(passenger);
                if (passenger.getType() != PassengerType.PREMIUM) {
                    passenger.deductBalance(discountedCost);
                }
            } else {
                System.out.println("Passenger " + passenger.getName() + " does not have sufficient balance to sign up for activity " + name);
            }
        } else {
            System.out.println("Activity " + name + " at " + destination.getName() + " is at full capacity.");
        }
    }

    /**
     * Calculates the discounted cost for a passenger based on their type.
     *
     * @param passenger The passenger for whom to calculate the discounted cost.
     * @return The discounted cost for the passenger.
     */
    private double calculateDiscountedCost(Passenger passenger) {
        if (passenger.getType() == PassengerType.GOLD) {
            return cost - (cost * 0.10); // 10% discount for gold passengers
        } else {
            return cost;
        }
    }

    /**
     * Checks the availability of the activity.
     *
     * @return True if there is still capacity for the activity, false otherwise.
     */
    public boolean checkAvailability() {
        return signedUpPassengers.size() < capacity;
    }

    /**
     * Gets the name of the activity.
     *
     * @return The name of the activity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity.
     *
     * @return The description of the activity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the cost of the activity.
     *
     * @return The cost of the activity.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the capacity of the activity.
     *
     * @return The capacity of the activity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the destination where the activity takes place.
     *
     * @return The destination of the activity.
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Gets the list of passengers signed up for the activity.
     *
     * @return The list of signed-up passengers.
     */
    public List<Passenger> getSignedUpPassengers() {
        return signedUpPassengers;
    }

    /**
     * Prints details of available activities at the destination.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities at " + destination.getName() + ":");
        boolean availableActivitiesExist = false;

        for (Activity activity : destination.getActivities()) {
            int remainingCapacity = activity.getCapacity() - activity.getSignedUpPassengers().size();
            if (remainingCapacity > 0) {
                availableActivitiesExist = true;
                String activityDetails = String.format("Activity: %-20s at %-20s. Cost: %.2f. Remaining Capacity: %d/%d",
                        activity.getName(), activity.getDestination().getName(), activity.getCost(),
                        remainingCapacity, activity.getCapacity());
                System.out.println(activityDetails);
            }
        }

        if (!availableActivitiesExist) {
            System.out.println("No available activities at " + destination.getName() + ".");
        }
    }

    /**
     * Prints details of the activity.
     */
    public void printDetails() {
        System.out.println("Activity: " + name);
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
        System.out.println("Capacity: " + capacity);
        System.out.println("Destination: " + destination.getName());
    }

}