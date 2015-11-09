package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.Options;
import org.flamierawieo.x00FA9A.client.Util;
import org.flamierawieo.x00FA9A.client.userskins.Skin;

import org.flamierawieo.x00FA9A.x00FA9A;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class Cursor  {

    private static GameContainer container;
    private static StateBasedGame game;
    private static Input input;

    public Cursor() {}

    public void draw() {
        int state = game.getCurrentStateID();
        boolean mousePressed = (state == x00FA9A.VIEW_GAME && Util.isMousePressed()) ||
                (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) ||
                 input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);

        draw(input.getMouseX(), input.getMouseY(), mousePressed);

    }

    public void draw(int mouseX, int mouseY, boolean mousePressed) {

        Image cursor = null;

        /**
         *  TODO
         *  If player uses a custom skin, it should work.
         *  I hope i will make it, really. :')
         */

        boolean multipleStyles = Images.CURSOR_IMAGE.hasMultipleStyles();
        boolean customSkin;

        Skin skin = Options.getSkin();

        if (multipleStyles) {
            customSkin = true;
        } else {
            cursor = Images.CURSOR_IMAGE.getImage();
        }

    }

    public boolean isStyled() {
        return (Images.CURSOR_IMAGE.hasMultipleStyles());
    }

}
