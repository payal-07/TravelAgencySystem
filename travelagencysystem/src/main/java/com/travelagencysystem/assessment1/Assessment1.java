package com.travelagencysystem.assessment1;

/**
 * The main class for demonstrating the travel agency system.
 */
public class Assessment1 {

    public static void main(String[] args) {
        // Creating instances for demonstration
    
        // Create destinations and activities
        Destination city1 = new Destination("City 1");
        Activity activity1 = new Activity("City Tour", "Historical Places", 50.0, 10, city1);
        city1.addActivity(activity1);

        Destination city2 = new Destination("City 2");
        Activity activity2 = new Activity("Beach Day", "Sun and Sand", 30.0, 8, city2);
        city2.addActivity(activity2);
        
        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Package 1", 20);
        travelPackage.addDestination(city1);
        travelPackage.addDestination(city2);

        // Create passengers
        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.GOLD, 200.0);

        // Sign up passengers for activities
        travelPackage.signUpForActivity(passenger1, "City 1", "City Tour");
        travelPackage.signUpForActivity(passenger2, "City 2", "Beach Day");

        // Print details
        travelPackage.printItinerary();
        travelPackage.printPassengerList();

        }
}
