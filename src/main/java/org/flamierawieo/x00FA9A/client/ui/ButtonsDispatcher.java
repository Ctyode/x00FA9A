package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.Image;

public class ButtonsDispatcher {

    // The image for button
    private Image img;

    //Size of object
    private float xSize, ySize;

    //Coordinates of object
    private float x, y;

    public ButtonsDispatcher(Image img, float x, float y) {
        this.img = img;
        this.xSize = img.getWidth() / 2f;
        this.ySize = img.getHeight() / 2f;
        this.x = x;
        this.y = y;
    }

    public Image getImages() {
        return img;
    }

}
