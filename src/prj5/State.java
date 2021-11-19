package prj5;
/**
 * Class for a State which contains races and their data.
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
public class State {
    
    private String stateName;
    private DoublyLinkedList<Race> raceData;

    /**
     * Constructor for a state object
     * @param stateName name of the state
     * @param raceData DLL that contains all races for a state
     */
    public State(String stateName, DoublyLinkedList<Race> raceData){
        this.stateName = stateName;
        this.raceData = raceData;
    }
    
    /**
     * gets the name of the state
     * @return the state's name
     */
    public String getName() {
        return stateName;
    }

    /**
     * gets the DLL of races in a state
     * @return the race DLL
     */
    public DoublyLinkedList<Race> getRaceData(){
        return raceData;
    }
}
