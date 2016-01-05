package game.gui;

import game.engine.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author mamamiyear
 *         on 16-1-4.
 */
public class MainFrame extends JFrame {

    private JPanel container;

    private GameEngine gamePane;
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
        System.out.println("The main window's width is " + this.getWidth() + " and height is " + this.getHeight());
        System.out.println("The main window's preferredWidth is " + this.getPreferredSize().getWidth() + " and preferredHeight is " + this.getPreferredSize().getHeight());

    }

    private void initComponents() {

        gamePane = new GameEngine();
        ctrlPane = new JPanel();
        startBtn = new JButton("开始");
        stopBtn = new JButton("停止");
        restartBtn = new JButton("重新开始");
        pauseBtn = new JButton("暂停");

        startBtn.setPreferredSize(new Dimension(100, 30));
        stopBtn.setPreferredSize(new Dimension(100, 30));
        restartBtn.setPreferredSize(new Dimension(100, 30));
        pauseBtn.setPreferredSize(new Dimension(100, 30));
        initButtonFunction();

        ctrlPane.setPreferredSize(new Dimension(150, 350));
        ctrlPane.setSize(new Dimension(150, 350));
        ctrlPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 46));
        ctrlPane.setBackground(Color.GREEN);

        ctrlPane.add(startBtn);
        ctrlPane.add(stopBtn);
        ctrlPane.add(pauseBtn);
        ctrlPane.add(restartBtn);

        container.add(gamePane);
        container.add(ctrlPane);

    }

    private void initButtonFunction() {

        startBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePane.move();
            }
        });

    }

}
