package prj5;
import cs2.WindowSide;
import cs2.Window;
import cs2.TextShape;
import cs2.Shape;
import cs2.Button;
import java.awt.Color;
/**
 * This class is a Graphic User Interface that displays the information based on the program
 * @version 2021.11.16
 * @author lane wills (lane20)
 * @author Jeffrey Zheng (jeffreyz)
 * @author Ananya Chilakamarthi (ananyac)
 *
 */
public class CovidWindow {
    private Window window;
    private Button sortByAlpha;
    private Button sortByCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private State[] state;
    private TextShape title;
    private Shape whiteBar;
    private Shape asianBar;
    private Shape blackBar;
    private Shape latinxBar;
    private Shape otherBar;
    private int asianCFR;
    private int blackCFR;
    private int whiteCFR;
    private int latinxCFR;
    private int otherCFR;
    private double whiteCFRPercent;
    private double blackCFRPercent;
    private double latinxCFRPercent;
    private double asianCFRPercent;
    private double otherCFRPercent;
    private static final int XSTARTING = 70;
    private static final int XGAP = 130;
    private static int BAR_WIDTH = 10;

    /**
     * This constructor initializes a new window of display that implements the information
     * given to the graph
     * @param state that the information is stored
     */
    public CovidWindow(State[] state){
        window = new Window();
        window.setTitle("Graph: Lane Jeffrey Ananya ");
        sortByAlpha = new Button("Sort by Alpha");
        sortByCFR = new Button("Sort by CFR");
        representDC = new Button("Represent DC");
        representVA = new Button("Represent VA");
        representMD = new Button("Represent MD");
        representGA = new Button("Represent GA");
        representNC = new Button("Represent NC");
        representTN = new Button("Represent TN");
        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);
        representDC.onClick(this, "clickedDC");
        representTN.onClick(this, "clickedTN");
        representVA.onClick(this, "clickedVA");
        representMD.onClick(this, "clickedMD");
        representNC.onClick(this, "clickedNC");
        representGA.onClick(this, "clickedGA");
        sortByAlpha.onClick(this, "clickedAlpha");
        sortByCFR.onClick(this, "clickedCFR");
        this.state = state;
    }

    /**
     * This method displays the information for DC when it is clicked
     * @param button The button to click
     */
    public void clickedDC(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "DC Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[0].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * This method displays the information for GA when it is clicked
     * @param button The button to click
     */
    public void clickedGA(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "GA Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[1].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * This method displays the information for MD when it is clicked
     * @param button The button to click
     */
    public void clickedMD(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "DC Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[2].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * This method displays the information for NC when it is clicked
     * @param button The button to click
     */
    public void clickedNC(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "NC Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[3].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * This method displays the information for DC when it is clicked
     * @param button The button to click
     */
    public void clickedTN(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "TN Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[4].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * This method displays the information for VA when it is clicked
     * @param button The button to click
     */
    public void clickedVA(Button button) {
        window.removeAllShapes();
        title = new TextShape(5, 0, "VA Case Fatality Ratios by Race");
        int x = (window.getGraphPanelWidth() / 2) - (title.getWidth()
                / 2);
        int y = (window.getGraphPanelHeight() / 2) - 125;
        title.moveTo(x, y);
        Object[] Race = state[5].getRaceData().toArray();
        extractData(Race);
        graph(Race);
    }

    /**
     * Helper method that extracts values from the state array
     * @param race state array used
     */
    private void extractData(Object[] race) {
        for (int i = 0; i < race.length; i++) {
            Race group = (Race) race[i];
            String name = group.getEthnicity();

            switch (name) {
                case "asian":
                    Race asian = group;
                    asianCFRPercent = asian.getCFR();
                    asianCFR = (int) Math.round(asian.getCFR() * 10);
                    break;
                case "white":
                    Race white = group;
                    whiteCFRPercent = white.getCFR();
                    whiteCFR = (int) Math.round(white.getCFR() * 10);
                    break;
                case "black":
                    Race black = group;
                    blackCFRPercent = black.getCFR();
                    blackCFR = (int) Math.round(black.getCFR() * 10);
                    break;
                case "latinx":
                    Race latinx = group;
                    latinxCFRPercent = latinx.getCFR();
                    latinxCFR = (int) Math.round(latinx.getCFR() * 10);
                    break;
                default:
                    Race other = group;
                    otherCFRPercent = other.getCFR();
                    otherCFR = (int) Math.round(other.getCFR() * 10);
                    break;
            }
        }
    }
    /**
     * Graphs the different groups to the window
     */
    private void graph(Object[] groups)
    {
        window.removeAllShapes();
        int yVal = (window.getGraphPanelHeight() * 3 / 4);
        for (int i = 0; i < groups.length; i++)
        {
            Race group = (Race) groups[i];
            String name = group.getEthnicity();
            int xVal = XSTARTING + XGAP * i;
            TextShape text = new TextShape(xVal, yVal + 13, name);
            window.addShape(text);
            switch(name){
                case "asian":
                    if(asianCFRPercent == -1)
                    {
                        TextShape na = new TextShape(xVal, yVal - 10, "NA");
                        window.addShape(na);
                    }
                    else
                    {
                        asianBar = new Shape(xVal + 10, yVal - asianCFR, BAR_WIDTH, asianCFR, Color.GREEN);
                        window.addShape(asianBar);
                        TextShape percent = new TextShape(xVal, yVal + 43, asianCFRPercent + "%");
                        window.addShape(percent);
                    }
                    break;
                case "white":
                    if(whiteCFRPercent == -1)
                    {
                        TextShape na = new TextShape(xVal , yVal - 10, "NA");
                        window.addShape(na);
                    }
                    else
                    {
                        whiteBar = new Shape(xVal + 10, yVal - whiteCFR, BAR_WIDTH, whiteCFR, Color.RED);
                        window.addShape(whiteBar);
                        TextShape percent = new TextShape(xVal, yVal + 43, whiteCFRPercent + "%");
                        window.addShape(percent);
                    }
                    break;
                case "black":
                    if(blackCFRPercent == -1)
                    {
                        TextShape na = new TextShape(xVal, yVal - 10, "NA");
                        window.addShape(na);
                    }
                    else
                    {
                        blackBar = new Shape(xVal + 10, yVal - blackCFR, BAR_WIDTH, blackCFR, Color.BLUE);
                        window.addShape(blackBar);
                        TextShape percent = new TextShape(xVal, yVal + 43, blackCFRPercent + "%");
                        window.addShape(percent);
                    }
                    break;
                case "latinx":
                    if(latinxCFRPercent == -1)
                    {
                        TextShape na = new TextShape(xVal, yVal - 10, "NA");
                        window.addShape(na);
                    }
                    else
                    {
                        latinxBar = new Shape(xVal + 10, yVal - latinxCFR, BAR_WIDTH, latinxCFR, Color.GRAY);
                        window.addShape(latinxBar);
                        TextShape percent = new TextShape(xVal, yVal + 43, latinxCFRPercent + "%");
                        window.addShape(percent);
                    }
                    break;
                default:
                    if(otherCFRPercent == -1)
                    {
                        TextShape na = new TextShape(xVal, yVal - 10, "NA");
                        window.addShape(na);
                    }
                    else
                    {
                        otherBar = new Shape(xVal + 10, yVal - otherCFR, BAR_WIDTH, otherCFR, Color.ORANGE);
                        window.addShape(otherBar);
                        TextShape percent = new TextShape(xVal, yVal + 43, otherCFRPercent + "%");
                        window.addShape(percent);
                    }
                    break;
            }
            window.addShape(title);
        }
    }

    /**
     * This method represents when the Sort by Alpha button is clicked
     * @param button that represents what is getting clicked
     */
    public void clickedAlpha(Button button) {
        if (title == null) {
            return;
        }
        String name = title.getText().substring(0, 2);
        switch(name){
            case "DC":
                state[0].getRaceData().insertionSortByAlpha();
                graph(state[0].getRaceData().toArray());
                break;
            case "GA":
                state[1].getRaceData().insertionSortByAlpha();
                graph(state[1].getRaceData().toArray());
                break;
            case "MD":
                state[2].getRaceData().insertionSortByAlpha();
                graph(state[2].getRaceData().toArray());
                break;
            case "NC":
                state[3].getRaceData().insertionSortByAlpha();
                graph(state[3].getRaceData().toArray());
                break;
            case "TN":
                state[4].getRaceData().insertionSortByAlpha();
                graph(state[4].getRaceData().toArray());
                break;
            default:
                state[5].getRaceData().insertionSortByAlpha();
                graph(state[5].getRaceData().toArray());
                break;
        }
        window.addShape(title);
    }

    /**
     * This method represents when the Sort by CFR button is clicked
     * @param button that is being clicked on
     */
    public void clickedCFR(Button button) {
        if (title == null) {
            return;
        }
        String name = title.getText().substring(0, 2);
        switch(name) {
            case "DC":
                state[0].getRaceData().insertionSortByCFR();
                graph(state[0].getRaceData().toArray());
                break;
            case "GA":
                state[1].getRaceData().insertionSortByCFR();
                graph(state[1].getRaceData().toArray());
                break;
            case "MD":
                state[2].getRaceData().insertionSortByCFR();
                graph(state[2].getRaceData().toArray());
                break;
            case "NC":
                state[3].getRaceData().insertionSortByCFR();
                graph(state[3].getRaceData().toArray());
                break;
            case "TN":
                state[4].getRaceData().insertionSortByCFR();
                graph(state[4].getRaceData().toArray());
                break;
            case "VA":
                state[5].getRaceData().insertionSortByCFR();
                graph(state[5].getRaceData().toArray());
                break;
        }
        window.addShape(title);
    }
}
