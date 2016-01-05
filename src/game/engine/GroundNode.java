package game.engine;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class GroundNode extends JPanel {

    private static final int WIDTH = 10;
    private static final int HEIGTH = 10;

    public static final Border LAND_BORDER = new LineBorder(Color.black, 1);

    public static final int LOCATION_UP = 11;
    public static final int LOCATION_DOWN = 12;
    public static final int LOCATION_LEFT = 13;
    public static final int LOCATION_RIGHT = 14;
    private GroundNode upNode;
    private GroundNode downNode;
    private GroundNode leftNode;
    private GroundNode rightNode;


    public GroundNode() {

        super();
        this.setSize(new Dimension(WIDTH, HEIGTH));
        this.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        this.setBorder(LAND_BORDER);
    }

    public void setNeighbourNode(int location, GroundNode value) {

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

    public GroundNode getUpNode() {
        return upNode;
    }
    public GroundNode getDownNode() {
        return downNode;
    }
    public GroundNode getLeftNode() {
        return leftNode;
    }
    public GroundNode getRightNode() {
        return rightNode;
    }


}
