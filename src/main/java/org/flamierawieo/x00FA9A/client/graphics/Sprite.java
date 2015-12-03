package org.flamierawieo.x00FA9A.client.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {

    private int textureID;

    public Sprite(int textureID) {
        this.textureID = textureID;
    }

    public int getTextureID() {
        return textureID;
    }

    public void setTextureID(int textureID) {
        this.textureID = textureID;
    }

    public void draw(float x, float y, float width, float height) {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glEnable(GL_TEXTURE_2D);
        glColor3f(1.0f, 1.0f, 1.0f);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glBindTexture(GL_TEXTURE_2D, textureID);
        glBegin(GL_QUADS);
        glTexCoord2f(0.0f, 0.0f); glVertex3f(0.0f, height, 0.0f);
        glTexCoord2f(1.0f, 0.0f); glVertex3f(width, height, 0.0f);
        glTexCoord2f(1.0f, 1.0f); glVertex3f(width, 0.0f, 0.0f);
        glTexCoord2f(0.0f, 1.0f); glVertex3f(0.0f, 0.0f, 0.0f);
        glEnd();
        glDisable(GL_BLEND);
        glDisable(GL_TEXTURE_2D);
        glPopMatrix();
    }

}
