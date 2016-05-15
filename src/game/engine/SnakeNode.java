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

    private static final int SIDE_LEGHT = 10;

    public static final int TO_EAST = 1;
    public static final int TO_WEST = -1;
    public static final int TO_SOUTH = 2;
    public static final int TO_NORTH = -2;
    private int pretoward;
    public int toward;

    public static final String HEAD = "Head";
    public static final String BODY = "Body";
    private String part;

    public static final Color HEAD_COLOR = Color.RED;
    public static final Color BODY_COLOR = Color.GRAY;
    private Color color;

    public static final Border HEAD_BORDER = new LineBorder(HEAD_COLOR);
    public static final Border BODY_BORDER = new LineBorder(BODY_COLOR);
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
        this.setSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));
        this.setPreferredSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));
        this.setBackground(color);
        this.setBorder(border);
        if(myIndex < snakeLength - 1) nextNode = new SnakeNode(myGround, this, myIndex + 1, snakeLength, TO_NORTH);
        else nextNode = null;
    }

    public SnakeNode(GameEngine ground, int length, int locaX, int locaY, int to) {
        myGround = ground;
        preNode = null;
        snakeLength = length;
        myIndex = 0;
        part = HEAD;
        color = HEAD_COLOR;
        border = HEAD_BORDER;
        locationX = locaX;
        locationY = locaY;
        System.out.println("Head location is " + this.locationX + ", " + this.locationY);
        preX = locationX;
        preY = locationY;
        if (to != TO_EAST && to != TO_WEST && to != TO_SOUTH && to != TO_NORTH) {
            toward = 0;
            System.out.println("方向在初始化时设置错误");
        } else {
            toward = to;
        }
        pretoward = toward;
        this.setSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));
        this.setPreferredSize(new Dimension(SIDE_LEGHT, SIDE_LEGHT));
        this.setBackground(color);
        this.setBorder(border);
        if(myIndex < snakeLength - 1) nextNode = new SnakeNode(myGround, this, myIndex + 1, snakeLength, toward);
        else nextNode = null;
    }

    private SnakeNode(GameEngine ground, SnakeNode pre, int index, int length, int to) {
        myGround = ground;
        preNode = pre;
        snakeLength = length;
        myIndex = index;
        part = BODY;
        color = BODY_COLOR;
        border = BODY_BORDER;
        switch (to) {
            case TO_EAST: locationY = preNode.locationY - 1;locationX = preNode.locationX; break;
            case TO_WEST: locationY = preNode.locationY + 1;locationX = preNode.locationX; break;
            case TO_SOUTH: locationX = preNode.locationX - 1;locationY = preNode.locationY; break;
            case TO_NORTH: locationX = preNode.locationX + 1;locationY = preNode.locationY; break;
            default: System.out.println("移动方向错误"); break;
        }
//        System.out.println("No." + this.myIndex + " body's location is " + this.locationX + ", " + this.locationY);
        preX = locationX;
        preY = locationY;
        toward = to;
        pretoward = toward;
        this.setBackground(color);
        this.setBorder(border);
        if (myIndex < snakeLength - 1) nextNode = new SnakeNode(myGround, this, myIndex + 1, snakeLength, to);
        else nextNode = null;

    }

    private void fellowPreNode(SnakeNode thisNode) {
        if (thisNode.nextNode != null) {
            SnakeNode next = thisNode.nextNode;
            next.preX = next.locationX;
            next.preY = next.locationY;
            next.pretoward = next.toward;
            next.locationX = thisNode.preX;
            next.locationY = thisNode.preY;
            next.toward = thisNode.pretoward;
            fellowPreNode(next);
        }
    }

    public boolean moveToward() {
        if(toward != TO_EAST && toward != TO_WEST && toward != TO_SOUTH && toward != TO_NORTH) return false;
        preX = locationX;
        preY = locationY;
        switch (toward) {
            case TO_EAST: locationY++; break;
            case TO_WEST: locationY--; break;
            case TO_SOUTH: locationX++; break;
            case TO_NORTH: locationX--; break;
        }
        fellowPreNode(this);
        return true;
    }

    public void moveBack() {
        locationX = preX;
        locationY = preY;
        toward = pretoward;
        SnakeNode next = nextNode;
        while (next != null) {
            next.preNode.preX = next.locationX;
            next.preNode.preY = next.locationY;
            next.preNode.pretoward = next.toward;
            next.locationX = next.preX;
            next.locationY = next.preY;
            next.toward = next.pretoward;
            next = next.nextNode;
        }
    }

    public boolean changeToward(int to) {

        if (to != TO_EAST && to != TO_WEST && to != TO_SOUTH && to != TO_NORTH) return false;
        if (to == -toward) return false;
        pretoward = toward;
        toward = to;
        return true;
    }

    public void addOneNode() {
        SnakeNode lastNode = this;
        lastNode.snakeLength++;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
            lastNode.snakeLength++;
        }
        lastNode.nextNode = new SnakeNode(lastNode.myGround, lastNode, lastNode.myIndex + 1, lastNode.snakeLength, lastNode.toward);
    }

}
