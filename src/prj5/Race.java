package prj5;
import java.text.DecimalFormat;

/**
 * @version 2021.11.16
 */
public class Race {
    private double cfr;
    private int covidDeaths;
    private int covidCases;
    private String name;

    /**
     *
     * @param name
     * @param covidCases
     * @param covidDeaths
     */
    public Race(String name, int covidCases, int covidDeaths) {
        this.name = name;
        this.covidCases = covidCases;
        this.covidDeaths = covidDeaths;
        if (covidDeaths == -1) {
            cfr = -1;
        }
        else {
            this.cfr = 100.0 * covidDeaths / covidCases;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        cfr = Double.valueOf(df.format(cfr));
    }

    public String getEthnicity() {
        return name;
    }

    public int getCovidCases() {
        return covidCases;
    }

    public int getCovidDeaths() {
        return covidDeaths;
    }

    public double getCFR() {
        return cfr;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(": ");
        builder.append(covidCases);
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

    public static int compareAlpha(Race group1, Race group2) {
        return group1.getRace().compareTo(group2.getRace());
    }


    public static double compareCFR(Race group1, Race group2) {
        double cfrDifference = group2.cfr - group1.cfr;
        if (cfrDifference == 0) {
            return group1.getEthnicity().compareTo(group2.getEthnicity());
        }
        return cfrDifference;
    }
}
