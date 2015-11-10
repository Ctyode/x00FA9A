package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Widget implements KeyListener, MouseListener {

    private Widget parent;
    private GameContainer container;
    private Input input;
    private Image img;
    private float width, height;
    private float x, y;
    private float originX, originY;
    private Map<String, Set<EventListener>> eventListeners;


    public Widget(Widget parent, GameContainer container, Image img, float x, float y) {
        this.parent = parent;
        this.container = container;
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.originX = img.getWidth() / 2.0f;
        this.originY = img.getHeight() / 2.0f;
        this.x = x;
        this.y = y;
        eventListeners = new HashMap<>();
    }

    public void addEventListener(String eventType, EventListener listener) {
        if(eventListeners.containsKey(eventType)) {
            eventListeners.put(eventType, new HashSet<>());
        }
        eventListeners.get(eventType).add(listener);
    }

    public Image getImg() {
        return img;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getOriginX() {
        return originX;
    }

    public float getOriginY() {
        return originY;
    }

    public Image getImages() {
        return img;
    }

    public void draw() {
        img.draw(x, y);
    }

    @Override
    public void keyPressed(int i, char c) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("keyPressed")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.keyPressed(i, c);
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("keyReleased")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.keyReleased(i, c);
        }
    }

    @Override
    public void mouseWheelMoved(int i) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mouseWheelMoved")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mouseWheelMoved(i);
        }
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mouseClicked")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mouseClicked(i, i1, i2, i3);
        }
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mousePressed")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mousePressed(i, i1, i2);
        }
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mouseReleased")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mouseReleased(i, i1, i2);
        }
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mouseMoved")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mouseMoved(i, i1, i2, i3);
        }
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        boolean tossEventToParent = false;
        for(EventListener l : eventListeners.get("mouseDragged")) {
            tossEventToParent = tossEventToParent || l.onEvent(input);
        }
        if(tossEventToParent) {
            parent.mouseDragged(i, i1, i2, i3);
        }
    }

    @Override
    public void setInput(Input input) {
        this.input = input;
    }

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

}
