package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.shared.Tickable;

import java.util.ArrayList;
import java.util.List;

public class View implements Tickable, Drawable {

    protected static ViewManager viewManager;
    protected List<Widget> widgets;

    public static ViewManager getViewManager() {
        return viewManager;
    }

    public static void setViewManager(ViewManager viewManager) {
        View.viewManager = viewManager;
    }

    public View() {
        widgets = new ArrayList<>();
    }

    private Widget getHoveredWidget() {
        Widget hoveredWidget;
        float mouseXPosition = 0; // what the fuck
        float mouseYPosition = 0; // what the fuck
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
    public void draw() {
        widgets.forEach(Widget::draw);
    }

    @Override
    public void tick(double delta) {
        widgets.forEach(w -> w.tick(delta));
    }

}
