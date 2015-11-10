package org.flamierawieo.x00FA9A.client;

import org.newdawn.slick.*;


public class x00FA9AClient implements Game {

    private static x00FA9AClient instance;
    private String name;
    private Input input;

    public x00FA9AClient(String name) {
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
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer c, Graphics g) throws SlickException {

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

