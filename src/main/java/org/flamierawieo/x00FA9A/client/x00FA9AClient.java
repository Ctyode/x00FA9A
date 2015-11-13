package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.newdawn.slick.*;

public class x00FA9AClient implements Game {

    private static x00FA9AClient instance;
    private String name;
    private Input input;
    private Graphics graphics;
    private ViewManager viewManager;

    private x00FA9AClient(String name) {
        this.name = name;
    }

    public static x00FA9AClient getInstance() {
        if (instance == null) {
            instance = new x00FA9AClient("Vriv");
        }
        return instance;
    }

    @Override
    public void init(GameContainer c) throws SlickException {
        input = c.getInput();
        graphics = c.getGraphics();
        viewManager = new ViewManager(new StartMenu(c));
        input.addPrimaryListener(viewManager);
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {
        viewManager.tick(delta / 1000);
    }

    @Override
    public void render(GameContainer c, Graphics g) throws SlickException {
        viewManager.draw(g);
    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    @Override
    public String getTitle() {
        return name;
    }

}

