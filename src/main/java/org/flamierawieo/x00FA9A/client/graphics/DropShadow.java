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
    protected HashMap<String, Integer> uniforms = new HashMap<String, Integer>();

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
    }

    @Override
    public void draw(float x, float y, float width, float height) {
        Settings settings = Settings.getInstance();
        VideoMode videoMode = settings.getVideoMode();
        glUseProgram(program);
        fillRect(x - 0.5f, y, width + 1.0f, height + 1.0f, Color.BLACK);
        setUniformf("resolution", videoMode.getWidth(), videoMode.getHeight());
        glUseProgram(0);
    }

    public int getUniformLocation(String name) {
        int location = -1;
        Integer locI = uniforms.get(name);
        if (locI == null) { // maybe it's not yet cached?
            location = glGetUniformLocation(program, name);
            uniforms.put(name, location);
    } else
            location = locI.intValue();
        // throw an exception if not found...
        if (location == -1)
            throw new IllegalArgumentException("no active uniform by name '" + name + "' "
                    + "(disable strict compiling to suppress warnings)");
        return location;
    }

    public void setUniformf(int loc, float a, float b) {
        if (loc==-1) return;
        glUniform2f(loc, a, b);
    }

    public void setUniformf(String name, float a, float b) {
        setUniformf(getUniformLocation(name), a, b);
    }


}