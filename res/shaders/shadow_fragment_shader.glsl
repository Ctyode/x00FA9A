#ifdef GL_ES
precision mediump float;
#endif
#extension GL_OES_standard_derivatives : enable

uniform vec2 resolution;
vec2 uv;

float roundedRectangle(vec2 pos, vec2 size, float radius, float thickness) {
    float dist = length(max(abs(uv - pos), size) - size) - radius;

    // первое число - сила размытия краев
    return smoothstep(20.0, 1.0, dist / thickness);
}

vec2 shadow_center = vec2(0.5, 0.5);

void main(void) {
    uv =  gl_FragCoord.xy / resolution.xy - shadow_center;
	uv *= resolution.xy / resolution.y;
    vec4 color = vec4(0.0, 0.0, 0.0, 0.0); // цвет фона

    vec2 pos = vec2(0.0, 0.0);
    vec2 size = vec2(1.9, 1.9); // размер прямоуголльника по осям x и y
    float radius = 0.1; // радиус угла. больше число - круглее углы. 2.0 превратит прямоугольник в круг
    float thickness = 1.0;
    float intensity = roundedRectangle(pos, size, radius, thickness);

    size *= 0.48;
    radius *= 0.6;
    intensity = roundedRectangle(pos, size, radius, 0.0005); // интенсивность сглаживания
    const vec4 rectColor = vec4(0.0, 0.0, 0.0, 0.16); // цвет прямоугольника
    color = mix(color, rectColor, intensity);

    gl_FragColor = vec4(color); // прозрачность/непрозрачность шейдера
}