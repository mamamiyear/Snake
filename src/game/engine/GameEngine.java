package game.engine;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 2016/1/4
 */
public class GameEngine extends JPanel {

    public static final int SIDE_LENGTH = 350;
    public final int NODE_NUM = SIDE_LENGTH / 10;

    private SnakeNode snake;
    private GroundNode[][] Nodes;

    public GameEngine() {
        init();
    }

    private void init() {
        /*初始化引擎*/
        this.setPreferredSize(new Dimension(SIDE_LENGTH, SIDE_LENGTH));
        this.setSize(new Dimension(SIDE_LENGTH, SIDE_LENGTH));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
//        this.setBackground(Color.black);
        this.removeAll();
        /*初始化引擎完成*/
        initGround();
        initSnake();
    }

    private void initGround() {
        /*初始化场地*/
        Nodes = new GroundNode[35][35];
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes[i].length; j++) {
                Nodes[i][j] = new GroundNode();
                Nodes[i][j].setLayout(new BorderLayout());
                this.add(Nodes[i][j]);
            }
        }
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes[i].length; j++) {

                if (i == 0) Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_UP, null);
                else Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_UP, Nodes[i - 1][j]);

                if (i == Nodes.length - 1) Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_DOWN, null);
                else Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_DOWN, Nodes[i + 1][j]);

                if (j == 0) Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_LEFT, null);
                else Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_LEFT, Nodes[i][j - 1]);

                if (j == Nodes[i].length - 1) Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_RIGHT, null);
                else Nodes[i][j].setNeighbourNode(GroundNode.LOCATION_RIGHT, Nodes[i][j + 1]);
            }
        }
        /*初始化场地完成*/
    }

    private void initSnake() {
        snake = new SnakeNode(this, 4);
        SnakeNode head = snake;
        while (head != null) {
            Nodes[head.locationX][head.locationY].add(head);
            head = head.nextNode;
        }
        this.updateUI();
    }

    public void move(int toward) {
        snake.changeToward(toward);
        snake.moveToward();
        SnakeNode head = snake;
        while (head != null) {
            Nodes[head.preX][head.preY].removeAll();
            Nodes[head.locationX][head.locationY].add(head);
            head = head.nextNode;
        }
        this.updateUI();
    }

    public void reInit() {
        SnakeNode head = snake;
        while (head != null) {
            Nodes[head.locationX][head.locationY].removeAll();
            head = head.nextNode;
        }
        initSnake();
    }


}
