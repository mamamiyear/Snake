package game.Engine;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 2016/1/4
 */
public class GameEngine extends JPanel {

    private EngineNode[][] Nodes;

    public GameEngine() {

        init();

    }

    private void init() {

        /*初始化引擎*/
        this.setPreferredSize(new Dimension(350, 350));
        this.setSize(new Dimension(350, 350));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setBackground(Color.black);
        this.removeAll();
        /*初始化引擎完成*/

        /*初始化场地*/
        Nodes = new EngineNode[35][35];
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes[i].length; j++) {
                Nodes[i][j] = new EngineNode();
                this.add(Nodes[i][j]);
            }
        }
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes[i].length; j++) {

                if (i == 0) Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_UP, null);
                else Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_UP, Nodes[i - 1][j]);

                if (i == Nodes.length - 1) Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_DOWN, null);
                else Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_DOWN, Nodes[i + 1][j]);

                if (j == 0) Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_LEFT, null);
                else Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_LEFT, Nodes[i][j - 1]);

                if (j == Nodes[i].length - 1) Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_RIGHT, null);
                else Nodes[i][j].setNeighbourNode(EngineNode.LOCATION_RIGHT, Nodes[i][j + 1]);
            }
        }
        /*初始化场地完成*/

        initSnake();
    }

    private void initSnake() {

    }


}
