package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;

public class Button {

    private GameContainer container;

    // The image for button
    private Image img;

    //Size of object
    private float xSize, ySize;

    //Coordinates of object
    private float x, y;

    public Button(GameContainer container, Image img, float x, float y) {
        this.container = container;
        this.img = img;
        this.xSize = img.getWidth() / 2f;
        this.ySize = img.getHeight() / 2f;
        this.x = x;
        this.y = y;
    }

    public Image getImages() {
        return img;
    }


    public void draw() {

        int width = container.getWidth();
        int height = container.getHeight();

        img.draw(x, y);
    }
}
