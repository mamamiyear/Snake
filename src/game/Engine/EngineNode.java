package game.Engine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class EngineNode extends JPanel {

    private static final int WIDTH = 10;
    private static final int HEIGTH = 10;

    public static final Border LAND_BORDER = new LineBorder(Color.black, 1);

    public static final int LOCATION_UP = 11;
    public static final int LOCATION_DOWN = 12;
    public static final int LOCATION_LEFT = 13;
    public static final int LOCATION_RIGHT = 14;
    private EngineNode upNode;
    private EngineNode downNode;
    private EngineNode leftNode;
    private EngineNode rightNode;


    public EngineNode() {

        super();
        this.setSize(new Dimension(this.WIDTH, this.HEIGTH));
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGTH));
        this.setBorder(this.LAND_BORDER);
    }

    public void setNeighbourNode(int location, EngineNode value) {

        switch (location) {
            case 11:
                upNode = value;
                break;
            case 12:
                downNode = value;
                break;
            case 13:
                leftNode = value;
                break;
            case 14:
                rightNode = value;
                break;
            default:
                System.out.println("设定临近节点的位置错误，设置失败");
                break;
        }
    }

    public EngineNode getUpNode() {
        return upNode;
    }
    public EngineNode getDownNode() {
        return downNode;
    }
    public EngineNode getLeftNode() {
        return leftNode;
    }
    public EngineNode getRightNode() {
        return rightNode;
    }


}
