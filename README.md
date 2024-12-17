Event Management System GUI

The Event Management System GUI is a Java-based application for managing events and participants using a Red-Black Tree data structure. This project is designed for efficient event storage, retrieval, and management while integrating a graphical user interface (GUI) for ease of use.


---

Features

Red-Black Tree Integration: Events are stored and retrieved using a Red-Black Tree for efficient data operations.

Participant Management: Register participants for events and manage their status.

Event Management:

Add, view, and remove events.

Mark events as active or inactive.


GUI: A user-friendly graphical interface for interacting with the system.

Data Structures:

Red-Black Tree: For event storage and search.

Linked List: For managing active events.

ArrayList: For participant tracking.




---

Class Descriptions

1. Event Class

Represents an event with the following attributes:

Event ID, Name, Date, Location, Type, and Active Status.

Participants can be registered to an event.


2. Participant Class

Represents a participant with attributes like:

Participant ID, Name, Registration Status, and Event Association.


3. RedBlackTree Class

Implements the Red-Black Tree data structure for:

Efficient insertion, deletion, and search operations.

Supports event storage and retrieval by Event ID.


4. EventManagementSystem Class

Handles the business logic of the application:

Adding and removing events.

Searching for events and participants.

Managing active events and participant registrations.


5. EventManagementSystemGUI Class

Implements the graphical user interface for the system:

Provides interactive forms and dialogs for managing events and participants.

Displays lists of events and participant details.


6. Main Class

The entry point of the application:

Initializes the system and launches the GUI.



---

Installation

Prerequisites

Java Development Kit (JDK) 8 or later.

NetBeans IDE (or any Java IDE of your choice).


Steps

1. Clone the repository:

git clone https://github.com/<your-username>/EventManagementSystemGUI.git


2. Open the project in NetBeans or your preferred IDE.


3. Build and run the project.




---

Usage

Add Events: Use the GUI to input event details and add them to the system.

Register Participants: Assign participants to specific events.

Manage Events: Search, view, and mark events as inactive.

Display Active Events: View all active events in the GUI.



---

Project Structure

EventManagementSystemGUI/  
├── src/  
│   ├── eventmanagemnetsystemgui/  
│   │   ├── Event.java  
│   │   ├── Participant.java  
│   │   ├── RedBlackTree.java  
│   │   ├── EventManagementSystem.java  
│   │   ├── EventManagementSystemGUI.java  
│   │   ├── Main.java  
│   └── README.md  
└── resources/  
    └── (icons, GUI assets, etc.)


---

Future Improvements

Persistent Storage: Add a database or file storage for saving event and participant data.

Advanced Search: Enhance search functionality to include filters like location or date.

Reports: Generate detailed reports of events and participants.

Theme Support: Add themes or color schemes to the GUI.



---

License

This project is licensed under the MIT License.
