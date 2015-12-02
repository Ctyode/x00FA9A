package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

public class Cursor implements Tickable, Drawable, MouseInputListener {

    private Sprite sprite;

    public Cursor() {
        sprite = new Sprite(Images.CURSOR_IMAGE.getTextureID(), 0.0f, 0.0f, 0.1f, 0.1f);
    }

    @Override
    public void onMouseMove(float x, float y) {
        sprite.move(x, y);
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {

    }

    @Override
    public void onMouseButtonUp(int button, int mods) {

    }

    @Override
    public void draw() {
        sprite.draw();
    }

    @Override
    public void tick(float delta) {

    }

}