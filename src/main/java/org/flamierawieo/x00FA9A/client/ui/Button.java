package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import static org.lwjgl.glfw.GLFW.*;

public class Button extends Widget implements Tickable, Drawable, MouseInputListener {

    private Runnable onClickRunnable;
    private Sprite sprite;

    public Button(Sprite sprite, float x, float y, float width, float height, Runnable onClickRunnable) {
        super(x, y, width, height);
        this.sprite = sprite;
        this.onClickRunnable = onClickRunnable;
    }

    public Button(Sprite sprite, float x, float y, float width, float height) {
        this(sprite, x, y, width, height, null);
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    @Override
    public void onMouseMove(float x, float y) {

    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void onMouseButtonUp(int button, int mods) {

    }

    @Override
    public void draw() {
        sprite.draw();
    }

    @Override
    public void tick(float delta) {

    }
}
