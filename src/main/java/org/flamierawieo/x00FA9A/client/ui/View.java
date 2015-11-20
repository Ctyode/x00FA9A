package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.Drawable;
import org.flamierawieo.x00FA9A.client.Tickable;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class View implements Tickable, Drawable, KeyListener, MouseListener {

    protected static ViewManager viewManager;
    protected static GameContainer container;
    protected static Input input;
    protected List<Widget> widgets;

    public static ViewManager getViewManager() {
        return viewManager;
    }

    public static void setViewManager(ViewManager viewManager) {
        View.viewManager = viewManager;
    }

    public static GameContainer getContainer() {
        return container;
    }

    public static void setContainer(GameContainer container) {
        View.container = container;
        input = container.getInput();
    }

    public View() {
        widgets = new ArrayList<>();
    }

    private Widget getHoveredWidget() {
        Widget hoveredWidget;
        float mouseXPosition = input.getMouseX();
        float mouseYPosition = input.getMouseY();
        for(int i = widgets.size() - 1; i >= 0; --i) {
            hoveredWidget = widgets.get(i);
            float widgetX = hoveredWidget.getAbsoluteX();
            float widgetY = hoveredWidget.getAbsoluteY();
            if(mouseXPosition >= widgetX && mouseYPosition >= widgetY && mouseXPosition <= widgetX + hoveredWidget.getWidth() && mouseYPosition <= widgetY + hoveredWidget.getHeight()) {
                return hoveredWidget;
            }
        }
        return null;
    }

    public void addWidget(Widget widget) {
        widgets.add(widget);
    }

    @Override
    public void keyPressed(int i, char c) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.keyPressed(i, c);
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.keyReleased(i, c);
        }
    }

    @Override
    public void mouseWheelMoved(int i) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mouseWheelMoved(i);
        }
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mouseClicked(i, i1, i2, i3);
        }
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mousePressed(i, i1, i2);
        }
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mouseReleased(i, i1, i2);
        }
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mouseMoved(i, i1, i2, i3);
        }
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        Widget hoveredWidget = getHoveredWidget();
        if(hoveredWidget != null) {
            hoveredWidget.mouseDragged(i, i1, i2, i3);
        }
    }

    @Override
    public void setInput(Input input) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
        // ayy lmao
    }

    @Override
    public void inputStarted() {
        // ayy lmao
    }

    @Override
    public void draw(Graphics g) {
        widgets.forEach(w -> w.draw(g));
    }

    @Override
    public void tick(double delta) {
        widgets.forEach(w -> w.tick(delta));
    }

}
