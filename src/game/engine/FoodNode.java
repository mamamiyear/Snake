package game.engine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-6.
 */
public class FoodNode extends JPanel {

    private static final int SIDE_LEGHT = 10;

    public static final String FOOD = "Food";
    public static final Color FOOD_COLOR = Color.GREEN;
    public static final Border FOOD_BORDER = new LineBorder(FOOD_COLOR, 1);

    private String part;
    private Color color;
    private Border border;
    public int locationX, locationY;

    public FoodNode(int locaX, int locaY) {
        locationX = locaX;
        locationY = locaY;
        border = FOOD_BORDER;
        color = FOOD_COLOR;
        part = FOOD;
        this.setBorder(border);
        this.setBackground(color);
        this.setSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));
        this.setPreferredSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));

    }

    public void changeLocation(int locaX, int locaY) {
        locationX = locaX;
        locationY = locaY;
    }

}
