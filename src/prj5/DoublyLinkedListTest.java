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
    
    /**
     * sets up all test methods
     */
    public void setUp()
    {
        list = new DoublyLinkedList<String>();
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
     * tests the isEmpty method.
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
    }
}
