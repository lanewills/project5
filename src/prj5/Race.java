package prj5;
import java.text.DecimalFormat;

/**
 * Class for a race that contains all race data.
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 */
public class Race implements Comparable<Race>{
    private double cfr;
    private int deaths;
    private int cases;
    private String name;

    /**
     * Constructor for a race object.
     * @param name name of the race
     * @param covidCases number of cases for the race
     * @param covidDeaths number of deaths for the race
     */
    public Race(String raceName, int covidCases, int covidDeaths) {
        name = raceName;
        cases = covidCases;
        deaths = covidDeaths;
        float tempcfr;
        
        if (covidDeaths == -1) {
            cfr = -1;
            return;
        }
        else {
            //typecast deaths and cases to float values, then calc
            tempcfr = (((float) deaths / (float) cases) * 100);
        }
        
        //convert float to rounded double
        DecimalFormat df = new DecimalFormat("#.#");
        cfr = Double.valueOf(df.format(tempcfr));
    }
    
    /**
     * gets the name of the race
     * @return the name of the race
     */
    public String getEthnicity() {
        return this.name;
    }
    
    /**
     * gets the amount of cases among a race
     * @return the amount of cases
     */
    public int getCovidCases() {
        return this.cases;
    }

    /**
     * gets the amount of deaths among a race
     * @return the amount of deaths
     */
    public int getCovidDeaths() {
        return this.deaths;
    }

    /**
     * gets the case fatality ratio among a race
     * @return the CFR
     */
    public double getCFR() {
        return this.cfr;
    }

    /**
     * writes out data of a race into a string
     * @return all of a race's data
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(": ");
        builder.append(cases);
        builder.append(" cases, ");
        if (cfr % 1 == 0) {
            builder.append((int)cfr);
        }
        else {
            builder.append(cfr);
        }
        builder.append("% CFR");
        return builder.toString();
    }

    /**
     * compares races by lexicographic order
     * @param group1 the first race
     * @param group2 the second race
     * @return -1 if group 1 comes after, 1 if before, 0 if equal
     */
    public static int compareAlpha(Race group1, Race group2) {
        return group1.getEthnicity().compareTo(group2.getEthnicity());
    }

    /**
     * compares races by CFR
     * @param group1 the first race
     * @param group2 the second race
     * @return -1 is group 1 is less, 1 if more, 0 if equal
     */
    public static int compareCFR(Race group1, Race group2) {
        double cfrDifference = group2.cfr - group1.cfr;
        if (cfrDifference == 0) {
            return group1.getEthnicity().compareTo(group2.getEthnicity());
        }
        if (cfrDifference > 0)
        {
            return -1;
        }
        return 1;
    }
    
    /**
     * compares two races first on CFR then on name
     * @param other the race to compare
     * @return 1 if this is greater, -1 if less, 0 if equal
     */
    public int compareTo(Race other)
    {
        if (this.getCFR() > other.getCFR())
        {
            return 1;
        }
        if (this.getCFR() < other.getCFR())
        {
            return -1;
        }
        return this.getEthnicity().compareTo(other.getEthnicity());
    }
}
