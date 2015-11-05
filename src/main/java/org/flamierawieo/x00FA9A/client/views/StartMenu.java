package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.input.InputDispatcher;
import org.flamierawieo.x00FA9A.client.ui.ButtonsDispatcher;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenu {

    private InputDispatcher inputDispatcher;

    private ButtonsDispatcher singleplayerButton, multiplayerButton, optionsButton, exitButton;

    private final int state;

    public StartMenu(int state) {
        this.state = state;
    }

    private GameContainer container;
    private StateBasedGame game;
    private Input input;

    /* TODO @Override
     * Zdes' hotela pereopredelit, no kakie-to problemki, a ya hochu spat', soryan. (git commit -m "govnokod")
     */
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

}
