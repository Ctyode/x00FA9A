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
    private float originX;
    private float originY;
    private float absolutePositionX;
    private float absolutePositionY;

    public static float calculateAbsolutePosition(float position, float length, float origin) {
        return position - length * origin;
    }

    public Widget(float x, float y, float width, float height, float originX, float originY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.originX = originX;
        this.originY = originY;
        updateAbsolutePosition();
    }

    public Widget(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    private void updateAbsolutePosition() {
        absolutePositionX = calculateAbsolutePosition(x, width, originX);
        absolutePositionY = calculateAbsolutePosition(y, height, originY);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        updateAbsolutePosition();
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        updateAbsolutePosition();
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updateAbsolutePosition();
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        updateAbsolutePosition();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        updateAbsolutePosition();
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
        updateAbsolutePosition();
    }

    public float getOriginX() {
        return originX;
    }

    public void setOriginX(float originX) {
        this.originX = originX;
        updateAbsolutePosition();
    }

    public float getOriginY() {
        return originY;
    }

    public void setOriginY(float originY) {
        this.originY = originY;
        updateAbsolutePosition();
    }

    public void setOrigin(float originX, float originY) {
        this.originX = originX;
        this.originY = originY;
        updateAbsolutePosition();
    }

    public float getAbsolutePositionX() {
        return absolutePositionX;
    }

    public float getAbsolutePositionY() {
        return absolutePositionY;
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
    public void onMouseButtonDown(float x, float y, int button, int mods) {

    }

    @Override
    public void onMouseButtonUp(float x, float y, int button, int mods) {

    }

    @Override
    public void onScroll(float x, float y, double scrollX, double scrollY) {

    }


    @Override
    public void draw() {

    }

    @Override
    public void tick(float delta) {

    }

}
