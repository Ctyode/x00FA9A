#ifdef GL_ES
precision mediump float;
#endif

#extension GL_OES_standard_derivatives : enable

uniform vec2 resolution;

const float radius = 0.1;
const float fade = 0.6;

void main() {
    vec4 color = vec4(0.0, 0.0, 0.0, 0.3);
    vec2 position = (gl_FragCoord.xy / resolution.xy) - 0.5;

    float length = length(position);
    float vignette = smoothstep(radius, fade - radius, length);

    color = mix(color, color * vignette, 1.0);

    gl_FragColor = color;
}