package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

public class Vertex {

    public final float x;
    public final float y;
    public final Color color;

    public Vertex(float x, float y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
        color = null;
    }

}
