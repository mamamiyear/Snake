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

    private static final int WIDTH = 10;
    private static final int HEIGTH = 10;

    public static final String FOOD = "Food";
    public static final Color FOOD_COLOR = Color.GREEN;
    public static final Border FOOD_BORDER = new LineBorder(FOOD_COLOR);

    private  Border border;

    public int locationX, locationY;


    public FoodNode(int locaX, int locaY) {




    }

}
