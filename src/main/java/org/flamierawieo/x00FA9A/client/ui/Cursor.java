package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.Options;
import org.flamierawieo.x00FA9A.client.input.InputDispatcher;
import org.flamierawieo.x00FA9A.client.input.InputListener;
import org.flamierawieo.x00FA9A.client.userskins.Skin;
import org.newdawn.slick.Image;

public class Cursor extends InputDispatcher {

    public Cursor(long glfwWindow, InputListener initialInputListener) {
        super(glfwWindow, initialInputListener);
    }

    /**
     *  TODO
     *  If player uses a custom skin, it should work.
     *  I hope i will make it, really. :')
     */

    Image cursor = null;

    boolean multipleStyles = Images.CURSOR_IMAGE.hasMultipleStyles();
    boolean customSkin;

    Skin skin = Options.getSkin();

}
