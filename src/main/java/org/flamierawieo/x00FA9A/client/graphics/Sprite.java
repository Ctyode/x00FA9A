package org.flamierawieo.x00FA9A.client.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Sprite implements Drawable {

    private int textureID;
    private float x;
    private float y;
    private float width;
    private float height;

    public Sprite(int textureID, float x, float y, float width, float height) {
        this.textureID = textureID;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glEnable(GL_TEXTURE_2D);
        glColor3f(1.0f, 1.0f, 1.0f);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glBindTexture(GL_TEXTURE_2D, textureID);
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f); glVertex3f(0.0f, 0.0f, 0.0f);
        glTexCoord2f(1.0f, 0.0f); glVertex3f(width, 0.0f, 0.0f);
        glTexCoord2f(1.0f, 1.0f); glVertex3f(width, height, 0.0f);
        glTexCoord2f(0.0f, 1.0f); glVertex3f(0.0f, height, 0.0f);
        glEnd();
        glDisable(GL_BLEND);
        glDisable(GL_TEXTURE_2D);
        glPopMatrix();
    }

}
