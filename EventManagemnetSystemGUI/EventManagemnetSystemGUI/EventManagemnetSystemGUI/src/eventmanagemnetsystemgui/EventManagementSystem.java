package eventmanagemnetsystemgui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EventManagementSystem {
    private RedBlackTree eventTree;
    private List<Event> events;

    public EventManagementSystem() {
        eventTree = new RedBlackTree();
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        eventTree.insert(event);
        events.add(event);
    }

    public Event searchEvent(int eventID) {
        return eventTree.search(eventID);
    }

    public void removeEvent(int eventID) {
        Event event = searchEvent(eventID);
        if (event != null) {
            event.setActive(false);  // Deactivate the event
            eventTree.remove(event); // Remove from Red-Black Tree
        }
    }

    public List<Event> getActiveEvents() {
        List<Event> activeEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.isActive()) {
                activeEvents.add(event);
            }
        }
        return activeEvents;
    }

    public void registerParticipant(Participant participant, Event event) {
        if (event != null && event.isActive()) {
            event.addParticipant(participant);
        } else {
            JOptionPane.showMessageDialog(null, "Event is inactive or doesn't exist.");
        }
    }

    public boolean removeParticipant(int participantID, Event event) {
        return event.removeParticipant(participantID);
    }

    public boolean isParticipantRegistered(int participantID, Event event) {
        return event.isParticipantRegistered(participantID);
    }

    public void displayAllEvents() {
        StringBuilder eventDetails = new StringBuilder("All Events:\n");
        for (Event event : events) {
            eventDetails.append(event.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, eventDetails.toString());
    }

    Participant searchParticipant(int participantID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
