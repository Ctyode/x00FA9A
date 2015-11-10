package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

import java.util.Stack;

public class ViewManager implements KeyListener, MouseListener {

    private Stack<View> viewStack;
    private View currentView;

    public ViewManager(View rootView) {
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
    }

    public View popView() {
        View lastCurrentView = currentView;
        viewStack.pop();
        currentView = viewStack.peek();
        return lastCurrentView;
    }

    public View peekView() {
        return currentView;
    }

    public View pushView(View view) {
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
    public void setInput(Input input) {
        // wtf for i dunno lol
    }

    @Override
    public boolean isAcceptingInput() {
        return true; // cus i dont give even a single fuck
    }

    @Override
    public void inputEnded() {
        // idk lol
    }

    @Override
    public void inputStarted() {
        // ofc lol
    }

}