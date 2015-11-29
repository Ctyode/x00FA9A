package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.views.StartMenu;

import java.util.Stack;

public class ViewManager {

    private static ViewManager instance = new ViewManager(new StartMenu());
    private static Stack<View> viewStack;
    private static View currentView;

    public static ViewManager getInstance() {
        return instance;
    }

    private ViewManager(View rootView) {
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
    }

    public static View popView() {
        View lastCurrentView = currentView;
        viewStack.pop();
        currentView = viewStack.peek();
        return lastCurrentView;
    }

    public static View peekView() {
        return currentView;
    }

    public static View pushView(View view) {
        currentView = view;
        viewStack.push(view);
        return currentView;
    }

    public static void draw() {
        currentView.draw();
    }

    public static void tick(double delta) {
        currentView.tick(delta);
    }

}
