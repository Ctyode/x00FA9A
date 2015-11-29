package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;

public class x00FA9AClient implements Game {

    private static x00FA9AClient instance = new x00FA9AClient("Beat Party");
    private static String name;
    private static GameContainer gameContainer;
    private static Input input;

    // TODO: сделать ченить с этим
    private static Image cursorImage;
    private static float cursorOriginX;
    private static float cursorOriginY;
    private static Image basicBackgroundImg;

    public static x00FA9AClient getInstance() {
        return instance;
    }

    private x00FA9AClient(String n) {
        name = n;
    }

    @Override
    public void init(GameContainer c) throws SlickException {
        gameContainer = c;
        input = c.getInput();
        input.addPrimaryListener(ViewManager.getInstance());
        cursorImage = Images.CURSOR_IMAGE.getImage();
        cursorOriginX = cursorImage.getWidth() / 2f;
        cursorOriginY = cursorImage.getHeight() / 2f;
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();
        basicBackgroundImg = Images.BASIC_BACKGROUND.getImage();
    }

    public static GameContainer getGameContainer() {
        return gameContainer;
    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public void render(GameContainer c, Graphics g) throws SlickException {
        g.drawImage(basicBackgroundImg, 0.0f, 0.0f);
        ViewManager.draw(g);
        g.drawImage(cursorImage, input.getMouseX() - cursorOriginX, input.getMouseY() - cursorOriginY);
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {
        ViewManager.tick(delta / 1000);
    }

}
