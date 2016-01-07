package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Squares extends Widget {

    private class Hint {
        int button;
        float time;
    }

    private boolean[] buttonState;
    private Surface pinkButton;
    private Surface greenButton;
    private Surface hint;
    private List<Hint> hints;

    public Squares(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        greenButton = new Surface(Color.WHITE, Color.GREEN, 6.0f, 0.025f);
        pinkButton = new Surface(Color.WHITE, Color.PINK, 6.0f, 0.025f);
        hint = new Surface(new Color(1.0f, 1.0f, 1.0f, 0.0f), Color.CYAN, 6.0f, 0.025f);
        buttonState = new boolean[9];
        hints = new ArrayList<>();
    }

    public Squares(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public void setButtonState(int buttonID, boolean state) {
        if(buttonID >= 0 && buttonID < buttonState.length) {
            buttonState[buttonID] = state;
        }
    }

    public void addHint(int buttonID, float time) {
        Hint hint = new Hint();
        hint.button = buttonID;
        hint.time = time;
        hints.add(hint);
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
        for(Hint h : hints) {
            int x = h.button % 3;
            int y = h.button / 3;
            hint.draw(0.1f + 0.15f * x, 0.1f + 0.15f * y, 0.1f * (1.0f + h.time), 0.1f * (1.0f + h.time));
        }
    }

    @Override
    public void tick(float delta) {
//        hints.forEach(h -> h.time -= delta);
//        hints = hints.stream().filter(h -> h.time > 0.0f).collect(Collectors.toList());
//        for(Hint h : hints) {
//            h.time -= delta;
//            if(h.time < 0.0f) {
//                hints.remove(h);
//            }
//        }
    }
}