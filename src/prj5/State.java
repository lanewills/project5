package prj5;

public class State {
    private String stateName;
    private DoublyLinkedList<Race> raceData;

    public State(String stateName, DoublyLinkedList<Race> raceData){
        this.stateName = stateName;
        this.raceData = raceData;
    }

    public String getName() {
        return stateName;
    }

    public DoublyLinkedList<Race> getRaceData(){
        return raceData;
    }
}
