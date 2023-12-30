package com.travelagencysystem.assessment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger in the travel agency system.
 */
public class Passenger {
    private final String name;
    private final int passengerNumber;
    private final PassengerType passengerType;
    private double balance;
    private final List<Activity> signedUpActivities;

    /**
     * Constructs a passenger with the specified details.
     *
     * @param name            The name of the passenger.
     * @param passengerNumber The unique identifier for the passenger.
     * @param passengerType   The type of the passenger (STANDARD, GOLD, PREMIUM).
     * @param balance         The balance of the passenger.
     */
    public Passenger(String name, int passengerNumber, PassengerType passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    /**
     * Signs up the passenger for a given activity.
     *
     * @param activity The activity to sign up for.
     */
    public void signUpForActivity(Activity activity) {
        if (passengerType == PassengerType.PREMIUM ||
                (passengerType == PassengerType.GOLD && balance >= 0.10 * activity.getCost()) ||
                (passengerType == PassengerType.STANDARD && balance >= activity.getCost())) {
            signedUpActivities.add(activity);
            double cost = calculateCostForActivity(activity);
            balance -= cost;
            if (balance < 0.0) {
                balance = 0.0; // Ensuring balance does not go below zero
            }
            System.out.println("Passenger " + name + " signed up for activity " + activity.getName() +
                    " at " + activity.getDestination().getName() + ". Cost: " + cost);
        } else {
            System.out.println("Passenger " + name + " does not have sufficient balance to sign up for activity " +
                    activity.getName());
        }
        System.out.println("Signed Up Activities for " + name + ": " + signedUpActivities);
    }

    /**
     * Calculates the cost of an activity for the passenger based on their type.
     *
     * @param activity The activity for which to calculate the cost.
     * @return The calculated cost.
     */
    public double calculateCostForActivity(Activity activity) {
        if (passengerType == PassengerType.GOLD) {
            return 0.10 * activity.getCost();
        } else {
            return activity.getCost();
        }
    }

    /**
     * Deducts the specified amount from the passenger's balance.
     *
     * @param amount The amount to deduct.
     */
    public void deductBalance(double amount) {
        if (amount > balance) {
            balance = 0.0;
        } else {
            balance -= amount;
        }
    }

    /**
     * Gets the list of activities that the passenger has signed up for.
     *
     * @return The list of signed-up activities.
     */
    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the balance of the passenger.
     *
     * @return The balance of the passenger.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the type of the passenger.
     *
     * @return The type of the passenger.
     */
    public PassengerType getType() {
        return passengerType;
    }

    /**
     * Prints the details of the passenger.
     */
    public void printDetails() {
        System.out.println("Passenger: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Passenger Type: " + passengerType);

        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            System.out.println("Balance: " + balance);
        }

        if (signedUpActivities.isEmpty()) {
            // No Activities Signed Up.
        } else {
            for (Activity activity : signedUpActivities) {
                String activityDetails = String.format("Activity: %-20s at %-20s. Cost: %.2f",
                        activity.getName(), activity.getDestination().getName(), calculateCostForActivity(activity));
                System.out.println(activityDetails);
            }
        }
    }
}