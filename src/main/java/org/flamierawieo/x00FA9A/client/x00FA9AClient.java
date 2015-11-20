package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;

public class x00FA9AClient implements Game {

    private static x00FA9AClient instance;
    private String name;
    private Input input;
    private Graphics graphics;
    private ViewManager viewManager;

    // TODO: сделать ченить с этим
    private Image cursorImage;
    private float cursorOriginX;
    private float cursorOriginY;

    private x00FA9AClient(String name) {
        this.name = name;
    }

    public static x00FA9AClient getInstance() {
        if (instance == null) {
            instance = new x00FA9AClient("Beat Party");
        }
        return instance;
    }

    @Override
    public void init(GameContainer c) throws SlickException {
        input = c.getInput();
        graphics = c.getGraphics();
        View.setContainer(c);
        viewManager = ViewManager.getInstance(new StartMenu());
        input.addPrimaryListener(viewManager);
        cursorImage = Images.CURSOR_IMAGE.getImage();
        cursorOriginX = cursorImage.getWidth() / 2f;
        cursorOriginY = cursorImage.getHeight() / 2f;
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {
        viewManager.tick(delta / 1000);
    }

    @Override
    public void render(GameContainer c, Graphics g) throws SlickException {
        viewManager.draw(g);

        graphics.drawImage(cursorImage, input.getMouseX() - cursorOriginX, input.getMouseY() - cursorOriginY);
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

