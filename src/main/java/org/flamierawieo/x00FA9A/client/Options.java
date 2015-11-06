package org.flamierawieo.x00FA9A.client;


import org.flamierawieo.x00FA9A.client.userskins.Skin;
import org.newdawn.slick.Input;

public class Options {

    private enum OptionType { BOOLEAN };

    public enum GameOption {


        DISABLE_MOUSE_BUTTONS ("WatchDog", "Wild dog", "watching with sixteen eyes", false);

        GameOption(String name, String displayName, String description, boolean value) {
            /** TODO
             * DO IT
             * JUST DO IT
             * YES, YOU CAN
             */
        }

        private boolean bool;

        public boolean getBooleanValue() {
            return bool;
        }

    }

    private static Skin skin;

    public static Skin getSkin() {
        return skin;
    }

    /** TODO
     * getKeyLeft and getKeyRight
     * like Osu (x and z)
     */

    public static int getKeyLeft() {
        return 0;
    }

    public static int getKeyRight() {
        return 0;
    }

    public static boolean isMouseDisabled() {
        return GameOption.DISABLE_MOUSE_BUTTONS.getBooleanValue();
    }


}
