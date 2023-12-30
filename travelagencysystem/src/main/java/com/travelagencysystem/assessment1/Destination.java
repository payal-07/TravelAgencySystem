package com.travelagencysystem.assessment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination in a travel package with a list of activities.
 */
public class Destination {
    private final String name;
    private final List<Activity> activities;

    /**
     * Constructor to initialize a destination with a name.
     *
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Adds an activity to the destination's list of activities.
     *
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Removes an activity from the destination's list of activities.
     *
     * @param activity The activity to remove.
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * Retrieves an activity by name from the destination's list of activities.
     *
     * @param activityName The name of the activity to retrieve.
     * @return The activity with the specified name, or null if not found.
     */
    public Activity getActivity(String activityName) {
        for (Activity activity : activities) {
            if (activity.getName().equals(activityName)) {
                return activity;
            }
        }
        return null;
    }

    /**
     * Gets the name of the destination.
     *
     * @return The name of the destination.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of activities associated with the destination.
     *
     * @return The list of activities.
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Prints details of the destination, including its name and the details of each activity.
     */
    public void printDetails() {
        System.out.println("Destination: " + name);
        System.out.println("Activities:");
        for (Activity activity : activities) {
            activity.printDetails();
        }
    }
}
