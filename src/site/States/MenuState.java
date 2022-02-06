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


        uiManager.addObject(new UIImageButton(handler.getWidth() /2 - 100, 250, 200, 60, SitePanel.start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getSite().homeState);
                System.out.println("test123");
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
        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Aaron's Apps", (SitePanel.SCREEN_WIDTH / 2) + 50, 150);

        uiManager.render(g);
    }
}
