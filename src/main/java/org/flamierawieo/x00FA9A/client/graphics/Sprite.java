package org.flamierawieo.x00FA9A.client.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {

    private Integer texture;

    public Sprite(Integer texture) {
        this.texture = texture;
    }

    public Integer getTexture() {
        return texture;
    }

    public void setTexture(int texture) {
        this.texture = texture;
    }

    public void draw(float x, float y, float width, float height) {
        if(texture != null) {
            glPushMatrix();
            glTranslatef(x, y, 0.0f);
            glColor3f(1.0f, 1.0f, 1.0f);
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, texture);
            glBegin(GL_QUADS);
            glTexCoord2f(0.0f, 0.0f);
            glVertex3f(0.0f, height, 0.0f);
            glTexCoord2f(1.0f, 0.0f);
            glVertex3f(width, height, 0.0f);
            glTexCoord2f(1.0f, 1.0f);
            glVertex3f(width, 0.0f, 0.0f);
            glTexCoord2f(0.0f, 1.0f);
            glVertex3f(0.0f, 0.0f, 0.0f);
            glEnd();
            glDisable(GL_TEXTURE_2D);
            glPopMatrix();
        }
    }

}
