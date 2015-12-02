package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.KeyInputListener;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

public class Widget implements Drawable, Tickable, KeyInputListener, MouseInputListener {

    private float x;
    private float y;
    private float width;
    private float height;

    public Widget(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {

    }

    @Override
    public void onKeyUp(int key, int scancode, int mods) {

    }

    @Override
    public void onMouseMove(float x, float y) {

    }

    @Override
    public void onMouseButtonDown(int button, int mods) {

    }

    @Override
    public void onMouseButtonUp(int button, int mods) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void tick(float delta) {

    }

}
