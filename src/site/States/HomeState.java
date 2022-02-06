package site.States;

import site.Handler;
import site.PONG.GameFrame2;
import site.SitePanel;
import site.SpaceGame.GameFrame;
import site.ui.ClickListener;
import site.ui.UIImageButton;
import site.ui.UIManager;

import java.awt.*;

public class HomeState extends State{

    public Rectangle gamesRect = new Rectangle(580, 350, 100, 100);


    private final UIManager uiManager;

    public HomeState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);

        // Back button
        uiManager.addObject(new UIImageButton(10, 10, 200, 60, SitePanel.back, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(SitePanel.menuState);
                System.out.println("test1234");
                Handler.isHome = false;
            }
        }));

        // Space Game Button
        uiManager.addObject(new UIImageButton(563, 400, 165, 212, SitePanel.spaceInvadersHome, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);

                GameFrame frame = new GameFrame();

                handler.getMouseManager().setUiManager(uiManager);

                System.out.println("test12345");
                Handler.isHome = false;

            }
        }));

        // Pong Button
        uiManager.addObject(new UIImageButton(503, 700, 200, 90, SitePanel.pongHome, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);

                GameFrame2 frame2 = new GameFrame2();

                handler.getMouseManager().setUiManager(uiManager);

                System.out.println("test123455");
                Handler.isHome = false;
                Handler.isPong = true;

            }
        }));


    }

    @Override
    public void tick() {
        uiManager.tick();

        if(Handler.isHome) {
            handler.getMouseManager().setUiManager(uiManager);

        }
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

        // Title
        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Aaron's Apps", (SitePanel.SCREEN_WIDTH / 2) + 50, 150);

        // Games Title
        g.setColor(Color.darkGray);
        g.fillRect(550, 300, 190, 70);

        Font fnt1 = new Font("arial", Font.BOLD, 40);
        g.setFont(fnt1);
        g.setColor(Color.ORANGE);
        g.drawString("Games", 580, 350);


    }
}


