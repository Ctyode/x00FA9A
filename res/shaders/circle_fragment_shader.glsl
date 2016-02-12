#version 120

vec3 render(float x, float y, float size) {

 // позиция фонарика, но надо не численно писать, а как-то еще, я просто не знаю как
    vec2 pos = vec2(500.0, 500.0);
    float dist = length(gl_FragCoord.xy - pos);

 /*
  тут радиус блюра фонарика, чтобы увеличить радиус нужно изменить численное значение, хех, больше число - меньше радиус
  это можно также использовать для радиуса тени в дальнейшем
  то есть тень надо рисовать без всяких там байт-буфферов, опенгла. все чисто шейдерами.
 */

    return vec3(pow ((size / dist), 5.0));
}

void main() {

 // последнее это размер фонарика, а еще если нормально написать 6-ю строчку, то можно первыми двумя числами менять позицию
    vec3 color = render(0.0, 0.0, 25.0);

 // число это alpha, то есть прозрачность фрагментного шейдера
    gl_FragColor = vec4(color, 1.0);

}