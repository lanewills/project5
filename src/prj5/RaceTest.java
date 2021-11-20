package prj5;
import student.TestCase;
/**
 * Test methods for the Race class.
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
public class RaceTest extends TestCase {
    
    private Race race1;
    private Race race2;
    
    /**
     * Sets up all test cases.
     */
    public void setUp()
    {
        race1 = new Race("test1", 234, 10);
        race2 = new Race("test2", 234, 34);
    }
    
    /**
     * tests getting the ethnicity name
     */
    public void testGetEthnicity()
    {
        assertEquals("test1", race1.getEthnicity());
        assertEquals("test2", race2.getEthnicity());
    }
    
    /**
     * Tests getting the covid cases count
     */
    public void testGetCovidCases()
    {
        assertEquals(234, race1.getCovidCases());
        assertEquals(234, race2.getCovidCases());
    }
    
    /**
     * Tests getting the covid death count
     */
    public void testGetCovidDeaths()
    {
        assertEquals(10, race1.getCovidDeaths());
        assertEquals(34, race2.getCovidDeaths());
    }
    
    /**
     * tests getting the CFR
     */
    public void testGetCFR()
    {
        assertEquals(4.3, race1.getCFR(), .0);
        assertEquals(14.5, race2.getCFR(), .0);
    }
    
    /**
     * tests the toString method.
     */
    public void testToString()
    {
        assertEquals("test1: 234 cases, 4.3% CFR", race1.toString());
        assertEquals("test2: 234 cases, 14.5% CFR", race2.toString());
    }
    
    /**
     * tests the compareAlpha method
     */
    public void testCompareAlpha()
    {
        assertEquals(Race.compareAlpha(race1, race2), -1);
        assertEquals(Race.compareAlpha(race2, race1), 1);
        assertEquals(Race.compareAlpha(race1, race1), 0);
    }
    
    /**
     * tests the compareCFR method
     */
    public void testCompareCFR()
    {
        assertEquals(Race.compareCFR(race1, race2), -1);
        assertEquals(Race.compareCFR(race2, race1), 1);
        assertEquals(Race.compareCFR(race1, race1), 0);
    }
    
    /**
     * tests the compareTo method
     */
    public void compareTo()
    {
        assertEquals(race1.compareTo(race1), 0);
        assertEquals(race1.compareTo(race2), -1);
        assertEquals(race2.compareTo(race1), 1);
    }
}
