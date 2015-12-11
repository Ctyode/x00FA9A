package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.KeyInputListener;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View implements Tickable, Drawable, KeyInputListener, MouseInputListener {

    private Map<Integer, String> actionMap;

    protected List<Widget> widgets;
    protected float xMousePosition;
    protected float yMousePosition;

    public View() {
        actionMap = new HashMap<>();
        widgets = new ArrayList<>();
    }

    private Widget getHoveredWidget() {
        Widget hoveredWidget;
        for(int i = widgets.size() - 1; i >= 0; --i) {
            hoveredWidget = widgets.get(i);
            float widgetX = hoveredWidget.getAbsolutePositionX();
            float widgetY = hoveredWidget.getAbsolutePositionY();
            if(xMousePosition >= widgetX &&
               yMousePosition >= widgetY &&
               xMousePosition <= widgetX + hoveredWidget.getWidth() &&
               yMousePosition <= widgetY + hoveredWidget.getHeight()) {
                return hoveredWidget;
            }
        }
        return null;
    }

    public void addWidget(Widget widget) {
        widgets.add(widget);
    }

    /**
     * Invokes when View Manager starts this view
     * @param viewManager view manager this view has started on
     */
    public void onViewStarted(ViewManager viewManager) {

    }

    /**
     * Invokes when View Manager pauses this view
     * @param viewManager view manager this view has paused on
     */
    public void onViewPaused(ViewManager viewManager) {

    }

    /**
     * Invokes when View Manager stops this view
     * @param viewManager view manager this view has stopped on
     */
    public void onViewStopped(ViewManager viewManager) {

    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        Widget hoveredWidget = getHoveredWidget();
        // коммент для тупых дебилов, чтобы даже тупой down понял
        if(hoveredWidget != null) {
            hoveredWidget.onKeyDown(key, scancode, mods);
        }
        String action = actionMap.get(key);
        if(action != null) {
            onAction(action);
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
        xMousePosition = x;
        yMousePosition = y;
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
    public void onScroll(double x, double y) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.onScroll(x, y);
        }
    }

    public void bindOnKeyDownAction(int key, String action) {
        actionMap.put(key, action);
    }

    public void onAction(String action) {

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
