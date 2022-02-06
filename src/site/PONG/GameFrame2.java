package site.PONG;

import java.awt.*;
import javax.swing.*;

public class GameFrame2 extends JFrame{

    GamePanel2 panel ;

    public GameFrame2(){
        panel = new GamePanel2();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}

