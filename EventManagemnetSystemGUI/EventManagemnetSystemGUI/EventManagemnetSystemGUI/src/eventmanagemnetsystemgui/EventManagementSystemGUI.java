package eventmanagemnetsystemgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EventManagementSystemGUI extends JFrame {
    private EventManagementSystem system;
    private JTextArea textArea;

    public EventManagementSystemGUI() {
        system = new EventManagementSystem();
        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);

        setTitle("Event Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        JButton addEventButton = new JButton("Add Event");
        JButton searchEventButton = new JButton("Search Event");
        JButton displayAllEventsButton = new JButton("Display All Events");
        JButton removeEventButton = new JButton("Remove Event");
        JButton registerParticipantButton = new JButton("Register Participant");
        JButton removeParticipantButton = new JButton("Remove Participant");
        JButton viewParticipantsButton = new JButton("View Participants");
        JButton searchParticipantButton = new JButton("Search Participant");

        panel.add(addEventButton);
        panel.add(searchEventButton);
        panel.add(displayAllEventsButton);
        panel.add(removeEventButton);
        panel.add(registerParticipantButton);
        panel.add(removeParticipantButton);
        panel.add(viewParticipantsButton);
        panel.add(searchParticipantButton);

        add(panel, BorderLayout.WEST);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Action Listeners for the buttons
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });

        searchEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEvent();
            }
        });

        displayAllEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllEvents();
            }
        });

        removeEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeEvent();
            }
        });

        registerParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerParticipant();
            }
        });

        removeParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeParticipant();
            }
        });

        viewParticipantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewParticipants();
            }
        });

        searchParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchParticipant();
            }
        });
    }

    private void addEvent() {
        // Collect event details from the user
        String eventName = JOptionPane.showInputDialog("Enter Event Name:");
        String eventLocation = JOptionPane.showInputDialog("Enter Event Location:");
        String eventDate = JOptionPane.showInputDialog("Enter Event Date (YYYY-MM-DD):");
        String eventType = JOptionPane.showInputDialog("Enter Event Type:");

        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID:"));

        Event event = new Event(eventID, eventName, eventLocation, eventDate, eventType);
        system.addEvent(event);

        JOptionPane.showMessageDialog(this, "Event added successfully.");
    }

    private void searchEvent() {
        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID to Search:"));
        Event event = system.searchEvent(eventID);
        if (event != null) {
            textArea.setText(event.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Event not found.");
        }
    }

    private void displayAllEvents() {
        List<Event> activeEvents = system.getActiveEvents();
        StringBuilder eventDetails = new StringBuilder("Active Events:\n");

        if (activeEvents.isEmpty()) {
            eventDetails.append("No active events found.");
        } else {
            for (Event event : activeEvents) {
                eventDetails.append(event.toString()).append("\n");
            }
        }

        textArea.setText(eventDetails.toString());
    }

    private void removeEvent() {
        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID to Remove:"));
        system.removeEvent(eventID);
        JOptionPane.showMessageDialog(this, "Event removed successfully.");
    }

    private void registerParticipant() {
        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID to Register Participant:"));
        Event event = system.searchEvent(eventID);

        if (event != null) {
            int participantID = Integer.parseInt(JOptionPane.showInputDialog("Enter Participant ID:"));
            String participantName = JOptionPane.showInputDialog("Enter Participant Name:");

            Participant participant = new Participant(participantID, participantName);
            system.registerParticipant(participant, event);

            JOptionPane.showMessageDialog(this, "Participant registered successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Event not found.");
        }
    }

    private void removeParticipant() {
        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID to Remove Participant:"));
        Event event = system.searchEvent(eventID);

        if (event != null) {
            int participantID = Integer.parseInt(JOptionPane.showInputDialog("Enter Participant ID to Remove:"));
            boolean removed = system.removeParticipant(participantID, event);

            if (removed) {
                JOptionPane.showMessageDialog(this, "Participant removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Participant not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Event not found.");
        }
    }

    private void viewParticipants() {
        int eventID = Integer.parseInt(JOptionPane.showInputDialog("Enter Event ID to View Participants:"));
        Event event = system.searchEvent(eventID);

        if (event != null) {
            StringBuilder participantDetails = new StringBuilder("Participants for Event ID " + eventID + ":\n");

            if (event.getParticipants().isEmpty()) {
                participantDetails.append("No participants registered.");
            } else {
                for (Participant participant : event.getParticipants()) {
                    participantDetails.append(participant.toString()).append("\n");
                }
            }

            textArea.setText(participantDetails.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Event not found.");
        }
    }

    private void searchParticipant() {
        int participantID = Integer.parseInt(JOptionPane.showInputDialog("Enter Participant ID to Search:"));
        Participant participant = system.searchParticipant(participantID);

        if (participant != null) {
            textArea.setText(participant.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Participant not found.");
        }
    }

    public static void main(String[] args) {
        EventManagementSystemGUI gui = new EventManagementSystemGUI();
        gui.setVisible(true);
    }
}
