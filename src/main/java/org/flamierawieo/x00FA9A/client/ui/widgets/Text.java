package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.lwjgl.BufferUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;

public class Text extends Widget {

    public static final float FONT_SCALE = 0.01f;

    private String text;
    private Font font;
    private Color color;
    private Integer textureID;
    private Sprite sprite;

    public Text(String text, Font font, Color color, float x, float y, float originX, float originY) {
        super(x, y, 0.0f, 0.0f, originX, originY);
        this.text = text;
        this.font = font;
        this.color = color;
        generateTexture();
    }

    public Text(String text, Font font, Color color, float x, float y) {
        this(text, font, color, x, y, 0.0f, 0.0f);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        generateTexture();
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        generateTexture();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        generateTexture();
    }

    private void generateTexture() {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setFont(font);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int width = fontMetrics.stringWidth(text);
        int height = fontMetrics.getHeight();
        graphics2D.dispose();

        System.out.println("THIS DANK CODE IS 2COOL4U"); // MAJESTIC GLORIOUS

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        graphics2D.setFont(font);
        fontMetrics = graphics2D.getFontMetrics();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(text, 0, fontMetrics.getAscent());
        graphics2D.dispose();

        System.out.println("Очередной никому не нужный логгер (очередь номер 2)"); // MAJESTIC GLORIOUS

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

        System.out.println("Очень осмысленный текст (3)"); // MAJESTIC GLORIOUS

        if(textureID == null) {
            textureID = glGenTextures();
        }
        glBindTexture(GL_TEXTURE_2D, textureID);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        glDisable(GL_TEXTURE_2D);

        System.out.println("Что-то претендующее на осмысленность (4)"); // MAJESTIC GLORIOUS

        if(sprite == null) {
            sprite = new Sprite(textureID);
        } else {
            sprite.setTextureID(textureID);
        }

        System.out.println("Не более осмысленное, но другое (5)"); // MAJESTIC GLORIOUS

        setWidth((float)font.getSize() * FONT_SCALE * ((float)width / (float)height));
        setHeight((float)font.getSize() * FONT_SCALE);
    }

    @Override
    public void draw() {
        if (sprite != null) {
            sprite.draw(getAbsolutePositionX(), getAbsolutePositionY(), getWidth(), getHeight());
        }
    }
}
