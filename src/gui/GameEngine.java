package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 2016/1/4
 */
public class GameEngine extends JPanel {

    private EngineNode[][] Nodes;

    public GameEngine() {



    }

    private void init() {

        this.setPreferredSize(new Dimension(350, 350));
        this.setSize(new Dimension(350, 350));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setBackground(Color.black);
        this.removeAll();

        Nodes = new EngineNode[50][50];
        for (EngineNode[] nodeRows : Nodes) {
            for (EngineNode node : nodeRows) {
                node = new EngineNode();
                this.add(node);
            }
        }

        initSnake();
    }

    private void initSnake() {

    }


}
