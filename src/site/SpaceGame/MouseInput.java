package site.SpaceGame;

import site.Handler;
import site.SitePanel;
import site.States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.*;

public class MouseInput implements MouseListener {

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

        // Play Button
        if(GamePanel.State.equals(GamePanel.STATE.MENU)) {
            if (mx >= (GamePanel.GAME_WIDTH / 2) - 50 && mx <= (GamePanel.GAME_WIDTH / 2) + 50) {
                if (my >= 200 && my <= 250) {
                    // Pressed Play button
                    System.out.println("test");
                    GamePanel.State = GamePanel.STATE.GAME;
                }
            }
        }
        if(GamePanel.State.equals(GamePanel.STATE.MENU)) {
            if (mx >= (GamePanel.GAME_WIDTH / 2) - 50 && mx <= (GamePanel.GAME_WIDTH / 2) + 50) {
                if (my >= 400 && my <= 450) {
                    // Pressed Exit button

                    Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
                    win.dispose();
                    //System.exit(1);
                }
            }
        }

        if(GamePanel.State.equals(GamePanel.STATE.GAME)) {
            if (mx >= 8 && mx <= 58) {
                if (my >= 8 && my <= 38) {
                    // Pressed Back button
                    System.out.println("test");
                    GamePanel.State = GamePanel.STATE.MENU;
                }
            }
        }

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
        /*

        int mx = e.getX();
        int my = e.getY();

        Graphics g = null;

// 263, 400, w = 165, h = 212

        if(State.getState().equals(SitePanel.homeState)) {
            if(mx >= 263 && mx <= 428) {
                if(my >= 400 && my <= 612) {

                    System.out.println("test");

                    assert g != null;
                    g.setColor(Color.red);
                    g.drawRect(1,1,10,10);
                }
            }
        }

         */
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
