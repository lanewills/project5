package prj5;
import student.TestCase;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

        longListA = new DoublyLinkedList<String>();

            for (int i = 0; i < 100; i++) {
                longListA.add("item" + i);
            }
            longListB = new DoublyLinkedList<String>();
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

    /**
     * Tests the hasNext() method of the iterator implementation.
     */
    public void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
    }


    /**
     * Tests the hasNext() method on an empty list
     */
    public void testIterator2() {
        Iterator<String> iter = list.iterator();
        assertFalse(iter.hasNext());
    }


    /**
     * Tests the hasNext() method on a list with one entry
     */
    public void testIterator3() {
        list.add("A");
        Iterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
    }


    /**
     * Tests the next() method
     */

    public void testIterator4() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iterator = list.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
    }


    /**
     * Tests the next method when the list is empty
     */

    public void testIterator5() {
        Iterator<String> iter = list.iterator();
        Exception thrown = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }


    /**
     * Tests the remove() method of the iterator implementation
     */

    public void testIterator6() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iter = list.iterator();
        iter.next();
        iter.remove();
        assertEquals("(B, C, D, E, F)", list.toString());
        assertEquals(5, list.getSize());
        Exception thrown = null;
        try {
            iter.remove();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        iter.next();
        iter.remove();
        assertEquals("(C, D, E, F)", list.toString());
        assertEquals(4, list.getSize());
    }


    /**
     * Tests the remove() method when next() has not been previously
     * called
     */
    public void testIterator7() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        Iterator<String> iter = list.iterator();
        Exception thrown = null;
        try {
            iter.remove();
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
    }

    
    /**
     * Testing the insertionSortByAlpha, insertionSortByCFR, and comparators
     */
    public void testSorting() {
        Race white1 = new Race("a", 10, 5);
        Race white2 = new Race("b", 50, 10);
        Race white3 = new Race("c", -1, -1);
        Race black1 = new Race("d", 20, 10);
        Race black2 = new Race("e", 50, 9);
        Race black3 = new Race("f", 26, 3);
        DoublyLinkedList<Race> races = new DoublyLinkedList<Race>();
        races.insertionSortByAlpha();
        races.insertionSortByCFR();
        races.add(white1);
        races.add(white2);
        races.add(white3);
        races.add(black1);
        races.add(black2);
        races.add(black3);
        races.insertionSortByAlpha();
        races.insertionSortByCFR();
        emptyListA.insertionSortByAlpha();
        emptyListA.insertionSortByAlpha();
        assertEquals(0, emptyListA.getSize());
        white1 = new Race("a", 10, 5);
        white2 = new Race("b", 10, 5);
        white3 = new Race("c", 10, 5);
        black1 = new Race("d", 10, 5);
        black2 = new Race("e", 10, 5);
        black3 = new Race("f", 10, 5);
        races.add(white1);
        races.add(white2);
        races.add(white3);
        races.add(black1);
        races.add(black2);
        races.add(black3);
        races.insertionSortByAlpha();
        races.insertionSortByCFR();
    }
    
    /**
     * tests the clear method
     */
    public void testClear()
    {
        list.add("test");
        list.add("another test");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
        
    }
    
    /**
     * tests the toArray method
     */
    public void testToArray() {
        shortListA.toArray();
        shortListA.clear();
        assertEquals(0, shortListA.getSize());
    }
    
    /**
     * tests the toString method
     */
    public void testToString()
    {
        list.add("test");
        list.add("test1");
        assertEquals(list.toString(), "(test, test1)");
    }

}
