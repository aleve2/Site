package site;

import site.States.State;
import site.input.MouseManager;

public class Handler {

    public static boolean isHome = false;

    private SitePanel sitePanel;

    public Handler(SitePanel sitePanel) { this.sitePanel = sitePanel;}

    public MouseManager getMouseManager() {
        return sitePanel.getMouseManager();
    }

    public int getWidth() {
        return sitePanel.getWidth();
    }

    public int getHeight() {
        return sitePanel.getHeight();
    }

    public SitePanel getSite() {
        return sitePanel;
    }

    public void setSite(SitePanel sitePanel) {
        this.sitePanel = sitePanel;
    }


}
