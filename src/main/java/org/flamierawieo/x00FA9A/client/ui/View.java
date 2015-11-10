package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class View implements KeyListener, MouseListener, Game {

    private List<Widget> widgets;
    private Input input;
    private Predicate<Widget> isHovered = w -> {
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        float widgetX = w.getX();
        float widgetY = w.getY();
        return mouseX <= widgetX && mouseY  <= widgetY &&
                mouseX >= widgetX + w.getWidth() && mouseY <= widgetY + w.getHeight();
    };

    public View() {
        widgets = new ArrayList<>();
    }

    private void eachReversed(Predicate<Widget> p, Consumer<Widget> c) {
        Widget currentWidget;
        for(int i = widgets.size(); i > 0; --i) {
            currentWidget = widgets.get(i);
            if(p.test(currentWidget)) {
                c.accept(currentWidget);
                break;
            }
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        eachReversed(isHovered, w -> w.keyPressed(i, c));
    }

    @Override
    public void keyReleased(int i, char c) {
        eachReversed(isHovered, w -> w.keyReleased(i, c));
    }

    @Override
    public void mouseWheelMoved(int i) {
        eachReversed(isHovered, w -> w.mouseWheelMoved(i));
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        eachReversed(isHovered, w -> w.mouseClicked(i, i1, i2, i3));
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
        eachReversed(isHovered, w -> w.mousePressed(i, i1, i2));
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
        eachReversed(isHovered, w -> w.mouseReleased(i, i1, i2));
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
        eachReversed(isHovered, w -> w.mouseMoved(i, i1, i2, i3));
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        eachReversed(isHovered, w -> w.mouseDragged(i, i1, i2, i3));
    }

    @Override
    public void setInput(Input input) {
        this.input = input;
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
        // ayy lmao
    }

    @Override
    public void inputStarted() {
        // ayy lmao
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    @Override
    public boolean closeRequested() {
        return false;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

}
