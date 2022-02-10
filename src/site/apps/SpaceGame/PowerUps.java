package site.apps.SpaceGame;

import java.awt.*;

public class PowerUps extends Rectangle{

    PowerUps(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y ,width, height);
    }
}
