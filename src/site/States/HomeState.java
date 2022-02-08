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
                Handler.isHome = false;
            }
        }));

        // Space Game Button
        uiManager.addObject(new UIImageButton(263, 400, 165, 212, SitePanel.spaceInvadersHome, new ClickListener() {
            @Override
            public void onClick() {
                GameFrame frame = new GameFrame();
                Handler.isHome = false;
            }
        }));

        // Pong Button
        uiManager.addObject(new UIImageButton(243, 650, 200, 110, SitePanel.pongHome, new ClickListener() {
            @Override
            public void onClick() {
                GameFrame2 frame2 = new GameFrame2();
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
        g.setColor(Color.ORANGE);
        g.fillRect((SitePanel.SCREEN_WIDTH / 2) + 10, 60, 610, 130);

        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Aaron's Apps", (SitePanel.SCREEN_WIDTH / 2) + 60, 150);

        // Games Title
        g.setColor(Color.darkGray);
        g.fillRect(250, 300, 190, 70);

        Font fnt1 = new Font("arial", Font.BOLD, 40);
        g.setFont(fnt1);
        g.setColor(Color.ORANGE);
        g.drawString("Games", 280, 350);


    }
}


