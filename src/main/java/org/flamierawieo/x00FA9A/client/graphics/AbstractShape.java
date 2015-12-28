package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

public abstract class AbstractShape {

    protected Color backgroundColor;
    protected Color borderColor;
    protected float borderThickness;

    public AbstractShape(Color backgroundColor, Color borderColor, float borderThickness) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
    }

}