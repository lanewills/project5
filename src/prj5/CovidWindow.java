package prj5;
import cs2.WindowSide;
import cs2.Window;
import cs2.TextShape;
import cs2.Shape;
import cs2.Button;
import java.awt.Color;
/**
 * This class is a Graphic User Interface that displays the information based on the program
 * @author Lane Wills (lane20) & Jeffrey Zheng (jeffreyz) & Ananya Chilakamarthi
 * @version 2021.11.16
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
    private tate[] state;
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
}
