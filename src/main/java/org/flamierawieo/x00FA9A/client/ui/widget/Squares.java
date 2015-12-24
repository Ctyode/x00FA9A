package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Widget;

public class Squares extends Widget {

    private Sprite buttonsBackground;
    private Sprite[] greenButton;

    public Squares(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        greenButton = new Sprite[] {
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture()),
                new Sprite(Images.BUTTONS_BACKGROUND.getTexture())
        };

    }

    public Squares(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }
}
