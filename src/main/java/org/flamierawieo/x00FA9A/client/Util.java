package org.flamierawieo.x00FA9A.client;

import org.newdawn.slick.Input;

public class Util {

    private static Input input;

    public static boolean isMousePressed() {
        boolean mouseDown = !Options.isMouseDisabled() &&
                (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON) ||
                input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON));

        return (mouseDown ||
                input.isKeyDown(Options.getKeyLeft()) ||
                input.isKeyDown(Options.getKeyRight()));
    }


}
