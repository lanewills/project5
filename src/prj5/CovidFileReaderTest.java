/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tests for the CovidFileReader class
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 */
public class CovidFileReaderTest extends TestCase{
    
    private CovidFileReader reader;
    
    /**
     * tests the covid file reader
     * @throws FileNotFoundException 
     */
    public void testCovidFileReader() throws FileNotFoundException
    {
        reader = new CovidFileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }
}
