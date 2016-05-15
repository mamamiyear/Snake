package game.engine;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * @author mamamiyear
 *         on 2016/1/4
 */
public class GameEngine extends JPanel {

    public static final int SIDE_LENGTH = 350;
    public final int NODE_NUM = SIDE_LENGTH / GroundNode.SIDE_LEGHT;

    private static final int initSnakeLength = 5;

    private TimerTask autoMove;
    private java.util.Timer timer;
    private long timePeriod;

    private SnakeNode snake;
    private FoodNode food;
    private GroundNode[][] Nodes;

    private LinkedList<Integer> operationBuffer;



    public GameEngine() {

        init();
    }

    private void init() {
        /*初始化引擎*/
        this.setPreferredSize(new Dimension(SIDE_LENGTH, SIDE_LENGTH));
        this.setSize(new Dimension(SIDE_LENGTH, SIDE_LENGTH));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.removeAll();
        operationBuffer = new LinkedList<>();
        /*初始化引擎完成*/
        initGround();
        initSnake();
        initFood();
    }

    private void initGround() {
        /*初始化场地*/
        Nodes = new GroundNode[NODE_NUM][NODE_NUM];
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
        snake = new SnakeNode(this, initSnakeLength, 5, 5, SnakeNode.TO_NORTH);
        SnakeNode head = snake;
        while (head != null) {
            Nodes[head.locationX][head.locationY].add(head);
            head = head.nextNode;
        }
        this.updateUI();
    }

    private void initFood() {
        putFood();
    }

    private void initTimer() {
        timePeriod = 100;
        autoMove = new TimerTask() {
            @Override
            public void run() {
                if (GameEngine.this.operationBuffer.isEmpty()) {
                    GameEngine.this.move();
                } else {
                    GameEngine.this.move(GameEngine.this.operationBuffer.poll());
                }
            }
        };
        timer = new Timer();
        timer.schedule(autoMove, timePeriod, timePeriod);
    }

    public void move() {
        boolean hasChanged = snake.changeToward(snake.toward);
        if(hasChanged && snake.moveToward()) {
            SnakeNode head = snake;
            try {
                if(head.locationX <0 || head.locationX>=NODE_NUM || head.locationY <0 || head.locationY>=NODE_NUM) {
                    snake.moveBack();
                    return;
                }
                if ("game.engine.FoodNode".equals(Nodes[head.locationX][head.locationY].getComponent(0).getClass().getName())) {
                    head.addOneNode();
                    putFood();
                }
                if ("game.engine.SnakeNode".equals(Nodes[head.locationX][head.locationY].getComponent(0).getClass().getName())) {
                    snake.moveBack();
                    return;
                }
            } catch (Exception ignored) {
            }
            while (head != null && head.locationX >= 0 && head.locationX < NODE_NUM && head.locationY >= 0 && head.locationY < NODE_NUM) {
                Nodes[head.locationX][head.locationY].removeAll();
                Nodes[head.locationX][head.locationY].add(head);
                Nodes[head.locationX][head.locationY].updateUI();
                head = head.nextNode;
            }
            this.updateUI();
        }
    }

    public void changeSnakeToward(int toward) {
        operationBuffer.offer(toward);
    }

    public void move(int toward) {
        boolean hasChanged = snake.changeToward(toward);
        if(hasChanged && snake.moveToward()) {
            SnakeNode head = snake;
            try {
                if(head.locationX <0 || head.locationX>=NODE_NUM || head.locationY <0 || head.locationY>=NODE_NUM) {
                    snake.moveBack();
                    return;
                }
                if ("game.engine.FoodNode".equals(Nodes[head.locationX][head.locationY].getComponent(0).getClass().getName())) {
                    head.addOneNode();
                    putFood();
                }
                if ("game.engine.SnakeNode".equals(Nodes[head.locationX][head.locationY].getComponent(0).getClass().getName())) {
                    snake.moveBack();
                    return;
                }
            } catch (Exception ignored) {
            }
            while (head != null && head.locationX >= 0 && head.locationX < NODE_NUM && head.locationY >= 0 && head.locationY < NODE_NUM) {
                Nodes[head.locationX][head.locationY].removeAll();
                Nodes[head.locationX][head.locationY].add(head);
                Nodes[head.locationX][head.locationY].updateUI();
                head = head.nextNode;
            }
            this.updateUI();
        }
    }

    public void reInit() {
        SnakeNode head = snake;
        while (head != null) {
            Nodes[head.locationX][head.locationY].removeAll();
            head = head.nextNode;
        }
        Nodes[food.locationX][food.locationY].removeAll();
        initSnake();
        putFood();
    }

    public void putFood() {

        boolean isValid = false;
        int foodX = 0;
        int foodY = 0;
        /*
        Some Sentence
        这里为判断语句，判断foodX， foodY是否为snake所在地
         */
        while (!isValid) {
            foodX = new Random().nextInt(NODE_NUM);
            foodY = new Random().nextInt(NODE_NUM);
            SnakeNode head = snake;
            while (head != null) {
                if (foodX == head.locationX && foodY == head.locationY) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                    head = head.nextNode;
                }
            }
        }
        food = new FoodNode(foodX, foodY);
        Nodes[food.locationX][food.locationY].removeAll();
        Nodes[food.locationX][food.locationY].add(food);
    }

    public void gameStart() {
        initTimer();
    }

    public void gameStop() {
        timer.cancel();
    }

    private class Pair {
        public int X;
        public int Y;

        public Pair(int x, int y) {
            X = x;
            Y = y;
        }

        public boolean equals(Pair p) {
            if (X == p.X && Y == p.Y) {
                return true;
            } else {
                return false;
            }
        }
    }


}
