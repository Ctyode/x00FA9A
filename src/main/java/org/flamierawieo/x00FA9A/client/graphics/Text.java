package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.lwjgl.BufferUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Text extends Sprite {

    private String string;
    private Font font;
    private Color color;
    private float width;
    private float height;
    private Integer texture;

    public Text(String string, Font font, Color color, float height) {
        super(null);
        this.string = string;
        this.font = font;
        this.color = color;
        this.height = height;
        updateTexture();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
        updateTexture();
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        updateTexture();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        updateTexture();
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    private void updateTexture() {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        Font scaledFont = font.deriveFont(Settings.getInstance().getVideoMode().getHeight() * this.height); // TODO: redesign project's WHOLE FUCKING ARCHITECTURE
        graphics2D.setFont(scaledFont);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int textureWidth = fontMetrics.stringWidth(string) + 2; // little hack preventing hard clipping
        int textureHeight = fontMetrics.getHeight() + 2;        // +1 pixel on each side of texture
        graphics2D.dispose();

        bufferedImage = new BufferedImage(textureWidth, textureHeight, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        graphics2D.setFont(scaledFont);
        fontMetrics = graphics2D.getFontMetrics();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(string, 1, fontMetrics.getAscent() + 1);
        graphics2D.dispose();

        System.out.println(bufferedImage.getWidth() + " " + bufferedImage.getHeight());
        int[] pixels = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
        bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), pixels, 0, bufferedImage.getWidth());
        ByteBuffer buffer = BufferUtils.createByteBuffer(bufferedImage.getWidth() * bufferedImage.getHeight() * 4);
        for(int y = 0; y < bufferedImage.getHeight(); y++){
            for(int x = 0; x < bufferedImage.getWidth(); x++){
                int pixel = pixels[y * bufferedImage.getWidth() + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red
                buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green
                buffer.put((byte) (pixel & 0xFF));             // Blue
                buffer.put((byte) ((pixel >> 24) & 0xFF));     // Alpha
            }
        }
        buffer.flip();

        /*
         * !!! QUESTIONABLE !!!
         */
        texture = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texture);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, textureWidth, textureHeight, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        glDisable(GL_TEXTURE_2D);
        width = height * ((float)textureWidth / (float)textureHeight);
        setTexture(texture);
        /*
         * !!! QUESTIONABLE !!!
         */
    }

    public void draw(float x, float y) {
        draw(x, y, width, height);
    }

}
