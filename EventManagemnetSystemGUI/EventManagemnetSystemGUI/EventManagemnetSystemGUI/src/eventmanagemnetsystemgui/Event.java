package eventmanagemnetsystemgui;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int eventID;
    private String eventName;
    private String eventLocation;
    private String eventType;
    private String eventDate;
    private boolean isActive;
    private List<Participant> participants;

    public Event(int eventID, String eventName, String eventLocation, String eventDate, String eventType) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.isActive = true;
        this.participants = new ArrayList<>();
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void addParticipant(Participant participant) {
        if (participant != null) {
            participants.add(participant);
        }
    }

    public boolean removeParticipant(int participantId) {
        return participants.removeIf(participant -> participant.getParticipantID() == participantId);
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }

    public boolean isParticipantRegistered(int participantId) {
        return participants.stream().anyMatch(p -> p.getParticipantID() == participantId);
    }

    @Override
    public String toString() {
        return "Event ID: " + eventID + ", Name: " + eventName + ", Location: " + eventLocation +
                ", Type: " + eventType + ", Date: " + eventDate + ", Active: " + isActive;
    }
}
