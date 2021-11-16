package prj5;
import java.io.FileNotFoundException;

/**
 * This class determines the specific file to read from and creates
 * a Graphic User Interface window
 * @author
 * @author
 * @author
 */
public class Input {
    /**
     * This main method takes a file name for input and if it is not specified, it reads a default file
     * @param args the file to be read
     * @throws FileNotFoundException if file is not found
     */
    public static void main(String[]args) throws FileNotFoundException{
        if (args.length == 1){
            new DataReader(args[0]);
        }

        else{
            new CovidFileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
