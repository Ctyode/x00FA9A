package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.ButtonsDispatcher;

import org.flamierawieo.x00FA9A.x00FA9A;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenu extends BasicGameState {

    private ButtonsDispatcher singleplayerButton, multiplayerButton, optionsButton, exitButton;

    private final int state;

    public StartMenu(int state) {
        this.state = state;
    }

    private GameContainer container;
    private StateBasedGame game;
    private Input input;

    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;
        this.container = container;
        this.input = container.getInput();

        int width = container.getWidth();
        int height = container.getHeight();


        // initialize menu buttons
        Image singleplayerImg = Images.SINGLEPLAYER_BUTTON.getImages();
        Image multiplayerImg = Images.MULTIPLAYER_BUTTON.getImages();

        singleplayerButton = new ButtonsDispatcher(singleplayerImg,
                width * 0.8f, (height / 2) - (singleplayerImg.getHeight() / 2f)
        );

        multiplayerButton = new ButtonsDispatcher(multiplayerImg,
                width * 0.8f, (height / 2) - (multiplayerImg.getHeight() / 2f)
        );

    }



    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        int width = container.getWidth();
        int height = container.getHeight();

        g.setBackground(Color.black);
        g.setColor(Color.white);



    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public int getID() {
        return state;
    }
}
