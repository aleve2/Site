package site.SpaceGame;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    public GameFrame() {
        panel = new GamePanel();

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        this.add(panel);
        this.setTitle("Space Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }


}
