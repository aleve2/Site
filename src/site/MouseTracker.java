package site;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTracker implements MouseMotionListener {
    public static int mx;
    public static int my;

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();

        e.consume();
    }
}
