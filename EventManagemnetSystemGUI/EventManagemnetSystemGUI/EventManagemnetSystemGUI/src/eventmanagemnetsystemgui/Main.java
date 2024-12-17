package eventmanagemnetsystemgui;
public class Main{
    public static void main(String[] args){
        EventManagementSystem system = new EventManagementSystem();

        // Add Events
        system.addEvent(new Event(1, "Tech Conference", "2024-12-15", "NYC", "Conference"));
        system.addEvent(new Event(2, "Music Concert", "2024-12-20", "LA", "Concert"));
        
        // Display All Events
        System.out.println("Displaying All Events:");
        system.displayAllEvents();

        // Search for an Event
        Event event = system.searchEvent(1);
        if(event != null){
            System.out.println("\nFound Event: " + event);
        }
    }
}
