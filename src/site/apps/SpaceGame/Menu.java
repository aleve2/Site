package site.apps.SpaceGame;

import java.awt.*;
import java.util.Random;

public class Menu {

    public Rectangle playButton = new Rectangle((GamePanel.GAME_WIDTH / 2) - 50, 200, 100, 50);
    public Rectangle helpButton = new Rectangle((GamePanel.GAME_WIDTH / 2) - 50, 300, 100, 50);
    public Rectangle quitButton = new Rectangle((GamePanel.GAME_WIDTH / 2) - 50, 400, 100, 50);

    Random random;
    public void render(Graphics g) {
        random = new Random();

        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Space Game", (GamePanel.GAME_WIDTH / 2) - 150, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play", playButton.x + 19, playButton.y + 35);
        g2d.draw(playButton);
        g.setFont(fnt1);
        g.drawString("Help", helpButton.x + 19, helpButton.y + 35);
        g2d.draw(helpButton);
        g.setFont(fnt1);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 35);
        g2d.draw(quitButton);


        g.setColor(Color.white);
        g.drawOval(random.nextInt(GamePanel.GAME_WIDTH), random.nextInt(GamePanel.GAME_HEIGHT), 2,2);

        g.setColor(Color.white);
        g.drawOval(random.nextInt(GamePanel.GAME_WIDTH), random.nextInt(GamePanel.GAME_HEIGHT), 2,2);

        g.setColor(Color.white);
        g.drawOval(random.nextInt(GamePanel.GAME_WIDTH), random.nextInt(GamePanel.GAME_HEIGHT), 2,2);

        g.setColor(Color.white);
        g.drawOval(random.nextInt(GamePanel.GAME_WIDTH), random.nextInt(GamePanel.GAME_HEIGHT), 2,2);

        g.setColor(Color.white);
        g.drawOval(random.nextInt(GamePanel.GAME_WIDTH), random.nextInt(GamePanel.GAME_HEIGHT), 2,2);

    }
}
