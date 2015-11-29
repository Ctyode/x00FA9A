package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.x00FA9AClient;

public class Graphics {

    public static final Node rootNode = new Node(0, 0);
    public static final Node uiRootNode = new Node(0, 0);

    public float calculateAbsolutePositionX(float x, float originX, float width) {
        return x * x00FA9AClient.getGameContainer().getWidth() - originX * width;
    }

    public float calculateAbsolutePositionX(float x) {
        return x * x00FA9AClient.getGameContainer().getWidth();
    }

    public float calculateAbsolutePositionXRelativeToAspectRatio(float x, float originX, float width) {
        return x * x00FA9AClient.getGameContainer().getWidth() - originX * width;
    }

    public float calculateAbsolutePositionY(float y, float originY, float height) {
        return y * x00FA9AClient.getGameContainer().getHeight() - originY * height;
    }

    public float calculateAbsolutePositionY(float y) {
        return y * x00FA9AClient.getGameContainer().getHeight();
    }

    public float calculateAbsolutePositionYRelativeToAspectRatio(float y, float originY, float height) {
        return y * x00FA9AClient.getGameContainer().getHeight() - originY * height;
    }

}
