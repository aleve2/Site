package site.SpaceGame;

import java.awt.*;

public class Score extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    static int player1 = 1;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN,50));
        g.drawString("Level " + String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_WIDTH / 2) + 270, 50);
    }
}
