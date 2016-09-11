#ifdef GL_ES
precision highp float;
#endif

uniform vec2 resolution;
uniform vec2 position;
uniform vec2 size;

float cornerRadius = 0.1; // TODO: meant to be uniform
uniform float shadowRadius;

vec4 shadowColor = vec4(0.0, 0.0, 0.0, 1.0); // TODO: meant to be uniform

// float pow2(float x) { return x * x; }

void main() {
  float aspect = resolution.x / resolution.y;
  float offset = (aspect - 1.0) * 0.5;
  vec2 relativeCoord = vec2(gl_FragCoord.x / resolution.x * aspect - offset, gl_FragCoord.y / resolution.y);
  float opacity =
    smoothstep(position.x, position.x + shadowRadius, relativeCoord.x) *
    smoothstep(position.x + size.x, position.x + size.x - shadowRadius, relativeCoord.x) *
    smoothstep(position.y, position.y + shadowRadius, relativeCoord.y) *
    smoothstep(position.y + size.y, position.y + size.y - shadowRadius, relativeCoord.y);

  /*
    smooth circle:
    smoothstep(cornerRadius, 0.0, sqrt(pow2(distance(relativeCoord.x, position.x)) + pow2(distance(relativeCoord.y, position.y))))
  */

  gl_FragColor = mix(vec4(0.0, 0.0, 0.0, 0.0), shadowColor, opacity); // TODO: replace black with transparent shadowColor
}
