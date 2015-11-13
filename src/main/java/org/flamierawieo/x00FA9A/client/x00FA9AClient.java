package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;

public class x00FA9AClient implements Game {

    private static x00FA9AClient instance;
    private String name;
    private Input input;
    private Graphics graphics;
    private ViewManager viewManager;

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
        graphics = c.getGraphics();
        viewManager = new ViewManager(new StartMenu(c));
        input.addPrimaryListener(viewManager);
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {
        viewManager.tick(delta / 1000);
    }

    public int mousePositionX() {
        int mouseX = Mouse.getX();
        return mouseX;
    }

    public int mousePositionY() {
        int mouseY = Mouse.getY();
        return mouseY;
    }

    @Override
    public void render(GameContainer c, Graphics g) throws SlickException {
        viewManager.draw(g);

        graphics.drawImage(Images.CURSOR_IMAGE.getImage(),
                mousePositionX() - Images.CURSOR_IMAGE.getImage().getWidth() / 2f,
                c.getHeight() - mousePositionY() - Images.CURSOR_IMAGE.getImage().getHeight() / 2f
        );
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

