package game.gui;

import game.engine.GameEngine;
import game.engine.SnakeNode;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        initKeyBoardListener();
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
        ctrlPane.setBorder(new LineBorder(Color.black, 1));

        ctrlPane.add(startBtn);
        ctrlPane.add(stopBtn);
//        ctrlPane.add(pauseBtn);
        ctrlPane.add(restartBtn);

        container.add(gamePane);
        container.add(ctrlPane);
    }

    private void initButtonFunction() {
        startBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePane.gameStart();
                gamePane.requestFocus();
                gamePane.updateUI();
                System.out.println("点击了“开始”按钮");
            }
        });
        stopBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePane.gameStop();
                gamePane.reInit();
                gamePane.updateUI();
                System.out.println("点击了“停止”按钮");
            }
        });
        restartBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePane.gameStop();
                gamePane.putFood();
                gamePane.reInit();
                gamePane.gameStart();
                gamePane.requestFocus();
                gamePane.updateUI();
                System.out.println("点击了“重新开始”按钮");
            }
        });
        pauseBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pauseBtn.getText().equals("暂停")) {
                    System.out.println("点击了“暂停”按钮");
                    pauseBtn.setText("继续");
                } else if (pauseBtn.getText().equals("继续")) {
                    System.out.println("点击了“继续”按钮");
                    gamePane.requestFocus();
                    pauseBtn.setText("暂停");
                }
                gamePane.updateUI();
            }
        });
    }

    private void initKeyBoardListener() {
        gamePane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //自动
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) gamePane.changeSnakeToward(SnakeNode.TO_EAST);
                if (e.getKeyCode() == KeyEvent.VK_LEFT) gamePane.changeSnakeToward(SnakeNode.TO_WEST);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) gamePane.changeSnakeToward(SnakeNode.TO_SOUTH);
                if (e.getKeyCode() == KeyEvent.VK_UP) gamePane.changeSnakeToward(SnakeNode.TO_NORTH);

                /*
                //手动
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) gamePane.move(SnakeNode.TO_EAST);
                if (e.getKeyCode() == KeyEvent.VK_LEFT) gamePane.move(SnakeNode.TO_WEST);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) gamePane.move(SnakeNode.TO_SOUTH);
                if (e.getKeyCode() == KeyEvent.VK_UP) gamePane.move(SnakeNode.TO_NORTH);
                */
            }
        });
    }
}
