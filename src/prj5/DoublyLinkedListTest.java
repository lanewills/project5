package prj5;
import student.TestCase;
/**
 * Tests for the DoublyLinkedList class
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 */
public class DoublyLinkedListTest extends TestCase {
    
    private DoublyLinkedList<String> list;
    private DoublyLinkedList<String> emptyListA;
    private DoublyLinkedList<String> emptyListB;
    private DoublyLinkedList<String> shortListA;
    private DoublyLinkedList<String> shortListB;
    private DoublyLinkedList<String> longListA;
    private DoublyLinkedList<String> longListB;
    private String objectNull;

    /**
     * sets up all test methods with initial conditions
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
        emptyListA = new DoublyLinkedList<String>();
        emptyListB = new DoublyLinkedList<String>();
        shortListA = new DoublyLinkedList<String>();
        shortListB = new DoublyLinkedList<String>();

        shortListA.add("item1");
        shortListA.add("item2");
        shortListA.add("item3");

        shortListB.add("item1");
        shortListB.add("item2");
        shortListB.add("item3");

        longListA = new DoublyLinkedList<String>()

            for (int i = 0; i < 100; i++)

            {
                longListA.add("item" + i)
            }

                longListB = new DoublyLinkedList<String();
                for (int i = 0; i < 100; i++){
                    longListB.add("item" + i);
                }
            objectNull = null;
        }
    
    /**
     * tests the getSize method
     */
    public void testGetSize()
    {
        assertEquals(list.getSize(), 0);
        list.add("test");
        assertEquals(list.getSize(), 1);
    }
    
    /**
     * tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
    }
    
    /**
     * tests the contains method
     */
    public void testContains()
    {
        assertFalse(list.contains("test"));
        list.add("test");
        assertTrue(list.contains("test"));
    }
}
