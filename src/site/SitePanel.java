package site;

import site.Display.Display;
import site.States.HomeState;
import site.States.MenuState;
import site.States.SpaceState;
import site.States.State;
import site.gfx.ImageLoader;
import site.input.MouseManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SitePanel implements Runnable {
    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = (int)(SCREEN_WIDTH * (0.7777));
    public static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    public static int PLAYER_DIAMETER = 10;

    Display display;
    public String title;
    private int width;
    private int height;

    Thread gameThread;
    Image image;
    Random random;

    // Inputs
    private MouseManager mouseManager;

    // Handler
    private Handler handler;

    private boolean running = false;
    private Thread thread;
    private Graphics g;
    private BufferStrategy bs;

    public static BufferedImage[] start;
    public static BufferedImage[] back;

    public static BufferedImage[] spaceInvadersHome;
    public static BufferedImage[] pongHome;
    public static BufferedImage[] mortgageHome;

    static int timeCheck = 0;
    public static boolean alreadyExecuted = false;

// States
    public static MenuState menuState;
    public static HomeState homeState;
    public static SpaceState spaceState;


// ---------------------------------------------------------------------------------------------------------------------

    SitePanel(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        mouseManager = new MouseManager();
    }

    public void init() {

        display = new Display(title, width, height);
        // display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        //Homepage Images
        spaceInvadersHome = new BufferedImage[2];
        spaceInvadersHome[0] = ImageLoader.loadImage("/textures/SpaceHome1.PNG");
        spaceInvadersHome[1] = ImageLoader.loadImage("/textures/SpaceHome2.PNG");

        pongHome = new BufferedImage[2];
        pongHome[0] = ImageLoader.loadImage("/textures/PongImage1.PNG");
        pongHome[1] = ImageLoader.loadImage("/textures/PongImage2.png");

        mortgageHome = new BufferedImage[2];
        mortgageHome[0] = ImageLoader.loadImage("/textures/Mortgage1.png");
        mortgageHome[1] = ImageLoader.loadImage("/textures/Mortgage2.png");

        //Start
        start = new BufferedImage[2];
        start[0] = ImageLoader.loadImage("/textures/StartButton1.png");
        start[1] = ImageLoader.loadImage("/textures/StartButton2.png");

        //Back
        back = new BufferedImage[2];
        back[0] = ImageLoader.loadImage("/textures/backbutton1.png");
        back[1] = ImageLoader.loadImage("/textures/backbutton2.png");


        //STATE

        handler = new Handler(this);

        menuState = new MenuState(handler);
        homeState = new HomeState(handler);
        spaceState = new SpaceState(handler);
        State.setState(menuState);

    }




/*
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        g = image.getGraphics();
        draw(g);
        g.drawImage(image, 0, 0,this);


    }

 */

    public void draw(Graphics g){

        if(State.getState().equals(menuState)){
            menuState.render(g);
        }
    }

    public void move() {

    }

    private void tick() {
        // keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0,0,width,height);
        // Draw here

        if (State.getState() != null) {
            State.getState().render(g);
        }

        // End drawing
        bs.show();
        g.dispose();

    }



    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }
        try {
            stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() throws InterruptedException {
        if(!running){
            return;
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


   /*

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            // ship.keyPressed(e);

        }

        public void keyReleased(KeyEvent e) {
            //  ship.keyReleased(e);

        }
    }

    */

