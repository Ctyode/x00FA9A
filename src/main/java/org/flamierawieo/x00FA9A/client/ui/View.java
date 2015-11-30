package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.KeyInputListener;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import java.util.ArrayList;
import java.util.List;

public class View implements Tickable, Drawable, KeyInputListener, MouseInputListener {

    protected List<Widget> widgets;
    protected int xMousePosition;
    protected int yMousePosition;

    public View() {
        widgets = new ArrayList<>();
    }

    private Widget getHoveredWidget() {
        Widget hoveredWidget;
        for(int i = widgets.size() - 1; i >= 0; --i) {
            hoveredWidget = widgets.get(i);
            float widgetX = hoveredWidget.getAbsoluteX();
            float widgetY = hoveredWidget.getAbsoluteY();
            if(xMousePosition >= widgetX && yMousePosition >= widgetY && xMousePosition <= widgetX + hoveredWidget.getWidth() && yMousePosition <= widgetY + hoveredWidget.getHeight()) {
                return hoveredWidget;
            }
        }
        return null;
    }

    public void addWidget(Widget widget) {
        widgets.add(widget);
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onKeyDown(key, scancode, mods);
        }
    }

    @Override
    public void onKeyUp(int key, int scancode, int mods) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onKeyUp(key, scancode, mods);
        }
    }

    @Override
    public void onMouseMove(float x, float y) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onMouseMove(x, y);
        }
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onMouseButtonDown(button, mods);
        }
    }

    @Override
    public void onMouseButtonUp(int button, int mods) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onMouseButtonUp(button, mods);
        }
    }

    @Override
    public void draw() {
        widgets.forEach(Widget::draw);
    }

    @Override
    public void tick(float delta) {
        widgets.forEach(w -> w.tick(delta));
    }

}
