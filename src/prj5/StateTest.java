package prj5;
import student.TestCase;
/**
 * Test methods for the State class.
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
public class StateTest extends TestCase {
    
    private State state1;
    private DoublyLinkedList<Race> raceList;
    
    /**
     * Sets up all test cases.
     */
    public void setUp()
    {
        raceList = new DoublyLinkedList<Race>();
        state1 = new State("VA", raceList);
    }
    
    /**
     * tests the getName method.
     */
    public void testGetName()
    {
        assertEquals(state1.getName(), "VA");
    }
    
    /**
     * tests the getRace method.
     */
    public void testGetRaceData()
    {
        assertEquals(state1.getRaceData(), raceList);
    }
}
