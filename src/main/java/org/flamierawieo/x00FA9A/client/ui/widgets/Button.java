package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.flamierawieo.x00FA9A.shared.Tickable;

public class Button extends Widget implements Tickable, Drawable, MouseInputListener {

    public static class Builder {

        private Text text;
        private int backgroundTexture;
        private Runnable onClickRunnable;
        private float x;
        private float y;
        private float width;
        private float height;
        private float originX;
        private float originY;

        public Button build() {
            return new Button(text, backgroundTexture, onClickRunnable, x, y, width, height, originX, originY);
        }

        public Builder setPosition(float x, float y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Builder setSize(float width, float height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder setOrigin(float originX, float originY) {
            this.originX = originX;
            this.originY = originY;
            return this;
        }

        public Builder setText(Text text) {
            this.text = text;
            return this;
        }

        public Builder setBackgroundTexture(int backgroundTexture) {
            this.backgroundTexture = backgroundTexture;
            return this;
        }

        public Builder setOnClickRunnable(Runnable onClickRunnable) {
            this.onClickRunnable = onClickRunnable;
            return this;
        }

        public Builder setX(float x) {
            this.x = x;
            return this;
        }

        public Builder setY(float y) {
            this.y = y;
            return this;
        }

        public Builder setWidth(float width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(float height) {
            this.height = height;
            return this;
        }

        public Builder setOriginX(float originX) {
            this.originX = originX;
            return this;
        }

        public Builder setOriginY(float originY) {
            this.originY = originY;
            return this;
        }

    }

    private Runnable onClickRunnable;
    private Sprite background;
    private Text text;

    public static Builder builder() {
        return new Builder();
    }

    public Button(Text text, int backgroundTexture, Runnable onClickRunnable, float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        this.background = new Sprite(backgroundTexture);
        this.text = text;
        this.onClickRunnable = onClickRunnable;
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw() {
        if(background != null) {
            background.draw(getAbsolutePositionX(), getAbsolutePositionY(), getWidth(), getHeight());
        }
        if(text != null) {
            text.draw(calculateAbsolutePosition(getX(), text.getWidth(), 0.5f),
                      calculateAbsolutePosition(getY(), text.getHeight(), 0.5f));
        }
    }

}
