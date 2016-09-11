package org.flamierawieo.x00FA9A.client.graphics;

import java.util.HashMap;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform2f;

public class ShaderConfig {

    private int program;
    private HashMap<String, Integer> uniforms = new HashMap<>();

    public ShaderConfig(int program) {
        this.program = program;
    }

    public int getUniformLocation(String name) {
        int location = -1;
        Integer locI = uniforms.get(name);
        if (locI == null) { // maybe it's not yet cached?
            location = glGetUniformLocation(program, name);
            uniforms.put(name, location);
        } else {
            location = locI.intValue();
        }
        // throw an exception if not found...
        if (location == -1) {
            throw new IllegalArgumentException("no active uniform by name '" + name + "' "
                    + "(disable strict compiling to suppress warnings)");
        }
        return location;
    }

    public void setUniformf(int loc, float a, float b) {
        if (loc == -1) return;
        glUniform2f(loc, a, b);
    }

    public void setUniformf(int loc, float a) {
        if (loc == -1) return;
        glUniform1f(loc, a);
    }

    public void setUniformf(String name, float a, float b) {
        setUniformf(getUniformLocation(name), a, b);
    }

    public void setUniformf(String name, float a) {
        setUniformf(getUniformLocation(name), a);
    }

}
