package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.newdawn.slick.*;

import java.util.Stack;

public class ViewManager implements InputListener {

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

    @Override
    public void keyPressed(int i, char c) {
        currentView.keyPressed(i, c);
    }

    @Override
    public void keyReleased(int i, char c) {
        currentView.keyReleased(i, c);
    }

    @Override
    public void mouseWheelMoved(int i) {
        currentView.mouseWheelMoved(i);
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        currentView.mouseClicked(i, i1, i2, i3);
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        currentView.mousePressed(i, i1, i2);
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        currentView.mouseReleased(i, i1, i2);
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        currentView.mouseMoved(i, i1, i2, i3);
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        currentView.mouseDragged(i, i1, i2, i3);
    }

    @Override
    public void setInput(Input input) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public boolean isAcceptingInput() {
        return true; // cus i dont give even a single fuck
    }

    @Override
    public void inputEnded() { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void inputStarted() { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerLeftPressed(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerLeftReleased(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerRightPressed(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerRightReleased(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerUpPressed(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerUpReleased(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerDownPressed(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerDownReleased(int i) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerButtonPressed(int i, int i1) { /* ¯\_(ツ)_/¯ */ }

    @Override
    public void controllerButtonReleased(int i, int i1) { /* ¯\_(ツ)_/¯ */ }

    public static void draw(Graphics g) {
        currentView.draw(g);
    }

    public static void tick(double delta) {
        currentView.tick(delta);
    }

}
