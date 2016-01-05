package game.engine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class SnakeNode extends JPanel {

    private static final int WIDTH = 10;
    private static final int HEIGTH = 10;

    public static final int TO_EAST = 1;
    public static final int TO_WEST = 2;
    public static final int TO_SOUTH = 3;
    public static final int TO_NORTH = 4;
    private int toward;

    public static final String HEAD = "Head";
    public static final String BODY = "Body";
    public static final String FOOD = "Food";
    private String part;

    public static final Color HEAD_COLOR = Color.RED;
    public static final Color BODY_COLOR = Color.GRAY;
    public static final Color FOOD_COLOR = Color.GREEN;
    private Color color;

    public static final Border HEAD_BORDER = new LineBorder(HEAD_COLOR);
    public static final Border BODY_BORDER = new LineBorder(BODY_COLOR);
    public static final Border FOOD_BORDER = new LineBorder(FOOD_COLOR);
    private Border border;

    public SnakeNode preNode;
    public SnakeNode nextNode;
    private int snakeLength;
    public int myIndex;

    public int preX;
    public int preY;
    public int locationX;
    public int locationY;

    private GameEngine myGround;

    public SnakeNode(GameEngine ground, int length) {
        myGround = ground;
        preNode = null;
        snakeLength = length;
        myIndex = 0;
        part = HEAD;
        color = HEAD_COLOR;
        border = HEAD_BORDER;
        locationX = myGround.NODE_NUM / 2;
        locationY = myGround.NODE_NUM / 2;
        preX = locationX;
        preY = locationY;
        this.setBackground(color);
        this.setBorder(border);
        if(myIndex < snakeLength - 1) nextNode = new SnakeNode(myGround, this, myIndex + 1, snakeLength);
        else nextNode = null;
    }

    private SnakeNode(GameEngine ground, SnakeNode pre, int index, int length) {

        myGround = ground;
        preNode = pre;
        snakeLength = length;
        myIndex = index;
        part = BODY;
        color = BODY_COLOR;
        border = BODY_BORDER;
        locationX = pre.locationX + 1;
        locationY = pre.locationY;
        preX = locationX;
        preY = locationY;
        this.setBackground(color);
        this.setBorder(border);
        if (myIndex < snakeLength - 1) nextNode = new SnakeNode(myGround, this, myIndex + 1, snakeLength);
        else nextNode = null;

    }

    public void moveToNorth() {

        preX = locationX;
        preY = locationY;
        locationX = locationX - 1;
        if (this.nextNode != null) {
            this.nextNode.moveToNorth();
        }


    }

}
