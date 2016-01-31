#version 110

attribute vec2 vertex;

void main() {
    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}