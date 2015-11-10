package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Button extends Widget {

    private Image image;
    private Runnable onClickRunnable;

    public Button(Image image, float x, float y, Runnable onClickRunnable) {
        super(x, y, image.getWidth(), image.getHeight());
        this.image = image;
        this.onClickRunnable = onClickRunnable;
    }

    public Button(Image image, float x, float y) {
        this(image, x, y, null);
    }

    public void onClick(Runnable r) {
        onClickRunnable = r;
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY());
    }

}
