package eventmanagemnetsystemgui;
public class Participant{
    private int participantID;
    private String participantName;
    private boolean isRegistered;
    public Participant(int participantID, String participantName){
        this.participantID = participantID;
        this.participantName = participantName;
        this.isRegistered = false; 
    }

    public int getParticipantID(){
        return participantID;
    }

    public String getParticipantName(){
        return participantName;
    }

    public boolean isRegistered(){
        return isRegistered;
    }

    public void setRegistered(boolean registered){
        isRegistered = registered;
    }

    @Override
    public String toString(){
        return "Participant ID: " + participantID + ", Name: " + participantName + ", Registered: " + isRegistered;
    }
}
