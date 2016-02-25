package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.ui.widget.ButtonDrawable;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.fillRect;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.glGetProgrami;

public class DropShadow implements ButtonDrawable {

    private int vertexShader;
    private int fragmentShader;
    private int program;

    public DropShadow() {
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
    }
}
