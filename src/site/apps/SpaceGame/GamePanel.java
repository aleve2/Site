package site.apps.SpaceGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.7777));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int SHIP_WIDTH = 30;
    static final int SHIP_HEIGHT = 50;
    static final int ENEMY_DIAMETER = 50;
    static final int POWER_DIAMETER = 10;

    public static Image backgroundImage;
    public static boolean alreadyExecuted = false;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    static Ship ship;
    Score score;
    PowerUps powerUps;
    Enemies enemies;
    Enemies2 enemies2;
    Enemies3 enemies3;
    Enemies4 enemies4;
    Enemies5 enemies5;
    Image ship1;

    public static Menu menu;
    public enum STATE{
        MENU,
        GAME
    }
    public static STATE State = STATE.MENU;

    GamePanel() {

        backgroundImage = new ImageIcon("stars.png").getImage();
        addMouseListener(new MouseInput());
        if (State == STATE.MENU){
            menu = new Menu();
            score = new Score(GAME_WIDTH, GAME_HEIGHT);
            this.setFocusable(true);
            this.addKeyListener(new AL());
            this.setOpaque(true);
            this.setPreferredSize(SCREEN_SIZE);
            ship1 = new ImageIcon("ship1.png").getImage();
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void newRound(){
        newShip();
        newEnemy();
        newPowerUp();
    }

    public void newGame(){
        newShip();
        newEnemy();
        newPowerUp();
        Ship.speedShip = 3;
        Enemies.initialSpeed = 7;
        Enemies2.initialSpeed = 7;
        Enemies3.initialSpeed = 7;
        Enemies4.initialSpeed = 7;
        Enemies5.initialSpeed = 7;
    }

    public void newPowerUp(){
        powerUps = new PowerUps(random.nextInt(GAME_HEIGHT - POWER_DIAMETER), random.nextInt(GAME_WIDTH - POWER_DIAMETER), POWER_DIAMETER, POWER_DIAMETER);
    }

    public void newEnemy(){
        random = new Random();
        enemies = new Enemies(random.nextInt(GAME_HEIGHT - ENEMY_DIAMETER), 60, ENEMY_DIAMETER, ENEMY_DIAMETER);
        enemies2 = new Enemies2(random.nextInt(GAME_HEIGHT - ENEMY_DIAMETER), 70, ENEMY_DIAMETER, ENEMY_DIAMETER);
        enemies3 = new Enemies3(random.nextInt(GAME_HEIGHT - ENEMY_DIAMETER), 20, ENEMY_DIAMETER, ENEMY_DIAMETER);
        enemies4 = new Enemies4(random.nextInt(GAME_HEIGHT - ENEMY_DIAMETER), 70, ENEMY_DIAMETER, ENEMY_DIAMETER);
        enemies5 = new Enemies5(random.nextInt(GAME_HEIGHT - ENEMY_DIAMETER), 20, ENEMY_DIAMETER, ENEMY_DIAMETER);
    }

    public void newShip(){
        ship = new Ship((GAME_WIDTH / 2),(GAME_HEIGHT - SHIP_HEIGHT),(SHIP_WIDTH),(SHIP_HEIGHT), 1);
    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        g.drawImage(backgroundImage, 500 , 500, null);
        draw(graphics);
        g.drawImage(image, 0, 0,this);
    }

    public void draw(Graphics g){

        if(State == STATE.GAME){

            ship.draw(g);
            score.draw(g);
            powerUps.draw(g);
            enemies.draw(g);
            enemies2.draw(g);
            enemies3.draw(g);
            enemies4.draw(g);
            enemies5.draw(g);

            Font fnt10 = new Font("arial", Font.BOLD, 20);
            g.setFont(fnt10);
            g.drawString("Back", 10,30);
            g.drawRect(8, 8, 50,30);


        } else if(State == STATE.MENU){
            menu.render(g);
        }



    }

    public void move() {

        if(!alreadyExecuted && State == STATE.GAME) {
            newShip();
            newEnemy();
            newPowerUp();
            alreadyExecuted = true;
        }
        if (alreadyExecuted && State == STATE.GAME) {

            score = new Score(GAME_WIDTH, GAME_HEIGHT);
            this.setFocusable(true);
            // (this.addKeyListener(new AL());)
            this.setPreferredSize(SCREEN_SIZE);
            // (gameThread = new Thread(this);)
            // (gameThread.start();)
            ship.move();
            enemies.move();
            enemies2.move();
            enemies3.move();
            enemies4.move();
            enemies5.move();
        }
    }

    public void checkCollision() {
        if (State == STATE.GAME) {

            if (enemies.y <= 0)
                enemies.setYDirection(-enemies.yVelocity);

            if (enemies.y >= GAME_HEIGHT - ENEMY_DIAMETER)
                enemies.setYDirection(-enemies.yVelocity);

            if (enemies.x <= 0)
                //enemies.setYDirection(enemies.yVelocity);
                enemies.setXDirection(-enemies.xVelocity);

            if (enemies.x >= GAME_WIDTH - ENEMY_DIAMETER)
                //enemies.setYDirection(enemies.yVelocity);
                enemies.setXDirection(-enemies.xVelocity);
            //Enemies 2

            if (enemies2.y <= 0)
                enemies2.setYDirection(-enemies2.yVelocity);

            if (enemies2.y >= GAME_HEIGHT - ENEMY_DIAMETER)
                enemies2.setYDirection(-enemies2.yVelocity);

            if (enemies2.x <= 0)
                //enemies.setYDirection(enemies.yVelocity);
                enemies2.setXDirection(-enemies2.xVelocity);

            if (enemies2.x >= GAME_WIDTH - ENEMY_DIAMETER)
                //enemies.setYDirection(enemies.yVelocity);
                enemies2.setXDirection(-enemies2.xVelocity);
            // Enemies 3

            if (enemies3.y <= 0)
                enemies3.setYDirection(-enemies3.yVelocity);

            if (enemies3.y >= GAME_HEIGHT - ENEMY_DIAMETER)
                enemies3.setYDirection(-enemies3.yVelocity);

            if (enemies3.x <= 0)
                //enemies.setYDirection(enemies.yVelocity);
                enemies3.setXDirection(-enemies3.xVelocity);

            if (enemies3.x >= GAME_WIDTH - ENEMY_DIAMETER)
                //enemies.setYDirection(enemies.yVelocity);
                enemies3.setXDirection(-enemies3.xVelocity);
            // Enemies 4
            if (enemies4.y <= 0)
                enemies4.setYDirection(-enemies4.yVelocity);

            if (enemies4.y >= GAME_HEIGHT - ENEMY_DIAMETER)
                enemies4.setYDirection(-enemies4.yVelocity);

            if (enemies4.x <= 0)
                //enemies.setYDirection(enemies.yVelocity);
                enemies4.setXDirection(-enemies4.xVelocity);

            if (enemies4.x >= GAME_WIDTH - ENEMY_DIAMETER)
                //enemies.setYDirection(enemies.yVelocity);
                enemies4.setXDirection(-enemies4.xVelocity);

            // Enemies 5
            if (enemies5.y <= 0)
                enemies5.setYDirection(-enemies5.yVelocity);

            if (enemies5.y >= GAME_HEIGHT - ENEMY_DIAMETER)
                enemies5.setYDirection(-enemies5.yVelocity);

            if (enemies5.x <= 0)
                //enemies.setYDirection(enemies.yVelocity);
                enemies5.setXDirection(-enemies5.xVelocity);

            if (enemies5.x >= GAME_WIDTH - ENEMY_DIAMETER)
                //enemies.setYDirection(enemies.yVelocity);
                enemies5.setXDirection(-enemies5.xVelocity);

            // Ship collision checks

            if (ship.y >= (GAME_HEIGHT - SHIP_HEIGHT)) {
                ship.y = GAME_HEIGHT - SHIP_HEIGHT;
            }
            if (ship.y <= 0) {
                Score.player1++;
                newRound();
            }

            if (ship.x <= 0) {
                ship.x = 0;
            }
            if (ship.x >= (GAME_WIDTH - SHIP_WIDTH)) {
                ship.x = GAME_WIDTH - SHIP_WIDTH;
            }

            // Enemies hitting Ship

            if (enemies.intersects(ship)) {
                newGame();
                Score.player1 = 1;
            }

            if (enemies2.intersects(ship)) {
                newGame();
                Score.player1 = 1;
            }

            if (enemies3.intersects(ship)) {
                newGame();
                Score.player1 = 1;
            }

            if (enemies4.intersects(ship)) {
                newGame();
                Score.player1 = 1;
            }

            if (enemies5.intersects(ship)) {
                newGame();
                Score.player1 = 1;
            }
            // Ship hitting power up

            if (powerUps.intersects(ship)) {
                Ship.speedShip++;
                Enemies.initialSpeed++;
                Enemies2.initialSpeed++;
                Enemies3.initialSpeed++;
                Enemies4.initialSpeed++;
                Enemies5.initialSpeed++;
                this.powerUps.setLocation(1200, 1200);
            }
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            ship.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            ship.keyReleased(e);
        }
    }
}
