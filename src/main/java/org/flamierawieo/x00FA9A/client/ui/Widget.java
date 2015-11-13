package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.Drawable;
import org.flamierawieo.x00FA9A.client.Tickable;
import org.newdawn.slick.*;

public class Widget implements Tickable, Drawable, KeyListener, MouseListener {

    private float x;
    private float y;
    private float width;
    private float height;
    private float originX;
    private float originY;

    public Widget(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        originX = x + width / 2.0f;
        originY = y + height / 2.0f;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        originX = x + width / 2.0f;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        originY = y + height / 2.0f;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        originX = x + width / 2.0f;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        originY = y + height / 2.0f;
    }

    public float getOriginY() {
        return originY;
    }

    public float getOriginX() {
        return originX;
    }

    @Override
    public void keyPressed(int i, char c) {
        // so that we can override it later
    }

    @Override
    public void keyReleased(int i, char c) {
        // so that we can override it later
    }

    @Override
    public void mouseWheelMoved(int i) {
        // so that we can override it later
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        // so that we can override it later
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        // so that we can override it later
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        // so that we can override it later
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        // so that we can override it later
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        // so that we can override it later
    }

    @Override
    public void setInput(Input input) {
        // lol
    }

    @Override
    public boolean isAcceptingInput() {
        return true; // lol
    }

    @Override
    public void inputEnded() {
        // LOL
    }

    @Override
    public void inputStarted() {
        // LOL
    }

    @Override
    public void draw(Graphics g) {
        // so that we can override it later
    }

    @Override
    public void tick(double delta) {
        // so that we can override it later
    }

}
