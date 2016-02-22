package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.ui.widget.ButtonDrawable;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.*;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;

public class Surface implements ButtonDrawable {

    private Color backgroundColor;
    private Color borderColor;
    private float borderThickness;
    private float radius;
    private int vertexShader;
    private int fragmentShader;
    private int program;

    public Surface(Color backgroundColor, Color borderColor, float borderThickness, float radius) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        this.radius = radius;

        vertexShader = Resources.getShader("res/shaders/shadow_vertex_shader.glsl", GL_VERTEX_SHADER);
        fragmentShader = Resources.getShader("res/shaders/shadow_fragment_shader.glsl", GL_FRAGMENT_SHADER);
        program = glCreateProgram();
        glAttachShader(program, vertexShader);
        glAttachShader(program, fragmentShader);
        glLinkProgram(program);
        glValidateProgram(program);
        int status = glGetProgrami(program, GL_LINK_STATUS);
        System.out.println(status == GL_TRUE);
    }

    @Override
    public void draw(float x, float y, float width, float height) {
        glUseProgram(program);
        fillRect(x - 0.9f, y - 0.6f, width + 0.6f , height + 0.6f, Color.BLACK);
        glUseProgram(0);
        strokeLine(x + radius, y, x + width - radius, y, borderThickness, borderColor);
        strokeLine(x + width, y + radius, x + width, y + height - radius, borderThickness, borderColor);
        strokeLine(x + radius, y + height, x + width - radius, y + height, borderThickness, borderColor);
        strokeLine(x, y + radius, x, y + height - radius, borderThickness, borderColor);
        strokeCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, borderColor, borderThickness);
        strokeCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, borderColor, borderThickness);
        fillRect(x, y + radius, width, height - (radius * 2), backgroundColor);
        fillRect(x + radius, y, width - (radius * 2), height, backgroundColor);
        fillCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 16, backgroundColor);
        fillCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 16, backgroundColor);
        fillCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 16, backgroundColor);
        fillCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 16, backgroundColor);
    }

}
