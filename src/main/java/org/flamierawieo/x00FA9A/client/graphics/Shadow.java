package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.Resources;

import java.awt.*;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Shadow {

//    private static int vertexShader;
//    private static int fragmentShader;
//    private static int program;
//    private static int texture;
//
//    static {
//        vertexShader = Resources.getShader("res/shaders/shadow_vertex_shader.glsl", GL_VERTEX_SHADER);
//        fragmentShader = Resources.getShader("res/shaders/shadow_fragment_shader.glsl", GL_FRAGMENT_SHADER);
//        program = glCreateProgram();
//        glAttachShader(program, fragmentShader);
//        glAttachShader(program, vertexShader);
//        glLinkProgram(program);
//        glValidateProgram(program);
//        int status = glGetProgrami(program, GL_LINK_STATUS);
//        System.out.println(status == GL_TRUE);
//        texture = glGenTextures();
//    }
//
//    public static void drawShadow(float x, float y, Vertex[] shape, float radius, Color color) {
//        ByteBuffer b = ByteBuffer.allocate(4);
//        glGenFramebuffers(1, b);
//        int buffer = b.getInt();
//        glPushMatrix();
//        glTranslatef(x, y, 0.0f);
//        glUseProgram(program);
//        glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
//        glBegin(GL_POLYGON);
//        for(Vertex v : shape) {
//            glVertex2f(v.x, v.y);
//        }
//        glEnd();
//        glBindFramebuffer(GL_FRAMEBUFFER, buffer);
//        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT8, GL_TEXTURE_2D, texture, 0);
//        glDrawBuffers(buffer);
//        glBindFramebuffer(GL_FRAMEBUFFER, 0);
//        glUseProgram(0);
//        glPopMatrix();
//    }

}
