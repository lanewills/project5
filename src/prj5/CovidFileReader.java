package prj5;

import java.util.Scanner;
import java.io.*;

/**
 * This CovidFileReader class reads the given data
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
public class CovidFileReader {
    private State[] states;

    /**
     * CovidFileReader constructor that reads the files and outputs the data
     * @param fileName would be the file to be read
     * @throws FileNotFoundException is thrown if there are no files
     */
    public CovidFileReader(String fileName) throws FileNotFoundException {
        readFile(fileName);
        outputFile(states);
        new CovidWindow(states);
    }

    /**
     * This private method reads the files and creates an array
     * where each state has a DoublyLinkedList of different races
     * @param fileName to determine which file is being read
     * @throws FileNotFoundException if files do not exist
     */
    private void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        states = new State[6];
        int i = 0;
        //This loops through to see if there is a next line to be split
        while (scanner.hasNextLine()){
            String [] string = scanner.nextLine().split(",", 11);
            states[i] = readState(string);
            i++;
        }
        scanner.close();
    }

    /**
     * This private method reads a line and initializes a state based on the values that are
     * given by the data
     * @param string which would be the given line to be read
     * @return State where the data is being implemented
     */
    private State readState(String[] string){
        //loops through the given line to be read and see if it is equal to specified text
        for (int i = 0; i < 11; i++){
            if (string[i].equals("NA")){
                string[i] = "-1";
            }
        }
        
        //for each race there is a set of values that are given to each data
        String name = string[0];
        Race asian = new Race("white", Integer.valueOf(string[1]), Integer.valueOf(string[6]));
        Race black = new Race("black", Integer.valueOf(string[2]), Integer.valueOf(string[7]));
        Race latinx = new Race("latinx", Integer.valueOf(string[3]), Integer.valueOf(string[8]));
        Race other = new Race("asian", Integer.valueOf(string[4]), Integer.valueOf(string[9]));
        Race white = new Race("other", Integer.valueOf(string[5]), Integer.valueOf(string[10]));
        
        //creating a doubly linked list to add the different types of races and storing within the state 
        DoublyLinkedList<Race> raceData = new DoublyLinkedList<Race>();
        raceData.add(asian);
        raceData.add(black);
        raceData.add(latinx);
        raceData.add(other);
        raceData.add(white);

        return new State(name, raceData);
    }

    /**
     * This private method prints out the state and the data that correlates
     * @param states which is array of states
     */
    private void outputFile(State[] states){
        //loops through the states and getting data for each race
        for (State state: states){
            DoublyLinkedList<Race> raceList = state.getRaceData();
            System.out.println(state.getName());
            raceList.insertionSortByAlpha();;
            
            //creating an array list where each city has specified race
            Object[] races = raceList.toArray();
            for (Object raceCity : races){
                System.out.println(raceCity.toString());
            }
            
            System.out.println("=====");
            raceList.insertionSortByCFR();
            races = raceList.toArray();
            
            //loops through the different ethnicity and prints out a string representation
            for (Object race: races){
                System.out.println(race.toString());
            }
            System.out.println("=====");
        }
    }
}
