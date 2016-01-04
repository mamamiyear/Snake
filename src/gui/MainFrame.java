package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class MainFrame extends JFrame {

    private JPanel container;

    private JPanel gamePane;
    private JPanel ctrlPane;
    private JButton startBtn;
    private JButton stopBtn;
    private JButton restartBtn;
    private JButton pauseBtn;


    public MainFrame() {

        super("Snake");
        initFrame();
        initComponents();
        setVisible(true);

    }

    private void initFrame() {


        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        container = new JPanel();
        container.setPreferredSize(new Dimension(500, 350));
        container.setSize(new Dimension(500, 350));
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(container);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
    }

    private void initComponents() {

        gamePane = new JPanel();
        ctrlPane = new JPanel();
        startBtn = new JButton("开始");
        stopBtn = new JButton("停止");
        restartBtn = new JButton("重新开始");
        pauseBtn = new JButton("暂停");

        startBtn.setPreferredSize(new Dimension(100, 30));
        stopBtn.setPreferredSize(new Dimension(100, 30));
        restartBtn.setPreferredSize(new Dimension(100, 30));
        pauseBtn.setPreferredSize(new Dimension(100, 30));

        gamePane.setPreferredSize(new Dimension(350, 350));
        gamePane.setSize(new Dimension(350, 350));
        gamePane.setBackground(Color.black);

        ctrlPane.setPreferredSize(new Dimension(150, 350));
        ctrlPane.setSize(new Dimension(150, 350));
        ctrlPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 46));

        ctrlPane.add(startBtn);
        ctrlPane.add(stopBtn);
        ctrlPane.add(pauseBtn);
        ctrlPane.add(restartBtn);

        container.add(gamePane);
        container.add(ctrlPane);



    }

}
