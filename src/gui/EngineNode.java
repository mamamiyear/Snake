package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class EngineNode extends JPanel {

    private static final int Width = 7;
    private static final int Heigth = 7;

    public static final int TO_EAST = 1;
    public static final int TO_WEST = 2;
    public static final int TO_SOUTH = 3;
    public static final int TO_NORTH = 4;
    private int toward;

    public static final String HEAD = "Head";
    public static final String BODY = "Body";
    public static final String LAND = "Land";
    public static final String FOOD = "Food";
    private String state;

    public static final Color HEAD_COLOR = Color.RED;
    public static final Color BODY_COLOR = Color.GRAY;
    public static final Color LAND_COLOR = Color.WHITE;
    public static final Color FOOD_COLOR = Color.GREEN;
    private Color color;

    public static final Border HEAD_BORDER = new LineBorder(HEAD_COLOR);
    public static final Border BODY_BORDER = new LineBorder(BODY_COLOR);
    public static final Border LAND_BORDER = new LineBorder(Color.BLACK);
    public static final Border FOOD_BORDER = new LineBorder(FOOD_COLOR);
    private Border border;




    public EngineNode() {



    }

}
