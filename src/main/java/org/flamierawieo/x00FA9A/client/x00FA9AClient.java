package org.flamierawieo.x00FA9A.client;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class x00FA9AClient extends StateBasedGame implements Game {

    private static x00FA9AClient instance;

    public x00FA9AClient(String name) {
        super(name);
    }

    public static x00FA9AClient getInstance() {
        if (instance == null) {
            instance = new x00FA9AClient("Vriv");
        }
        return instance;
    }



    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public boolean closeRequested() {
        return false;
    }

    @Override
    public String getTitle() {
        return null;
    }


}

