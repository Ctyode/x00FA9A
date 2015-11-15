package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Background extends Widget {

    private Image image;

    public Background(Image image, float x, float y) {
        super(x, y, image.getWidth(), image.getHeight());
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY());
    }

}
