package org.flamierawieo.x00FA9A.client.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BasicView extends BasicGameState {

    private final int state;

    public BasicView(int state) {
        this.state = state;
    }

    protected GameContainer container;
    protected StateBasedGame game;
    protected Input input;

    protected int width;
    protected int height;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;
        this.container = container;
        this.input = container.getInput();

        width = container.getWidth();
        height = container.getHeight();

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics)
            throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i)
            throws SlickException {

    }



}
