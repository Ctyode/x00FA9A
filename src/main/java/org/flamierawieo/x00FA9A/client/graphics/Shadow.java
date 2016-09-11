package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.flamierawieo.x00FA9A.client.settings.VideoMode;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.fillRect;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.*;

public class Shadow implements ShadowDrawable {

    private static int fragmentShader;
    private static int program;
    private ShaderConfig shaderConfig;

    public Shadow() {
        fragmentShader = Resources.getShader("res/shaders/shadow_fragment_shader.glsl", GL_FRAGMENT_SHADER);
        program = glCreateProgram();
        glAttachShader(program, fragmentShader);
        glLinkProgram(program);
        glValidateProgram(program);
        int status = glGetProgrami(program, GL_LINK_STATUS);
        System.out.println(status == GL_TRUE);
        shaderConfig = new ShaderConfig(program);
    }

    @Override
    public void draw(float x, float y, float width, float height, float radius) {
        Settings settings = Settings.getInstance();
        VideoMode videoMode = settings.getVideoMode();
        glUseProgram(program);
        fillRect(x, y, width, height, Color.BLACK);
        shaderConfig.setUniformf("resolution", videoMode.getWidth(), videoMode.getHeight());
        shaderConfig.setUniformf("position", x, y);
        shaderConfig.setUniformf("size", width, height);
        shaderConfig.setUniformf("shadowRadius", radius);
        glUseProgram(0);
    }

}
