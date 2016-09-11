#ifdef GL_ES
precision mediump float;
#endif

uniform vec2  resolution;
uniform float time;
uniform vec2 mouse;

void main() {
	float x = resolution.x * mouse.x;
	float y = resolution.y * mouse.y;
	float size = 30.0;
	vec2  pos = vec2(x, y);
	float dist = size / (length(gl_FragCoord.xy - pos));
	vec3 color = vec3(0.0);
	color = vec3(time, sin(time), sin(dist) * 0.2);
	gl_FragColor = vec4(dist, vec3(color));
}