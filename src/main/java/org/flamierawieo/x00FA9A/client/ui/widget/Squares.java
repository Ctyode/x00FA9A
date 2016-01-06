package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import java.awt.*;

public class Squares extends Widget {

    private boolean[] buttonState;
    private Surface pinkButton;
    private Surface greenButton;


    public Squares(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        greenButton = new Surface(Color.WHITE, Color.GREEN, 6.0f, 0.025f);
        pinkButton = new Surface(Color.WHITE, Color.PINK, 6.0f, 0.025f);
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
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if(buttonState[3 * y + x]) {
                    pinkButton.draw(0.1f + 0.15f * x, 0.1f + 0.15f * y, 0.1f, 0.1f);
                } else {
                    greenButton.draw(0.1f + 0.15f * x, 0.1f + 0.15f * y, 0.1f, 0.1f);
                }
            }
        }
    }

}
