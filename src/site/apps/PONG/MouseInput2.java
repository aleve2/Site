package site.apps.PONG;


import site.Handler;
import site.apps.SpaceGame.GamePanel;

import java.awt.event.MouseListener;
import java.awt.event.*;

public class MouseInput2 implements MouseListener {

    private Handler handler;

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(Handler.isPong) {
            if (mx >= 8 && mx <= 58) {
                if (my >= 8 && my <= 38) {
                    // Pressed Back button
                    System.out.println("test123");
                    GamePanel.State = GamePanel.STATE.MENU;
                }
            }
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
