package org.flamierawieo.x00FA9A.client.input;

public interface InputListener {

    public void onKeyPress(int key, int scancode, int mods);
    public void onKeyRelease(int key, int scancode, int mods);
    public void onMouseButtonPress(int button, int mods, int x, int y);
    public void onMouseButtonRelease(int button, int mods, int x, int y);
    public void onMouseMove(int x, int y, int deltaX, int deltaY);

}
