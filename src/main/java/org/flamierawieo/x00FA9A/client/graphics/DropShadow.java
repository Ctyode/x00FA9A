package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.flamierawieo.x00FA9A.client.settings.VideoMode;
import org.flamierawieo.x00FA9A.client.ui.widget.ButtonDrawable;

import java.awt.*;
import java.util.HashMap;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.fillRect;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.glGetProgrami;

public class DropShadow implements ButtonDrawable {

    private int vertexShader;
    private int fragmentShader;
    private int program;
    private ShaderConfig shaderConfig;
    protected HashMap<String, Integer> uniforms = new HashMap<>();

    public DropShadow() {
//        vertexShader = Resources.getShader("res/shaders/shadow_vertex_shader.glsl", GL_VERTEX_SHADER);
        fragmentShader = Resources.getShader("res/shaders/shadow_fragment_shader.glsl", GL_FRAGMENT_SHADER);
        program = glCreateProgram();
//        glAttachShader(program, vertexShader);
        glAttachShader(program, fragmentShader);
        glLinkProgram(program);
        glValidateProgram(program);
        int status = glGetProgrami(program, GL_LINK_STATUS);
        System.out.println(status == GL_TRUE);
        shaderConfig = new ShaderConfig(program);
    }

    @Override
    public void draw(float x, float y, float width, float height) {
        Settings settings = Settings.getInstance();
        VideoMode videoMode = settings.getVideoMode();
        glUseProgram(program);
        fillRect(x - 0.5f, y, width + 1.0f, height + 1.0f, Color.BLACK);
        shaderConfig.setUniformf("resolution", videoMode.getWidth(), videoMode.getHeight());
        glUseProgram(0);
    }


}