package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.InputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import java.util.Stack;

public class ViewManager implements Tickable, Drawable, InputListener {

    private Stack<View> viewStack;
    private View currentView;

    public ViewManager(View rootView) {
        currentView = rootView;
        viewStack = new Stack<>();
        viewStack.push(rootView);
    }

    public View pushView(View view) {
        viewStack.push(view);
        currentView = view;
        return currentView;
    }

    public View peekView() {
        return currentView;
    }

    public View popView() {
        View oldView = viewStack.pop();
        currentView = viewStack.peek();
        return oldView;
    }

    @Override
    public void onKeyPress(int key, int scancode, int mods) {
        currentView.onKeyPress(key, scancode, mods);
    }

    @Override
    public void onKeyRelease(int key, int scancode, int mods) {
        currentView.onKeyRelease(key, scancode, mods);
    }

    @Override
    public void onMouseButtonPress(int button, int mods, int x, int y) {
        currentView.onMouseButtonPress(button, mods, x, y);
    }

    @Override
    public void onMouseButtonRelease(int button, int mods, int x, int y) {
        currentView.onMouseButtonRelease(button, mods, x, y);
    }

    @Override
    public void onMouseMove(int x, int y, int deltaX, int deltaY) {
        currentView.onMouseMove(x, y, deltaX, deltaY);
    }

    @Override
    public void draw() {
        currentView.draw();
    }

    @Override
    public void tick(double delta) {
        currentView.tick(delta);
    }

}
