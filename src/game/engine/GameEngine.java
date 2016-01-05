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
        this.setBackground(Color.black);
        this.removeAll();
        /*初始化引擎完成*/

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

        initSnake();
    }

    private void initSnake() {
        snake = new SnakeNode(this, 4);
        SnakeNode head = snake;
        while (head != null) {
//            System.out.println(head.myIndex + "的 locationX 和 locationY 为：" + head.locationX + "----" + head.locationY);
            Nodes[head.locationX][head.locationY].add(head);
            System.out.println(Nodes[head.locationX][head.locationY].getComponent(0).getClass().getName());
            head = head.nextNode;
        }
    }

    public void move() {

//        snake.moveToNorth();
        SnakeNode head = new SnakeNode(this, 1);
        while (head != null) {
//            System.out.println(head.myIndex + "的preX 和 preY 为：" + head.preX + "----" + head.preY);
//            System.out.println(head.myIndex + "的 locationX 和 locationY 为：" + head.locationX + "----" + head.locationY);
//            Nodes[head.preX][head.preY].removeAll();
//            Nodes[head.locationX][head.locationY].add(new SnakeNode(this, 1));
            Nodes[0][0].add(head);
            System.out.println(Nodes[0][0].getComponent(0).getClass().getName());
            head = head.nextNode;
        }

    }


}
