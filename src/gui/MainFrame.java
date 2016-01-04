package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class MainFrame extends JFrame {

    private Container container;
    private JPanel gamePane;
    private JPanel ctrlPane;
    private int screenWidth;
    private int screenHeight;


    public MainFrame() {

        super("Snake");
        initFrame();
        initComponents();
        setVisible(true);

    }

    private void initFrame() {

        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        if(screenWidth <= 450 || screenHeight <= 350) System.exit(0);
        container = this.getContentPane();
        container.setLayout(new FlowLayout());
    }

    private void initComponents() {

        gamePane = new JPanel();
        ctrlPane = new JPanel();

        gamePane.setPreferredSize(new Dimension(350, 350));
        gamePane.setSize(new Dimension(350, 350));
        gamePane.setBackground(Color.black);
        ctrlPane.setBackground(Color.blue);

        container.add(gamePane);
        container.add(ctrlPane);

    }

}
