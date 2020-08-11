package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class XO extends JFrame {private JFrame myFrame;

    public XO() {
        myFrame = new JFrame();


        myFrame.setTitle("XO");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
        myFrame.setLayout(new BorderLayout());
        myFrame.setLocationRelativeTo(null);

        JPanel jCenterPanel = new JPanel();
        JPanel jBottomPanel = new JPanel();
        jCenterPanel.setLayout(new BorderLayout());
        jBottomPanel.setLayout(new GridLayout());
        JButton jbStart = new JButton("Star New Game");
        JButton jbExit = new JButton("Exit");

        // model
        GameFieldMap gameMap = new GameFieldMap();
        // controller
        GameLogic gameLogic = new GameLogic(gameMap);
        // view
        jbExit.addActionListener(e -> System.exit(0));

        jBottomPanel.add(jbStart);
        jBottomPanel.add(jbExit);

        try {
            GameField gameField = new GameField(myFrame, gameLogic);
            jbStart.addActionListener((ActionEvent e) -> {
                gameField.newGame();
            });
            jCenterPanel.add(gameField, BorderLayout.CENTER);
        }
        catch (IOException e) {
            System.out.println("Files read failed.");
        }

        myFrame.add(jBottomPanel, BorderLayout.SOUTH);
        myFrame.add(jCenterPanel, BorderLayout.CENTER);

        myFrame.revalidate();
        myFrame.repaint();

        myFrame.setVisible(true);
    }
}
