package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.Drawable;
import org.flamierawieo.x00FA9A.client.Tickable;
import org.newdawn.slick.*;

public class Widget implements Tickable, Drawable, KeyListener, MouseListener {

    private GameContainer container;
    private float x;
    private float y;
    private float absoluteX;
    private float absoluteY;
    private float width;
    private float height;
    private float originX;
    private float originY;

    public Widget(float x, float y, float w, float h, float originX, float originY) {
        container = View.getContainer();
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        this.originX = originX;
        this.originY = originY;
        calculateAbsolutePosition();
    }

    private void calculateAbsolutePosition() {
        absoluteX = x * container.getWidth() - originX * width;
        absoluteY = y * container.getHeight() - originY * height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        calculateAbsolutePosition();
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        calculateAbsolutePosition();
    }

    public float getAbsoluteX() {
        return absoluteX;
    }

    public float getAbsoluteY() {
        return absoluteY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
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
