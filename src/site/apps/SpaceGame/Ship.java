package site.apps.SpaceGame;

import java.awt.*;
import java.awt.event.*;

public class Ship extends Rectangle {

    int xVelocity;
    int yVelocity;
    int id;
    static public int speedShip = 3;

    Ship(int x, int y, int SHIP_WIDTH, int SHIP_HEIGHT, int id) {
        super(x,y,SHIP_WIDTH,SHIP_HEIGHT);
        this.id=id;
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(-speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setYDirection(-speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(-speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setYDirection(speedShip);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(speedShip);
            move();
        }
    }


    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setYDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setXDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setYDirection(0);
            move();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setXDirection(0);
            move();
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;

    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void move() {
        y = y + yVelocity;
        x = x + xVelocity;
    }
    public void draw(Graphics g) {
        if(id == 1)
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
