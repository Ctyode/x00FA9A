package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.flamierawieo.x00FA9A.shared.Tickable;

public class Button extends Widget implements Tickable, Drawable, MouseInputListener {

    public static class Builder {

        private Text text;
        private Runnable onClickRunnable;
        private float x;
        private float y;
        private float width;
        private float height;
        private float originX;
        private float originY;
        private ButtonDrawable buttonDrawable;

        public Button build() {
            return new Button(text, onClickRunnable, x, y, width, height, originX, originY, buttonDrawable);
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

        public Builder setOnClickRunnable(Runnable onClickRunnable) {
            this.onClickRunnable = onClickRunnable;
            return this;
        }

        public Builder setButtonDrawable(ButtonDrawable buttonDrawable) {
            this.buttonDrawable = buttonDrawable;
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
    private Text text;
    private ButtonDrawable buttonDrawable;

    public static Builder builder() {
        return new Builder();
    }

    public Button(Text text, Runnable onClickRunnable, float x, float y, float width, float height, float originX, float originY, ButtonDrawable buttonDrawable) {
        super(x, y, width, height, originX, originY);
        this.text = text;
        this.onClickRunnable = onClickRunnable;
        this.buttonDrawable = buttonDrawable;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    public void setButtonDrawable(ButtonDrawable buttonDrawable) {
        this.buttonDrawable = buttonDrawable;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw() {
        buttonDrawable.draw(getAbsolutePositionX(), getAbsolutePositionY(), getWidth(), getHeight());
        if(text != null) {
            text.draw(calculateAbsolutePosition(getAbsolutePositionX() + (getWidth() * 0.5f), text.getWidth(), 0.5f),
                      calculateAbsolutePosition(getAbsolutePositionY() + (getHeight() * 0.5f), text.getHeight(), 0.5f));
        }
    }

}
