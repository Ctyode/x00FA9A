package org.flamierawieo.x00FA9A.client.input;

public interface MouseInputListener {

    void onMouseMove(float x, float y);
    void onMouseButtonDown(float x, float y, int button, int mods);
    void onMouseButtonUp(float x, float y, int button, int mods);
    void onScroll(float x, float y, double scrollX, double scrollY);

}
