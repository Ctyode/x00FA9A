package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Widget;

public class Background extends Widget {

    private Sprite sprite;

    public Background(Sprite sprite, float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        this.sprite = sprite;
    }

    public Background(Sprite sprite, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.sprite = sprite;
    }

    @Override
    public void draw() {
        sprite.draw(getAbsolutePositionX(), getAbsolutePositionY(), getWidth(), getHeight());
    }

}
