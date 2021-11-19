package prj5;
/**
 * 
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
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
