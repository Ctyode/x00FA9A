package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Widget;

public class Squares extends Widget {

    private Sprite buttonsBackground;
    private Sprite greenButtonSprite;
    private Sprite pinkButtonSprite;
    private boolean[] buttonState;

    public Squares(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        buttonsBackground = new Sprite(Images.BUTTONS_BACKGROUND.getTexture());
        greenButtonSprite = new Sprite(Images.GREEN_BUTTON.getTexture());
        pinkButtonSprite = new Sprite(Images.PINK_BUTTON.getTexture());
        buttonState = new boolean[9];
    }

    public Squares(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public void setButtonState(int buttonID, boolean state) {
        if(buttonID >= 0 && buttonID < buttonState.length) {
            buttonState[buttonID] = state;
        }
    }

    @Override
    public void draw() {
        buttonsBackground.draw(getAbsolutePositionX(), getAbsolutePositionY(), getWidth(), getHeight());
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (buttonState[3 * y + x]) {
                    pinkButtonSprite.draw(getAbsolutePositionX() + 0.05f + 0.21f * x, getAbsolutePositionY() + 0.05f + 0.21f * y, 0.2f, 0.2f);
                } else {
                    greenButtonSprite.draw(getAbsolutePositionX() + 0.05f + 0.21f * x, getAbsolutePositionY() + 0.05f + 0.21f * y, 0.2f, 0.2f);
                }
            }
        }
    }

}
