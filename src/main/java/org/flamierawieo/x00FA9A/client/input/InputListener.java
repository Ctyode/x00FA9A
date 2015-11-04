package org.flamierawieo.x00FA9A.client.input;

public interface InputListener {

    /**
     * Called every time key was pressed
     * @param key pressed key
     * @param scancode wtf i dunno lol
     * @param mods mods (like Ctrl and shit)
     */
    void onKeyPress(int key, int scancode, int mods);

    /**
     * Called every time key was released
     * @param key pressed key
     * @param scancode wtf i dunno lol
     * @param mods mods (like Ctrl and shit)
     */
    void onKeyRelease(int key, int scancode, int mods);

    /**
     * Called every time mouse button was pressed
     * @param button pressed mouse button
     * @param mods mods (like Ctrl and shit)
     * @param x x position of cursor in window
     * @param y y position of cursor in window
     */
    void onMouseButtonPress(int button, int mods, int x, int y);

    /**
     * Called every time mouse button was released
     * @param button pressed mouse button
     * @param mods mods (like Ctrl and shit)
     * @param x x position of cursor in window
     * @param y y position of cursor in window
     */
    void onMouseButtonRelease(int button, int mods, int x, int y);

    /**
     * Called every time mouse moves
     * @param x x position of cursor in window
     * @param y y position of cursor in window
     * @param deltaX difference between last and current cursor x positions
     * @param deltaY difference between last and current cursor y positions
     */
    void onMouseMove(int x, int y, int deltaX, int deltaY);

}
