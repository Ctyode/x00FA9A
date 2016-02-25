package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.KeyInputListener;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import java.util.ArrayList;
import java.util.List;

public class View implements Tickable, Drawable, KeyInputListener, MouseInputListener {

    public Boolean isHovered(Widget widget, float xMousePosition, float yMousePosition) {
        float widgetX = widget.getAbsolutePositionX();
        float widgetY = widget.getAbsolutePositionY();
        return (xMousePosition >= widgetX &&
           yMousePosition >= widgetY &&
           xMousePosition <= widgetX + widget.getWidth() &&
           yMousePosition <= widgetY + widget.getHeight());
    }

    /**
     * Invokes when View Manager starts this view
     */
    public void onViewStarted() {

    }

    /**
     * Invokes when View Manager pauses this view
     */
    public void onViewPaused() {

    }

    /**
     * Invokes when View Manager stops this view
     */
    public void onViewStopped() {

    }


    @Override
    public void draw() {

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
    public void tick(float delta) {

    }
}
