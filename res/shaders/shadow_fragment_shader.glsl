#ifdef GL_ES
precision mediump float;
#endif
#extension GL_OES_standard_derivatives : enable

uniform vec2 resolution;

vec2 uv;

    float roundedRectangle(vec2 pos, vec2 size, float radius, float thickness) {
    float dist = length(max(abs(uv-pos), size) - size) - radius;

  // первое число - сила размытия краев
    return smoothstep(2.0, 1.0, dist / thickness);
}

void main(void) {
    uv = 2.0 * ( gl_FragCoord.xy / 400.0 ) - 1.0;
    uv.x *= 1.0;
    vec3 color = vec3(0.0, 0.9, 0.5); // цвет фона, есличо (спринг грин, хех)

    vec2 pos = vec2(0.0, 0.0);
    vec2 size = vec2(0.8, 0.1); // размер прямоуголльника по осям x и y
    float radius = 0.1; // радиус угла. больше число - круглее углы. 2.0 превратит прямоугольник в круг
    float thickness = 1.0;
    float intensity = roundedRectangle(pos, size, radius, thickness);

    size *= 1.0;
    radius *= 0.6;
    thickness == 1.0;
    intensity = roundedRectangle(pos, size, radius, 0.014); // интенсивность сглаживания
    const vec3 rect2Color = vec3(1.0, 1.0, 1.0); // цвет прямоугольника
    color = mix(color, rect2Color, intensity);

    gl_FragColor = vec4(color, 1.0); // прозрачность/непрозрачность шейдера
}