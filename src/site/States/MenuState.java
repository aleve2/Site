package site.States;

import site.Handler;
import site.SitePanel;
import site.ui.ClickListener;
import site.ui.UIImageButton;
import site.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);

        // Start Button
        // Old y: 250
        uiManager.addObject(new UIImageButton(handler.getWidth() /2 - 100, 300, 200, 80, SitePanel.start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getSite().homeState);
                // System.out.println("test123");
                Handler.isHome = true;
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
        if(!Handler.isHome) {
            handler.getMouseManager().setUiManager(uiManager);
        }
    }

    @Override
    public void render(Graphics g) {

        // Title
        g.setColor(Color.ORANGE);
        g.fillRect((SitePanel.SCREEN_WIDTH / 2) + 10, 60, 610, 130);

        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Aaron's Apps", (SitePanel.SCREEN_WIDTH / 2) + 60, 150);

        Font fnt3 = new Font("Ink Free", Font.BOLD, 30);
        g.setFont(fnt3);
        g.setColor(Color.black);
        g.drawString("Welcome to my Site. This is where I put all my old and new projects." +
                " Press Start to begin!", (SitePanel.SCREEN_WIDTH / 2) - 270, 250);

        uiManager.render(g);
    }
}
