package com.travelagencysystem.assessment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {

    /**
     * Tests the addActivity and removeActivity methods in the Destination class.
     * Verifies that an activity can be successfully added to and removed from the destination's activities list.
     */
    @Test
    public void testAddAndRemoveActivity() {
        Destination destination = new Destination("City 1");
        Activity activity = new Activity("City Tour", "Historical Places", 50.0, 10, destination);

        // Test adding an activity to the destination
        destination.addActivity(activity);
        assertTrue(destination.getActivities().contains(activity));

        // Test removing an activity from the destination
        destination.removeActivity(activity);
        assertFalse(destination.getActivities().contains(activity));
    }

}