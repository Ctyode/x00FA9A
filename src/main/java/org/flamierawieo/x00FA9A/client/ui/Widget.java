package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.KeyInputListener;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

public class Widget implements Drawable, Tickable, KeyInputListener, MouseInputListener {

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public int getAbsoluteX() {
        return 0;
    }

    public int getAbsoluteY() {
        return 0;
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {

    }

    @Override
    public void onKeyUp(int key, int scancode, int mods) {

    }

    @Override
    public void onMouseMove(double x, double y) {

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
    public void tick(double delta) {

    }

}
